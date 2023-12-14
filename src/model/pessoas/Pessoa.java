package model.pessoas;

import model.enums.Estados;

import java.time.LocalDate;

public abstract class Pessoa {
  private String nome;
  private int telefone;
  private String cidade;
  private Estados estado;
  private LocalDate dataNascimento;
  private int key;

  public Pessoa(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
    this.nome = nome;
    this.telefone = telefone;
    this.cidade = cidade;
    this.estado = estado;
    this.dataNascimento = dataNascimento;
    setKey(key);
  }

  private void setKey(int key ) {
    this.key = key;
  }

  public String getNome() {
    return nome;
  }

  public int getTelefone() {
    return telefone;
  }

  public String getCidade() {
    return cidade;
  }

  public Estados getEstado() {
    return estado;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public int getKey() {
    return key;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public void setEstado(Estados estado) {
    this.estado = estado;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}
