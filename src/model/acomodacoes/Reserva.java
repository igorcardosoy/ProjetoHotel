// Pacote onde a classe ReservaAbstract está localizada
package model.acomodacoes;

// Importações de classes necessárias do pacote model.pessoas e java.time
import model.pessoas.Hospede;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.CartaoCredito;

import static view.Hotel.*;


/**
 * Definição da classe ReservaAbstract (classe abstrata) que representa uma
 * reserva de acomodação no hotel.
 * adicionais, acomodacao, cartaoCredito, valor de uma possivel multa.

 */
public class Reserva {

    // Atributos da classe
    private LocalDateTime checkIn;           // Data e hora de check-in da reserva
    private LocalDateTime checkOut;          // Data e hora de check-out da reserva
    private Hospede hospedePrincipal;        // Hóspede principal associado à reserva
    private List<Hospede> hospedes;          // Lista de hóspedes adicionais associados à reserva
    private Acomodacao acomodacao;           // Acomodação associada à reserva
    private CartaoCredito cartaoCredito;           // Cartão de crédito associado à reserva
    private double multa;                    // Valor da multa associada à reserva


    /**
     * Construtor da classe ReservaAbstract que recebe os parâmetros para
     * inicializar os atributos.
     * @param checkIn
     * @param checkOut
     * @param hospedePrincipal
     * @param acomodacao
     * @param cartaoCredito
     */
    public Reserva(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal,
                   Acomodacao acomodacao, CartaoCredito cartaoCredito) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.hospedePrincipal = hospedePrincipal;
        this.acomodacao = acomodacao;
        this.cartaoCredito = cartaoCredito;
        this.multa = 0;
        hospedes = new ArrayList<>();
    }


    /**
     * Método que adiciona um hóspede à lista de hóspedes acomodados no hotel.
     * @param hospede que será adicionado a lista de hospedes da reserva.
     * @return true se o hospede foi adicionado com sucesso, false caso contrario.
     */
    public boolean addHospede(Hospede hospede) {
        return hospedes.add(hospede);
    }

    /**
     * Método que remove um hóspede da lista de hóspedes acomodados no hotel.
     * @param hospede que será removido da lista de hospedes da reserva.
     * @return true se o hospede foi removido com sucesso, false caso contrario.
     */
    public Boolean removeHospede(Hospede hospede) {
        return hospedes.remove(hospede);
    }

    /**
     * Método que recupera a lista de hóspedes acomodados no hotel.
     * @return lista de hospedes acomodados.
     */
    public List<Hospede> getHospedes() {
        return hospedes;
    }


    /**
     * Método para obter a data e hora de check-in da reserva
     * @return Data e hora de check-in da reserva.
     */
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    /**
     * Método para obter a data e hora de check-out da reserva
     * @return Data e hora de check-out da reserva.
     */
    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    /**
     * Método para obter o hóspede principal associado à reserva
     * @return Hóspede principal associado à reserva.
     */
    public Hospede getHospedePrincipal() {
        return hospedePrincipal;
    }

    /**
     * Método para obter a acomodação associada à reserva
     * @return Acomodação associada à reserva.
     */
    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    /**
     * Método para obter o cartão de crédito associado à reserva
     * @return Cartão de crédito associado à reserva.
     */
    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    /**
     * Método para definir a data e hora de checkin da reserva
     */
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Método para definir a data e hora de checkout da reserva
     */
    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }


    /**
     * @return Valor da multa associada à reserva.
     */
    public double getMulta() {
        return multa;
    }

    /**
     * Método que verifica se hospede deverá pagar multa ou não.
     * @return true se o hospede deverá pagar multa, false caso contrario.
     */
  public boolean canRemoveWithoutPay() {
    return false;
  }

    /**
     * Método que retorna uma descricao da reserva.
     * @return String contendo data e hora de checkin e checkout, nome do
     * hospede principal, numero da acomodacao e numero do cartao de credito,
     * valor da possivel multa e quantidade de hospedes na acomodacao.
     */
  public String toString() {
    return "Reserva: " + this.checkIn.format(formatterData) + " - " + this.checkOut.format(formatterData) + " - " + this.hospedePrincipal.getNome() + " - " + this.acomodacao.getNumero() + " - " + this.cartaoCredito.getNumero() + " - " + this.multa + " - " + this.hospedes.size();
  }

    /**
     * Método que retorna uma lista com todos os hospedes da reserva.
     * @return lista de hospedes.
     */
  public List<Hospede> getAllHospedes() {
    List<Hospede> hospedes = new ArrayList<>();
    hospedes.add(this.hospedePrincipal);
    hospedes.addAll(this.hospedes);
    return hospedes;
  }
}