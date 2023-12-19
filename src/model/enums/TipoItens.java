package model.enums;

import model.itensCosumo.ItensConsumo;

/**
 * Definição da enumeração de tipos de itens de consumo.
 * @see java.lang.Enum  LAVANDERIA, FRIGOBAR, RESTAURANTE.
 */
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