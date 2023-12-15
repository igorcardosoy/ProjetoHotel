package model.pessoas;

import model.Indentificacao;
import model.ListaItensConsumo;
import model.enums.Estados;
import model.enums.TipoDoc;
import model.enums.TipoItens;
import model.itensCosumo.Consumo;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa {
  private String pais;
  private String email;
  private Indentificacao indentificacao;
  private String nomeMae;
  private String nomePai;
  private List<Consumo> dadosConsumo;
  private List<Consumo> dadosConsumoFrigobar;
  private List<Consumo> dadosConsumoLavanderia;
  private List<Consumo> dadosConsumoRestaurante;
  private List<ItensConsumo> itensComprados;

public Hospede(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, String pais, String email, TipoDoc tipoDoc, int numDoc, String nomeMae, String nomePai) {
    super(nome, telefone, cidade, estado, dataNascimento, 1);
    this.pais = pais;
    this.email = email;
    this.indentificacao = new Indentificacao(numDoc, tipoDoc);
    this.nomeMae = nomeMae;
    this.nomePai = nomePai;
    setItensComprados();
    setDadosConsumo();
  }

  private void setItensComprados() {
    this.itensComprados = new ArrayList<>(5);
  }

  private void setDadosConsumo() {
    this.dadosConsumo = new ArrayList<>(5);
    this.dadosConsumoFrigobar = new ArrayList<>(5);
  }

  //key 3 == adm, 2 == funcionario, 1 == hospede
  private boolean canEdit(int key) {
    return key > 1;
  }

  public void consumirItem(LocalDateTime dataDoConsumo, String nomeFuncionario, int qntConsumida, double valorUnitario, int codigoItem, List<ItensConsumo> listaItensConsumo) {

    ItensConsumo itemConsumido = null;

    for (ItensConsumo item : listaItensConsumo) {
      if (item.getCodigo() == codigoItem) {
          itemConsumido = item;
        break;
      }
    }

    if (itemConsumido != null)
    {
      if (itemConsumido.getTipo() == TipoItens.FRIGOBAR) {
        dadosConsumoFrigobar.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      } else {
        dadosConsumo.add(new Consumo(dataDoConsumo, nomeFuncionario, codigoItem, qntConsumida, valorUnitario));
      }
    }

  }

  public boolean removerItem(ItensConsumo item, int key) {
    if (canEdit(key)){
      return itensComprados.remove(item);
    }

    return false;
  }

  public boolean contabilizarItens(int key) {
    if (canEdit(key)) {
      dadosConsumo.addAll(dadosConsumoFrigobar);
      dadosConsumoFrigobar.clear();

      return true;
    }

    return false;
  }

  public List<Consumo> getConsumo(){
    return dadosConsumo;
  }

  public String getPais() {
    return pais;
  }

  public String getEmail() {
    return email;
  }

  public int getIndentificacaoNumero() {
    return indentificacao.getNumero();
  }

  public String getIndentificacaoTipo() {
    return indentificacao.getTipo();
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

  public void setPais(String pais) {
    this.pais = pais;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setIndentificacao(Indentificacao indentificacao) {
    this.indentificacao = indentificacao;
  }

  public void setNomeMae(String nomeMae) {
    this.nomeMae = nomeMae;
  }

  public void setNomePai(String nomePai) {
    this.nomePai = nomePai;
  }
}
