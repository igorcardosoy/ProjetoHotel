package view;

import model.acomodacoes.*;
import model.enums.Estados;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Hotel {
  private List<Administrador> administradores;
  private List<Hospede> hospedes;
  private List<Funcionario> funcionarios;

  private List<ItensConsumo> itensConsumoDisponiveis;

  private List<Acomodacao> acomodacoesDisponiveis;
  private List<TipoAcomodacao> tiposAcomodacao;

  private List<Reserva> reservas;
  private List<Acomodado> acomodados;

  private final Scanner scanner = new Scanner(System.in);

  public Hotel() {
    administradores = new ArrayList<>(5);
    hospedes = new ArrayList<>(100);
    funcionarios = new ArrayList<>(10);

    itensConsumoDisponiveis = new ArrayList<>(100);

    acomodacoesDisponiveis = new ArrayList<>(100);
    tiposAcomodacao = new ArrayList<>(10);

    reservas = new ArrayList<>(100);
    acomodados = new ArrayList<>(100);
  }

  public void init() {
    String opcao;
    String title = "Hotel";

    do {
      Object[] questions = {
              "Cadastrar administrador",
              "Cadastrar funcionario",
              "Cadastrar hospede",
              "Cadastrar acomodacao",
              "Cadastrar tipo de acomodacao",
              "Cadastrar item de consumo",
              "Cadastrar reserva",
              "Cadastrar acomodado",
              "Cadastrar consumo",
              "Ver administradores",
              "Sair"};

      opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE, null, questions, questions[0]);

      menu(opcao);

    } while (!opcao.equals("Sair"));
  }

  private void menu(String opcao){
    switch (opcao) {
      case "Cadastrar administrador":
        cadastrarAdministrador();
        break;
//      case "Cadastrar funcionario":
//        cadastrarFuncionario();
//        break;
//      case "Cadastrar hospede":
//        cadastrarHospede();
//        break;
//      case "Cadastrar acomodacao":
//        cadastrarAcomodacao();
//        break;
//      case "Cadastrar tipo de acomodacao":
//        cadastrarTipoAcomodacao();
//        break;
//      case "Cadastrar item de consumo":
//        cadastrarItemConsumo();
//        break;
//      case "Cadastrar reserva":
//        cadastrarReserva();
//        break;
//      case "Cadastrar acomodado":
//        cadastrarAcomodado();
//        break;
//      case "Cadastrar consumo":
//        cadastrarConsumo();
//        break;
      case "Ver administradores":
        mostrarAdministradores();
        break;
      case "Sair":
        System.out.println("Saindo...");
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  private void cadastrarAdministrador() {

    String title = "Cadastrar administrador";

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do administrador", title, JOptionPane.QUESTION_MESSAGE);
    int telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o telefone do administrador", title, JOptionPane.QUESTION_MESSAGE));
    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do administrador", title, JOptionPane.QUESTION_MESSAGE);


    Object[] estados = new Object[Estados.values().length];
    System.arraycopy(Estados.values(), 0, estados, 0, estados.length);
    Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do administrador", title, JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

    LocalDate dataNascimento = null;
    boolean done = false;
    while (!done) {
      try {
        dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de nascimento do administrador", title, JOptionPane.QUESTION_MESSAGE));
        done = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
      }
    }

    administradores.add(new Administrador(nome, telefone, cidade, estado, dataNascimento));
  }

  private void mostrarAdministradores() {
    String title = "Administradores";
    StringBuilder message = new StringBuilder();

    for (Administrador administrador : administradores) {
      message.append(administrador.toString()).append("\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), title, JOptionPane.INFORMATION_MESSAGE);
  }

}
