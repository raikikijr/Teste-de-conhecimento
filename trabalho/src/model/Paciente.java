package model;

public class Paciente  extends Pessoa{
    private String endereco;
    private int idade;

    public Paciente() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "|id='" + getId() + '\'' +
                "|nome='" + getNome() + '\'' +
                "|endereco='" + endereco + '\'' +
                "|idade='" + idade +
                '|';
    }
}
