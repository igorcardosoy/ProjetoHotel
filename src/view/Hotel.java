package view;

import model.acomodacoes.*;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

// Definição da classe Hotel
public class Hotel {

  // Atributos da classe
  private int nivelAcesso;
  private Pessoa pessoa;

  private final List<Administrador> administradores;
  private final List<Hospede> hospedes;
  private final List<Funcionario> funcionarios;

  private final List<ItensConsumo> itensConsumoDisponiveis;

  private final List<Acomodacao> acomodacoesDisponiveis;
  private final List<TipoAcomodacao> tiposAcomodacao;

  private final List<Reserva> reservas;
  private final List<Acomodado> acomodados;

  private final Scanner scanner = new Scanner(System.in);
  private final Object[] estados = Estados.values();

  // Construtor da classe Hotel
  public Hotel() {
    // Inicialização das listas e chamada do método defaultValues()
    administradores = new ArrayList<>(5);
    hospedes = new ArrayList<>(100);
    funcionarios = new ArrayList<>(10);

    itensConsumoDisponiveis = new ArrayList<>(100);

    acomodacoesDisponiveis = new ArrayList<>(100);
    tiposAcomodacao = new ArrayList<>(10);

    reservas = new ArrayList<>(100);
    acomodados = new ArrayList<>(100);

    defaultValues();
  }

  // Método para iniciar o hotel
  public void init() {
    String opcao = "";
    String title = "Hotel";
    boolean quit = false;

    while (!quit) {

      int escolha;

      // Opções de acesso
      Object[] acessos = {
              "Sair",
              "Hospede",
              "Funcionario",
              "Administrador" };

      do {
        // Janela de diálogo para escolher o acesso
        escolha = JOptionPane.showOptionDialog(null, "Escolha um acesso", title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, acessos, acessos[1]);
        nivelAcesso(escolha);
        if (nivelAcesso == -1) {
          quit = true;
        }
      } while (nivelAcesso == 0);

      // Loop enquanto a opção não for "Sair" e o nível de acesso for maior que 0
      while (!opcao.equals("Sair") && nivelAcesso > 0) {
        // Opções específicas de acordo com o nível de acesso
        Object[] questions = functionsAceess();

        // Janela de diálogo para escolher uma opção
        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
                null, questions, questions[0]);

        // Execução da opção escolhida
        menu(opcao);
      }
    }
  }

  // Métodos privados auxiliares utilizando JOptionPane

  // Método que retorna as opções de acordo com o nível de acesso
  private Object[] functionsAceess(){
    Object[] functionADM = {};
    Object[] functionFUNC = {};

    if (nivelAcesso == 3) {
      // Opções específicas para administradores
      functionADM = new Object[]{
              "Cadastrar administrador",
              "Cadastrar funcionario",
              "Cadastrar tipo de acomodacao",
              "Cadastrar acomodacao",
              "Ver funcionarios",
              "Ver administradores"
      };
    }

    if (nivelAcesso >= 2) {
      // Opções específicas para funcionários
      functionFUNC = new Object[]{
              "Cadastrar reserva",
              "Cadastrar acomodado",
              "Cadastrar item de consumo",
              "Cadastrar consumo",
              "Cadastrar hospede"
      };
    }

    // Opções padrão
    Object[] functionDefault = {
            "Encerrar estadia",
            "Mudar acesso"
    };

    // Juntar as funções ADM, FUNC e DEFAULT
    Object[] questions = new Object[functionADM.length + functionFUNC.length + functionDefault.length];

    System.arraycopy(functionADM, 0, questions, 0, functionADM.length);
    System.arraycopy(functionFUNC, 0, questions, functionADM.length, functionFUNC.length);
    System.arraycopy(functionDefault, 0, questions, functionADM.length + functionFUNC.length, functionDefault.length);

    return questions;
  }

  // Método que gerencia o nível de acesso
  private void nivelAcesso(int acesso) {
    switch (acesso) {
      case 3:
        ADMAccess();
        break;
      case 2:
        // Nível de acesso para funcionários
        FuncAccess();
        break;
      case 1:
        // Entrar como hóspede? Sim ou não
        HospedeAccess();
        break;
      case 0:
        // Sair...
        nivelAcesso = -1;
        break;
    }
  }

  // Método para entrar como administrador
  private void ADMAccess() {

    int senha;

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
          pessoa = adm;
          break;
        }
      }

      senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de administrador",
              JOptionPane.QUESTION_MESSAGE));
      assert adm != null;
      if (adm.allowAccess(senha)) {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
      } else {
        nivelAcesso = 3;
      }
    }
  }

  // Método para entrar como funcionário
  private void FuncAccess() {
    int senha;

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

      // Senha para entrar como funcionário
      senha = Integer.parseInt(
              JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE));
      assert func != null;
      if (func.allowAccess(senha)) {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
      } else {
        nivelAcesso = 2;
        pessoa = func;
      }
    }
  }

  // Método para entrar como hóspede
  private void HospedeAccess() {
    if (JOptionPane.showConfirmDialog(null, "Deseja entrar como hospede?", "Acesso de hospede",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
      nivelAcesso = 1;
      pessoa = null;
    } else {
      nivelAcesso = 0;
    }
  }

  // Método que gerencia as opções do menu
  private void menu(String opcao) {
    switch (opcao) {
      case "Cadastrar administrador":
        cadastrarAdministrador();
        break;
      case "Cadastrar funcionario":
        cadastrarFuncionario();
        break;
      case "Ver administradores":
        mostrarAdministradores();
        break;
      case "Ver funcionarios":
        mostrarFuncionarios();
        break;
      case "Cadastrar hospede":
        cadastrarHospede();
        break;
      case "Cadastrar reserva":
        cadastrarReserva();
        break;
      case "Cadastrar acomodado":
        cadastrarAcomodado();
        break;
      case "Cadastrar item de consumo":
        cadastrarItemConsumo();
        break;
      case "Cadastrar tipo de acomodacao":
        cadastrarTipoAcomodacao();
        break;
      case "Cadastrar acomodacao":
        cadastrarAcomodacao();
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

  // Método para cadastrar um administrador
  private void cadastrarAdministrador() {
    // Janela de diálogo para coletar informações do administrador
    String title = "Cadastrar administrador";

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do administrador", title,
            JOptionPane.QUESTION_MESSAGE);

    int telefone = Integer.parseInt(
            JOptionPane.showInputDialog(null, "Digite o telefone do administrador", title, JOptionPane.QUESTION_MESSAGE));

    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do administrador", title,
            JOptionPane.QUESTION_MESSAGE);

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

    // Adicionar o administrador à lista
    administradores.add(new Administrador(nome, telefone, cidade, estado, dataNascimento));
  }

  // Método para cadastrar um funcionário
  private void cadastrarFuncionario(){
    // Janela de diálogo para coletar informações do funcionário
    String title = "Cadastrar funcionario";

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionario", title,
            JOptionPane.QUESTION_MESSAGE);
    int telefone = Integer.parseInt( JOptionPane.showInputDialog(null, "Digite o telefone do funcionario", title,
            JOptionPane.QUESTION_MESSAGE));
    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do funcionario", title, JOptionPane.QUESTION_MESSAGE);

    Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do funcionario", title,
            JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

    LocalDate dataNascimento = null;
    boolean done = false;
    while (!done) {
      try {
        dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
                "Digite a data de nascimento do funcionario", title, JOptionPane.QUESTION_MESSAGE));
        done = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
      }
    }

    // Adicionar o funcionário à lista
    if (pessoa instanceof Administrador administrador){
      administrador.cadastrarFuncionario(nome, telefone, cidade, estado, dataNascimento, funcionarios);
    }
  }

  // Método para cadastrar um hóspede
  private void cadastrarHospede() {
    // Janela de diálogo para coletar informações do hóspede
    String title = "Cadastrar hospede";

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do hospede", title, JOptionPane.QUESTION_MESSAGE);
    int telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o telefone do hospede", title,
            JOptionPane.QUESTION_MESSAGE));
    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do hospede", title, JOptionPane.QUESTION_MESSAGE);

    Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do hospede", title,
            JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

    LocalDate dataNascimento = null;
    boolean done = false;
    while (!done) {
      try {
        dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
                "Digite a data de nascimento do hospede", title, JOptionPane.QUESTION_MESSAGE));
        done = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
      }
    }

    String pais = JOptionPane.showInputDialog(null, "Digite o pais do hospede", title, JOptionPane.QUESTION_MESSAGE);

    String email = JOptionPane.showInputDialog(null, "Digite o email do hospede", title, JOptionPane.QUESTION_MESSAGE);

    // Selecionar o tipo de documento
    Object[] tiposDoc = {"CPF", "RG", "Passaporte"};
    TipoDoc tipoDoc = (TipoDoc) JOptionPane.showInputDialog(null, "Escolha o tipo de documento", title,
            JOptionPane.QUESTION_MESSAGE, null, tiposDoc, tiposDoc[0]);

    int numDoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do documento", title,
            JOptionPane.QUESTION_MESSAGE));

    String nomeMae = JOptionPane.showInputDialog(null, "Digite o nome da mae do hospede", title,
            JOptionPane.QUESTION_MESSAGE);

    String nomePai = JOptionPane.showInputDialog(null, "Digite o nome do pai do hospede", title,
            JOptionPane.QUESTION_MESSAGE);

    // Adicionar o hóspede à lista

    if (nivelAcesso >= 2){
      if (pessoa instanceof Funcionario funcionario)
        funcionario.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
      if (pessoa instanceof Administrador administrador)
        administrador.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
    }
  }

  // TO DO
  private void cadastrarReserva() {

  }

  // TO DO
  private void cadastrarAcomodado() {

  }

  // TO DO
  private void cadastrarItemConsumo() {

  }

  // TO DO
  private void cadastrarTipoAcomodacao() {

  }

  // TO DO
  private void cadastrarAcomodacao() {

  }

  private void mostrarHospedes() {
    String title = "Hospedes";
    StringBuilder message = new StringBuilder();

    message.append("--------------------------------------------------").append("\n");
    for (Hospede hospede : hospedes) {
      message.append(hospede.toString()).append("\n");
      message.append("--------------------------------------------------").append("\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Método para mostrar os administradores em uma janela de diálogo
  private void mostrarAdministradores() {
    String title = "Administradores";
    StringBuilder message = new StringBuilder();

    message.append("--------------------------------------------------").append("\n");
    for (Administrador administrador : administradores) {
      message.append(administrador.toString()).append("\n");
      message.append("--------------------------------------------------").append("\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Método para mostrar os funcionários em uma janela de diálogo
  private void mostrarFuncionarios() {
    String title = "Funcionarios";
    StringBuilder message = new StringBuilder();

    message.append("--------------------------------------------------").append("\n");
    for (Funcionario funcionario : funcionarios) {
      message.append(funcionario.toString()).append("\n");
      message.append("--------------------------------------------------").append("\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Método para configurar valores padrão
  private void defaultValues(){
    // Cadastrar administradores
    administradores.add(new Administrador("Igor", 16992479541L, "Ibaté", Estados.SP, LocalDate.parse("2005-04-18")));
    pessoa = administradores.getFirst();

    // Cadastrar funcionários
    if (pessoa instanceof Administrador administrador){
      administrador.cadastrarFuncionario("Caua", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-03-16"), funcionarios);
      administrador.cadastrarFuncionario("Pedro", 123456789, "São Carlos", Estados.SP, LocalDate.parse("2003-08-21"), funcionarios);
      administrador.cadastrarFuncionario("Eduardo", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-07-12"), funcionarios);
    }
  }
}
