package view;

import model.Saida;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.itensCosumo.Consumo;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Definição da classe Remoção para efetuar as remoções realizadas no sistema
 */
public class Remocao {

  public static void removerAcomodacao() {

  }

  // TO DO
  public static void removerTipoAcomodacao() {

  }

  /**
   * Método para a remoção de um item de consumo da lista
   * @param itensConsumoDisponiveis itens de consumo disponiveis
   */
  public static void removerConsumo(List<ItensConsumo> itensConsumoDisponiveis) {
    String nomeItemConsumo = JOptionPane.showInputDialog(null, "Digite o nome do item de consumo a ser removido", "Remover item de consumo", JOptionPane.QUESTION_MESSAGE);

    ItensConsumo itemConsumoRemover = null;

    // Procurar o item de consumo na lista
    for (ItensConsumo item : itensConsumoDisponiveis) {
        if (item.getDescricao().equals(nomeItemConsumo)) {
            itemConsumoRemover = item;
            break;
        }
    }

    // Remover o item de consumo da lista
    if (itemConsumoRemover != null) {
        itensConsumoDisponiveis.remove(itemConsumoRemover);
        JOptionPane.showMessageDialog(null, "Item de consumo removido com sucesso!", "Remover item de consumo", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Item de consumo não encontrado!", "Remover item de consumo", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Método para romover um item consumido
   * @param itensConsumoDisponiveis itens de consumo disponiveis
   * @param usuarioLogado usuario logado
   */
  public static void removerItemConsumo(List<ItensConsumo> itensConsumoDisponiveis, Pessoa usuarioLogado) {

    if (usuarioLogado instanceof Funcionario){
      String nomeItemConsumo = JOptionPane.showInputDialog(null, "Digite o nome do item de consumo", "Remover item de consumo", JOptionPane.QUESTION_MESSAGE);

      ItensConsumo itemConsumo = null;

      for (ItensConsumo itemConsumo1 : itensConsumoDisponiveis) {
        if (itemConsumo1.getDescricao().equals(nomeItemConsumo)) {
          itemConsumo = itemConsumo1;
          break;
        }
      }
      itensConsumoDisponiveis.remove(itemConsumo);

      JOptionPane.showMessageDialog(null, "Item de consumo removido com sucesso!", "Remover item de consumo", JOptionPane.INFORMATION_MESSAGE);
    }

  }

  /**
   * Método para remover um acomodado do sistema
   * @param acomodados acomodados
   * @param hospedes hospedes
   * @param acomodado acomodado
   */
  public static void removerAcomodado(List<Acomodado> acomodados, List<Hospede> hospedes, Acomodado acomodado) {

    List<Hospede> hospedesAcomodados = acomodado.getAllHospedes();

    for (Hospede hospede1 : hospedesAcomodados) {
          removerHospede(hospedes, hospede1);
    }

    acomodados.remove(acomodado);

    JOptionPane.showMessageDialog(null, "Acomodado removido com sucesso!", "Remover acomodado", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Método para remover um acomodado
   * @param acomodados acomodados
   * @param hospedes hospedes
   * @param usuarioLogado usuario logado
   */
  public static void removerAcomodado(List<Acomodado> acomodados, List<Hospede> hospedes, Pessoa usuarioLogado){

    if (usuarioLogado instanceof Funcionario){
      String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede", "Remover acomodado", JOptionPane.QUESTION_MESSAGE);

      Acomodado acomodado = null;
      List<Hospede> hospedesAcomodados;

      for (Acomodado acomodado1 : acomodados) {
        if (acomodado1.getHospedePrincipal().getNome().equals(nomeHospede)) {
          acomodado = acomodado1;
          break;
        }
      }

      assert acomodado != null;
      hospedesAcomodados = acomodado.getAllHospedes();

      for (Hospede hospede1 : hospedesAcomodados) {
        hospedes.remove(hospede1);
      }

      acomodados.remove(acomodado);

      JOptionPane.showMessageDialog(null, "Acomodado removido com sucesso!", "Remover acomodado", JOptionPane.INFORMATION_MESSAGE);
    }
  }


  /**
   * Método para remover uma reserva
   * @param reservas reservas
   * @param reserva reserva
   * @param usuarioLogado usuario logado
   */
  public static void removerReserva(List<Reserva> reservas, Reserva reserva , Pessoa usuarioLogado){
    if (usuarioLogado instanceof Funcionario){

      reservas.remove(reserva);

      JOptionPane.showMessageDialog(null, "Reserva removida com sucesso!", "Remover reserva", JOptionPane.INFORMATION_MESSAGE);

    }
  }

  /**
   * Método para remoção de uma reserva
   * @param reservas reservas
   * @param usuarioLogado usuario logado
   */
  public static void removerReserva(List<Reserva> reservas, Pessoa usuarioLogado){
    if (usuarioLogado instanceof Funcionario){
      boolean found = false;

      String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede", "Remover reserva", JOptionPane.QUESTION_MESSAGE);

      for (Reserva reserva : reservas) {
        if (reserva.getHospedePrincipal().getNome().equals(nomeHospede)) {
          if (reserva.canRemoveWithoutPay())
          {
            reservas.remove(reserva);
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Multa a ser paga:"  + reserva.getMulta(), "Remover reserva", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Valor cobrado do cartão final: [" + reserva.getCartaoCredito().getNumerosFinais() + "]", "Remover reserva", JOptionPane.INFORMATION_MESSAGE);
          }

          found = true;
          break;
        }
      }

      if (!found) {
        JOptionPane.showMessageDialog(null, "Reserva não encontrada!", "Remover reserva", JOptionPane.ERROR_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "Reserva removida com sucesso!", "Remover reserva", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }

  // TO DO
  public static void removerFuncionario() {

  }

  // TO DO
  public static void removerAdministrador() {

  }

  /**
   * Método para a remoção de um hospede
   * @param hospedes hospedes
   * @param usuarioLogado usuario logado
   */
  public static void removerHospede(List<Hospede> hospedes, Pessoa usuarioLogado) {

    if (usuarioLogado instanceof Funcionario funcionario){
      String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede", "Remover hóspede", JOptionPane.QUESTION_MESSAGE);

      Hospede hospede = null;

      for (Hospede hospede1 : hospedes) {
        if (hospede1.getNome().equals(nomeHospede)) {
          hospede = hospede1;
          break;
        }
      }

      funcionario.removerHospede(hospede, hospedes);

      JOptionPane.showMessageDialog(null, "Hóspede removido com sucesso!", "Remover hóspede", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  /**
   * Método para encerrar a estadia do hospede
   * @param acomodados acomodados
   * @param hospedes  hospedes
   * @param acomodado acomodado
   */
  public static void encerrarEstadia(List<Acomodado> acomodados, List<Hospede> hospedes, Acomodado acomodado){
    boolean certeza = JOptionPane.showConfirmDialog(null, "Deseja encerrar a estadia?", "Encerrar estadia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

    if (certeza) {

      double gastosTelefonicos = 0;

      for (Hospede hospede : acomodado.getAllHospedes()) {
        gastosTelefonicos += hospede.getGastosTelefonicos();
      }

      //Descobrir quantos dias de diferença tem entre oi checkout e checkin
      LocalDateTime checkIn = acomodado.getCheckIn();
      LocalDateTime checkOut = acomodado.getCheckOut();
      int dias = checkOut.getDayOfYear() - checkIn.getDayOfYear();

      double gastosGeraisConsumo = 0;

      StringBuilder sb = new StringBuilder();
      sb.append("\n---------------------------------------");

      for (Hospede hospede : acomodado.getAllHospedes()) {
        for (Consumo consumo : hospede.getConsumo()) {
          gastosGeraisConsumo += consumo.getValorTotal();
          sb.append(consumo);
          sb.append("\n---------------------------------------");
        }
      }

      sb.append("\nGastos gerais de consumo: R$ ").append(gastosGeraisConsumo);

      JOptionPane.showMessageDialog(null, sb.toString(), "Encerrar estadia", JOptionPane.INFORMATION_MESSAGE);

      Saida saida = new Saida(LocalDateTime.now(), acomodado.getAcomodacao().getNumero(), dias, acomodado.getAcomodacao().getTipo().getDiaria(), gastosTelefonicos, gastosGeraisConsumo);

      JOptionPane.showMessageDialog(null, saida.toString(), "Encerrar estadia", JOptionPane.INFORMATION_MESSAGE);

      removerAcomodado(acomodados, hospedes, acomodado);
    }
  }
}
