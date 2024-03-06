import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> Paciente = new ArrayList<>();
        ArrayList<Medico> Medico = new ArrayList<>();
        ArrayList<Consultas> Consultas = new ArrayList<>();
        System.out.println("Seja bem vindo a Policlinica OxeTech!");
        while (true){
            System.out.println("Escolha: ");
            System.out.println("1 para Cadastrar um Paciente");
            System.out.println("2 para Cadastrar um Médico");
            System.out.println("3 para Agendar Consulta");
            System.out.println("4 para Listar Agendamentos");
            System.out.println("5 para Cancelar alguma Consulta");
            System.out.println("ou digite 6 para Sair");
            System.out.println("O que você deseja? ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando um paciente! ");
                    break;
                case 2:
                    System.out.println("Cadastrando um médico! ");
                    break;
                case 3:
                    System.out.println("Agendando uma consulta ");
                    break;
                case 4:
                    System.out.println("Listando atendimentos ");
                    break;
                case 5:
                    System.out.println("Qual consulta quer cancelar? ");
                    break;
                case 6:
                    System.out.println("Obrigado por utilizar nossos serviços, boa recuperação!");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida, Tente outra vez!");
            }
        }
        }
}