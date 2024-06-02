/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Amigo;

public class AmigoDAO {

    public void createAmigo(Amigo a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO amigo (nome, telefone) VALUES(?,?)");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getTelefone());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Amigo> readAmigo() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Amigo> amigos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM amigo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigo = new Amigo();

                amigo.setId(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setTelefone(rs.getString("telefone"));
                amigos.add(amigo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return amigos;

    }

    public List<Amigo> readAmigoForNome(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Amigo> amigos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM amigo WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigo = new Amigo();

                amigo.setId(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setTelefone(rs.getString("telefone"));
                amigos.add(amigo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return amigos;

    }

    public List<Amigo> readAmigoForTel(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Amigo> amigos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM amigo WHERE telefone LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Amigo amigo = new Amigo();

                amigo.setId(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setTelefone(rs.getString("telefone"));
                amigos.add(amigo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return amigos;

    }

    public void updateAmigo(Amigo a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Amigo SET nome = ?, telefone = ? WHERE idAmigo = ?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getTelefone());
            stmt.setInt(3, a.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deleteAmigo(Amigo a) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM amigo WHERE idAmigo = ?");
            stmt.setInt(1, a.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
