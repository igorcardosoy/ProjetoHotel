package model.itensCosumo;

import java.time.LocalDateTime;

public class Consumo {
  LocalDateTime dataConsumo;
  String nomeFuncionario;
  int codigoItem;
  int quantidade;
  double valor;

  public Consumo(LocalDateTime dataConsumo, String nomeFuncionario, int codigoItem, int quantidade, double valor) {
    this.dataConsumo = dataConsumo;
    this.nomeFuncionario = nomeFuncionario;
    this.codigoItem = codigoItem;
    this.quantidade = quantidade;
    this.valor = valor;
  }
}
