package model.acomodacoes;

import model.acomodacoes.TipoAcomodacao;

// Definição da classe Acomodacao
public class Acomodacao {

  // Atributos da classe
  int numero; // Número da acomodação
  int andar;  // Andar onde a acomodação está localizada
  TipoAcomodacao tipo; // Tipo de acomodação (presumivelmente uma enumeração TipoAcomodacao)

  // Construtor da classe Acomodacao que recebe parâmetros para inicializar os atributos
  public Acomodacao(int numero, int andar, TipoAcomodacao tipo) {
    this.numero = numero;
    this.andar = andar;
    this.tipo = tipo;
  }

  // Método para obter o número da acomodação
  public int getNumero() {
    return numero;
  }

  // Método para obter o andar da acomodação
  public int getAndar() {
    return andar;
  }

  // Método para obter o tipo de acomodação
  public TipoAcomodacao getTipo() {
    return tipo;
  }
}

