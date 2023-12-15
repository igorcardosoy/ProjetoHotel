package model.acomodacoes;

import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import java.time.LocalDateTime;
import java.util.List;

public abstract class ReservaAbstract {
  private LocalDateTime checkIn;
  private LocalDateTime checkOut;
  private Hospede hospedePrincipal;
  private List<Hospede> hospedes;
  private Acomodacao acomodacao;

  public ReservaAbstract(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.hospedePrincipal = hospedePrincipal;
    this.acomodacao = acomodacao;
  }


  public void addHospede(Hospede hospede) {
    hospedes.add(hospede);
  }

  public Boolean removeHospede(Hospede hospede) {
    return hospedes.remove(hospede);
  }

  public List<Hospede> getHospedes() {
    return hospedes;
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

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }

}
