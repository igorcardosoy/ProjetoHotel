package model.itensCosumo;

import java.time.LocalDateTime;

import static view.Hotel.formatterDataHora;


/**
 * Definição da classe Consumo do hospede.
 * data do consumo, funcionario responsavel pela marcacao, codigo
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
     * @param dataConsumo data do consumo
     * @param funcionarioResponsavel funcionario responsavel pela marcacao
     * @param codigoItem codigo do item
     * @param quantidade quantidade consumida
     * @param valorTotal valor total
     */
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
    return "\nData do consumo: " + dataConsumo.format(formatterDataHora)+ "\n" +
           "Código do item: " + codigoItem + "\n" +
           "Quantidade: " + quantidade + "\n" +
           "Valor total: " + valorTotal + "\n";
  }
}
