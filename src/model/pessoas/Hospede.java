package model.pessoas;

import model.Indentificacao;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.enums.TipoItens;
import model.itensCosumo.Consumo;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static view.Hotel.formatterData;

/**
 * Definição da classe Hospede que herda de Pessoa
 * @atributos país, email, identificação, nome da mãe, nome do pai, gastos telefonicos, dados de consumo,
 *            dados de cosumo do frigobar, dados de consumo da lavanderia, itens comprados, funcionário responsável
 */
public class Hospede extends Pessoa {

  // Atributos específicos da classe Hospede
  private String pais;
  private String email;
  private Indentificacao identificacao;
  private String nomeMae;
  private String nomePai;
  private double gastosTelefonicos;
  private List<Consumo> dadosConsumo;
  private List<Consumo> dadosConsumoFrigobar;
  private List<Consumo> dadosConsumoLavanderia;
  private List<Consumo> dadosConsumoRestaurante;
  private List<ItensConsumo> itensComprados;
  private Funcionario funcionarioResponsavel;

  /**
   * Construtor da classe Hospede
   * @param nome
   * @param telefone
   * @param cidade
   * @param estado
   * @param dataNascimento
   * @param pais
   * @param email
   * @param tipoDoc
   * @param numDoc
   * @param nomeMae
   * @param nomePai
   * @param funcionarioResponsavel
   * @param senha
   */
  public Hospede(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, String pais,
                 String email, TipoDoc tipoDoc, int numDoc, String nomeMae, String nomePai, Funcionario funcionarioResponsavel, int senha){
    // Chamando o construtor da classe pai (Pessoa)
    super(nome, telefone, cidade, estado, dataNascimento, senha);
    // Inicializando os atributos específicos da classe Hospede
    this.pais = pais;
    this.email = email;
    this.identificacao = new Indentificacao(numDoc, tipoDoc);
    this.nomeMae = nomeMae;
    this.nomePai = nomePai;
    gastosTelefonicos = 0;
    // Inicializando listas
    setItensComprados();
    setDadosConsumo();
  }

  /**
   * Método privado para inicializar a lista de itens comprados
   */
  private void setItensComprados() {
    this.itensComprados = new ArrayList<>(5);
  }

  /**
   * Método privado para inicializar as listas de consumo
   */
  private void setDadosConsumo() {
    this.dadosConsumo = new ArrayList<>(5);
    this.dadosConsumoFrigobar = new ArrayList<>(5);
    // this.dadosConsumoLavanderia = new ArrayList<>(5);
    // this.dadosConsumoRestaurante = new ArrayList<>(5);
  }

  /**
   * Método privado para verificar se o usuário tem permissão para editar
   * @param key
   * @return true se a senha estiver correta, false caso contrario.
  */
  private boolean canEdit(int key) {
    return key == this.getKey();
  }

  /**
   * Método para registrar o consumo de um item
   * @param dataDoConsumo
   * @param nomeFuncionario
   * @param qntConsumida
   * @param valorUnitario
   * @param codigoItem
   * @param listaItensConsumo
   */
  public void consumirItem(LocalDateTime dataDoConsumo, String nomeFuncionario, int qntConsumida, double valorUnitario,
                           int codigoItem, List<ItensConsumo> listaItensConsumo) {
    ItensConsumo itemConsumido = null;

    // Procura o item na lista de itens disponíveis
    for (ItensConsumo item : listaItensConsumo) {
      if (item.getCodigo() == codigoItem) {
        itemConsumido = item;
        break;
      }
    }

    // Se o item foi encontrado, registra o consumo na lista apropriada
    if (itemConsumido != null) {
      if (itemConsumido.getTipo() == TipoItens.FRIGOBAR) {
        dadosConsumoFrigobar.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      } else {
        dadosConsumo.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      }
    }
  }

  /**
   * Método para remover um item da lista de itens comprados
   * @param item
   * @param key
   * @return itensComprados.remove(item) caso um item tenha sido removido ou false caso contrário
   */
  public boolean removerItem(ItensConsumo item, int key) {
    // Verifica se o usuário tem permissão para remover itens
    if (canEdit(key)) {
      return itensComprados.remove(item);
    }
    return false;
  }

  /**
   * Método para contabilizar os itens consumidos
   * @param key
   * @return true caso a contabilização dos itens ocorrer com sucesso ou false caso contrário
   */
  public boolean contabilizarItens(int key) {
    // Verifica se o usuário tem permissão para contabilizar itens
    if (canEdit(key)) {
      dadosConsumo.addAll(dadosConsumoFrigobar);
      dadosConsumoFrigobar.clear();
      return true;
    }
    return false;
  }

  // Métodos de acesso aos atributos da classe Hospede

  /**
   * Métodos de acesso a lista de consumo
   * @return os dados de consumo
   */
  public List<Consumo> getConsumo() {
    return dadosConsumo;
  }

  /**
   * Métodos de acesso a lista de consumo do frigobar
   * @return os dados de consumo do frigobar
   */
  public List<Consumo> getConsumoFrigobar() {
    return dadosConsumoFrigobar;
  }

  /**
   * Métodos de acesso ao país do hospede
   * @return o país de origem
   */
  public String getPais() {
    return pais;
  }

  /**
   * Métodos de acesso ao email do hospede
   * @return o email do hospede
   */
  public String getEmail() {
    return email;
  }

  /**
   * Métodos de acesso ao número da identificação do hospede
   * @return número da identificação do hospede
   */
  public int getIdentificacaoNumero() {
    return identificacao.getNumero();
  }

  /**
   * Métodos de acesso aos gastos telefonicos do hospede
   * @return os gastos telefonicos
   */
  public double getGastosTelefonicos() {
    return gastosTelefonicos;
  }

  /**
   * Métodos de acesso ao tipo de identificação do hospede
   * @return o tipo de identificação do hospede
   */
  public String getIdentificacaoTipo() {
    return identificacao.getTipo();
  }

  /**
   * Métodos de acesso do nome da mãe do hospede
   * @return o nome da mãe do hospede
   */
  public String getNomeMae() {
    return nomeMae;
  }

  /**
   * Métodos de acesso do nome do pai do hospede
   * @return o nome do pai do hospede
   */
  public String getNomePai() {
    return nomePai;
  }

  /**
   * Métodos de acesso ao funcionário responsável
   * @return o funcionário responsável
   */
  public Funcionario getFuncionarioResponsavel() {
    return funcionarioResponsavel;
  }

  /**
   * Métodos de acesso aos itens comprados pelo hospede
   * @return os itens comprados pelo hospede
   */
  public List<ItensConsumo> getItensComprados() {
    return itensComprados;
  }

  // Métodos de modificação dos atributos da classe Hospede

  /**
   * Método de modificação do país do hospede
   * @param pais
   */
  public void setPais(String pais) {
    this.pais = pais;
  }

  /**
   * Método de modificação do email do hospede
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Método de modificação da identificação do hospede
   * @param identificacao
   */
  public void setIdentificacao(Indentificacao identificacao) {
    this.identificacao = identificacao;
  }

  /**
   * Método de modificação do nome da mãe do hospede
   * @param nomeMae
   */
  public void setNomeMae(String nomeMae) {
    this.nomeMae = nomeMae;
  }

  /**
   * Método de modificação do nome do pai do hospede
   * @param nomePai
   */
  public void setNomePai(String nomePai) {
    this.nomePai = nomePai;
  }

  /**
   * Método de modificação do funcinário responsável pelo do hospede
   * @param funcionarioResponsavel
   */
  public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
    this.funcionarioResponsavel = funcionarioResponsavel;
  }

  /**
   * Método de acesso ao atributo identificacao
   * @return a indentificação do hospede
   */
  public Indentificacao getIdentificacao() {
    return this.identificacao;
  }

   /**
    * Método protegido para verificar a senha do hospede
    * @param key
    * @return true se a senha estiver correta, false caso contrario.
    */
  @Override
  protected boolean password(int key) {
    return key == this.getKey();
  }

  /**
    * Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    * @return String contendo os dados do hospede como nome, telefone, cidade, estado, data de nascimento
    */
  @Override
  public String toString() {
    return "Hospede: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
            + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento().format(formatterData);


  }

}
