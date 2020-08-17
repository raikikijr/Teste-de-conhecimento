package control;

import model.Agenda;
import model.Paciente;
import model.Profissional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AgendaControl {

    public static Agenda cadastrar(String hora, String data, Paciente paciente, Profissional profissional, int id) {
        Agenda agenda = new Agenda();
        agenda.setHora(converteStringParaHora(hora));
        agenda.setData(converteStringParaData(data));
        agenda.setPaciente(paciente);
        agenda.setProfissional(profissional);
        agenda.setId(id);
        return agenda;
    }

    private static Date converteStringParaData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;
        try {
            dataFormatada = formato.parse(data);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
        }

        return dataFormatada;
    }

    private static Date converteStringParaHora(String hora) {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
        Date horaFormatada = null;
        try {
            horaFormatada = formato.parse(hora);
        } catch (ParseException e) {
            System.out.println("Hora inválida!");
        }

        return horaFormatada;
    }

    public static String validacao(String hora, String data, Paciente paciente, Profissional profissional) {
        int cont = 0;
        String retorno = "";
        if (hora.isEmpty()) {
            retorno = "Erro ao inserir hora";
            cont++;
        }

        if (data.isEmpty()) {
            retorno = cont < 1 ? "Erro ao inserir data" : retorno.concat(", erro no campo Data");
            cont++;
        }

        if (paciente == null) {
            retorno = cont < 1 ? "Selecione um paciente" : retorno.concat(", selecione um paciente");
            cont++;
        }
        if (profissional == null) {
            retorno = cont < 1 ? "selecine um profissional" : retorno.concat(", selecione um profissional");
        }
        return retorno;

    }

    public static Agenda selecionandoAgenda(List<Agenda> listaAgenda, int numeroId) {
        for (Agenda agenda : listaAgenda) {
            if (agenda.getId() == numeroId) {
                return agenda;
            }
        }
        return null;
    }

}