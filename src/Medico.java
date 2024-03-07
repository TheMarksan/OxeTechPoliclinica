public class Medico {
    private String nome;
    private String cpf;
    private String crm;

    private double salario;

    private Especialidade especialidade;

    public Medico(String nome, String cpf, String crm, double salario, Especialidade especialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.salario = salario;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
