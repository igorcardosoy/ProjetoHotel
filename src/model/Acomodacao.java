package model;

public class Acomodacao {
  int numero;
  int andar;
  TipoAcomodacao tipo;

  public Acomodacao(int numero, int andar, TipoAcomodacao tipo) {
    this.numero = numero;
    this.andar = andar;
    this.tipo = tipo;
  }

  public int getNumero() {
    return numero;
  }

  public int getAndar() {
    return andar;
  }

  public TipoAcomodacao getTipo() {
    return tipo;
  }
}
