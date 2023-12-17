package model.pessoas;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.enums.Estados;
import model.itensCosumo.Consumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Definição da classe Funcionario que herda de Pessoa
public class Funcionario extends Pessoa {

    // Construtor protegido(protected) da classe Funcionario que chama o construtor da classe pai (Pessoa)
    protected Funcionario(String nome, long telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
        super(nome, telefone, cidade, estado, dataNascimento, key);
    }

    // Métodos de manipulação de cadastro de hóspede

    // Método privado que verifica se um hóspede já existe na lista
    private boolean existeHospede(Hospede hospede, List<Hospede> hospedes) {
        for (Hospede lista : hospedes) {
            if (lista.getIdentificacaoNumero() == hospede.getIdentificacaoNumero()) {
                return true;
            }
        }
        return false;
    }

    // Método para cadastrar um novo hóspede
    public boolean cadastrarHospede(Hospede hospede, List<Hospede> hospedes) {
        if (!existeHospede(hospede, hospedes)) {
            hospedes.add(hospede);
            return true;
        }
        return false;
    }

    // Método para remover um hóspede
    public boolean removerHospede(Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospedes.remove(hospede);
            return true;
        }
        return false;
    }

    // Método público que verifica se há reserva no nome do hóspede, antes de iniciar um novo cadastro
    public boolean temReserva(String nomeHospede, List<Reserva> reservas) {
        for (Reserva lista : reservas) {
            if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                return true;
            }
        }
        return false;
    }

    // Método para cadastrar uma nova reserva
    public boolean cadastrarReserva(Reserva reserva, List<Reserva> reservas) {
        if (!temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.add(reserva);
            return true;
        }
        return false;
    }

    // Método para remover uma reserva
    public boolean removerReserva(Reserva reserva, List<Reserva> reservas) {
        if (temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.remove(reserva);
            return true;
        }
        return false;
    }

    // Método que recupera reservas de hóspedes com nome igual
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

    // Método para acomodar um hóspede a partir de uma reserva
    public boolean acomodarHospede(String nomeHospede, Funcionario funcionarioResponsavel, List<Reserva> reservas,
                                   List<Acomodado> acomodados) {
        if (temReserva(nomeHospede, reservas)) {
            for (Reserva lista : reservas) {
                if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                    Acomodado acomodar = new Acomodado(lista);
                    reservas.remove(lista);
                    acomodados.add(acomodar);
                    return true;
                }
            }
        }
        return false;
    }

    // Método para acomodar um hóspede sem necessidade de reserva
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

    // Método para desacomodar um hóspede
    public boolean desacomodarHospede(Hospede hospede, Acomodado acomodado, List<Acomodado> acomodados) {
        return acomodados.remove(acomodado);
    }

    // Manipulação de cadastro de consumo
    public boolean cadastrarConsumo(Consumo consumo, Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospede.getConsumo().add(consumo);
            return true;
        }
        return false;
    }

    // Método que verifica se o funcionário tem acesso com a senha fornecida
    public boolean allowAccess(int nivelAcesso) {
        return password(nivelAcesso);
    }

    // Método privado para verificar a senha do funcionário
    private boolean password(int key) {
        return key == 4321;
    }

    // Método protegido para obter a data de nascimento do funcionário
    protected LocalDate getdataNascimento() {
        return super.getDataNascimento();
    }

    // Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    @Override
    public String toString() {
        return "Funcionario: " + super.getNome() + "\nTelefone: " + super.getTelefone() + "\nCidade: " + super.getCidade()
                + "\nEstado: " + super.getEstado() + "\nData de Nascimento: " + super.getDataNascimento();
    }
}
