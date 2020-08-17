package model;

public class Profissional extends Pessoa{
    private String departamento;
    private String especialidade;

    public Profissional() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "|id='" + getId() + '\'' +
                "|nome='" + getNome() + '\'' +
                "|departamento='" + departamento + '\'' +
                "|especialidade='" + especialidade + '\'' +
                '|';
    }
}
