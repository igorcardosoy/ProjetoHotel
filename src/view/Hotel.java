package view;

import model.acomodacoes.ReservaAbstract;
import model.acomodacoes.TipoAcomodacao;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import java.util.List;

import java.util.Scanner;

public static class Hotel {
  List<Pessoa> administradores;
  List<Pessoa> hospedes;
  List<Pessoa> funcionarios;

  List<ItensConsumo> itensConsumoDisponiveis;

  List<Acomodacao> acomodacoes;
  List<TipoAcomodacao> tiposAcomodacao;

  List<ReservaAbstract> reservas;
  List<ReservaAbstract> acomodados;

  Scanner scan = new Scanner(System.in);

  public List<ItensConsumo> getItensConsumoDisponiveis() {
    return itensConsumoDisponiveis;
  }

  public List<Acomodacao> getAcomodacoes() {
    return acomodacoes;
  }

  public List<TipoAcomodacao> getTiposAcomodacao() {
    return tiposAcomodacao;
  }

  public List<ReservaAbstract> getReservas() {
    return reservas;
  }

  public List<ReservaAbstract> getAcomodados() {
    return acomodados;
  }
}
