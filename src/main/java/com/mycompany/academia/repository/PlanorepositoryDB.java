/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.repository;

import com.mycompany.academia.database.Conexao;
import com.mycompany.academia.model.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class PlanorepositoryDB {
     public void adicionar(Plano plano) {
        String sql = "INSERT INTO plano (nome, descricao) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plano.getNome());
            stmt.setString(2, plano.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Plano> listar() {
        ArrayList<Plano> planos = new ArrayList<>();
        String sql = "SELECT * FROM plano";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Plano plano = new Plano(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
                planos.add(plano);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planos;
    }
}
