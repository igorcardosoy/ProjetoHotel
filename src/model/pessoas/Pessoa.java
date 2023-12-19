package model.pessoas;

import model.Indentificacao;
import model.enums.Estados;

import java.time.LocalDate;

import static view.Hotel.formatterData;

public abstract class Pessoa {
  private String nome;
  private long telefone;
  private String cidade;
  private Estados estado;
  private LocalDate dataNascimento;
  private int key;

  public Pessoa(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
    this.nome = nome;
    this.telefone = telefone;
    this.cidade = cidade;
    this.estado = estado;
    this.dataNascimento = dataNascimento;
    setKey(key);
  }

  private void setKey(int key) {
    this.key = key;
  }

  public String getNome() {
    return nome;
  }

  public long getTelefone() {
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

  public boolean allowAccess(int key) {
    return password(key);
  }

  // Método privado para verificar a senha do funcionário
  protected abstract boolean password(int key);

  public String toString() {
    return "Nome: " + nome + "\n" +
            "Telefone: " + telefone + "\n" +
            "Cidade: " + cidade + "\n" +
            "Estado: " + estado + "\n" +
            "Data de Nascimento: " + dataNascimento.format(formatterData) + "\n";
  }
}
