package model.pessoas;

import model.Indentificacao;
import model.enums.Estados;

import java.time.LocalDate;

import static view.Hotel.formatterData;

/**
 * Definição da classe Pessoa que é abstrata e representa uma pessoa
 */
public abstract class Pessoa {
  private String nome;
  private long telefone;
  private String cidade;
  private Estados estado;
  private LocalDate dataNascimento;
  private int key;

  /**
   * Construtor da classe da Pessoa
   * @param nome nome da pessoa
   * @param telefone telefone da pessoa
   * @param cidade cidade da pessoa
   * @param estado estado da pessoa
   * @param dataNascimento data de nascimento da pessoa
   * @param key chave de acesso da pessoa
   */
  public Pessoa(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
    this.nome = nome;
    this.telefone = telefone;
    this.cidade = cidade;
    this.estado = estado;
    this.dataNascimento = dataNascimento;
    setKey(key);
  }

  /**
   * Método de modificação da chave
   * @param key chave de acesso
   */
  private void setKey(int key) {
    this.key = key;
  }

  /**
   * Método de acesso ao nome da pessoa 
   * @return o nome da pessoa
   */
  public String getNome() {
    return nome;
  }

  /**
   * Método de acesso ao telefone da pessoa
   * @return o telefone
   */
  public long getTelefone() {
    return telefone;
  }

  /**
   * Método de acesso
   * @return a cidade
   */
  public String getCidade() {
    return cidade;
  }

  /**
   * Método de acesso do estado
   * @return o estado
   */
  public Estados getEstado() {
    return estado;
  }

  /**
   * Método de acesso à data de nascimento da pessoa
   * @return à data de nascimento 
   */
  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  /**
   * Método de acesso da chave de acesso
   * @return a chave de acesso
   */
  public int getKey() {
    return key;
  }

  /**
   * Método de modificação do nome da pessoa
   * @param nome que sera setado
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Método de modificação do telefone da pessoa
   * @param telefone que sera setado
   */
  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  /**
   * Método de modificação da cidade do hospede
   * @param cidade que sera setado
   */
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  /**
   * Método de modificação do estado da pessoa
   * @param estado que sera setado
   */
  public void setEstado(Estados estado) {
    this.estado = estado;
  }

  /**
   * Método de modificação da data de nascimento da pessoa
   * @param dataNascimento data de nascimento que sera setada
   */
  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  /**
   * Método para permitir o acesso da pessoa
   * @param key chave de acesso
   * @return chave de acesso
   */
  public boolean allowAccess(int key) {
    return password(key);
  }

  protected abstract boolean password(int key);

  /**
    * Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    * @return String contendo os dados de uma pessoa como nome, telefone, cidade, estado, data de nascimento
    */
  public String toString() {
    return "Nome: " + nome + "\n" +
            "Telefone: " + telefone + "\n" +
            "Cidade: " + cidade + "\n" +
            "Estado: " + estado + "\n" +
            "Data de Nascimento: " + dataNascimento.format(formatterData) + "\n";
  }
}
