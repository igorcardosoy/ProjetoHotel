package model.acomodacoes;

import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;
import java.time.LocalDateTime;

// Definição da classe Acomodado, que herda de ReservaAbstract
public class Acomodado extends ReservaAbstract {

  // Atributo adicional específico da classe Acomodado
  private Funcionario funcionarioResponsavel;

  // Construtor da classe Acomodado que recebe parâmetros para inicializar os atributos
  public Acomodado(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, Funcionario funcionarioResponsavel) {
    // Chamada ao construtor da classe pai (ReservaAbstract) usando a palavra-chave 'super'
    super(checkIn, checkOut, hospedePrincipal, acomodacao);

    // Inicialização do atributo específico da classe Acomodado
    this.funcionarioResponsavel = funcionarioResponsavel;
  }
}
