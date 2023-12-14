package model;

import model.enums.TipoDoc;

public class DocumentoIndentificacao {
  private int numero;
  private TipoDoc tipo;

  public DocumentoIndentificacao(int numero, TipoDoc tipo) {
    this.numero = numero;
    this.tipo = tipo;
  }

  public int getNumero() {
    return numero;
  }

  public String getTipo() {
    return tipo.name();
  }
}
