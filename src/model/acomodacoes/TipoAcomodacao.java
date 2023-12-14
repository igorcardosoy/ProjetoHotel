package model.acomodacoes;

public class TipoAcomodacao{
  int codigo;
  String nome;
  String descricao;
  int quantidadeExistente;
  double valorDiaria;
  int adultosComportados;
  int criancasComportadas;

  public TipoAcomodacao(int codigo, String name, String descricao, int quantidadeExistente, double valorDiaria, int adultosComportados, int criancasComportadas) {
    this.codigo = codigo;
    this.nome = name;
    this.descricao = descricao;
    this.quantidadeExistente = quantidadeExistente;
    this.valorDiaria = valorDiaria;
    this.adultosComportados = adultosComportados;
    this.criancasComportadas = criancasComportadas;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getQuantidadeExistente() {
    return quantidadeExistente;
  }

  public double getDiaria() {
    return valorDiaria;
  }

  public int getAdultosComportados() {
    return adultosComportados;
  }

  public int getCriancasComportadas() {
    return criancasComportadas;
  }
}
