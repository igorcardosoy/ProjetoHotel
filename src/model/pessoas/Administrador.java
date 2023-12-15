package model.pessoas;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.TipoAcomodacao;
import model.enums.Estados;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Administrador extends Funcionario{
    public Administrador(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento) {
        super(nome, telefone, cidade, estado, dataNascimento, 3);
    }   

    // Manipulacao de funcionario


    // Metodo que verifica se há um cadastro do funcionario, antes de iniciar um novo cadastro
    public boolean existeFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        for (Funcionario lista : funcionarios) {
            if (lista.getNome().equals(funcionario.getNome()) && lista.getdataNascimento().equals(funcionario.getdataNascimento()) && lista.getTelefone() == funcionario.getTelefone()) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        if (!existeFuncionario(funcionario, funcionarios)) {
            funcionarios.add(funcionario);
            return true;
        }
        
        return false;
    }

    public boolean removerFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        if (existeFuncionario(funcionario, funcionarios)) {
            funcionarios.remove(funcionario);
            return true;
        }

        return false;
    }

    public boolean editarFuncionario(Funcionario funcionario, Funcionario newFuncionario, List<Funcionario> funcionarios) {
        if (existeFuncionario(funcionario, funcionarios)) {
            funcionarios.remove(funcionario);
            funcionarios.add(newFuncionario);
            return true;
        }
        
        return false;
    }

    // Manipulacao de cadastros de acomodacao
    public boolean cadastrarAcomodacao(List<Acomodacao> acomodacoes, Acomodacao acomodacao, List<Acomodacao> acomodacoesDisponiveis) {
        for (Acomodacao lista : acomodacoes) {
            if (lista.getNumero() == acomodacao.getNumero()) {
                return false;
            }
        }

        acomodacoesDisponiveis.add(acomodacao);
        return true;
    }

    public boolean editarAcomodacao(List<Acomodacao> acomodacoes, Acomodacao newAcomodacao, int numeroAcomodacao) {
        for (Acomodacao lista : acomodacoes) {
            if (lista.getNumero() == numeroAcomodacao) {
                acomodacoes.remove(lista);
                acomodacoes.add(newAcomodacao);
                return true;
            }
        }

        return false;
    }

    public boolean removerAcomodacao(Acomodacao acomodacao, List<Acomodacao> acomodacoes) {
        return acomodacoes.remove(acomodacao);
    }

    public boolean cadastrarTipoAcomodacao(TipoAcomodacao tipoAcomodacao, List<TipoAcomodacao> tiposAcomodacao) {
        for (TipoAcomodacao lista : tiposAcomodacao) {
            if (lista.getNome().equals(tipoAcomodacao.getNome())) {
                return false;
            }
        }

        tiposAcomodacao.add(tipoAcomodacao);
        return true;
    }

    public boolean removerTipoAcomodacao(TipoAcomodacao tipoAcomodacao, List<TipoAcomodacao> tiposAcomodacao) {

        for (TipoAcomodacao lista : tiposAcomodacao) {
            if (lista.equals(tipoAcomodacao)) {
                tiposAcomodacao.remove(lista);
                return true;
            }
        }
        
        return false;
    }

    // Manipulacao de cadastros de consumo
    public boolean cadastrarItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                return false;
            }
        }

        itensConsumo.add(itemConsumo);
        return true;
    }

    public boolean removerItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                itensConsumo.remove(lista);
                return true;
            }
        }

        return false;
    }
}
