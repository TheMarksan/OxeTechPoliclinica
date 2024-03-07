public class Paciente {
    private String nome;
    private String cpf;
    private String cartaoSus;
    public Especialidade especialidade;


    public Paciente(String nome, String cpf, String cartaoSus, Especialidade especialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoSus = cartaoSus;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cartaoSus='" + cartaoSus + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
