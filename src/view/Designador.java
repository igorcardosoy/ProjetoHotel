package view;

import model.acomodacoes.Acomodacao;

import java.util.ArrayList;
import java.util.List;

public class Designador {
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


