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
            stmt = con.prepareStatement("INSERT INTO amigoferramentaemprestimo (codFerramenta, codAmigo, dataDeEmprestimo, dataDeDevolucao) VALUES(?,?,?,?)");
            stmt.setInt(1, e.getIdFerramenta());
            stmt.setInt(2, e.getIdAmigo());
            stmt.setDate(3, e.getDataEmprestimo());
            stmt.setDate(4, e.getDataDevolucao());

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
            stmt = con.prepareStatement("SELECT * FROM amigoferramentaemprestimo");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdFerramenta(rs.getInt("codFerramenta"));
                emprestimo.setIdAmigo(rs.getInt("codAmigo"));
                emprestimo.setDataEmprestimo(rs.getDate("dataDeEmprestimo"));
                emprestimo.setDataDevolucao(rs.getDate("dataDeDevolucao"));
                
                emprestimos.add(emprestimo);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FerramentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return emprestimos;

    }
    
    //Função para atualizar os dados no banco de dados.
    public void updateEmprestimo(Emprestimo e) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE amigoferramentaemprestimo SET dataDeEmprestimo = ?, dataDeDevolucao = ? WHERE codFerramenta = ? AND codAmigo = ?");
            stmt.setInt(3, e.getIdFerramenta());
            stmt.setInt(4, e.getIdAmigo());
            stmt.setDate(1, e.getDataEmprestimo());
            stmt.setDate(2, e.getDataDevolucao());
            

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
            stmt = con.prepareStatement("DELETE FROM amigoferramentaemprestimo WHERE WHERE codFerramenta = ? AND codAmigo = ?");
            stmt.setInt(1, e.getIdFerramenta());
            stmt.setInt(2, e.getIdAmigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
