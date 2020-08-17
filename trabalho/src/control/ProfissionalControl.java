package control;

import model.Profissional;

import java.util.List;

public class ProfissionalControl {

    public Profissional cadastrar(String nome, String departamento, String especialidade, int id) {
        Profissional profissional = new Profissional();
        profissional.setNome(nome);
        profissional.setDepartamento(departamento);
        profissional.setEspecialidade(especialidade);
        profissional.setId(id);

        return profissional;
    }

    public String validacao(String nome, String departamento, String especialidade) {
        int cont = 0;
        String retorno = "";
        if (nome.isEmpty()) {
            retorno = "Por favor insira seu nome";
            cont++;
        }

        if (departamento.isEmpty()) {
            retorno = cont < 1 ? "Por favor insira seu departamento" : retorno.concat(", insira seu departamento");
            cont++;
        }

        if (especialidade.isEmpty()) {
            retorno = cont < 1 ? "Por favor insira sua especialidade" : retorno.concat(", insira sua especialidade");
        }
        return retorno;
    }
    public Profissional selecionandoProfissional(List<Profissional> listaProfissional, int numeroId) {
        for ( Profissional profissional : listaProfissional) {
            if (profissional.getId() == numeroId) {
                return profissional;
            }
        }
        return null;
    }
}
