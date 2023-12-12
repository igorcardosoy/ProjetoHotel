package model;

import java.time.LocalDateTime;
import java.util.List;

public class Reserva {
  private LocalDateTime checkIn;
  private LocalDateTime checkOut;
  private Hospede hospedePrincipal;
  private List<Hospede> hospedes;
  private Acomodacao acomodacao;
  private double multa;
  private double desconto;

  public Reserva(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, double multa, double desconto) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.hospedePrincipal = hospedePrincipal;
    this.acomodacao = acomodacao;
    this.multa = multa;
    this.desconto = desconto;
  }

  public void addHospede(Hospede hospede) {
    hospedes.add(hospede);
  }

  public Boolean removeHospede(Hospede hospede) {
    return hospedes.remove(hospede);
  }

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public Hospede getHospedePrincipal() {
    return hospedePrincipal;
  }

  public Acomodacao getAcomodacao() {
    return acomodacao;
  }

  public double getMulta() {
    return multa;
  }

  public double getDesconto() {
    return desconto;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }
}
