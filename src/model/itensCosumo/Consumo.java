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

  public LocalDateTime getDataConsumo() {
    return dataConsumo;
  }

  public String getFuncionarioResponsavel() {
    return funcionarioResponsavel;
  }

  public int getCodigoItem() {
    return codigoItem;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setDataConsumo(LocalDateTime dataConsumo) {
    this.dataConsumo = dataConsumo;
  }

  public String toString() {
    return "Data do consumo: " + dataConsumo + "\n" +
           "Código do item: " + codigoItem + "\n" +
           "Quantidade: " + quantidade + "\n" +
           "Valor total: " + valorTotal + "\n";
  }
}
