package view;

import model.acomodacoes.*;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;

import java.util.List;

public class Hotel {
  private List<Administrador> administradores;
  private List<Hospede> hospedes;
  private List<Funcionario> funcionarios;

  private List<ItensConsumo> itensConsumoDisponiveis;

  private List<Acomodacao> acomodacoesDisponiveis;
  private List<TipoAcomodacao> tiposAcomodacao;

  private List<Reserva> reservas;
  private List<Acomodado> acomodados;


}
