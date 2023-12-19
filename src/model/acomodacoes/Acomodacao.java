package model.acomodacoes;

/**
 * Definição da classe Acomodacao.
 */
public class Acomodacao {

  // Atributos da classe
  private int numero; // Número da acomodação
  private int andar;  // Andar onde a acomodação está localizada
  private TipoAcomodacao tipo; // Tipo de acomodação (presumivelmente uma enumeração TipoAcomodacao)

    /**
     * Construtor da classe Acomodacao que recebe parâmetros para inicializar
     * os atributos.
     * @param numero numero da acomodacao
     * @param andar andar da acomodacao
     * @param tipo  tipo da acomodacao
     */
  public Acomodacao(int numero, int andar, TipoAcomodacao tipo) {
    this.numero = numero;
    this.andar = andar;
    this.tipo = tipo;
  }

  /**
   *  Método para obter o número da acomodação
   * @return número da acomodação.
   */
  public int getNumero() {
    return numero;
  }


  /**
   * Método para obter o andar da acomodação
   * @return andar da acomodação.
   */
  public int getAndar() {
    return andar;
  }

    /**
     * Método para obter o tipo da acomodação
     * @return tipo da acomodação.
     */
  public TipoAcomodacao getTipo() {
    return tipo;
  }

    /**
     * Método que retorna uma descricao da acomodacao.
     * @return String contendo o numero, andar e o tipo da acomodacao.
     */
  public String toString() {
    return "Número: " + numero + " | " +
           "Andar: " + andar + " | " +
           "Tipo: " + tipo.getDescricao() + "\n";
  }
}

