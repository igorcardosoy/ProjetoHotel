package model.itensCosumo;

import java.time.LocalDateTime;

public class Consumo {
  LocalDateTime dataConsumo;
  String funcionarioResponsavel;
  int codigoItem;
  int quantidade;
  double valorTotal;

  public Consumo(LocalDateTime dataConsumo, String funcionarioResponsavel, int codigoItem, int quantidade, double valorTotal) {
    this.dataConsumo = dataConsumo;
    this.funcionarioResponsavel = funcionarioResponsavel;
    this.codigoItem = codigoItem;
    this.quantidade = quantidade;
    this.valorTotal = valorTotal;
  }
}
