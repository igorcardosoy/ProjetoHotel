package model;

/**
 * Definição da classe CartaoCredito, em que sera armazenará os dados
 * do cartão de crédito do hospede
 */
public class CartaoCredito {
    private long numero;
    private int cvv;
    private String nome;
    private String dataValidade;

    /**
     * Construtor da classe CartaoCredito
     * @param numero numero do cartão de crédito
     * @param cvv cvv do cartão de crédito
     * @param nome nome do responsável do cartão de crédito
     * @param dataValidade data de validade do cartão de crédito
     */
    public CartaoCredito(long numero, int cvv, String nome, String dataValidade) {
        this.numero = numero;
        this.cvv = cvv;
        this.nome = nome;
        this.dataValidade = dataValidade;
    }

    /**
     * Método de acesso ao número do cartão de crédito
     * @return o número do cartão
     */
    public long getNumero() {
        return numero;
    }

    /**
     * Método de acesso aos números finais do cartão de crédito
     * @return os números finais do cartão de crédito
     */
    public long getNumerosFinais() {
        for (int i = 0; i < 3; i++){
            numero = numero % 10000;
        }
        return numero;
    }

    /**
     * Método de acesso ao cvv do cartão de crédito
     * @return o cvv do cartão de crédito
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Método de acesso ao nome do responsável do cartão de crédito
     * @return o nome do do dono do cartão de crédito
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método de acesso à data de validade do cartão de crédito
     * @return à data de validade
     */
    public String getDataValidade() {
        return dataValidade;
    }

    /**
     * Método de modificação do número do cartão de crédito
     * @param numero numero do cartão de crédito que sera setado
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método de modificação do cvv do cartão de crédito
     * @param cvv cvv do cartão de crédito que sera setado
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Método de modificação do nome do responsável do cartão de crédito
     * @param nome nome do responsável do cartão de crédito que sera setado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método de modificação à data de validade do cartão de crédito
     * @param dataValidade data de validade do cartão de crédito que sera setado
     */
    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
    * Sobrescrevendo o método toString() para fornecer uma representação textual do objeto
    * @return String contendo os dados do cartão de crédito como número, cvv, nome, data de validade
    */
    public String toString() {
        return "Numero: " + numero + " CVV: " + cvv + " Nome: " + nome + " Data de Validade: " + dataValidade;
    }
}
