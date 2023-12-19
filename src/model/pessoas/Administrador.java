package model.pessoas;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.TipoAcomodacao;
import model.enums.Estados;
import model.itensCosumo.ItensConsumo;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static view.Hotel.formatterData;

// Definição da classe Administrador que herda de Funcionario
public class Administrador extends Funcionario {

    // Construtor da classe Administrador que chama o construtor da classe pai (Funcionario)
    public Administrador(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
        super(nome, telefone, cidade, estado, dataNascimento, key);
    }

    // Manipulação de funcionário

    // Método que verifica se há um cadastro do funcionário antes de iniciar um novo cadastro
    public boolean existeFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        for (Funcionario lista : funcionarios) {
            if (lista.getNome().equals(funcionario.getNome())
                    && lista.getdataNascimento().equals(funcionario.getdataNascimento())
                    && lista.getTelefone() == funcionario.getTelefone()) {
                return true;
            }
        }
        return false;
    }

    // Método para cadastrar um novo funcionário
    public boolean cadastrarFuncionario(String nome, long telefone, String cidade, Estados estado,
                                        LocalDate dataNascimento, List<Funcionario> funcionarios) {
        Funcionario new_funcionario = new Funcionario(nome, telefone, cidade, estado, dataNascimento, 2);

        if (!existeFuncionario(new_funcionario, funcionarios)) {
            funcionarios.add(new_funcionario);
            return true;
        }
        return false;
    }

    // Método para remover um funcionário
    public boolean removerFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        if (existeFuncionario(funcionario, funcionarios)) {
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }

    // Método para editar as informações de um funcionário
    public boolean editarFuncionario(Funcionario funcionario, Funcionario newFuncionario,
                                     List<Funcionario> funcionarios) {
        if (existeFuncionario(funcionario, funcionarios)) {
            funcionarios.remove(funcionario);
            funcionarios.add(newFuncionario);
            return true;
        }
        return false;
    }

    // Manipulação de cadastros de acomodação

    // Método para cadastrar uma nova acomodação
    public boolean cadastrarAcomodacao(List<Acomodacao> acomodacoesDisponiveis,
                                       List<Acomodado> acomodacoes, Acomodacao acomodacao) {
        for (Acomodado lista : acomodacoes) {
            if (Objects.equals(lista.getAcomodacao().getNumero(), acomodacao.getNumero())) {
                return false;
            }
        }
        acomodacoesDisponiveis.add(acomodacao);
        return true;
    }

    // Método para editar as informações de uma acomodação
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

    // Método para remover uma acomodação
    public boolean removerAcomodacao(Acomodacao acomodacao, List<Acomodacao> acomodacoes) {
        return acomodacoes.remove(acomodacao);
    }

    // Método para cadastrar um novo tipo de acomodação
    public boolean cadastrarTipoAcomodacao(TipoAcomodacao tipoAcomodacao, List<TipoAcomodacao> tiposAcomodacao) {
        for (TipoAcomodacao lista : tiposAcomodacao) {
            if (lista.getNome().equals(tipoAcomodacao.getNome())) {
                return false;
            }
        }
        tiposAcomodacao.add(tipoAcomodacao);
        return true;
    }

    // Método para remover um tipo de acomodação
    public boolean removerTipoAcomodacao(TipoAcomodacao tipoAcomodacao, List<TipoAcomodacao> tiposAcomodacao) {
        for (TipoAcomodacao lista : tiposAcomodacao) {
            if (lista.equals(tipoAcomodacao)) {
                tiposAcomodacao.remove(lista);
                return true;
            }
        }
        return false;
    }

    // Manipulação de cadastros de consumo

    // Método para cadastrar um novo item de consumo
    public boolean cadastrarItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                return false;
            }
        }
        itensConsumo.add(itemConsumo);
        return true;
    }

    // Método para remover um item de consumo
    public boolean removerItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                itensConsumo.remove(lista);
                return true;
            }
        }
        return false;
    }


    // Método privado para verificar a senha do administrador
    @Override
    protected boolean password(int key) {
        return key == this.getKey();
    }

    // Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    @Override
    public String toString() {
        return "Administrador: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
                + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento().format(formatterData);
    }
}
