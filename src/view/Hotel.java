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
import java.util.*;

public class Hotel {

  private int nivelAcesso;

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
    String opcao = "";
    String title = "Hotel";
    boolean quit = false;

    while (!quit) {

      int escolha;

      Object[] acessos = {
          "Sair",
          "Hospede",
          "Funcionario",
          "Administrador" };

      do {
        escolha = JOptionPane.showOptionDialog(null, "Escolha um acesso", title, JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, acessos, acessos[1]);
        nivelAcesso(escolha);
        if (nivelAcesso == -1) {
          quit = true;
        }
      } while (nivelAcesso == 0);

      while (!opcao.equals("Sair") && nivelAcesso > 0) {
        Object[] questions = functionAceess();

        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, questions, questions[0]);

        menu(opcao);
      }
    }
  }

  private Object[] functionAceess(){
    Object[] functionADM = {};
    Object[] functionFUNC = {};

    if (nivelAcesso == 3) {
      functionADM = new Object[]{
              "Cadastrar administrador",
              "Cadastrar funcionario",
              "Ver administradores",
              "Cadastrar tipo de acomodacao"
      };
    }

    if (nivelAcesso >= 2) {
      functionFUNC = new Object[]{
              "Cadastrar hospede",
              "Cadastrar acomodacao",
              "Cadastrar item de consumo",
              "Cadastrar reserva",
              "Cadastrar acomodado",
              "Cadastrar consumo"
      };
    }

    Object[] functionDefault = {
            "Encerrar estadia",
            "Mudar acesso"
    };

    // Juntar as funcoes ADM, FUNC e DEFAULT
    Object[] questions = new Object[functionADM.length + functionFUNC.length + functionDefault.length];

    System.arraycopy(functionADM, 0, questions, 0, functionADM.length);
    System.arraycopy(functionFUNC, 0, questions, functionADM.length, functionFUNC.length);
    System.arraycopy(functionDefault, 0, questions, functionADM.length + functionFUNC.length, functionDefault.length);

    return questions;
  }

  private void nivelAcesso(int acesso) {

    int senha;

    switch (acesso) {
      case 3:
        if (administradores.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Nao ha administradores cadastrados");
          cadastrarAdministrador();
        } else {
          // Selecionar qual administrador de acordo com o nome.
          Object[] nomes = new Object[administradores.size()];
          for (int i = 0; i < administradores.size(); i++) {
            nomes[i] = administradores.get(i).getNome();
          }

          String nome = (String) JOptionPane.showInputDialog(null, "Escolha um administrador", "Acesso de administrador",
                  JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

          Administrador adm = null;

          for (Administrador lista : administradores) {
            if (lista.getNome().equals(nome)) {
              adm = lista;
              break;
            }
          }

          // Senha para acesso de administrador
          senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de administrador",
                  JOptionPane.QUESTION_MESSAGE));
          assert adm != null;
          if (adm.allowAccess(senha)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
          } else {
            nivelAcesso = 3;
          }
        }
        break;
      case 2:
        if (funcionarios.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Nao ha funcionarios cadastrados");
        } else {
          Object[] nomesFuncionarios = new Object[funcionarios.size()];
          for (int i = 0; i < funcionarios.size(); i++) {
            nomesFuncionarios[i] = funcionarios.get(i).getNome();
          }

          String nomeFuncionario = (String) JOptionPane.showInputDialog(null, "Escolha um funcionario",
                  "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE, null, nomesFuncionarios, nomesFuncionarios[0]);

          Funcionario func = null;

          for (Funcionario lista : funcionarios) {
            if (lista.getNome().equals(nomeFuncionario)) {
              func = lista;
              break;
            }
          }

          // Senha para entrar como funcionario
          senha = Integer.parseInt(
                  JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE));
          assert func != null;
          if (func.allowAccess(senha)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
          } else {
            nivelAcesso = 2;
          }
          break;
        }
      case 1:
        // Entrar como hospede? Sim ou não
        if (JOptionPane.showConfirmDialog(null, "Deseja entrar como hospede?", "Acesso de hospede",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          nivelAcesso = 1;
        } else {
          nivelAcesso = 0;
        }
        break;
      case 0:
        // Sair...
        nivelAcesso = -1;
        break;
    }
  }

  private void menu(String opcao) {
    switch (opcao) {
      case "Cadastrar administrador":
        cadastrarAdministrador();
        break;
      // case "Cadastrar funcionario":
      // cadastrarFuncionario();
      // break;
      // case "Cadastrar hospede":
      // cadastrarHospede();
      // break;
      // case "Cadastrar acomodacao":
      // cadastrarAcomodacao();
      // break;
      // case "Cadastrar tipo de acomodacao":
      // cadastrarTipoAcomodacao();
      // break;
      // case "Cadastrar item de consumo":
      // cadastrarItemConsumo();
      // break;
      // case "Cadastrar reserva":
      // cadastrarReserva();
      // break;
      // case "Cadastrar acomodado":
      // cadastrarAcomodado();
      // break;
      // case "Cadastrar consumo":
      // cadastrarConsumo();
      // break;
      case "Ver administradores":
        mostrarAdministradores();
        break;
      case "Mudar acesso":
        nivelAcesso = 0;
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

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do administrador", title,
        JOptionPane.QUESTION_MESSAGE);
    int telefone = Integer.parseInt(
        JOptionPane.showInputDialog(null, "Digite o telefone do administrador", title, JOptionPane.QUESTION_MESSAGE));
    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do administrador", title,
        JOptionPane.QUESTION_MESSAGE);

    Object[] estados = new Object[Estados.values().length];
    System.arraycopy(Estados.values(), 0, estados, 0, estados.length);
    Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do administrador", title,
        JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

    LocalDate dataNascimento = null;
    boolean done = false;
    while (!done) {
      try {
        dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
            "Digite a data de nascimento do administrador", title, JOptionPane.QUESTION_MESSAGE));
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
