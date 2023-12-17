package model.enums;


public enum Keys {
    ADMINISTRADOR(1),
    FUNCIONARIO(2),
    HOSPEDE(3);

    private int tipo;
    Keys(int tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        if(tipo == 1) {
            return "HOSPEDE";
        } else if (tipo == 2) {
            return "FUNCIONARIO";
        } else {
            return "ADMINISTRADOR";
        }
    }

    public int getkey() {
        return tipo;
    }
}