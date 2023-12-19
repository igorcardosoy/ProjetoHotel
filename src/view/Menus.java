package view;

import model.pessoas.*;
import model.acomodacoes.*;
import model.itensCosumo.*;
import javax.swing.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Definição da classe Menus que oferece as opções do menu do sistema
 */
public class Menus {

  /**
   * Método que oferece o menu de funções para visualizar os dados do Hotel
   * @param hospedes lista de hospedes
   * @param administradores lista de administradores
   * @param funcionarios lista de funcionarios
   * @param reservas lista de reservas
   * @param acomodados lista de acomodados
   * @param itensConsumo lista de itens de consumo
   * @param tiposAcomodacao  lista de tipos de acomodacao
   * @param acomodacoes lista de acomodacoes
   * @param funcoesVizualizar funcoes de vizualizacao
   */
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
      case "Ver tipos de acomodacao" -> Visualizacao.mostrarTiposAcomodacao(tiposAcomodacao);
      case "Ver acomodacoes" -> Visualizacao.mostrarAcomodacoes(acomodacoes);
      default -> "Opcao invalida";
    };

    JOptionPane.showMessageDialog(null, result, title, JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Método que oferece o menu de funções para remover os dados do Hotel
   * @param hospedes hospedes
   * @param administradores administradores
   * @param funcionarios funcionarios
   * @param reservas reservas
   * @param acomodados acomodados
   * @param itensConsumo itens de consumo
   * @param tiposAcomodacao tipos de acomodacao
   * @param acomodacoes acomodacoes
   * @param funcoesRemover funcoes de remocao
   * @param usuario usuario
   */
  private void menuRemover(
          List<Hospede> hospedes,
          List<Administrador> administradores,
          List<Funcionario> funcionarios,
          List<Reserva> reservas,
          List<Acomodado> acomodados,
          List<ItensConsumo> itensConsumo,
          List<TipoAcomodacao> tiposAcomodacao,
          List<Acomodacao> acomodacoes,
          Object[] funcoesRemover,
          Pessoa usuario
  ) {
    String title = "Remover";
    String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
            null, funcoesRemover, funcoesRemover[0]);

    switch (opcao) {
      case "Remover hospede":
        Remocao.removerHospede(hospedes, usuario);
        break;
      case "Remover administrador":
        Remocao.removerAdministrador();
        break;
      case "Remover funcionario":
        Remocao.removerFuncionario();
        break;
      case "Remover reserva":
        Remocao.removerReserva(reservas, usuario);
        break;
      case "Remover acomodado":
        Remocao.removerAcomodado(acomodados, hospedes, usuario);
        break;
      case "Remover item de consumo":
        Remocao.removerItemConsumo(itensConsumo, usuario);
        break;
      case "Remover consumo":
        Remocao.removerConsumo(itensConsumo);
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

  /**
   * Método que oferece o menu de funções para editar os dados do Hotel
   * @param usuario usuario
   * @param hospedes lista de hospedes
   * @param administradores  lista de administradores
   * @param funcionarios lista de funcionarios
   * @param reservas lista de reservas
   * @param acomodados lista de acomodados
   * @param itensConsumo lista de itens de consumo
   * @param tiposAcomodacao lista de tipos de acomodacao
   * @param acomodacoes lista de acomodacoes
   * @param funcoesEditar  funcoes de edicao
   */
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

  /**
   * Método que oferece o menu de funções para cadastrar os dados do Hotel
   * @param usuario usuario
   * @param hospedes hospedes
   * @param administradores administradores
   * @param funcionarios funcionarios
   * @param reservas reservas
   * @param acomodados acomodados
   * @param itensConsumo itens de consumo
   * @param tiposAcomodacao tipos de acomodacao
   * @param acomodacoes acomodacoes
   * @param funcoesCadastro funcoes de cadastro
   */
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
          Object[] funcoesCadastro)
  {


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

  /**
   * Método que gerencia as opções do menu
   * @param opcao opcao
   * @param usuario usuario
   * @param hospedes hospedes
   * @param administradores administradores
   * @param funcionarios funcionarios
   * @param reservas  reservas
   * @param acomodados  acomodados
   * @param itensConsumo itens de consumo
   * @param tiposAcomodacao tipos de acomodacao
   * @param acomodacoes acomodacoes
   * @param funcoesCadastro funcoes de cadastro
   * @param funcoesEditar funcoes de edicao
   * @param funcoesRemover funcoes de remocao
   * @param funcoesVizualizar funcoes de vizualizacao
   * @return true se não ocorreu nada de errado ou false caso contrario
   */
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
                      Object[] funcoesVizualizar)
  {

    switch (opcao) {
      case "Cadastros":
        menuCadastros(usuario, hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesCadastro);
        break;
      case "Editar":
        menuEditar(usuario, hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesEditar);
        break;
      case "Remover":
        menuRemover(hospedes, administradores, funcionarios, reservas, acomodados, itensConsumo, tiposAcomodacao, acomodacoes, funcoesRemover, usuario);
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
          Remocao.encerrarEstadia(acomodados, hospedes, acomodado);
        }
        break;
      default:
          return true;
    }
    return false;
  }
}
