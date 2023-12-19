package view;

import model.pessoas.*;
import model.acomodacoes.*;
import model.itensCosumo.*;
import javax.swing.*;

import java.time.LocalDateTime;
import java.util.List;


public class Menus {

  // Oferece o menu de funções para visualizar os dados do Hotel
  private void menuVizualizar(
          List<Hospede> hospedes,
          List<Administrador> administradores,
          List<Funcionario> funcionarios,
          List<Reserva> reservas,
          List<Acomodado> acomodados,
          List<ItensConsumo> itensConsumo,
          List<TipoAcomodacao> tiposAcomodacao,
          List<Acomodacao> acomodacoes,
          Object[] funcoesVizualizar
  ) {
    String title = "Vizualizar";
    String opcao;
    Object result;

    opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesVizualizar, funcoesVizualizar[0]);

    result = switch (opcao) {
      case "Ver hospedes" -> Visualizacao.mostrarHospedes(hospedes);
      case "Ver administradores" -> Visualizacao.mostrarAdministradores(administradores);
      case "Ver funcionarios" -> Visualizacao.mostrarFuncionarios(funcionarios);
      case "Ver reservas" -> Visualizacao.mostrarReservas(reservas);
      case "Ver acomodados" -> Visualizacao.mostrarAcomodados(acomodados);
      case "Ver itens de consumo" -> Visualizacao.mostarItensConsumo(itensConsumo);
      case "Ver consumos" -> Visualizacao.mostrarConsumos();
      case "Ver tipos de acomodacao" -> Visualizacao.mostrarTiposAcomodacao(tiposAcomodacao);
      case "Ver acomodacoes" -> Visualizacao.mostrarAcomodacoes(acomodacoes);
      default -> "Opcao invalida";
    };

    JOptionPane.showMessageDialog(null, result, title, JOptionPane.INFORMATION_MESSAGE);
  }

  // Oferece o menu de funções para remover os dados do Hotel
  private void menuRemover(
          List<Hospede> hospedes,
          List<Administrador> administradores,
          List<Funcionario> funcionarios,
          List<Reserva> reservas,
          List<Acomodado> acomodados,
          List<ItensConsumo> itensConsumo,
          List<TipoAcomodacao> tiposAcomodacao,
          List<Acomodacao> acomodacoes,
          Object[] funcoesRemover
  ) {
    String title = "Remover";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesRemover, funcoesRemover[0]);

    switch (opcao) {
      case "Remover hospede":
        Remocao.removerHospede(hospedes);
        break;
      case "Remover administrador":
        Remocao.removerAdministrador();
        break;
      case "Remover funcionario":
        Remocao.removerFuncionario();
        break;
      case "Remover reserva":
        Remocao.removerReserva(reservas);
        break;
      case "Remover acomodado":
        Remocao.removerAcomodado(acomodados, hospedes);
        break;
      case "Remover item de consumo":
        Remocao.removerItemConsumo(itensConsumo);
        break;
      case "Remover consumo":
        Remocao.removerConsumo();
        break;
      case "Remover tipo de acomodacao":
        Remocao.removerTipoAcomodacao();
        break;
      case "Remover acomodacao":
        Remocao.removerAcomodacao();
        break;
      default:
        JOptionPane.showMessageDialog(null, "Opcao invalida", title, JOptionPane.ERROR_MESSAGE);
        break;
    }
  }

  // Oferece o menu de funções para editar os dados do Hotel
  private void menuEditar(
          Pessoa usuario,
          List<Hospede> hospedes,
          List<Administrador> administradores,
          List<Funcionario> funcionarios,
          List<Reserva> reservas,
          List<Acomodado> acomodados,
          List<ItensConsumo> itensConsumo,
          List<TipoAcomodacao> tiposAcomodacao,
          List<Acomodacao> acomodacoes,
          Object[] funcoesEditar
  ) {
    String title = "Editar";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesEditar, funcoesEditar[0]);

    switch (opcao) {
      case "Editar hospede":
        Editar.editarHospede();
        break;
      case "Editar administrador":
        Editar.editarAdministrador();
        break;
      case "Editar funcionario":
        Editar.editarFuncionario();
        break;
      case "Editar reserva":
        Editar.editarReserva();
        break;
      case "Editar acomodado":
        Editar.editarAcomodado();
        break;
      case "Editar item de consumo":
        Editar.editarItemConsumo();
        break;
      case "Editar consumo":
        Editar.editarConsumo();
        break;
      case "Editar tipo de acomodacao":
        Editar.editarTipoAcomodacao();
        break;
      case "Editar acomodacao":
        Editar.editarAcomodacao();
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Oferece o menu de funções para cadastrar os dados do Hotel
  private void menuCadastros(
          Pessoa usuario,
          List<Hospede> hospedes,
          List<Administrador> administradores,
          List<Funcionario> funcionarios,
          List<Reserva> reservas,
          List<Acomodado> acomodados,
          List<ItensConsumo> itensConsumo,
          List<TipoAcomodacao> tiposAcomodacao,
          List<Acomodacao> acomodacoes,
          Object[] funcoesCadastro,
          Object[] estados) {


    String title = "Cadastros";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesCadastro, funcoesCadastro[0]);

    switch (opcao) {
      case "Cadastrar hospede":
        Cadastros.cadastrarHospede(hospedes, usuario);
        break;
      case "Cadastrar administrador":
        Cadastros.cadastrarAdministrador(administradores, usuario);
        break;
      case "Cadastrar funcionario":
        Cadastros.cadastrarFuncionario(funcionarios, usuario);
        break;
      case "Cadastrar reserva":
        Cadastros.cadastrarReserva(reservas, acomodacoes, usuario,
                tiposAcomodacao, hospedes);
        break;
      case "Cadastrar acomodado":
        Cadastros.cadastrarAcomodado(usuario, reservas, acomodados, acomodacoes, tiposAcomodacao, hospedes);
        break;
      case "Cadastrar item de consumo":
        Cadastros.cadastrarItemConsumo(itensConsumo, usuario);
        break;
      case "Cadastrar consumo":
        Cadastros.cadastrarConsumo();
        break;
      case "Cadastrar tipo de acomodacao":
        Cadastros.cadastrarTipoAcomodacao(tiposAcomodacao, usuario);
        break;
      case "Cadastrar acomodacao":
        Cadastros.cadastrarAcomodacao(acomodacoes, acomodados, tiposAcomodacao, usuario);
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  // Método que gerencia as opções do menu
  public boolean menu(String opcao, Pessoa usuario,
                      List<Hospede> hospedes,
                      List<Administrador> administradores,
                      List<Funcionario> funcionarios,
                      List<Reserva> reservas,
                      List<Acomodado> acomodados,
                      List<ItensConsumo> itensConsumo,
                      List<TipoAcomodacao> tiposAcomodacao,
                      List<Acomodacao> acomodacoes,
                      Object[] funcoesCadastro,
                      Object[] funcoesEditar,
                      Object[] funcoesRemover,
                      Object[] funcoesVizualizar,
                      Object[] estados) {

    switch (opcao) {
      case "Cadastros":
        menuCadastros(usuario, hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesCadastro, estados);
        break;
      case "Editar":
        menuEditar(usuario, hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesEditar);
        break;
      case "Remover":
        menuRemover(hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesRemover);
        break;
      case "Vizualizar":
        menuVizualizar(hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesVizualizar);
        break;
      case "Consumir":
        if (usuario instanceof Hospede hospede) {

          //Selecionar qual itens quer consumir
          ItensConsumo item = (ItensConsumo) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Consumir", JOptionPane.QUESTION_MESSAGE,
                  null, itensConsumo.toArray(), itensConsumo.getFirst());

          int qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade: ", "Consumir", JOptionPane.QUESTION_MESSAGE));

          hospede.consumirItem(LocalDateTime.now(), hospede.getFuncionarioResponsavel().getNome(), qnt, item.getValor(), item.getCodigo(), itensConsumo);
        } else {

          JOptionPane.showMessageDialog(null, "Apenas hospedes podem consumir", "Consumir", JOptionPane.ERROR_MESSAGE);
        }
        break;
      case "Encerrar estadia":
        Acomodado acomodado = null;

        if (usuario instanceof Hospede hospede) {
          for (Acomodado acomodado1 : acomodados) {
            if (acomodado1.getHospedePrincipal().equals(hospede)) {
              acomodado = acomodado1;
              break;
            }
          }
          Remocao.encerrarEstadia(acomodados, hospedes,acomodado);
        }
        break;
      default:
          return true;
    }
    return false;
  }
}
