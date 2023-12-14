package model.itensCosumo;

import model.itensCosumo.ItensConsumo;

import java.util.ArrayList;
import java.util.List;

public class ListaItensConsumo {
  List<ItensConsumo> itensConsumoDisponiveis;

  public ListaItensConsumo() {
    itensConsumoDisponiveis = new ArrayList<ItensConsumo>(5);
  }

  public void adicionarItem(ItensConsumo item) {
    itensConsumoDisponiveis.add(item);
  }

  public boolean removerItem(ItensConsumo item) {
    return itensConsumoDisponiveis.remove(item);
  }


  public ItensConsumo getItem(int codigoItem) {
    for (ItensConsumo item : itensConsumoDisponiveis) {
      if (item.getCodigo() == codigoItem) {
        return item;
      }
    }
    return null;
  }
}
