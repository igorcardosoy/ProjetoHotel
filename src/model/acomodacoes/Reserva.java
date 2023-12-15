package model.acomodacoes;

import model.pessoas.Hospede;

import java.time.LocalDateTime;

public class Reserva extends ReservaAbstract {
  private double multa;
  private double desconto;

  public Reserva(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao,
      double multa, double desconto) {
    super(checkIn, checkOut, hospedePrincipal, acomodacao);
    this.multa = multa;
    this.desconto = desconto;
  }

  public double getMulta() {
    return multa;
  }

  public double getDesconto() {
    return desconto;
  }

}
