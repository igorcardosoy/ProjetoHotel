package view;

import model.acomodacoes.*;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.itensCosumo.Consumo;
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
  private Pessoa usuario;

  private Object[] funcoesCadastro;
  private Object[] funcoesEditar;
  private Object[] funcoesRemover;
  private Object[] funcoesVizualizar;
  private Object[] funcoesDefault;

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

    funcoesCadastro = new Object[]{};
    funcoesEditar = new Object[]{};
    funcoesRemover = new Object[]{};
    funcoesVizualizar = new Object[]{};
    funcoesDefault = new Object[]{};

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
        functionsAceess();

        Object[] questions;

        if (usuario == null){
         questions = funcoesDefault;
        } else {
          questions = new Object[]{
                  "Cadastros",
                  "Editar",
                  "Remover",
                  "Vizualizar",
                  "Funcoes padrao",
                  "Voltar"
          };
        }

        // Janela de diálogo para escolher uma opção, entre Cadastros, Editar, Remover, Vizualizar e Sair
        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
                null, questions, questions[0]);

        // Execução da opção escolhida
        menu(opcao);
      }
    }
  }

  // Métodos privados auxiliares utilizando JOptionPane

  // Método que retorna as opções de acordo com o nível de acesso
  private void functionsAceess(){
    Object[] functionFUNC = {};

    if (nivelAcesso == 3) {
      // Opções específicas para administradores
      funcoesCadastro = new Object[]{
              "Cadastrar administrador",
              "Cadastrar funcionario",
              "Cadastrar tipo de acomodacao",
              "Cadastrar acomodacao",
      };

      funcoesEditar = new Object[]{
              "Editar administrador",
              "Editar funcionario",
              "Editar tipo de acomodacao",
              "Editar acomodacao",
      };

      funcoesRemover = new Object[]{
              "Remover administrador",
              "Remover funcionario",
              "Remover tipo de acomodacao",
              "Remover acomodacao",
      };

      funcoesVizualizar = new Object[]{
              "Ver administradores",
              "Ver funcionarios",
              "Ver tipos de acomodacao",
              "Ver acomodacoes",
      };
    }

    if (nivelAcesso >= 2) {
      // Opções específicas para funcionários

      // Funcoes cadastro recebe as funcionalidades de um funcionario, sem perder o que tem dentro.
      functionFUNC = new Object[]{
              "Cadastrar reserva",
              "Cadastrar acomodado",
              "Cadastrar item de consumo",
              "Cadastrar consumo",
              "Cadastrar hospede",
              "Voltar"
      };

      // Juntar a funcao de cadastro com as funcoes do funcionario
      Object[] AuxFunctionsFUNC = new Object[funcoesCadastro.length + functionFUNC.length];
      System.arraycopy(funcoesCadastro, 0, AuxFunctionsFUNC, 0, funcoesCadastro.length);
      System.arraycopy(functionFUNC, 0, AuxFunctionsFUNC, funcoesCadastro.length, functionFUNC.length);

      funcoesCadastro = AuxFunctionsFUNC;

      functionFUNC = new Object[]{
              "Editar reserva",
              "Editar acomodado",
              "Editar item de consumo",
              "Editar consumo",
              "Editar hospede",
              "Voltar"
      };

      // Juntar a funcao de editar com as funcoes do funcionario
      AuxFunctionsFUNC = new Object[funcoesEditar.length + functionFUNC.length];
      System.arraycopy(funcoesEditar, 0, AuxFunctionsFUNC, 0, funcoesEditar.length);
      System.arraycopy(functionFUNC, 0, AuxFunctionsFUNC, funcoesEditar.length, functionFUNC.length);

      funcoesEditar = AuxFunctionsFUNC;

      functionFUNC = new Object[]{
              "Remover reserva",
              "Remover acomodado",
              "Remover item de consumo",
              "Remover consumo",
              "Remover hospede",
              "Voltar"
      };

      // Juntar a funcao de remover com as funcoes do funcionario
      AuxFunctionsFUNC = new Object[funcoesRemover.length + functionFUNC.length];
      System.arraycopy(funcoesRemover, 0, AuxFunctionsFUNC, 0, funcoesRemover.length);
      System.arraycopy(functionFUNC, 0, AuxFunctionsFUNC, funcoesRemover.length, functionFUNC.length);

      funcoesRemover = AuxFunctionsFUNC;

      functionFUNC = new Object[]{
              "Ver reservas",
              "Ver acomodados",
              "Ver itens de consumo",
              "Ver consumos",
              "Ver hospedes",
              "Voltar"
      };

      // Juntar a funcao de vizualizar com as funcoes do funcionario
      AuxFunctionsFUNC = new Object[funcoesVizualizar.length + functionFUNC.length];
      System.arraycopy(funcoesVizualizar, 0, AuxFunctionsFUNC, 0, funcoesVizualizar.length);
      System.arraycopy(functionFUNC, 0, AuxFunctionsFUNC, funcoesVizualizar.length, functionFUNC.length);

      funcoesVizualizar = AuxFunctionsFUNC;

    }


    // Opções padrão
    funcoesDefault = new Object[]{
            "Consumir", 
            "Encerrar estadia",
            "Voltar",
    };

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

      String nome = (String) JOptionPane.showInputDialog(null, "Escolha um administrador", "Acesso de administrador", JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

      Administrador adm = null;

      for (Administrador lista : administradores) {
        if (lista.getNome().equals(nome)) {
          adm = lista;
          usuario = adm;
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
        usuario = func;
      }
    }
  }

  // Método para entrar como hóspede
  private void HospedeAccess() {
    if (JOptionPane.showConfirmDialog(null, "Deseja entrar como hospede?", "Acesso de hospede",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
      nivelAcesso = 1;
      usuario = null;
    } else {
      nivelAcesso = 0;
    }
  }

  // Oferece o menu de funções para visualizar os dados do Hotel
  private void menuVizualizar(){
    String title = "Vizualizar";
    String opcao;

    opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesVizualizar, funcoesVizualizar[0]);

    switch (opcao) {
      case "Ver hospedes":
        mostrarHospedes();
        break;
      case "Ver administradores":
        mostrarAdministradores();
        break;
      case "Ver funcionarios":
        mostrarFuncionarios();
        break;
      case "Ver reservas":
        mostrarReservas();
        break;
      case "Ver acomodados":
        mostrarAcomodados();
        break;
      case "Ver itens de consumo":
        mostarItensConsumo();
        break;
      case "Ver consumos":
        mostrarConsumos();
        break;
      case "Ver tipos de acomodacao":
        mostrarTiposAcomodacao();
        break;
      case "Ver acomodacoes":
        mostrarAcomodacoes();
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Oferece o menu de funções para remover os dados do Hotel
  private void menuRemover(){
    String title = "Remover";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesRemover, funcoesRemover[0]);

    switch (opcao) {
      case "Remover hospede":
        removerHospede();
        break;
      case "Remover administrador":
        removerAdministrador();
        break;
      case "Remover funcionario":
        removerFuncionario();
        break;
      case "Remover reserva":
        removerReserva();
        break;
      case "Remover acomodado":
        removerAcomodado();
        break;
      case "Remover item de consumo":
        removerItemConsumo();
        break;
      case "Remover consumo":
        removerConsumo();
        break;
      case "Remover tipo de acomodacao":
        removerTipoAcomodacao();
        break;
      case "Remover acomodacao":
        removerAcomodacao();
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Oferece o menu de funções para editar os dados do Hotel
  private void menuEditar(){
    String title = "Editar";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesEditar, funcoesEditar[0]);

    switch (opcao) {
      case "Editar hospede":
        editarHospede();
        break;
      case "Editar administrador":
        editarAdministrador();
        break;
      case "Editar funcionario":
        editarFuncionario();
        break;
      case "Editar reserva":
        editarReserva();
        break;
      case "Editar acomodado":
        editarAcomodado();
        break;
      case "Editar item de consumo":
        editarItemConsumo();
        break;
      case "Editar consumo":
        editarConsumo();
        break;
      case "Editar tipo de acomodacao":
        editarTipoAcomodacao();
        break;
      case "Editar acomodacao":
        editarAcomodacao();
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Oferece o menu de funções para cadastrar os dados do Hotel
  private void menuCadastros(){
    String title = "Cadastros";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesCadastro, funcoesCadastro[0]);

    switch (opcao) {
      case "Cadastrar hospede":
        cadastrarHospede();
        break;
      case "Cadastrar administrador":
        cadastrarAdministrador();
        break;
      case "Cadastrar funcionario":
        cadastrarFuncionario();
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
      case "Cadastrar consumo":
        cadastrarConsumo();
        break;
      case "Cadastrar tipo de acomodacao":
        cadastrarTipoAcomodacao();
        break;
      case "Cadastrar acomodacao":
        cadastrarAcomodacao();
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Método que gerencia as opções do menu
  private void menu(String opcao) {
    switch (opcao) {
      case "Cadastros":
        menuCadastros();
        break;
      case "Editar":
        menuEditar();
        break;
      case "Remover":
        menuRemover();
        break;
      case "Vizualizar":
        menuVizualizar();
        break;
      case "Voltar":
        nivelAcesso = 0;
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
    if (usuario instanceof Administrador administrador){
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
      if (usuario instanceof Funcionario funcionario)
        funcionario.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
      if (usuario instanceof Administrador administrador)
        administrador.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
    }
  }

  // TO DO
  private void mostarItensConsumo() {
    StringBuilder message = new StringBuilder("Itens de consumo do hotel:\n");
    
    for (Consumo consumo : itensConsumoDisponiveis) {
        message.append("---------------------------------\n");
        message.append("Data de consumo: ").append(consumo.getDataConsumo()).append("\n");
        message.append("Número da Acomodação: ").append(consumo.getNumero()).append("\n");

        List<ItemConsumo> itensConsumidos = consumo.getItensConsumidos();
        for (ItemConsumo item : itensConsumidos) {
            message.append("   - Código do Item: ").append(item.getCodigo()).append("\n");
            message.append("     Descrição: ").append(item.getDescricao()).append("\n");
            message.append("     Quantidade Consumida: ").append(item.getQuantidadeConsumida()).append("\n");
            message.append("     Valor Unitário: ").append(item.getValorUnitario()).append("\n");
            message.append("     Valor Total: ").append(item.getValorTotal()).append("\n");
        }

        message.append("Valor Total do Consumo: ").append(consumo.getValorTotal()).append("\n");
        message.append("---------------------------------\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), "Itens de Consumo", JOptionPane.INFORMATION_MESSAGE);
}

  // TO DO
  private void mostrarAcomodacoes() {
    
  }

  // TO DO
  private void mostrarTiposAcomodacao() {

  }

  // TO DO
  private void mostrarConsumos() {
    
  }

  // TO DO
  private void mostrarAcomodados() {

  }

  // TO DO
  private void mostrarReservas() {

  }

  // TO DO
  private void removerAcomodacao() {

  }

  // TO DO
  private void removerTipoAcomodacao() {

  }

  // TO DO
  private void removerConsumo() {

  }

  // TO DO
  private void removerItemConsumo() {

  }

  // TO DO
  private void removerAcomodado() {

  }

  // TO DO
  private void removerReserva(Reserva reserva) {
    if (reservas.contains(reserva)) {
      // Verifica se a reserva está dentro do prazo sem multa
      if (reserva.getPrazoRemocaoSemMulta()) {
          reservas.remove(reserva);
          JOptionPane.showMessageDialog(null, "Reserva removida com sucesso!");
      } else {
          JOptionPane.showMessageDialog(null, "Não é possível remover a reserva sem multa após o prazo.");
      }
  } else {
      JOptionPane.showMessageDialog(null, "Reserva não encontrada.");
    }
  }

  // TO DO
  private void removerFuncionario() {

  }

  // TO DO
  private void removerAdministrador() {

  }

  // TO DO
  private void removerHospede() {

  }

  // TO DO
  private void editarAcomodacao() {

  }

  // TO DO
  private void editarTipoAcomodacao() {

  }

  // TO DO
  private void editarConsumo() {

  }

  // TO DO
  private void editarItemConsumo() {

  }

  // TO DO
  private void editarAcomodado() {

  }

  // TO DO
  private void editarReserva() {

  }

  // TO DO
  private void editarFuncionario() {

  }

  // TO DO
  private void editarAdministrador() {

  }

  // TO DO
  private void editarHospede() {

  }

  // TO DO
  private void cadastrarReserva() {

  }

  // TO DO
  private void cadastrarAcomodado() {
    String title = "Cadastrar acomodado";

    String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede a ser acomodado", title,
            JOptionPane.QUESTION_MESSAGE);
    int numeroAcomodacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da acomodação", title,
            JOptionPane.QUESTION_MESSAGE));
    LocalDate dataCheckIn = LocalDate.now();  // Você pode ajustar conforme necessário

    Acomodado acomodado = new Acomodado(nomeHospede, numeroAcomodacao, dataCheckIn);

    acomodados.add(acomodado);

    JOptionPane.showMessageDialog(null, "Acomodado cadastrado com sucesso!");
}

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

  // TO DO
  private void cadastrarConsumo() {

  }

  // Método para mostrar os hóspedes em uma janela de diálogo
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
    usuario = administradores.getFirst();

    // Cadastrar funcionários
    if (usuario instanceof Administrador administrador){
      administrador.cadastrarFuncionario("Caua", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-03-16"), funcionarios);
      administrador.cadastrarFuncionario("Pedro", 123456789, "São Carlos", Estados.SP, LocalDate.parse("2003-08-21"), funcionarios);
      administrador.cadastrarFuncionario("Eduardo", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-07-12"), funcionarios);
    }
  }
}
