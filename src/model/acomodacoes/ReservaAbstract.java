// Pacote onde a classe ReservaAbstract está localizada
package model.acomodacoes;

// Importações de classes necessárias do pacote model.pessoas e java.time
import model.pessoas.Hospede;
import java.time.LocalDateTime;
import java.util.List;

// Definição da classe ReservaAbstract (classe abstrata)
public abstract class ReservaAbstract {

  // Atributos da classe
  private LocalDateTime checkIn;           // Data e hora de check-in da reserva
  private LocalDateTime checkOut;          // Data e hora de check-out da reserva
  private Hospede hospedePrincipal;        // Hóspede principal associado à reserva
  private List<Hospede> hospedes;          // Lista de hóspedes adicionais associados à reserva
  private Acomodacao acomodacao;           // Acomodação associada à reserva

  // Construtor da classe ReservaAbstract que recebe parâmetros para inicializar os atributos
  public ReservaAbstract(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal,
                         Acomodacao acomodacao) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.hospedePrincipal = hospedePrincipal;
    this.acomodacao = acomodacao;
  }

  // Método para adicionar um hóspede à lista de hóspedes associada à reserva
  public void addHospede(Hospede hospede) {
    hospedes.add(hospede);
  }

  // Método para remover um hóspede da lista de hóspedes associada à reserva
  public Boolean removeHospede(Hospede hospede) {
    return hospedes.remove(hospede);
  }

  // Método para obter a lista de hóspedes associada à reserva
  public List<Hospede> getHospedes() {
    return hospedes;
  }

  // Método para obter a data e hora de check-in da reserva
  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  // Método para obter a data e hora de check-out da reserva
  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  // Método para obter o hóspede principal associado à reserva
  public Hospede getHospedePrincipal() {
    return hospedePrincipal;
  }

  // Método para obter a acomodação associada à reserva
  public Acomodacao getAcomodacao() {
    return acomodacao;
  }

  // Método para definir a data e hora de check-in da reserva
  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  // Método para definir a data e hora de check-out da reserva
  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }
}