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
import model.Ferramenta;

/**
 *
 * @author gusta
 */
public class FerramentaDAO {

     //Função para cadastrar os dados no banco de dados.
    public void createFerramenta(Ferramenta f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ferramenta (nome, marca, custoDeAquisicao, quantidade) VALUES(?,?,?,?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setInt(4, f.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Função para ler os dados no banco de dados.
    public List<Ferramenta> readFerramenta() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
         List<Ferramenta> ferramentas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ferramenta");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("idFerramenta"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setCusto(rs.getDouble("custoDeAquisicao"));
                ferramenta.setQuantidade(rs.getInt("quantidade"));
                ferramentas.add(ferramenta);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ferramentas;

    }
    
    //Função para bsucar os dados na coluna nome no banco de dados.
    public List<Ferramenta> readFerramentaForNome(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
         List<Ferramenta> ferramentas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ferramenta WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("idFerramenta"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setCusto(rs.getDouble("custoDeAquisicao"));
                ferramenta.setQuantidade(rs.getInt("quantidade"));
                ferramentas.add(ferramenta);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ferramentas;

    }
    
     //Função para bsucar os dados na coluna marca no banco de dados.
     public List<Ferramenta> readFerramentaForMarca(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
         List<Ferramenta> ferramentas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ferramenta WHERE marca LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Ferramenta ferramenta = new Ferramenta();

                ferramenta.setId(rs.getInt("idFerramenta"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setCusto(rs.getDouble("custoDeAquisicao"));
                ferramenta.setQuantidade(rs.getInt("quantidade"));
                ferramentas.add(ferramenta);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return ferramentas;

    }
    
    //Função para atualizar os dados no banco de dados.
    public void updateFerramenta(Ferramenta f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE ferramenta SET nome = ?, marca = ?, custoDeAquisicao = ?, quantidade = ? WHERE idFerramenta = ?");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMarca());
            stmt.setDouble(3, f.getCusto());
            stmt.setInt(4, f.getQuantidade());
            stmt.setInt(5, f.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Função para excluir os dados no banco de dados.
    public void deleteFerramenta(Ferramenta f) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM ferramenta WHERE idFerramenta = ?");
            stmt.setInt(1, f.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
