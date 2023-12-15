package model.pessoas;

import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.acomodacoes.ReservaAbstract;
import model.enums.Estados;
import model.itensCosumo.Consumo;
import view.Hotel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa{

    protected Funcionario(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento, int key) {
            super(nome, telefone, cidade, estado, dataNascimento, key);
    }

    // Métodos de manipulacao de cadastro de hospede

    private boolean existeHospede(Hospede hospede, List<Hospede> hospedes){
        for (Hospede lista : hospedes){
            if (lista.getIndentificacao().getNumero() == hospede.getIndentificacao().getNumero()) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarHospede(Hospede hospede, List<Hospede> hospedes) {
        if (!existeHospede(hospede, hospedes)) {
            hospedes.add(hospede);
            return true;
        }

        return false;
    }

    public boolean removerHospede(Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospedes.remove(hospede);
            return true;
        }
        
        return false;
    }

    // Metodo public que sera consultado no main, verificando se há reserva no nome do hospede, antes de iniciar um novo cadastro
    public boolean temReserva(String nomeHospede, List<Reserva> reservas) {
        for (Reserva lista : reservas) {
            if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastrarReserva(Reserva reserva, List<Reserva> reservas) {
        if (!temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.add(reserva);
            return true; 
        }

        return false;
    }

    public boolean removerReserva(Reserva reserva, List<Reserva> reservas) {
        if (temReserva(reserva.getHospedePrincipal().getNome(), reservas)) {
            reservas.remove(reserva);
            return true;
        }

        return false;
    }

    // Método que recupera reservas de hospedes com nome igual
    public List<Reserva> getReserva(String nomeHospede, List<Reserva> reservas) {
        List <Reserva> reservasComNomeIgual = new ArrayList<>();

        for (Reserva lista : reservas) {
            if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
                reservasComNomeIgual.add(lista);
            }
        }

        if(!reservasComNomeIgual.isEmpty()) {
            return reservasComNomeIgual;
        }

        return null;
    }

    public boolean acomodarHospede(String nomeHospede, Funcionario funcionarioResponsavel, List<Reserva> reservas, List<Acomodado> acomodados) {
        if (temReserva(nomeHospede, reservas)) {
            for (Reserva lista : reservas) {
                if (lista.getHospedePrincipal().getNome().equals(nomeHospede)) {
    
                    Acomodado acomodar = new Acomodado(lista.getCheckIn(), lista.getCheckOut(), lista.getHospedePrincipal(), lista.getAcomodacao(), funcionarioResponsavel);

                    reservas.remove(lista);
                    acomodados.add(acomodar);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean acomodarHospede(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospede, Acomodacao acomodacao, Funcionario funcionarioResponsavel, List<Acomodado> acomodados, List<Reserva> reservas) {
        if(!temReserva(hospede.getNome(), reservas)) {
            Acomodado acomodar = new Acomodado(checkIn, checkOut, hospede, acomodacao, funcionarioResponsavel);
            acomodados.add(acomodar);
            return true;
        }

        return false;
    }

    public boolean desacomodarHospede(Hospede hospede, Acomodado acomodado, List<Acomodado> acomodados) {
       return acomodados.remove(acomodado);
    }

    // Manipulacao de cadastro de consumo
    public boolean cadastrarConsumo(Consumo consumo, Hospede hospede, List<Hospede> hospedes) {
        if (existeHospede(hospede, hospedes)) {
            hospede.getConsumo().add(consumo);
            return true;
        }

        return false;

    }

    protected LocalDate getdataNascimento() {
        return super.getDataNascimento();
    }
}
