/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.repository;
import com.mycompany.academia.database.Conexao;
import com.mycompany.academia.model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AlunoRepositoryDB {
     public void adicionar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aluno> listar() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
    public void update(String nome,String email, String email_antigo){
      String sql ="UPDATE aluno SET nome = ?, email = ? WHERE email =?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, email_antigo);
            stmt.executeUpdate();
        }catch(SQLException error){}
    }
    public void deletar(String email){
        String sql = "DELETE FROM aluno WHERE email =?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
           int linhasAfetadas = stmt.executeUpdate();
           if(linhasAfetadas > 0){
               System.out.println("Aluno deletado");
           }else{
               System.out.println("Error");
           }
        }catch(SQLException error){}
    }
}
