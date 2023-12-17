package model.pessoas;

import model.Indentificacao;
import model.acomodacoes.Acomodacao;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.enums.TipoItens;
import model.enums.Keys;
import model.itensCosumo.Consumo;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// Definição da classe Hospede que herda de Pessoa
public class Hospede extends Pessoa {

  // Atributos específicos da classe Hospede
  private String pais;
  private String email;
  private Indentificacao identificacao;
  private String nomeMae;
  private String nomePai;
  private List<Consumo> dadosConsumo;
  private List<Consumo> dadosConsumoFrigobar;
  private List<Consumo> dadosConsumoLavanderia;
  private List<Consumo> dadosConsumoRestaurante;
  private List<ItensConsumo> itensComprados;

  // Construtor da classe Hospede
  public Hospede(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, String pais,
                 String email, TipoDoc tipoDoc, int numDoc, String nomeMae, String nomePai) {
    // Chamando o construtor da classe pai (Pessoa)
    super(nome, telefone, cidade, estado, dataNascimento, 1);
    // Inicializando os atributos específicos da classe Hospede
    this.pais = pais;
    this.email = email;
    this.identificacao = new Indentificacao(numDoc, tipoDoc);
    this.nomeMae = nomeMae;
    this.nomePai = nomePai;
    // Inicializando listas
    setItensComprados();
    setDadosConsumo();
  }

  // Método privado para inicializar a lista de itens comprados
  private void setItensComprados() {
    this.itensComprados = new ArrayList<>(5);
  }

  // Método privado para inicializar as listas de consumo
  private void setDadosConsumo() {
    this.dadosConsumo = new ArrayList<>(5);
    this.dadosConsumoFrigobar = new ArrayList<>(5);
    // this.dadosConsumoLavanderia = new ArrayList<>(5);
    // this.dadosConsumoRestaurante = new ArrayList<>(5);
  }

  // Método privado para verificar se o usuário tem permissão para editar (key 3 == adm, 2 == funcionario, 1 == hospede)
  private boolean canEdit(int key) {
    return key == Keys.FUNCIONARIO.getkey();
  }

  // Método para registrar o consumo de um item
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

  // Método para remover um item da lista de itens comprados
  public boolean removerItem(ItensConsumo item, int key) {
    // Verifica se o usuário tem permissão para remover itens
    if (canEdit(key)) {
      return itensComprados.remove(item);
    }
    return false;
  }

  // Método para contabilizar os itens consumidos
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
  public List<Consumo> getConsumo() {
    return dadosConsumo;
  }

  public String getPais() {
    return pais;
  }

  public String getEmail() {
    return email;
  }

  public int getIdentificacaoNumero() {
    return identificacao.getNumero();
  }

  public String getIdentificacaoTipo() {
    return identificacao.getTipo();
  }

  public String getNomeMae() {
    return nomeMae;
  }

  public String getNomePai() {
    return nomePai;
  }

  public List<ItensConsumo> getItensComprados() {
    return itensComprados;
  }

  // Métodos de modificação dos atributos da classe Hospede
  public void setPais(String pais) {
    this.pais = pais;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setIdentificacao(Indentificacao identificacao) {
    this.identificacao = identificacao;
  }

  public void setNomeMae(String nomeMae) {
    this.nomeMae = nomeMae;
  }

  public void setNomePai(String nomePai) {
    this.nomePai = nomePai;
  }

  // Método de acesso ao atributo identificacao
  public Indentificacao getIdentificacao() {
    return this.identificacao;
  }

}
