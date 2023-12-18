package model;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Reserva;
import model.acomodacoes.Acomodado;
import model.pessoas.Hospede;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Saida {
    private int numAcomodacao; //Número da acomodação utilizada
    private LocalDateTime DataHora; //checkout do hospede
    private float diariaCost; //Número de diárias cobradas
    private float uniDiaria; //Valor de cada diária
    private float telefonemaCost; //Valor gasto com telefonemas
    private float desconto; //Desconto concedido

    public Saida(Acomodacao acomodacao, Reserva reserva, int numAcomodacao, LocalDateTime DataHora, float diariaCost, float uniDiaria, float telefonemaCost){
        this.numAcomodacao = acomodacao.getNumero();
        this.DataHora = reserva.getCheckOut();
        this.diariaCost = diariaCost;
        this.uniDiaria = uniDiaria;
        this.telefonemaCost = telefonemaCost;
    }

    public int getNumAcomodacao() {
        return numAcomodacao;
    }

    public void setNumAcomodacao(int numAcomodacao) {
        this.numAcomodacao = numAcomodacao;
    }

    
    public LocalDateTime getDataHora() {
        return DataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.DataHora = dataHora;
    }

    public float getDiariaCost() {
        return diariaCost;
    }

    public void setDiariaCost(float diariaCost) {
        this.diariaCost = diariaCost;
    }

    public float getUniDiaria() {
        return uniDiaria;
    }

    public void setUniDiaria(float uniDiaria) {
        this.uniDiaria = uniDiaria;
    }

    public float getTelefonemaCost() {
        return telefonemaCost;
    }

    public void setTelefonemaCost(float telefonemaCost) {
        this.telefonemaCost = telefonemaCost;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float calcularTotal(){
        float totalDiaria =  diariaCost * uniDiaria;

        float totalPagar = totalDiaria + /*totalConsumo*/ + telefonemaCost;

        if(desconto > 0){
            totalPagar -= desconto;
        }
        
        return Math.abs(totalPagar);
    }

    @Override
    public String toString() {
        float totalPagar = calcularTotal();

        return "Saida do hóspede: [Número da Acomodação=" + numAcomodacao + ", Data e Horário de Saida=" + DataHora + 
                ", Número de Diárias Cobradas=" + diariaCost + ", Valor de Cada Diária=" + uniDiaria + ", Valor Gasto com Telefonemas=" + 
                telefonemaCost + ", Desconto=" + desconto + "Total a pagar=" + totalPagar + "]";
    }


    

}
