package view;

import control.AgendaControl;
import control.PacienteControl;
import control.ProfissionalControl;
import model.Agenda;
import model.Paciente;
import model.Profissional;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        try {
            cadastroPessoas();

        } catch (InterruptedException e) {
            System.out.println("Erro no sistema.");
        }
    }

    public static void cadastroPessoas() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        List<Profissional> listaProfissional = new ArrayList<>();
        List<Paciente> listaPaciente = new ArrayList<>();
        List<Agenda> listaAgenda = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Cadastra Paciente");
            System.out.println("Opção 2 - Cadastra profissional");
            System.out.println("Opção 3 - Atualizar Paciente");
            System.out.println("Opção 4 - Atualizar profissional");
            System.out.println("Opção 5 - Atualizar agenda");
            System.out.println("Opção 6 - Remover Paciente");
            System.out.println("Opção 7 - Remover profissional");
            System.out.println("Opção 8 - Remover agendamento");
            System.out.println("Opção 9 - Agendar Consulta");
            System.out.println("Opção 10 - Listar toda Agenda");
            System.out.println("Opção 0 - Sair do programa");
            System.out.println("_______________________");

            System.out.print("Digite aqui sua opção: ");

            String verificandoOpcao = sc.nextLine();

            if (isNumeric(verificandoOpcao)){
                opcao = Integer.parseInt(verificandoOpcao);

            } else {
                System.out.println("Opção inválida.");
                opcao = 11;
                Thread.currentThread().sleep(2000);
            }

            if (opcao == 1) {


                System.out.print("Digite o nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite o endereço: ");
                String endereco = sc.nextLine();

                System.out.print("Digite a idade: ");
                String idade = sc.nextLine();

                System.out.println();
                PacienteControl pacienteControl = new PacienteControl();
                String validacaoCadastro = pacienteControl.validacao(nome, endereco, idade);

                if (validacaoCadastro.isEmpty()) {
                    int idPaciente = listaPaciente.size() + 1;
                    Paciente paciente = pacienteControl.cadastrar(nome, endereco, idade, idPaciente);
                    System.out.println(paciente.toString());
                    listaPaciente.add(paciente);
                    System.out.println("Cadastrado com sucesso!");
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                } else {
                    System.out.println(validacaoCadastro);
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                }
            }
            if (opcao == 2) {


                System.out.print("Digite o nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite o Departamento: ");
                String departamento = sc.nextLine();

                System.out.print("Digite a sua Especialidade: ");
                String especialidade = sc.nextLine();

                System.out.println();
                ProfissionalControl profissionalControl = new ProfissionalControl();
                String validacaoCadastro = profissionalControl.validacao(nome, departamento, especialidade);

                if (validacaoCadastro.isEmpty()) {
                    int idProfissional = listaProfissional.size() + 1;
                    Profissional profissional = profissionalControl.cadastrar(nome, departamento, especialidade, idProfissional);
                    System.out.println(profissional.toString());
                    listaProfissional.add(profissional);
                    System.out.println("Cadastrado com sucesso!");
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                } else {
                    System.out.println(validacaoCadastro);
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                }
            }
            if (opcao == 3) {
                System.out.println("Lista de paciente.");
                System.out.println("____________________________");
                for (Paciente paciente : listaPaciente) {
                    System.out.println(paciente.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do paciente que deseja atualizar");
                int idPaciente = Integer.parseInt(sc.nextLine());
                PacienteControl pacienteControl = new PacienteControl();
                Paciente paciente = pacienteControl.selecionandoPaciente(listaPaciente, idPaciente);
                if (paciente != null) {

                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Digite a idade: ");
                    String idade = sc.nextLine();
                    System.out.println();
                    String validacaoCadastro = pacienteControl.validacao(nome, endereco, idade);

                    if (validacaoCadastro.isEmpty()) {
                        Paciente pacienteAtualizado = pacienteControl.cadastrar(nome, endereco, idade, idPaciente);
                        System.out.println(pacienteAtualizado.toString());
                        listaPaciente.add(pacienteAtualizado);
                        listaPaciente.remove(paciente);
                        System.out.println("Atualizado com sucesso!");
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    } else {
                        System.out.println(validacaoCadastro);
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    }
                } else {
                    System.out.println("Não existe nenhum paciente com esse ID ");
                }
            }
            if (opcao == 4) {
                System.out.println("Lista de profissional.");
                System.out.println("____________________________");
                for (Profissional profissional : listaProfissional) {
                    System.out.println(profissional.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do profissional que deseja atualizar");
                int idProfissional = Integer.parseInt(sc.nextLine());
                ProfissionalControl profissionalControl = new ProfissionalControl();
                Profissional profissional = profissionalControl.selecionandoProfissional(listaProfissional, idProfissional);
                if (profissional != null) {

                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o seu departamento: ");
                    String departamento = sc.nextLine();

                    System.out.print("Digite a sua especialidade: ");
                    String especialidade = sc.nextLine();
                    System.out.println();
                    String validacaoCadastro = profissionalControl.validacao(nome, departamento, especialidade);

                    if (validacaoCadastro.isEmpty()) {
                        Profissional profissionalAtualizado = profissionalControl.cadastrar(nome, departamento, especialidade, idProfissional);
                        System.out.println(profissionalAtualizado.toString());
                        listaProfissional.add(profissionalAtualizado);
                        listaProfissional.remove(profissional);
                        System.out.println("Profissional atualizado com sucesso!");
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    } else {
                        System.out.println(validacaoCadastro);
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    }
                } else {
                    System.out.println("Não existe nenhum profissional com esse ID ");
                }
            }
            if (opcao == 5) {


                System.out.println("Lista de profissional.");
                System.out.println("____________________________");
                for (Profissional profissional : listaProfissional) {
                    System.out.println(profissional.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do profissional que deseja atualizar na Agenda");
                int idProfissional = Integer.parseInt(sc.nextLine());
                ProfissionalControl profissionalControl = new ProfissionalControl();
                Profissional profissional = profissionalControl.selecionandoProfissional(listaProfissional, idProfissional);
                System.out.println("Lista de paciente.");
                System.out.println("____________________________");
                for (Paciente paciente : listaPaciente) {
                    System.out.println(paciente.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do paciente que deseja atualizar");
                int idPaciente = Integer.parseInt(sc.nextLine());
                PacienteControl pacienteControl = new PacienteControl();
                Paciente paciente = pacienteControl.selecionandoPaciente(listaPaciente, idPaciente);

                    System.out.print("Digite a hora da consulta (Exemplo: 12:30 ) : ");
                    String hora = sc.nextLine();

                    System.out.print("Digite o dia da consulta (Exemplo: 23/08/2020) : ");
                    String data = sc.nextLine();

                    System.out.println();
                    String validacaoCadastro = AgendaControl.validacao(hora, data , paciente, profissional );
                    if (validacaoCadastro.isEmpty()) {
                        int idAgenda = listaAgenda.size() + 1;
                        AgendaControl agendaControl = new AgendaControl();
                        Agenda agenda = agendaControl.selecionandoAgenda(listaAgenda, idAgenda);
                        Agenda agendaAtualizada = AgendaControl.cadastrar(hora, data, paciente, profissional, idPaciente);
                        System.out.println(agendaAtualizada.toString());
                        listaAgenda.add(agendaAtualizada);
                        listaAgenda.remove(agenda);
                        System.out.println("Atualidado com sucesso!");
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    } else {
                        System.out.println(validacaoCadastro);
                        Thread.currentThread().sleep(4000);
                        System.out.println("____________________________");
                    }

            }

            if (opcao == 6) {
                System.out.println("Lista de paciente.");
                System.out.println("____________________________");
                for (Paciente paciente : listaPaciente) {
                    System.out.println(paciente.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do paciente que deseja remover");
                int idPaciente = Integer.parseInt(sc.nextLine());
                PacienteControl pacienteControl = new PacienteControl();
                Paciente paciente = pacienteControl.selecionandoPaciente(listaPaciente, idPaciente);

                if (paciente != null) {
                    System.out.println("Deseja realmente remover o paciente " + paciente.getNome() + "? S ou N");
                    String verificandoExclusao = sc.nextLine();
                    if (verificandoExclusao.equals("S") || verificandoExclusao.equals("s")) {
                        listaPaciente.remove(paciente);
                        System.out.println("Paciente " + paciente.getNome() + " foi removido com sucesso!");
                        System.out.println("____________________________");
                        Thread.currentThread().sleep(4000);
                    } else {
                        System.out.println(" Retornando para o menu principal. ");
                        System.out.println("____________________________");
                        Thread.currentThread().sleep(4000);
                    }
                } else {
                    System.out.println("Não existe nenhum paciente com esse ID ");
                    System.out.println("____________________________");
                    Thread.currentThread().sleep(4000);
                }
            }

            if (opcao == 7) {
                System.out.println("Lista de profissional.");
                System.out.println("____________________________");
                for (Profissional profissional : listaProfissional) {
                    System.out.println(profissional.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do profissional que deseja Remover");
                int idProfissional = Integer.parseInt(sc.nextLine());
                ProfissionalControl profissionalControl = new ProfissionalControl();
                Profissional profissional = profissionalControl.selecionandoProfissional(listaProfissional, idProfissional);
                if (profissional != null) {
                    System.out.println("Deseja realmente remover o profissional " + profissional.getNome() + "? S ou N");
                    String verificandoExclusao = sc.nextLine();
                    if (verificandoExclusao.equals("S") || verificandoExclusao.equals("s")) {
                        listaPaciente.remove(profissional);
                        System.out.println("Profissional " + profissional.getNome() + " foi removido com sucesso!");
                        System.out.println("____________________________");
                        Thread.currentThread().sleep(4000);
                    } else {
                        System.out.println(" Retornando para o menu principal. ");
                        System.out.println("____________________________");
                        Thread.currentThread().sleep(4000);
                    }
                } else {
                    System.out.println("Não existe nenhum profissional com esse ID ");
                    System.out.println("____________________________");
                    Thread.currentThread().sleep(4000);
                }
            }
            if (opcao == 8){

                System.out.println("Lista de Agendamento.");
                System.out.println("____________________________");
                for (Agenda agenda : listaAgenda) {
                    System.out.println(agenda.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID da agenda que deseja remover");
                int idAgenda = Integer.parseInt(sc.nextLine());
                AgendaControl agendaControl = new AgendaControl();
                Agenda agenda = AgendaControl.selecionandoAgenda(listaAgenda, idAgenda);

                System.out.println("Deseja realmente remover esse agendamento? " + agenda.toString() + "? S ou N");
                String verificandoExclusao = sc.nextLine();
                if (verificandoExclusao.equals("S") || verificandoExclusao.equals("s")) {
                    listaAgenda.remove(agenda);
                    System.out.println("O Agendamento " + agenda.toString() + " foi removido com sucesso!");
                    System.out.println("____________________________");
                    Thread.currentThread().sleep(4000);
                } else {
                    System.out.println(" Retornando para o menu principal. ");
                    System.out.println("____________________________");
                    Thread.currentThread().sleep(4000);
                }
                if (agenda != null){


                }

            }
            if (opcao == 9) {

                System.out.println("Lista de profissional.");
                System.out.println("____________________________");
                for (Profissional profissional : listaProfissional) {
                    System.out.println(profissional.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do profissional que deseja cadastrar na Agenda");
                int idProfissional = Integer.parseInt(sc.nextLine());
                ProfissionalControl profissionalControl = new ProfissionalControl();
                Profissional profissional = profissionalControl.selecionandoProfissional(listaProfissional, idProfissional);
                System.out.println("Lista de paciente.");
                System.out.println("____________________________");
                for (Paciente paciente : listaPaciente) {
                    System.out.println(paciente.toString());
                }
                System.out.println("____________________________");
                System.out.println("Digite o ID do paciente que deseja atualizar");
                int idPaciente = Integer.parseInt(sc.nextLine());
                PacienteControl pacienteControl = new PacienteControl();
                Paciente paciente = pacienteControl.selecionandoPaciente(listaPaciente, idPaciente);
                System.out.print("Digite a hora da consulta (Exemplo: 12:30) :");
                String hora = sc.nextLine();

                System.out.print("Digite o dia da consulta (Exemplo: 23/11/2020) :");
                String data = sc.nextLine();

                System.out.println();
                String validacaoCadastro = AgendaControl.validacao(hora, data, paciente , profissional);
                if (validacaoCadastro.isEmpty()) {
                    int idAgenda = listaAgenda.size() + 1;
                    Agenda agenda = AgendaControl.cadastrar(hora, data, paciente, profissional, idAgenda);
                    System.out.println(agenda.toString());
                    listaAgenda.add(agenda);
                    System.out.println("Cadastrado com sucesso!");
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                } else {
                    System.out.println(validacaoCadastro);
                    Thread.currentThread().sleep(4000);
                    System.out.println("____________________________");
                }

            }
            if (opcao == 10){
                System.out.println("Agenda completa");
                System.out.println("____________________________");

                for (Agenda agenda : listaAgenda) {
                    System.out.println(agenda.toString());
                }
                Thread.currentThread().sleep(4000);
                System.out.println("____________________________");
            }
        }

        while (opcao != 0);
        sc.close();
    }
    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}