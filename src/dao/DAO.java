/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Amigo;
import model.Ferramenta;

public class DAO {

    //Conectando o banco de dados.
    public Connection getConexao() {
        Connection conexao = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_alunos";
            String url = "jdbc:mysql://" + server + ":3306/"
                    + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root";

            conexao = DriverManager.getConnection(url, user, password);

            if (conexao != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return conexao;

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
            return null;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
            return null;
        }
    }

    //Relatorio de ferramentas.
    public boolean selectFerramentaDB(Ferramenta objeto) {
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ?????");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getInt("custo");
                int quantidade = res.getInt("quantidade");
                /*Aluno objeto = new Aluno(curso, fase, id, nome, idade);
                minhaLista.add(objeto);*/
            }
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
        return true;
    }

    //Inserindo ferramenta no banco de dados.
    public boolean insertFerramentaDB(Ferramenta objeto) {
        String sql = "INSERT INTO ??????(id,nome,marca,custo,quantidade) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());
            stmt.setInt(5, objeto.getQuantidade());
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    //Deletando uma ferramenta do banco de dados.
    public boolean deleteFerramentaDB(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM ??????? WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    //Editando uma ferramenta pelo seu ID.
    public boolean updateFerramentaDB(Ferramenta objeto) {
        String sql = "UPDATE ??????? set nome = ? ,marca = ? ,custo = ? ,quantidade = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(5, objeto.getId());
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getQuantidade());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    
    //Relatorio de amigos.
    public boolean selectAmigoDB(Amigo objeto) {
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ?????");
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                
                /*Aluno objeto = new Aluno(curso, fase, id, nome, idade);
                minhaLista.add(objeto);*/
            }
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
        return true;
    }

    //Inserindo amigo no banco de dados.
    public boolean insertAmigoDB(Amigo objeto) {
        String sql = "INSERT INTO ??????(id,nome,telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    //Deletando um amigo do banco de dados.
    public boolean deleteAmigoDB(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM ??????? WHERE id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    //Editando um amigo pelo seu ID.
    public boolean updateAmigoDB(Amigo objeto) {
        String sql = "UPDATE ??????? set nome = ? ,telefone = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
             stmt.setInt(3, objeto.getId());
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
}
