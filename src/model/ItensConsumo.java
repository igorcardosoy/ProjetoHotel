package model;

public class ItensConsumo {

  TipoItens tipo;
  int coidgo;
  String descricao;
  double valor;

  public ItensConsumo(int coidgo, String tipo, String descricao, double valor) {
    this.coidgo = coidgo;
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
}
