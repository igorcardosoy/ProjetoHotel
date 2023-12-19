package model.acomodacoes;

import model.CartaoCredito;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import java.time.LocalDateTime;

import static view.Hotel.*;


/**
 * Definição da classe Acomodado, que herda de Reserva e representa o hospede
 * que está acomodado no hotel.
 * @atributos Data e hora de checkin e checkout, hospede principal,
 * acomodacao, funcionario responsavel pela acomodacao e cartao de credito.
 */
public class Acomodado extends Reserva {

  // Atributo adicional específico da classe Acomodado
  private Funcionario funcionarioResponsavel;


  /**
   * Construtor da classe Acomodado que recebe os parâmetros do hospede, alem
   * de seu funcionarioResponsavel.
   * @param checkIn
   * @param checkOut
   * @param hospedePrincipal
   * @param acomodacao
   * @param responsavel
   * @param cartaoCredito
   */
  public Acomodado(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal,
                   Acomodacao acomodacao, Funcionario responsavel, CartaoCredito cartaoCredito) {
    // Chamada ao construtor da classe pai (ReservaAbstract) usando a palavra-chave 'super'
    super(checkIn, checkOut, hospedePrincipal,
            acomodacao, cartaoCredito);
    this.funcionarioResponsavel = responsavel;
  }

  /**
   * Construtor da classe Acomodado que recebe a reserva previa do hospede,
   * alem de seu funcionarioResponsavel.
   * para efetuar a
   * @param reserva
   * @param funcionarioResponsavel
   */
  public Acomodado(Reserva reserva, Funcionario funcionarioResponsavel) {
    super(reserva.getCheckIn(), reserva.getCheckOut(), reserva.getHospedePrincipal(), reserva.getAcomodacao(), reserva.getCartaoCredito());
      this.funcionarioResponsavel = funcionarioResponsavel;
  }

  /**
   * Metodo que retorna a descricao do hospede acomodado no hotel.
   * @return String contendo data e hora de checkin e checkout, nome do
   * hospede principal, numero da acomodacao e nome do funcionario responsavel.
   */
  public String toString() {
    return "Check-in: " + getCheckIn().format(formatterDataHora) + " | " +
            "Check-out: " + getCheckOut().format(formatterData) + " | " +
            "Hóspede principal: " + getHospedePrincipal().getNome() + " | " +
            "Acomodação: " + getAcomodacao().getNumero() + " | " +
            "Funcionário responsável: " + funcionarioResponsavel.getNome() + "\n";
  }
}

