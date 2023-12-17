package model.acomodacoes;

import model.CartaoCredito;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;
import java.time.LocalDateTime;

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

  public Acomodado(Reserva reserva) {
    super(reserva.getCheckIn(), reserva.getCheckOut(), reserva.getHospedePrincipal(), reserva.getAcomodacao(), reserva.getCartaoCredito());
      this.funcionarioResponsavel = null;
  }
}

