package model.enums;

import model.itensCosumo.ItensConsumo;

public enum TipoItens {
  LAVANDERIA("Lavanderia"),
  FRIGOBAR("Frigobar"),
  RESTAURANTE("Restaurante");

  private String tipoItens;

    TipoItens(String tipoItens) {
        this.tipoItens = tipoItens;
    }

    public String getTipoItens() {
        return tipoItens;
    }
}