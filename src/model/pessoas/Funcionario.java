package model.pessoas;

public class Funcionario extends Pessoa{
    private Funcionario(String nome, int telefone, String cidade, Estados estado, LocalDate dataNascimento) {
        super(nome, telefone, cidade, estado, dataNascimento, 002);
    }

    // Métodos de manipulacao de cadastro de hospede

    // Metodo public que sera consultado no main, verificando se há cadastro desse mesmo hospede, antes de iniciar um novo cadastro
    public boolean existeHospede(Hospede hospede){
        for (Hospede lista : hotel.getHospedes()) {
            if (lista.getIndentificacao().getNumDoc() == hospede.getIndentificacao().getNumDoc()) {
                return true;
            }
        }

        return false;
    }

    private boolean cadastrarHospede(Hospede hospede) {
        if (!existeHospede(hospede)) {
            hotel.getHospedes().add(hospede);
            return true;
        }

        return false;
    }

    private boolean removerHospede(Hospede hospede) {
        if (existeHospede(hospede)) {
            hotel.getHospedes().remove(hospede);
            return true;
        }
        
        return false;
    }

    // Metodo public que sera consultado no main, verificando se há reserva no nome do hospede, antes de iniciar um novo cadastro
    public boolean temReserva(String nomeHospede) {
        for (ReservaAbstract lista : hotel.getReservas()) {
            if (lista.getHospede().getNome() == nomeHospede) {
                return true;
            }
        }

        return false;
    }

    private boolean cadastrarReserva(ReservaAbstract reserva) {
        if (!temReserva(reserva.getHospede().getNome())) {
            hotel.getReservas().add(reserva);
            return true; 
        }

        return false;
    }

    private boolean removerReserva(ReservaAbstract reserva) {
        if (temReserva(reserva.getHospede().getNome())) {
            hotel.getReservas().remove(reserva);
            return true;
        }

        return false;
    }

    // Método que recupera reservas de hospedes com nome igual
    public boolean getReserva(String nomeHospede) {
        List <ReservaAbstract> reservasComNomeIgual = new ArrayList<>();

        for (ReservaAbstract lista : hotel.getReservas()) {
            if (lista.getHospede().getIndentificacao().getNumDoc() == hospede.getIndentificacao().getNumDoc()) {
                reservasComNomeIgual.add(lista);
            }
        }

        if(reservasComNomeIgual.size() > 0) {
            return reservasComNomeIgual;
        }

        return null;
    }

    private boolean acomodarHospede(String nomeHospede, Funcionario funcionarioResponsavel) {
        if (temReserva(nomeHospede) == false) {
            for (ReservaAbstract lista : hotel.getReservas()) {
                if (lista.getHospede().getNome() == nomeHospede) {
    
                    ReservaAbstract acomodar = new ReservaAbstract(lista.getCheckIn(), lista.getCheckOut(), lista.getHospede(), lista.getAcomodacao(), funcionarioResponsavel); 
    
                    hotel.getReservas().remove(lista);
                    hotel.getAcomodados().add(acomodar);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean acomodarHospede(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospede, Acomodacao acomodacao, Funcionario funcionarioResponsavel) {
        if(!temReserva(hospede.getNome())) {
            ReservaAbstract acomodar = new ReservaAbstract(checkIn, checkOut, hospede, acomodacao, funcionarioResponsavel);
            hotel.getAcomodados().add(acomodar);
            return true;
        }

        return false;
    }

    private boolean desacomodarHospede(Hospede hospede) {
        hotel.getAcomodacoes().remove(acomodacao);
    }

    // Manipulacao de cadastro de consumo
    
    private boolean cadastrarConsumoFrigobar(Consumo consumo, Hospede hospede) {
        hotel.getConsumosFrigobar().add(consumo);
    }

    private boolean removerConsumoFrigobar(Consumo consumo) {
        hotel.getConsumosFrigobar().remove(consumo);
    }

    private boolean cadastrarConsumoLavanderia(Consumo consumo, Hospede hospede) {
        hotel.getConsumosLavanderia().add(consumo);
    }

    private boolean removerConsumoLavanderia(Consumo consumo, Hospede hospede) {
        hotel.getConsumosLavanderia().remove(consumo);
    }

    private boolean cadastrarConsumoRestaurante(Consumo consumo, Hospede hospede) {
        hotel.getConsumosRestaurante().add(consumo);
    }

    private boolean removerConsumoRestaurante(Consumo consumo, Hospede hospede) {
        hotel.getConsumosRestaurante().remove(consumo);
    }
}
