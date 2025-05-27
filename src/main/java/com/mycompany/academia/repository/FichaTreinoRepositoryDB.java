/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.repository;

import com.mycompany.academia.database.Conexao;
import com.mycompany.academia.model.FichaTreino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class FichaTreinoRepositoryDB {
    
    
     public void adicionar(FichaTreino ficha) {
        String sql = "INSERT INTO ficha_treino (aluno_id, descricao) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ficha.getAlunoId());
            stmt.setString(2, ficha.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<FichaTreino> listarPorAluno(int alunoId) {
        ArrayList<FichaTreino> fichas = new ArrayList<>();
        String sql = "SELECT * FROM ficha_treino WHERE aluno_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FichaTreino ficha = new FichaTreino(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getString("descricao")
                );
                fichas.add(ficha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fichas;
    }
    public void excluirFicha(int id){
        String sql = "delete from ficha_treino where id =?";
        try(Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
