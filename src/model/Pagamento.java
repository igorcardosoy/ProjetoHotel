package model;

import model.enums.FormasPagamento;

/**
 * Definição da classe Pagamento dependendo do que o hóspede deseje
 * @atributos formas de pagamento 
 */
public class Pagamento {

    private FormasPagamento formaPagamento;

    /**
     * Construtor da classe Pagamento
     * @param formasPagamento formas de pagamento
     */
    public Pagamento(FormasPagamento formasPagamento){
        this.formaPagamento = formaPagamento;
    }

    /**
     * Método de interação de acordo com a escolha do hóspede
     */
    public void realizarPagamento(){
        switch(formaPagamento){
            case AVISTA_DINHEIRO:
                System.out.println("Pagamento à vista em dinheiro realizado.");
                break;
            case AVISTA_CHEQUE:
                System.out.println("Pagamento à vista em cheque realizado.");
                break;
            case AVISTA_CARTAO_CREDITO:
                System.out.println("Pagamento à vista com cartão de crédito realizado.");
                break;
            case FATURADO_30DIAS:
                System.out.println("Pagamento faturado em 30 dias realizado.");
                break;
            default:
                System.out.println("Forma de pagamento não reconhecida.");
                break;
        }
    }
}
