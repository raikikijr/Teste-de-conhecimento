package control;

import model.Paciente;

import java.util.List;

public class PacienteControl {

    public Paciente cadastrar(String nome, String endereco, String idade, int id) {
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setIdade(Integer.parseInt(idade));
        paciente.setEndereco(endereco);
        paciente.setId(id);

        return paciente;
    }

    public String validacao(String nome, String endereco, String idade) {
        int cont = 0;
        String retorno = "";
        if (nome.isEmpty()) {
            retorno = "Por favor insira seu nome";
            cont++;
        }

        if (idade.isEmpty()) {
            retorno = cont < 1 ? "Por favor insira sua idade" : retorno.concat(", insira sua idade");
            cont++;
        }

        if (endereco.isEmpty()) {
            retorno = cont < 1 ? "Por favor insira seu endereço" : retorno.concat(", insira seu endereço");
        }
        return retorno;
    }

    public Paciente selecionandoPaciente(List<Paciente> listaPaciente, int numeroId) {
        for (Paciente paciente : listaPaciente) {
            if (paciente.getId() == numeroId) {
                return paciente;
            }
        }
        return null;
    }

}


