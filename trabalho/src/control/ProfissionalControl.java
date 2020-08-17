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
            retorno = "Erro ao inserir o nome";
            cont++;
        }

        if (departamento.isEmpty()) {
            retorno = cont < 1 ? "Erro ao inserir o departamento" : retorno.concat(", erro no campo departamento");
            cont++;
        }

        if (especialidade.isEmpty()) {
            retorno = cont < 1 ? "Erro ao inserir a especialidade" : retorno.concat(", erro no campo especialidade");
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
