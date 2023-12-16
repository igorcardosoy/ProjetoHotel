package model.acomodacoes;

import model.pessoas.Hospede;

import java.time.LocalDateTime;

// Definição da classe Reserva que estende de ReservaAbstract
public class Reserva extends ReservaAbstract {

  // Atributos adicionais específicos da classe Reserva
  private double multa;     // Valor da multa associada à reserva
  private double desconto;  // Valor do desconto associado à reserva

  // Construtor da classe Reserva que recebe parâmetros para inicializar os atributos
  public Reserva(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, double multa, double desconto) {
    // Chamada ao construtor da classe pai (ReservaAbstract) usando a palavra-chave 'super'
    super(checkIn, checkOut, hospedePrincipal, acomodacao);

    // Inicialização dos atributos específicos da classe Reserva
    this.multa = multa;
    this.desconto = desconto;
  }

  // Método para obter o valor da multa associada à reserva
  public double getMulta() {
    return multa;
  }

  // Método para obter o valor do desconto associado à reserva
  public double getDesconto() {
    return desconto;
  }

}

