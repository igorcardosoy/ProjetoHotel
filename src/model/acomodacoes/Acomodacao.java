package model.acomodacoes;

/**
 * Definição da classe Acomodacao.
 * @atributos numero, andar, tipo.
 */
public class Acomodacao {

  // Atributos da classe
  int numero; // Número da acomodação
  int andar;  // Andar onde a acomodação está localizada
  TipoAcomodacao tipo; // Tipo de acomodação (presumivelmente uma enumeração TipoAcomodacao)

    /**
     * Construtor da classe Acomodacao que recebe parâmetros para inicializar
     * os atributos.
     * @param numero
     * @param andar
     * @param tipo
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

