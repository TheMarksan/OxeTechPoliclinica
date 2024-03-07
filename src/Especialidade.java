import java.util.ArrayList;
public class Especialidade {
    String nome;
    private static ArrayList<Especialidade> especialidades = new ArrayList<>();
    public Especialidade(String nome) {
        this.nome = nome;
    }
    public static void inicializarEspecialidades() {
        especialidades.add(new Especialidade("Cardiologia"));
        especialidades.add(new Especialidade("Dermatologia"));
        especialidades.add(new Especialidade("Pediatria"));
        especialidades.add(new Especialidade("Reumatologia"));
        especialidades.add(new Especialidade("Ginecologia"));
    }

    public static ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public String getNome(){
        return nome;
    }

    public static Especialidade getEsp(int indice) {
        return Especialidade.getEspecialidades().get(indice);
    }

}
