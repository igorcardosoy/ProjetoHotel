package model.pessoas;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.acomodacoes.TipoAcomodacao;
import model.enums.Estados;
import model.itensCosumo.Consumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static view.Hotel.formatterData;
/**
 * Definição da classe Funcionario que que herda de Pessoa
 */
public class Funcionario extends Pessoa {
    /**
     * Construtor da classe funcionario que recebe parâmetros para inicializar
     * um funcinário
     * @param nome
     * @param telefone
     * @param cidade
     * @param estado
     * @param dataNascimento
     * @param key
     */
    // Construtor protegido(protected) da classe Funcionario que chama o construtor da classe pai (Pessoa)
    protected Funcionario(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
        super(nome, telefone, cidade, estado, dataNascimento, key);
    }

    // Métodos de manipulação de cadastro de hóspede

    /**
     * Método privado que verifica se um hóspede já existe na lista
     * @param hospede
     * @param hospedes
     * @return true para caso o hópede existe na lista ou false caso contrário
     */
    private boolean existeHospede(Hospede hospede, List<Hospede> hospedes) {
        for (Hospede lista : hospedes) {
            if (lista.getIdentificacaoNumero() == hospede.getIdentificacaoNumero() && lista.getIdentificacaoTipo().equals(hospede.getIdentificacaoTipo())){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para cadastrar um novo hóspede
     * @param hospede
     * @param hospedes
     * @return true se deu certo cadastrar ou false caso não foi possível realizar o cadastro
     */
    public boolean cadastrarHospede(Hospede hospede, List<Hospede> hospedes) {
        if (!existeHospede(hospede, hospedes)) {
            hospedes.add(hospede);
            return true;
        }
        return false;
    }

    /**
     * Método para remover um hóspede
     * @param hospede
     * @param hospedes
     * @return true caso a remoção do hospede ocorrer com sucesso ou false caso não ocorrer a remoção
     */
    public boolean removerHospede(Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospedes.remove(hospede);
            return true;
        }
        return false;
    }

    /**
     * Método público que verifica se há reserva no nome do hóspede, antes de iniciar um novo cadastro
     * @param nomeHospede
     * @param reservas
     * @return true se tem a reserva do hóspede ou false caso não tenha a reserva
     */
    public boolean temReserva(String nomeHospede, List<Reserva> reservas) {
        for (Reserva lista : reservas) {
            if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para cadastrar uma nova reserva
     * @param reserva
     * @param reservas
     * @return true se o cadastro da reserva for efetuada com sucesso ou false caso a reserva não tenha sido feita
     */
    public boolean cadastrarReserva(Reserva reserva, List<Reserva> reservas) {
        if (!temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.add(reserva);
            return true;
        }
        return false;
    }

    /**
     * Método para remover uma reserva
     * @param reserva
     * @param reservas
     * @return true caso a remoção da reserva der certo ou false caso a remoção não tenha ocorrido
     */
    public boolean removerReserva(Reserva reserva, List<Reserva> reservas) {
        if (temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.remove(reserva);
            return true;
        }
        return false;
    }

    /**
     * Método que recupera reservas de hóspedes com nome igual
     * @param nomeHospede
     * @param reservas
     * @return reservasComNomeIgual caso há reservas de hóspedes com nome igual ou null caso contrário
     */
    public List<Reserva> getReserva(String nomeHospede, List<Reserva> reservas) {
        List<Reserva> reservasComNomeIgual = new ArrayList<>();
        for (Reserva lista : reservas) {
            if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                reservasComNomeIgual.add(lista);
            }
        }
        if (!reservasComNomeIgual.isEmpty()) {
            return reservasComNomeIgual;
        }
        return null;
    }

    /**
     * Método para acomodar um hóspede a partir de uma reserva
     * @param nomeHospede
     * @param funcionarioResponsavel
     * @param reservas
     * @param acomodados
     * @return true se a acomodação do hospede ocorrer conforme a reserva ou false caso contrário
     */
    public boolean acomodarHospede(String nomeHospede, Funcionario funcionarioResponsavel, List<Reserva> reservas,
                                   List<Acomodado> acomodados) {
        if (temReserva(nomeHospede, reservas)) {
            for (Reserva lista : reservas) {
                if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                    Acomodado acomodar = new Acomodado(lista, this);
                    reservas.remove(lista);
                    acomodados.add(acomodar);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para acomodar um hóspede sem necessidade de reserva
     * @param checkIn
     * @param checkOut
     * @param hospede
     * @param acomodacao
     * @param funcionarioResponsavel
     * @param acomodados
     * @param reservas
     * @return true se acomodação do hopede ocorrer com sucesso ou false caso contrário
     */
    public boolean acomodarHospede(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospede,
                                   Acomodacao acomodacao, Funcionario funcionarioResponsavel, List<Acomodado> acomodados,
                                   List<Reserva> reservas) {
        if (!temReserva(hospede.getNome(), reservas)) {
            Acomodado acomodar = new Acomodado(checkIn, checkOut, hospede, acomodacao, funcionarioResponsavel, null);
            acomodados.add(acomodar);
            return true;
        }
        return false;
    }

    /**
     * Método para desacomodar um hóspede
     * @param hospede
     * @param acomodado
     * @param acomodados
     * @return true se a desacomodação ocorrer com sucesso ou false caso contrário
     */
    public boolean desacomodarHospede(Hospede hospede, Acomodado acomodado, List<Acomodado> acomodados) {
        return acomodados.remove(acomodado);
    }

    /**
     * Manipulação de cadastro de consumo
     * @param consumo
     * @param hospede
     * @param hospedes
     * @return true caso o cadastro do consumo ocorrer com sucesso ou false caso contrário
     */
    public boolean cadastrarConsumo(Consumo consumo, Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospede.getConsumo().add(consumo);
            return true;
        }
        return false;
    }

    /**
     * Método protegido para verificar a senha do funcionário
     * @param key
     * @return true se a senha estiver correta, false caso contrario.
     */
    @Override
    protected boolean password(int key) {
        return key == this.getKey();
    }

    /**
     * Método protegido para obter a data de nascimento do funcionário
     * @return true caso obtenha a data de nascimento do funcionário
     */
    protected LocalDate getdataNascimento() {
        return super.getDataNascimento();
    }

    /**
     * Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
     * @return String contendo os dados do funcionário como nome, telefone, cidade, estado, data de nascimento
     */
    @Override
    public String toString() {
        return "Funcionario: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
                + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento().format(formatterData);


    }

    /**
     * Método que cadastra o hóspede no sistema
     * @param acomodados
     * @param acomodacoesDisponiveis
     * @param tiposAcomodacao
     * @param checkIn
     * @param checkOut
     * @param hospedePrincipal
     * @param acomodacao
     */
    public void cadastrarAcomodado(List<Acomodado> acomodados, List<Acomodacao> acomodacoesDisponiveis, List<TipoAcomodacao> tiposAcomodacao, LocalDateTime checkIn, 
                                    LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao){

        Acomodado acomodado = new Acomodado(checkIn, checkOut, hospedePrincipal, acomodacao, this, null);

        acomodados.add(acomodado);
        acomodacoesDisponiveis.remove(acomodacao);

        for (TipoAcomodacao tipoAcomodacao : tiposAcomodacao) {
            if (tipoAcomodacao.getCodigo() == acomodacao.getTipo().getCodigo()) {
                tipoAcomodacao.addQuantidadeDisponivel();
            }
        }
    }

    /**
     * Método que recupera os dados de uma reserva feita pelo hospede
     * @param reserva
     * @param acomodados
     * @param acomodacoesDisponiveis
     * @param tiposAcomodacao
     */
    public void cadastrarAcomodado(Reserva reserva, List<Acomodado> acomodados, List<Acomodacao> acomodacoesDisponiveis, List<TipoAcomodacao> tiposAcomodacao) {
        Acomodado acomodado = new Acomodado(reserva, this);
        acomodados.add(acomodado);
        acomodacoesDisponiveis.remove(reserva.getAcomodacao());
        //Encontrar o tipo de acomodação e adicionar a quantidade disponível
        for (TipoAcomodacao tipoAcomodacao : tiposAcomodacao) {
            if (tipoAcomodacao.getCodigo() == reserva.getAcomodacao().getTipo().getCodigo()) {
                tipoAcomodacao.addQuantidadeDisponivel();
            }
        }
    }
}
