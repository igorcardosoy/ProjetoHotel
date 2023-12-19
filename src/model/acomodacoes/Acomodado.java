package model.acomodacoes;

import model.CartaoCredito;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import java.time.LocalDateTime;

import static view.Hotel.*;

// Definição da classe Acomodado, que herda de ReservaAbstract
public class Acomodado extends Reserva {

  // Atributo adicional específico da classe Acomodado
  private Funcionario funcionarioResponsavel;

  // Construtor da classe Acomodado que recebe parâmetros para inicializar os atributos
  public Acomodado(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal,
                   Acomodacao acomodacao, Funcionario responsavel, CartaoCredito cartaoCredito) {
    // Chamada ao construtor da classe pai (ReservaAbstract) usando a palavra-chave 'super'
    super(checkIn, checkOut, hospedePrincipal,
            acomodacao, cartaoCredito);
    this.funcionarioResponsavel = responsavel;
  }

  public Acomodado(Reserva reserva, Funcionario funcionarioResponsavel) {
    super(reserva.getCheckIn(), reserva.getCheckOut(), reserva.getHospedePrincipal(), reserva.getAcomodacao(), reserva.getCartaoCredito());
      this.funcionarioResponsavel = funcionarioResponsavel;
  }

  public String toString() {
    return "Check-in: " + getCheckIn().format(formatterDataHora) + " | " +
            "Check-out: " + getCheckOut().format(formatterData) + " | " +
            "Hóspede principal: " + getHospedePrincipal().getNome() + " | " +
            "Acomodação: " + getAcomodacao().getNumero() + " | " +
            "Funcionário responsável: " + funcionarioResponsavel.getNome() + "\n";
  }
}

