package view;

import model.acomodacoes.Acomodacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Definição da classe Designador
 */
public class Designador {
    /**
     * Método estatico que acessa as acomodações disponíveis
     * @param descricao descricao
     * @param acomodacoes acomodacoes
     * @return as acomodações disponíveis
     */
    public static List<Acomodacao> getAcomodacoesDisponiveis(String descricao,
                                                             List<Acomodacao> acomodacoes){
        List<Acomodacao> acomodacoesDisponiveis = new ArrayList<>();

        for (Acomodacao acomodacao : acomodacoes) {
            System.out.println(acomodacao.getTipo().getDescricao());
            if (acomodacao.getTipo().getDescricao().equalsIgnoreCase(descricao)) {
                acomodacoesDisponiveis.add(acomodacao);
            }
        }

        return acomodacoesDisponiveis.isEmpty() ? null :
                acomodacoesDisponiveis;
    }
}


