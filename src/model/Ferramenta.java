package model;

public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private double custo;
    private int quantidade;

    public Ferramenta() {
        this(0, "", "", 0, 0);
    }

    public Ferramenta(int id, String nome, String marca, double custo, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.quantidade = quantidade;
    }

    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

