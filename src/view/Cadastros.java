package view;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.TipoAcomodacao;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.enums.TipoItens;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Cadastros {

  // Método para cadastrar um administrador
  public static void cadastrarAdministrador(int nivelAcesso, List<Administrador> administradores, Object[] estados, Pessoa usuario) {
    if (nivelAcesso >= 3) {
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
  }

  // Método para cadastrar um funcionário
  public static void cadastrarFuncionario(int nivelAcesso, List<Funcionario> funcionarios, Object[] estados, Pessoa usuario){
    if (nivelAcesso >= 3){
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
      if (usuario instanceof Administrador administrador)
        administrador.cadastrarFuncionario(nome, telefone, cidade, estado, dataNascimento, funcionarios);
    }
  }

  // Método para cadastrar um hóspede
  public static void cadastrarHospede(int nivelAcesso, List<Hospede> hospedes, Object[] estados, Pessoa usuario) {
    if (nivelAcesso >= 2){
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

      if (usuario instanceof Funcionario funcionario)
        funcionario.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
      if (usuario instanceof Administrador administrador)
        administrador.cadastrarHospede(new Hospede(nome, telefone, cidade, estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae, nomePai), hospedes);
    }
  }

  // TO DO
  public static void cadastrarReserva() {

  }

  // TO DO
  public static void cadastrarAcomodado() {
//    if (nivelAcesso >= 2) {
//      String title = "Cadastrar acomodado";
//
//      String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede a ser acomodado", title,
//              JOptionPane.QUESTION_MESSAGE);
//      int numeroAcomodacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da acomodação", title,
//              JOptionPane.QUESTION_MESSAGE));
//      LocalDate dataCheckIn = LocalDate.now();  // Você pode ajustar conforme necessário
//
//      Reserva reserva = null;
//
//      for (Reserva r : reservas) {
//        if (r.getHospedePrincipal().getNome().equals(nomeHospede)) {
//          reserva = r;
//          break;
//        }
//      }
//
//      if (usuario instanceof Funcionario funcionario) {
//        if (funcionario.cadastrarAcomodado(new Acomodado(reserva, dataCheckIn, numeroAcomodacao), acomodados)){
//          JOptionPane.showMessageDialog(null, "Acomodado cadastrado com sucesso!");
//        } else {
//          JOptionPane.showMessageDialog(null, "Acomodado ja existe!");
//        }
//      }
//      if (usuario instanceof Administrador administrador){
//        if (administrador.cadastrarAcomodado(new Acomodado(reserva, dataCheckIn, numeroAcomodacao), acomodados)){
//          JOptionPane.showMessageDialog(null, "Acomodado cadastrado com sucesso!");
//        } else {
//          JOptionPane.showMessageDialog(null, "Acomodado ja existe!");
//        }
//      }

//
//      JOptionPane.showMessageDialog(null, "Acomodado cadastrado com sucesso!");
//    }
  }

  public static void cadastrarItemConsumo(int nivelAcesso, List<ItensConsumo> itensConsumoDisponiveis, Pessoa usuario) {
    if (nivelAcesso >= 3) {
      String title = "Cadastrar item de consumo";

      long codigo = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o codigo do item de consumo", title, JOptionPane.QUESTION_MESSAGE));
      TipoItens tipo = (TipoItens) JOptionPane.showInputDialog(null, "Escolha o tipo do item de consumo", title, JOptionPane.QUESTION_MESSAGE, null, TipoItens.values(), TipoItens.values()[0]);
      String descricao = JOptionPane.showInputDialog(null, "Digite o nome do item de consumo", title, JOptionPane.QUESTION_MESSAGE);
      double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco do item de consumo", title, JOptionPane.QUESTION_MESSAGE));


      ItensConsumo itemConsumo = new ItensConsumo(codigo, tipo, descricao, preco);

      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarItemConsumo(itemConsumo, itensConsumoDisponiveis)){
          JOptionPane.showMessageDialog(null, "Item de consumo cadastrado com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Item de consumo ja existe!");
        }
      }
    }
  }

  public static void cadastrarTipoAcomodacao(int nivelAcesso, List<TipoAcomodacao> tiposAcomodacao, Pessoa usuario) {
    if (nivelAcesso >= 3) {
      String title = "Cadastrar tipo de acomodacao";

      // Dados necessarios: codigo, nome, descricao, quantidades existentes, diaria, adultos comportados, criancas comportadas

      long codigo = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o codigo do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      String nome = JOptionPane.showInputDialog(null, "Digite o nome do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE);
      String descricao = JOptionPane.showInputDialog(null, "Digite a descricao do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE);
      int quantidadeExistente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade existente do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      double diaria = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a diaria do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int adultosComportados = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de adultos comportados do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int criancasComportadas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de criancas comportadas do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));


      TipoAcomodacao tipoAcomodacao = new TipoAcomodacao(codigo, nome, descricao, quantidadeExistente, diaria, adultosComportados, criancasComportadas);


      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarTipoAcomodacao(tipoAcomodacao, tiposAcomodacao)){
          JOptionPane.showMessageDialog(null, "Tipo de acomodacao cadastrado com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Tipo de acomodacao ja existe!");
        }
      }
    }
  }

  public static void cadastrarAcomodacao(int nivelAcesso, List<Acomodacao> acomodacoesDisponiveis, List<Acomodado> acomodados, List<TipoAcomodacao> tiposAcomodacao, Pessoa usuario) {
    if (nivelAcesso >= 3) {
      String title = "Cadastrar acomodacao";

      //Escolha o tipo de acomodacao
      Object[] tipos = new Object[tiposAcomodacao.size()];
      for (int i = 0; i < tiposAcomodacao.size(); i++) {
        tipos[i] = tiposAcomodacao.get(i).getNome();
      }

      String tipo = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

      // Conveter o tipo para TipoAcomodacao
      TipoAcomodacao tipoAcomodacao = null;
      for (TipoAcomodacao tipoAcomodacao1 : tiposAcomodacao) {
        if (tipoAcomodacao1.getNome().equals(tipo)) {
          tipoAcomodacao = tipoAcomodacao1;
          break;
        }
      }

      int andar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o andar da acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da acomodacao", title, JOptionPane.QUESTION_MESSAGE));

      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarAcomodacao(acomodacoesDisponiveis, acomodados, new Acomodacao(andar, numero, tipoAcomodacao))) {
          JOptionPane.showMessageDialog(null, "Acomodacao cadastrada com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Acomodacao ja existe!");
        }
      }
    }
  }

  // TO DO
  static void cadastrarConsumo() {

  }
}
