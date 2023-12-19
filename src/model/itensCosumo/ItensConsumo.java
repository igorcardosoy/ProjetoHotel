package model.itensCosumo;

import model.enums.TipoItens;

/**
 * Definição da classe ItensConsumo.
 */
public class ItensConsumo {
  TipoItens tipo;
  int codigo;
  String descricao;
  double valor;

    /**
     * Construtor da classe ItensConsumo que recebe parâmetros para inicializar
     * os atributos.
     * @param codigo
     * @param tipo
     * @param descricao
     * @param valor
     */
  public ItensConsumo(int codigo, TipoItens tipo, String descricao, double valor) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.valor = valor;
    this.tipo = tipo;
  }


  /**
   * @return valor do item.
   */
  public double getValor() {
      return valor;
  }

    /**
     * @return codigo do item.
     */
  public int getCodigo() {
    return codigo;
  }

    /**
     * @return tipo do item.
     */
  public TipoItens getTipo() {
    return tipo;
  }

    /**
     * @return descricao do item.
     */
  public String getDescricao(){
    return descricao;
  }

  public String toString(){
    return "Código: " + codigo + " | " +
            "Tipo: " + tipo + " | " +
            "Descrição: " + descricao + " | " +
            "Valor: " + valor + " | ";
  }
}