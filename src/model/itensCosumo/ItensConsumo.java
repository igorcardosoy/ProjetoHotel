package model.itensCosumo;

import model.enums.TipoItens;

public class ItensConsumo {

  TipoItens tipo;
  int codigo;
  String descricao;
  double valor;

  public ItensConsumo(int codigo, String tipo, String descricao, double valor) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.valor = valor;

    switch (tipo) {
      case "LAVANDERIA":
        this.tipo = TipoItens.LAVANDERIA;
        break;
      case "FRIGOBAR":
        this.tipo = TipoItens.FRIGOBAR;
        break;
      case "RESTAURANTE":
        this.tipo = TipoItens.RESTAURANTE;
        break;
    }
  }


  public int getCodigo() {
    return codigo;
  }

  public TipoItens getTipo() {
    return tipo;
  }
}
