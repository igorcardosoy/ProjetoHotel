package model.pessoas;

import model.enums.Estados;

public class Hospede extends Pessoa {
  Estados estado;


  public Hospede(Estados estado) {
    this.estado = estado;
  }

}
