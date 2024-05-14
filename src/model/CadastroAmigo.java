package model;

public class CadastroAmigo {

    private String nome;
    private String telefone;


    public CadastroAmigo() {
        this("", "");
    }

    public CadastroAmigo(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
   
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
