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
import model.Emprestimo;

public class EmprestimoDAO {

    //Função para cadastrar os dados no banco de dados.
    public void createEmprestimo(Emprestimo e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO emprestimo (nomeFerramenta, nomeAmigo, dataDeEmprestimo, dataDeDevolucao) VALUES(?,?,?,?)");
            stmt.setString(1, e.getNomeFerramenta());
            stmt.setString(2, e.getNomeAmigo());
            stmt.setString(3, e.getDataEmprestimo());
            stmt.setString(4, e.getDataDevolucao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Função para ler os dados salvos no banco de dados.
    public List<Emprestimo> readEmprestimo() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setNomeFerramenta(rs.getString("nomeFerramenta"));
                emprestimo.setNomeAmigo(rs.getString("nomeAmigo"));
                emprestimo.setDataEmprestimo(rs.getString("dataDeEmprestimo"));
                emprestimo.setDataDevolucao(rs.getString("dataDeDevolucao"));

                emprestimos.add(emprestimo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return emprestimos;

    }
    
    //Função para bsucar os dados na coluna nomeAmigo no banco de dados.
    public List<Emprestimo> readEmprestimoForAmigo(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE nomeAmigo LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setNomeFerramenta(rs.getString("nomeFerramenta"));
                emprestimo.setNomeAmigo(rs.getString("nomeAmigo"));
                emprestimo.setDataEmprestimo(rs.getString("dataDeEmprestimo"));
                emprestimo.setDataDevolucao(rs.getString("dataDeDevolucao"));
                emprestimos.add(emprestimo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return emprestimos;

    }

    //Função para bsucar os dados na coluna nomeFerramenta no banco de dados.
    public List<Emprestimo> readEmprestimoForFerramenta(String nome) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE nomeFerramenta LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setNomeFerramenta(rs.getString("nomeFerramenta"));
                emprestimo.setNomeAmigo(rs.getString("nomeAmigo"));
                emprestimo.setDataEmprestimo(rs.getString("dataDeEmprestimo"));
                emprestimo.setDataDevolucao(rs.getString("dataDeDevolucao"));
                emprestimos.add(emprestimo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return emprestimos;

    }

    //Função para atualizar os dados no banco de dados.
    public void updateEmprestimo(Emprestimo e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE emprestimo SET nomeFerramenta = ?, nomeAmigo = ?, dataDeEmprestimo = ?, dataDeDevolucao = ? WHERE idEmprestimo = ?");

            stmt.setString(1, e.getNomeFerramenta());
            stmt.setString(2, e.getNomeAmigo());
            stmt.setString(3, e.getDataEmprestimo());
            stmt.setString(4, e.getDataDevolucao());
            stmt.setInt(5, e.getIdEmprestimo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Função para excluir os dados no banco de dados.
    public void deleteEmprestimo(Emprestimo e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM emprestimo WHERE idEmprestimo = ?");

            stmt.setInt(1, e.getIdEmprestimo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
