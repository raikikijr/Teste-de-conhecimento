package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda {
    private int id;
    private Paciente paciente;
    private Profissional profissional;
    private Date hora;
    private Date data;

    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "|id='" + id + "'" +
                "|nome do paciente='" + paciente.getNome() + "'" +
                "|nome do profissional='" + profissional.getNome() + "'" +
                "|hora=" +  new SimpleDateFormat("HH:mm").format(hora) +
                "|data=" + new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(data) +
                '|';
    }
}
