package model;

import model.enums.TipoDoc;
import model.pessoas.Hospede;

public class Indentificacao {
  private int numero;
  private TipoDoc tipo;

  public Indentificacao(int numero, TipoDoc tipo) {
    this.numero = numero;
    this.tipo = tipo;
  }

  public int getNumero() {
    return numero;
  }

  public String getTipo() {
    return tipo.name();
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setTipo(TipoDoc tipo) {
    this.tipo = tipo;
  }

  public String toString() {
    return "Tipo: " + tipo.name() + " Numero: " + numero;
  }
}
