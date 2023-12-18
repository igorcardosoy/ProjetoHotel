package model;

public class CartaoCredito {
    private long numero;
    private int cvv;
    private String nome;
    private String dataValidade;

    public CartaoCredito(long numero, int cvv, String nome, String dataValidade) {
        this.numero = numero;
        this.cvv = cvv;
        this.nome = nome;
        this.dataValidade = dataValidade;
    }

    public long getNumero() {
        return numero;
    }

    public long getNumerosFinais() {
        for (int i = 0; i < 3; i++){
            numero = numero % 10000;
        }
        return numero;
    }

    public int getCvv() {
        return cvv;
    }

    public String getNome() {
        return nome;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String toString() {
        return "Numero: " + numero + " CVV: " + cvv + " Nome: " + nome + " Data de Validade: " + dataValidade;
    }
}
