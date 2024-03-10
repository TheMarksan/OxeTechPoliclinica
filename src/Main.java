import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//15 numeros p o cartão do SUS
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Paciente> Pacientes = new ArrayList<>();
    private static ArrayList<Medico> Medicos = new ArrayList<>();
    private static ArrayList<Consultas> Consultas = new ArrayList<>();
    public static void main(String[] args) {
        Especialidade.inicializarEspecialidades();

        ArrayList<Consultas> Consultas = new ArrayList<>();
        System.out.println("Seja bem vindo a Policlinica OxeTech!");
        while (true){
            System.out.println("Escolha: ");
            System.out.println("1 para Cadastrar um Paciente");
            System.out.println("2 para Cadastrar um Médico");
            System.out.println("3 para Agendar Consulta");
            System.out.println("4 para Listar todas as consultas");
            System.out.println("5 para Cancelar alguma Consulta");
            System.out.println("ou digite 6 para Sair");
            System.out.println("O que você deseja? ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando um paciente! ");
                    cadPaciente();
                    break;
                case 2:
                    System.out.println("Cadastrando um médico! ");
                    cadMedico();
                    break;
                case 3:
                    System.out.println("Agendando uma consulta ");
                    agendarMedico();
                    break;
                case 4:
                    System.out.println("Listando todas as consultas");
                    listarTodasConsultas();
                    //listar consultas do paciente ou médico (com data, hora e infos dos dois). Consultas estão vinculadas ao CRM ou o numero do cartão SUS
                    break;
                case 5:
                    System.out.println("Vamos cancelar uma consulta");
                    desmarcarConsulta();
                    break;
                case 6:
                    System.out.println("Obrigado por utilizar nossos serviços, boa recuperação!");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida, Tente outra vez!");
            }
        }
    }
    private static void cadPaciente() {
        scanner.nextLine();
        System.out.print("Digite o nome do paciente: ");
        String name = scanner.nextLine();
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        /*while (!validarCPF(cpf) || cpfJaCadastrado(cpf)) {
            if (!validarCPF(cpf)) {
                System.out.println("Formato de CPF inválido. Tente novamente no formato válido (xxx.xxx.xxx-xx):");
            } else {
                System.out.println("Esse CPF já está cadastrado. Tente novamente:");
            }
            cpf = scanner.nextLine();
        }*/
        System.out.print("Digite o cartão SUS do paciente: ");
        String cardSUS= scanner.nextLine();

        System.out.println("Para qual especialidade o paciente deseja agendar a consulta?");

        for (int i = 0; i < Especialidade.getEspecialidades().size(); i++) {
            System.out.println(i + ". " + Especialidade.getEspecialidades().get(i).getNome());
        }
        int index = scanner.nextInt();
        Especialidade especialidade = Especialidade.getEsp(index);

        Paciente paciente = new Paciente(name, cpf, cardSUS, especialidade);
        Pacientes.add(paciente);
        System.out.println("\nGerando protocolo de atendimento...");
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void cadMedico() {
        scanner.nextLine();
        System.out.print("Digite o nome do médico: ");
        String name = scanner.nextLine();
        System.out.print("Digite o CPF do médico: ");
        String cpf = scanner.nextLine();
        /*while (!validarCPF(cpf) || cpfJaCadastrado(cpf) || medicoComCPFExistente(cpf)) {
            if (!validarCPF(cpf)) {
                System.out.println("Formato de CPF inválido. Tente novamente no formato válido (xxx.xxx.xxx-xx):");
            } else if (cpfJaCadastrado(cpf)) {
                System.out.println("Este CPF já está cadastrado para um paciente. Tente novamente:");
            } else if (medicoComCPFExistente(cpf)) {
                System.out.println("Este CPF já está cadastrado para outro médico. Tente novamente:");
            }
            cpf = scanner.nextLine();
        }*/

        System.out.println("Digite o CRM do médico: (xxxx-UF)");
        String crm= scanner.nextLine();
        /*while (!validarCRM(crm) || crmJaCadastrado(crm)) {
            if (!validarCRM(crm)) {
                System.out.println("Digite o CRM no formato válido (xxxx-UF):");
            } else if (crmJaCadastrado(crm)) {
                System.out.println("Este CRM já está cadastrado. Tente novamente:");
            }
            crm = scanner.nextLine();
        }*/

        System.out.print("Digite o salário do médico: ");
        double salario = scanner.nextDouble();

        System.out.println("Digite a especialidade do médico: ");

        for (int i = 0; i < Especialidade.getEspecialidades().size(); i++) {
            System.out.println(i + ". " + Especialidade.getEspecialidades().get(i).getNome());
        }
        int index = scanner.nextInt();
        Especialidade especialidade = Especialidade.getEsp(index);

        Medico medico = new Medico(name, cpf, crm, salario, especialidade);
        Medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }


    private static void agendarMedico() {
        if(Pacientes.isEmpty()){
            System.out.println("Sem pacientes cadastrados.");
        }else{
            System.out.println("Agendar consulta para qual paciente?");
            for (int i = 0; i < Pacientes.size(); i++) {
                Paciente paciente = Pacientes.get(i);
                System.out.println((i) + ". " + "Nome: " + paciente.getNome() + "\n - CPF: " + paciente.getCpf() + "\n - Cartão SUS: " + paciente.getCartaoSus() + "\n - Especialidade: " + paciente.getEspecialidade().getNome()  + "\n");
            }
            int indexPaciente = scanner.nextInt();
            Paciente paciente = Pacientes.get(indexPaciente);
            agendarConsulta(paciente, paciente.getEspecialidade());
        }
    }
    private static void agendarConsulta(Paciente paciente, Especialidade especialidade) {
        System.out.println("Médicos disponíveis para a especialidade "+especialidade.getNome());
        if (Medicos.isEmpty()) {
            System.out.println("Não há médicos\n");
        } else {
            boolean achou = false;
            for (int i = 0; i < Medicos.size(); i++) {
                Medico medico = Medicos.get(i);
                if(medico.getEspecialidade().getNome().equals(especialidade.getNome())){
                    System.out.println(i + ". " + medico.getNome() + " - CRM: "+medico.getCrm());
                    achou = true;
                }
            }
            if(!achou){
                System.out.println("Não há médicos para essa especialidade.");
                return;
            }
        }

        System.out.println("Escolha o médico pelo número correspondente:");
        int indexMedico = scanner.nextInt();
        Medico medicoSelecionado = Medicos.get(indexMedico);

        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite a data e hora da consulta (no formato 'DD/MM/YYYY HH:MM'): ");
        String dataHoraString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, formatter);


        Consultas consulta = new Consultas(medicoSelecionado, paciente, especialidade.getNome(), dataHora);
        Consultas.add(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    private static void desmarcarConsulta() {
        for (int i = 0; i < Consultas.size(); i++) {
            if (Consultas.get(i).getPaciente() == null) {
                System.out.println((i + 1) + ". " + "Nenhuma consulta agendada");
                break;
            }
            System.out.println((i + 1) + ". " + Consultas.get(i).getPaciente().getNome());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        Consultas.get(index - 1).setPaciente(null);
        System.out.println("Consulta desmarcada com sucesso!");
    }

    private static void listarTodasConsultas() {
        for (int i = 0; i < Consultas.size(); i++) {
            if (Consultas.get(i).getPaciente() == null) {
                System.out.println((i + 1) + ". " + "Para esse paciente não tem consulta agendada.");
                break;
            }else if (Consultas.get(i).getMedico() == null){
                System.out.println((i + 1) + ". " + "Nenhuma consulta agendada");
                break;
            }
            System.out.println((i + 1) + ". " + Consultas.get(i).getMedico().getNome() + " - Especialidade - " + Consultas.get(i).getMedico().getEspecialidade().getNome()
                    + " CRM - " + Consultas.get(i).getMedico().getCrm() + "\n Paciente: " + Consultas.get(i).getPaciente().getNome() + " Cartão do Sus: " + Consultas.get(i).getPaciente().getCartaoSus());
        }
    }


   /* public static boolean validarCPF(String cpf) {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        return cpf.matches(regex);
    }

    public static boolean validarCRM(String crm) {
        String regex = "\\d{4}-[A-Z]{2}";

        return crm.matches(regex);
    }*/

    private static boolean cpfJaCadastrado(String cpf) {
        for (Paciente paciente : Pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private static boolean medicoComCPFExistente(String cpf) {
        for (Medico medico : Medicos) {
            if (medico.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    private static boolean crmJaCadastrado(String crm) {
        for (Medico medico : Medicos) {
            if (medico.getCrm().equals(crm)) {
                return true;
            }
        }
        return false;
    }
}

