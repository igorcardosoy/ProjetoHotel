package model.acomodacoes;

import model.pessoas.Hospede;

import java.time.LocalDateTime;

public class Reserva extends ReservaAbstract {
  private double multa;
  private double desconto;

  public Reserva(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, double multa, double desconto, double multa1, double desconto1) {
    super(checkIn, checkOut, hospedePrincipal, acomodacao);
    this.multa = multa1;
    this.desconto = desconto1;
  }

  public double getMulta() {
    return multa;
  }

  public double getDesconto() {
    return desconto;
  }

}
