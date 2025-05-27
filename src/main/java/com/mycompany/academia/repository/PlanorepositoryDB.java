package repository;

import database.Conexao;
import model.Plano;

import java.sql.*;
import java.util.ArrayList;

public class PlanoRepositoryDB {
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
