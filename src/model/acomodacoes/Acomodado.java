package model.acomodacoes;

import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import java.time.LocalDateTime;

public class Acomodado extends ReservaAbstract {
  private Funcionario funcionarioResponsavel;

  public Acomodado(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, Funcionario funcionarioResponsavel) {
    super(checkIn, checkOut, hospedePrincipal, acomodacao);
    this.funcionarioResponsavel = funcionarioResponsavel;
  }


}
