package view;

import model.Saida;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.itensCosumo.Consumo;
import model.pessoas.Hospede;

import javax.swing.*;
import java.time.LocalDateTime;
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
  public static void removerAcomodado(List<Acomodado> acomodados, List<Hospede> hospedes, Acomodado acomodado) {

    List<Hospede> hospedesAcomodados = acomodado.getAllHospedes();
    acomodados.remove(acomodado);

    for (Hospede hospede1 : hospedesAcomodados) {
          hospedes.remove(hospede1);
    }



      JOptionPane.showMessageDialog(null, "Acomodado removido com sucesso!", "Remover acomodado", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void removerAcomodado(List<Acomodado> acomodados, List<Hospede> hospedes) {

    String nomeHospede = JOptionPane.showInputDialog(null, "Digite o nome do hóspede", "Remover acomodado", JOptionPane.QUESTION_MESSAGE);

    Acomodado acomodado = null;

    for (Acomodado acomodado1 : acomodados) {
      if (acomodado1.getHospedePrincipal().getNome().equals(nomeHospede)) {
        acomodado = acomodado1;
        break;
      }
    }

    for (Hospede hospede1 : hospedes) {
      hospedes.remove(hospede1);
    }

    acomodados.remove(acomodado);

    JOptionPane.showMessageDialog(null, "Acomodado removido com sucesso!", "Remover acomodado", JOptionPane.INFORMATION_MESSAGE);
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
          sb.append(consumo.toString());
          sb.append("\n---------------------------------------");
        }
      }

      sb.append("\nGastos gerais de consumo: R$ ").append(gastosGeraisConsumo);

      Saida saida = new Saida(LocalDateTime.now(), acomodado.getAcomodacao().getNumero(), dias, acomodado.getAcomodacao().getTipo().getDiaria(), gastosTelefonicos, gastosGeraisConsumo);

      JOptionPane.showMessageDialog(null, saida.toString(), "Encerrar estadia", JOptionPane.INFORMATION_MESSAGE);

      removerAcomodado(acomodados, hospedes, acomodado);
    }
  }
}
