public class Consultas {
    private Medico medico;
    private Paciente paciente;

    private String especialidade;

    public Consultas(Medico medico, Paciente paciente, String especialidade) {
        this.medico = medico;
        this.paciente = paciente;
        this.especialidade = especialidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
