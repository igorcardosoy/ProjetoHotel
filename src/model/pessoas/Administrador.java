package model.pessoas;

public class Administrador extends Funcionario{
    public Administrador(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento) {
        super(nome, telefone, cidade, estado, dataNascimento, 001);
    }   

    // Manipulacao de funcionario


    // Metodo que verifica se há um cadastro do funcionario, antes de iniciar um novo cadastro
    public boolean existeFuncionario(Funcionario funcionario) {
        for (Funcionario lista : hotel.getFuncionarios()) {
            if (lista.getNome() == funcionario.getNome() && lista.getdataNascimento() == funcionario.getdataNascimento() && lista.getTelefone() == funcionario.getTelefone()) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        if (!existeFuncionario(funcionario)) {
            hotel.getFuncionarios().add(funcionario);
            return true;
        }
        
        return false;
    }

    public boolean removerFuncionario(Funcionario funcionario) {
        if (existeFuncionario(funcionario)) {
            hotel.getFuncionarios().remove(funcionario);
            return true;
        }

        return false;
    }

    public boolean editarFuncionario(Funcionario funcionario, Funcionario newFuncionario) {
        if (existeFuncionario(funcionario)) {
            hotel.getFuncionarios().remove(funcionario);
            hotel.getFuncionarios().add(newFuncionario);
            return true;
        }
        
        return false;
    }

    // Manipulacao de cadastros de acomodacao
    public boolean cadastrarAcomodacao(List<Acomodacao> acomodacoes, Acomodacao acomodacao) {
        for (Acomodacao lista : acomodacoes) {
            if (lista.getNumero() == acomodacao.getNumero()) {
                return false;
            }
        }

        hotel.getAcomodacoes().add(acomodacao);
        return true;
    }

    public boolean editarAcomodacao(List<Acomodacao> acomodacoes, Acomodacao newAcomodacao, int numeroAcomodacao) {
        for (Acomodacao lista : acomodacoes) {
            if (lista.getNumero() == numeroAcomodacao) {
                hotel.getAcomodacoes().remove(lista);
                hotel.getAcomodacoes().add(acomodacao);
                return true;
            }
        }

        return false;
    }

    public boolean removerAcomodacao(Acomodacao acomodacao) {
        hotel.getAcomodacoes().remove(acomodacao);
    }

    public boolean cadastrarTipoAcomodacao(TipoAcomodacao tipoAcomodacao) {
        for (TipoAcomodacao lista : hotel.getTiposAcomodacao()) {
            if (lista.getNome().equals(tipoAcomodacao.getNome())) {
                return false;
            }
        }

        hotel.getTiposAcomodacao().add(tipoAcomodacao);
        return true;
    }

    public boolean removerTipoAcomodacao(TipoAcomodacao tipoAcomodacao) {

        for (Acomodacao lista : hotel.getAcomodacoes()) {
            if (lista.getTipo().equals(tipoAcomodacao.geTipo())) {
                hotel.getAcomodacoes().remove(lista);
                return true;
            }
        }
        
        return false;
    }

    // Manipulacao de cadastros de consumo
    public boolean cadastrarItemConsumo(ItensConsumo itemConsumo) {
        for (ItensConsumo lista : hotel.getItensConsumoDisponiveis()) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                return false;
            }
        }

        hotel.getItensConsumoDisponiveis().add(itemConsumo);
        return true;
    }

    public boolean removerItemConsumo(ItensConsumo itemConsumo) {
        for (ItensConsumo lista : hotel.getItensConsumoDisponiveis()) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                hotel.getItensConsumoDisponiveis().remove(lista);
                return true;
            }
        }

        return false;
    }
}
