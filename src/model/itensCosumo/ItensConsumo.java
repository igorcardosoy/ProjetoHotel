package model.itensCosumo;

import model.enums.TipoItens;

public class ItensConsumo {

  TipoItens tipo;
  int codigo;
  String descricao;
  double valor;

  public ItensConsumo(int codigo, TipoItens tipo, String descricao, double valor) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.valor = valor;
    this.tipo = tipo;
  }

  public int getCodigo() {
    return codigo;
  }

  public double getValor() {
    return valor;
  }

  public TipoItens getTipo() {
    return tipo;
  }

  public String getDescricao(){
    return descricao;
  }
}