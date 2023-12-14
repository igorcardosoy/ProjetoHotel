package view;

import model.acomodacoes.ReservaAbstract;
import model.acomodacoes.TipoAcomodacao;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import java.util.List;

public class Hotel {
  List<Pessoa> administradores;
  List<Pessoa> hospedes;
  List<Pessoa> funcionarios;

  List<ItensConsumo> itensConsumoDisponiveis;

  List<TipoAcomodacao> tiposAcomodacao;

  List<ReservaAbstract> reservas;
  List<ReservaAbstract> acomodados;
}
