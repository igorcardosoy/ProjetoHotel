package model.itensCosumo;

import java.time.LocalDateTime;


/**
 * Definição da classe Consumo do hospede.
 * @atributos data do consumo, funcionario responsavel pela marcacao, codigo
 * do item, quantidade consumida e valor total.
 */
public class Consumo {
  LocalDateTime dataConsumo;
  String funcionarioResponsavel;
  int codigoItem;
  int quantidade;
  double valorTotal;

    /**
     * Construtor da classe Consumo que recebe parâmetros para inicializar
     * os atributos.
     * @param dataConsumo
     * @param funcionarioResponsavel
     * @param codigoItem
     * @param quantidade
     * @param valorTotal
     */
  public Consumo(LocalDateTime dataConsumo, String funcionarioResponsavel, int codigoItem, int quantidade, double valorTotal) {
    this.dataConsumo = dataConsumo;
    this.funcionarioResponsavel = funcionarioResponsavel;
    this.codigoItem = codigoItem;
    this.quantidade = quantidade;
    this.valorTotal = valorTotal;
  }
}
