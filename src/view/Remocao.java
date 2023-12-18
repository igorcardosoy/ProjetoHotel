package view;

import model.acomodacoes.Reserva;

import javax.swing.*;
import java.util.List;

public class Remocao {

  public static void removerAcomodacao() {

  }

  // TO DO
  public static void removerTipoAcomodacao() {

  }

  // TO DO
  public static void removerConsumo() {

  }

  // TO DO
  public static void removerItemConsumo() {

  }

  // TO DO
  public static void removerAcomodado() {

  }

  public static void removerReserva(List<Reserva> reservas) {

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

  // TO DO
  public static void removerFuncionario() {

  }

  // TO DO
  public static void removerAdministrador() {

  }

  // TO DO
  public static void removerHospede() {

  }
}
