package model;

import model.enums.FormasPagamento;

public class Pagamento {

    private FormasPagamento formaPagamento;

    public Pagamento(FormasPagamento formasPagamento){
        this.formaPagamento = formaPagamento;
    }

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
