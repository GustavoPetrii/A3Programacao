/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

public class Emprestimo {

    private int idFerramenta;
    private int idAmigo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    
     public Emprestimo() {
        this(0, 0,new Date(0), new Date(0) );
    }


    public Emprestimo(int idFerramenta, int idAmigo, Date dataEmprestimo, Date dataDevolucao) {
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;

    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "idFerramenta=" + idFerramenta + ", idAmigo=" + idAmigo + '}';
    }
    
    
    
}
