package model.itensCosumo;

import model.enums.TipoItens;

public class ItensConsumo {

  TipoItens tipo;
  long codigo;
  String descricao;
  double valor;

  public ItensConsumo(long codigo, TipoItens tipo, String descricao, double valor) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.valor = valor;
    this.tipo = tipo;
  }

  public long getCodigo() {
    return codigo;
  }

  public TipoItens getTipo() {
    return tipo;
  }

  public String getDescricao(){
    return descricao;
  }
}