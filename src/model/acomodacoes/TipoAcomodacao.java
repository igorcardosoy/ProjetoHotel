package model.acomodacoes;

/**
 * Definição da classe TipoAcomodacao.
 * valor da diaria,
 * quantidade de adultos  e criancas que cabem nela.
 */
public class TipoAcomodacao {

  // Atributos da classe
  long codigo;                   // Código identificador do tipo de acomodação
  String nome;                  // Nome do tipo de acomodação
  String descricao;             // Descrição do tipo de acomodação
  int quantidadeExistente;      // Quantidade existente desse tipo de acomodação
  int quantidadeDisponivel;     // Quantidade disponível desse tipo de acomodação
  double valorDiaria;           // Valor da diária para esse tipo de acomodação
  int adultosComportados;       // Número de adultos que podem ser acomodados
  int criancasComportadas;      // Número de crianças que podem ser acomodadas

    /**
     * Construtor da classe TipoAcomodacao que recebe parâmetros para inicializar
     * os atributos.
     * @param codigo codigo do tipo de acomodacao
     * @param nome nome do tipo de acomodacao
     * @param descricao descricao do tipo de acomodacao
     * @param quantidadeExistente quantidade existente do tipo de acomodacao
     * @param valorDiaria valor da diaria do tipo de acomodacao
     * @param adultosComportados quantidade de adultos que cabem na acomodacao
     * @param criancasComportadas quantidade de criancas que cabem na acomodacao
     */
  public TipoAcomodacao(long codigo, String nome, String descricao, int quantidadeExistente, double valorDiaria,
                        int adultosComportados, int criancasComportadas) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
    this.quantidadeExistente = quantidadeExistente;
    this.quantidadeDisponivel = quantidadeExistente;
    this.valorDiaria = valorDiaria;
    this.adultosComportados = adultosComportados;
    this.criancasComportadas = criancasComportadas;
  }


  /**
   * @return código identificador do tipo de acomodação.
   */
  public long getCodigo() {
    return codigo;
  }


  /**
   * @return nome do tipo de acomodação.
   */
  public String getNome() {
    return nome;
  }

  /**
   * @return descrição do tipo de acomodação.
   */
  public String getDescricao() {
    return descricao;
  }

    /**
     * @return quantidade existente desse tipo de acomodação.
     */
  public int getQuantidadeExistente() {
    return quantidadeExistente;
  }

    /**
     * @return valor da diária para esse tipo de acomodação.
     */
  public double getDiaria() {
    return valorDiaria;
  }

  /**
   * @return número de adultos que podem ser acomodados.
   */
  public int getAdultosComportados() {
    return adultosComportados;
  }


  /**
   * @return número de crianças que podem ser acomodadas.
   */
  public int getCriancasComportadas() {
    return criancasComportadas;
  }

    /**
     * @return quantidade disponível desse tipo de acomodação.
     */
  public int getQuantidadeDisponivel() {
    return quantidadeDisponivel;
  }

    /**
     * Método para ocupar uma unidade da quantidade disponível
     */
  public void addQuantidadeDisponivel() {
    quantidadeDisponivel -= 1;
  }

  /**
   * @return tipo da acomodação.
   */
  public TipoAcomodacao getTipo() {
    return this;
  }

    /**
     * Método que retorna uma descricao do tipo de acomodacao.
     * @return String contendo o codigo, nome, descricao, quantidade
     * existente, valor da diaria e
     * quantidade de adultos e criancas que cabem nela.
     */
  @Override
    public String toString() {
        return "TipoAcomodacao{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidadeExistente=" + quantidadeExistente +
                ", valorDiaria=" + valorDiaria +
                ", adultosComportados=" + adultosComportados +
                ", criancasComportadas=" + criancasComportadas +
                '}';
    }
}
