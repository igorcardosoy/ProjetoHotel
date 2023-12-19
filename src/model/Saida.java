package model;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Reserva;
import model.acomodacoes.Acomodado;
import model.pessoas.Hospede;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static view.Hotel.formatterDataHora;

/**
 * Definição da classe Saida para o processamento do encerramento da
 * estadia do hospede no hotel
 * @atributos número da acomodação, data e hora, diária cobrada, valor de cada diária, 
 *            gasto com telefonemas, desconto concedido, valor dos gastos com o consumo
 */
public class Saida {
    private int numAcomodacao; //Número da acomodação utilizada
    private LocalDateTime DataHora; //checkout do hospede
    private int diariaCost; //Número de diárias cobradas
    private double uniDiaria; //Valor de cada diária
    private double telefonemaCost; //Valor gasto com telefonemas
    private float desconto; //Desconto concedido
    private double gastosConsumo; //Valor gasto com consumo

    /**
     * Construtor da classe Saida caso o hospede tenha desconto
     * @param checkOut checkout do hospede
     * @param numAcomodacao número da acomodação utilizada
     * @param diariaCost número de diárias cobradas
     * @param uniDiaria valor de cada diária
     * @param telefonemaCost valor gasto com telefonemas
     * @param gastosConsumo valor gasto com consumo
     * @param desconto  desconto concedido
     */
    public Saida(LocalDateTime checkOut, int numAcomodacao, int diariaCost, double uniDiaria, double telefonemaCost, double gastosConsumo, float desconto){
        this.numAcomodacao = numAcomodacao;
        this.DataHora = checkOut;
        this.diariaCost = diariaCost;
        this.uniDiaria = uniDiaria;
        this.telefonemaCost = telefonemaCost;
        this.desconto = desconto;
        this.gastosConsumo = gastosConsumo;
    }

    /**
     * Construtor da classe Saida caso o hospede não tenha desconto
     * @param checkOut checkout do hospede
     * @param numAcomodacao número da acomodação utilizada
     * @param diariaCost número de diárias cobradas
     * @param uniDiaria valor de cada diária
     * @param telefonemaCost valor gasto com telefonemas
     * @param gastosConsumo valor gasto com consumo
     */
    public Saida(LocalDateTime checkOut, int numAcomodacao, int diariaCost, double uniDiaria, double telefonemaCost, double gastosConsumo){
        this.numAcomodacao = numAcomodacao;
        this.DataHora = checkOut;
        this.diariaCost = diariaCost;
        this.uniDiaria = uniDiaria;
        this.telefonemaCost = telefonemaCost;
        this.gastosConsumo = gastosConsumo;
        this.desconto = 0;
    }

    /**
     * Método de acesso ao número da acomodação utilizada
     * @return o número da acomodação utilizada
     */
    public int getNumAcomodacao() {
        return numAcomodacao;
    }

    /**
     * Método de modificação ao número da acomodação utilizada
     * @param numAcomodacao número da acomodação utilizada
     */
    public void setNumAcomodacao(int numAcomodacao) {
        this.numAcomodacao = numAcomodacao;
    }

    /**
     * Método de acesso a data e hora do checkout
     * @return data e hora
     */
    public LocalDateTime getDataHora() {
        return DataHora;
    }

    /**
     * Método de modificação a data e hora do checkout
     * @param dataHora data e hora
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.DataHora = dataHora;
    }

    /**
     * Método de acesso ao valor da diária
     * @return valor da diária
     */
    public float getDiariaCost() {
        return diariaCost;
    }

    /**
     * Método de modificação ao valor da diária
     * @param diariaCost valor da diária
     */
    public void setDiariaCost(int diariaCost) {
        this.diariaCost = diariaCost;
    }

    /**
     * Método de acesso ao valor de cada diária
     * @return valor de cada diária
     */
    public double getUniDiaria() {
        return uniDiaria;
    }

    /**
     * Método de modificação ao valor de cada diária
     * @param uniDiaria valor de cada diária
     */
    public void setUniDiaria(float uniDiaria) {
        this.uniDiaria = uniDiaria;
    }

    /**
     * Método de acesso ao gasto com telefonema
     * @return o gasto com telefonema
     */
    public double getTelefonemaCost() {
        return telefonemaCost;
    }

    /**
     * Método de modificação ao gasto com telefonemas
     * @param telefonemaCost gasto com telefonemas
     */
    public void setTelefonemaCost(float telefonemaCost) {
        this.telefonemaCost = telefonemaCost;
    }

    /**
     * Método de acesso ao desconto
     * @return o desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * Método de modificação do desconto
     * @param desconto desconto
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * Método que calcula o total a pagar
     * @return o total a pagar
     */
    private float calcularTotal(){
        double totalDiaria =  diariaCost * uniDiaria;

        double totalPagar = totalDiaria + gastosConsumo + telefonemaCost;

        if(desconto > 0){
            totalPagar -= desconto;
        }
        
        return Math.abs((float)totalPagar);
    }

    /**
    * Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    * @return String contendo os dados da saída do hospede como o número da acomodação utilizada, checkout do hospede, 
    *         número de diárias cobradas, valor de cada diária, valor gasto com telefonemas, desconto concedido, total a pagar
    */
    @Override
    public String toString() {
        float totalPagar = calcularTotal();

        return "Saida do hóspede: [Número da Acomodação=" + numAcomodacao + ", Data e Horário de Saida=" + DataHora.format(formatterDataHora) +
                ", Número de Diárias Cobradas=" + diariaCost + ", Valor de Cada Diária=" + uniDiaria + ", Valor Gasto com Telefonemas=" + 
                telefonemaCost + ", Desconto=" + desconto + "Total a pagar=" + totalPagar + "]";
    }


    

}
