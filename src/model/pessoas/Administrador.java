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


/**
 * Definição da classe Administrador que herda de Funcionario.
 */
public class Administrador extends Funcionario {

    /**
     * Construtor da classe Administrador que recebe parâmetros para inicializar
     * os atributos.
     * @param nome do administrador
     * @param telefone do administrador
     * @param cidade do administrador
     * @param estado do administrador
     * @param dataNascimento do administrador
     * @param senha do administrador
     */
    public Administrador(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int senha) {
        super(nome, telefone, cidade, estado, dataNascimento, senha);
    }

    // Manipulação de funcionário


    /**
     * Método para verificar se um funcionário já existe na lista de funcionários.
     * @param funcionario especifiico que será verificado
     * @param funcionarios de funcionarios
     * @return true se o funcionario existe na lista, false caso contrario.
     */
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


    /**
     * Método para cadastrar um novo funcionário
     *
     * @param nome do funcionario
     * @param telefone do funcionario
     * @param cidade do funcionario
     * @param estado do funcionario
     * @param dataNascimento do funcionario
     * @param funcionarios é uma lista de funcionarios do hotel
     */
    public void cadastrarFuncionario(String nome, long telefone, String cidade, Estados estado,
                                     LocalDate dataNascimento, int senha, List<Funcionario> funcionarios) {
        Funcionario new_funcionario = new Funcionario(nome, telefone, cidade, estado, dataNascimento, senha);

        if (!existeFuncionario(new_funcionario, funcionarios)) {
            funcionarios.add(new_funcionario);
        }
    }

    /**
     * Método para remover um funcionário
     * @param funcionario especifico que será removido
     * @param funcionarios é uma lista de funcionarios do hotel
     * @return true se o funcionario foi removido com sucesso, false caso contrario.
     */
    public boolean removerFuncionario(Funcionario funcionario, List<Funcionario> funcionarios) {
        if (existeFuncionario(funcionario, funcionarios)) {
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }

    /**
     * Método para editar as informações de um funcionário
     * @param funcionario especifico que será editado
     * @param newFuncionario novo funcionario com as informações atualizadas
     * @param funcionarios é uma lista de funcionarios do hotel
     * @return true se o funcionario foi editado com sucesso, false caso contrario.
     */
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


    /**
     * Método para cadastrar uma acomodação na lista de acomodações.
     * @param acomodacoesDisponiveis no hotel
     * @param acomodacoes ocupadas no hotel
     * @param acomodacao especifica que será cadastrada
     * @return true se a acomodacao foi cadastrada com sucesso, false caso contrario.
     */
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

    /**
     * Método para editar as informações de uma acomodação
     * @param acomodacoes disponiveis no hotel
     * @param newAcomodacao nova acomodacao com as informações atualizadas
     * @param numeroAcomodacao especifica que será editada
     * @return true se a acomodacao foi editada com sucesso, false caso contrario.
     */
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

    /**
     * Método para remover uma acomodação
     * @param acomodacao especifica que será removida
     * @param acomodacoes disponiveis no hotel
     * @return true se a acomodacao foi removida com sucesso, false caso contrario.
     */
    public boolean removerAcomodacao(Acomodacao acomodacao, List<Acomodacao> acomodacoes) {
        return acomodacoes.remove(acomodacao);
    }

    /**
     * Metodo para cadastrar um tipo de acomodacao nos tipos disponiveis do hotel.
     * @param tipoAcomodacao especifico que será cadastrado
     * @param tiposAcomodacao disponiveis no hotel
     * @return true se o tipo de acomodacao foi cadastrado com sucesso, false caso contrario.
     */
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

    /**
     * Método para remover um tipo de acomodação do hotel.
     * @param tipoAcomodacao de acomodacao especifico que será removido
     * @param tiposAcomodacao disponiveis no hotel
     * @return true se o tipo de acomodacao foi editado com sucesso, false caso contrario.
     */
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

    /**
     * Método para cadastrar um item de consumo.
     * @param itemConsumo especifico que será cadastrado
     * @param itensConsumo disponiveis no hotel
     * @return true se o item de consumo foi cadastrado com sucesso, false caso contrario.
     */
    public boolean cadastrarItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                return false;
            }
        }
        itensConsumo.add(itemConsumo);
        return true;
    }

    /**
     * Método para remover um item de consumo
     * @param itemConsumo de consumo especifico que será removido
     * @param itensConsumo de consumo disponiveis no hotel
     * @return true se o item de consumo foi editado com sucesso, false caso contrario.
     */
    public boolean removerItemConsumo(ItensConsumo itemConsumo, List<ItensConsumo> itensConsumo) {
        for (ItensConsumo lista : itensConsumo) {
            if (lista.getCodigo() == itemConsumo.getCodigo()) {
                itensConsumo.remove(lista);
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo que verifica se a senha do administrador esta correta.
     * @param key senha do administrador
     * @return true se a senha estiver correta, false caso contrario.
     */
    @Override
    protected boolean password(int key) {
        return key == this.getKey();
    }

    /**
     * Método que retorna uma descricao do administrador.
     * @return String contendo o nome, telefone, cidade, estado e data de nascimento.
     */
    @Override
    public String toString() {
        return "Administrador: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
                + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento().format(formatterData);
    }
}
