/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.util.*;

/**
 *
 * @author jmmonteiro
 */
public class GestorDeExamesDoDEI {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Curso> cursos = new ArrayList<>();
    //nao sei como instanciar alunos nem funcionarios do array pessoas :P por isso criei um array para cada
    //afinal achoque ja sei ;P
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Sala> salas;
    private static ArrayList<Exame> exames; //is this really needed?
    //file names
    private String cursosFich = "cursos.obj";
    private static String pessoasFich = "pessoas.obj";
    private String salasFich = "salas";         //.txt
    private String examesFich = "exames.obj";

    public static void main(String[] args) {
        // TODO code application logic here
        GestorDeExamesDoDEI gestor = new GestorDeExamesDoDEI();
        /*ver se se pode fazer assim ^ ou se é preciso a classe menu
         */
        int opcao, numero;
        Exame exame;
        Aluno aluno;
        Docente docente;
        NaoDocente naoDocente;
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Docente> docentes = new ArrayList<>();
        ArrayList<NaoDocente> naoDocentes = new ArrayList<>();
        exames = new ArrayList<>();
        salas = new ArrayList<>();
        
        gestor.guardaPessoas(pessoasFich);

        /*
        Scanner sc = new Scanner(System.in);

        for (Pessoa p : pessoas) {
            if (p.tipoPessoa() == 1) {
                aluno = (Aluno) p;
                alunos.add(aluno);
            } else if (p.tipoPessoa() == 2) {
                docente = (Docente) p;
                docentes.add(docente);
            } else if (p.tipoPessoa() == 3) {
                naoDocente = (NaoDocente) p;
                naoDocentes.add(naoDocente);
            }
        }

        System.out.print("Escolha uma opção:\n "
                + "1.Criar Exame.\n"
                + "2.Inscrever Alunos.\n"
                + "3.Lançar Notas.\n"
                + "4.Configurar Sala.\n"
                + "5.Convocar vigilantes e funcionários para um exame.\n"
                + "6.Listagem.\n"
                + "A sua opção: ");

        opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                exame = gestor.novoExame();
                exames.add(exame);
                salas.add(exame.getSala());
                break;
            case 2:
                System.out.println("Insira o número do aluno que pretende inscrever:");
                numero = sc.nextInt();

                if (alunos.isEmpty()) {
                    System.out.println("Não existem alunos listados.");
                } else {
                    for (Aluno a : alunos) {
                        if (a.getNumero() == numero) {
                            if (gestor.inscreveAluno(a)) {
                                System.out.println("Aluno inscrito.");
                            } else {
                                System.out.println("Não foi possivel inscrever o Aluno.");
                            }
                        }
                    }
                }
                break;
            case 3:
                
            case 9:
                gestor.ExamesDoAluno(exames, alunos);
            
            case 10:
                gestor.ExamesDoFuncionario(exames, docentes, naoDocentes);  
                
        }*/
    }

    public Exame novoExame() {
        String disc = "";
        int duraçao = 0, opcao;
        boolean protege = true;

        Exame exame;
        Disciplina disciplina = new Disciplina(); /*isto tem de ser criado assim para o puder usar logo sem o criar*/

        Sala sala;

        Scanner sc = new Scanner(System.in);

        System.out.print("--------NOVO EXAME----------\n\n");
        System.out.print("Escolha o tipo de exame:\n"
                + "1. Exame de Época Normal.\n"
                + "2. Exame de Época de Recurso.\n"
                + "3. Exame de Época Especial.\n"
                + "A sua opção :");
        opcao = sc.nextInt();

        //Exame
        while (protege) {
            System.out.print("Preencha os dados do EXAME:\n"
                    + "1. Disciplina: ");

            try {
                disc = sc.next();
                protege = false;
            } catch (Exception e) {
                protege = true;
                System.out.println("--------Insira letras e não números.-------");
            }

            System.out.print("2. Duraçao: ");

            try {
                duraçao = sc.nextInt();
                protege = false;
            } catch (Exception e) {
                protege = true;
                System.out.println("--------Insira números e não letras.-------");
            }
        }

        /*encontra disciplina dentro do curso
         ** é indiferente se a disciplina estiver dentro de mais que um curso
         */
        for (Curso curso : cursos) {
            for (Disciplina d : curso.getDisciplinas()) {
                if (d.getNome().equals(disc)) {
                    disciplina = d;
                    break;
                }
            }
            if (disciplina.getNome().isEmpty()) {
                break;
            }
        }

        //cria exame consoante o tipo
        switch (opcao) {
            case 1:
                exame = new ENormal(disciplina, duraçao);
                break;
            case 2:
                exame = new ERecurso(disciplina, duraçao);
                break;
            case 3:
                exame = new EEspecial(disciplina, duraçao);
                break;
            default:
                return null;
        }

        sala = requisitaSala(duraçao);
        exame.setSala(sala);
        exame.setData(sala.getHorario().get(sala.getHorario().size() - 1)); //a data que fica no exame é a última data a ser inserida no horario da sala
        exame.setDisciplina(disciplina);
        return exame;

        //Docente responsavel
    }

    public Sala requisitaSala(int duraçao) {

        String depSala, nomeSala;
        Sala sala = new Sala();
        Data data;

        Scanner sc = new Scanner(System.in);

        //Sala
        System.out.print("-----------\n"
                + "Preencha os dados da SALA:\n"
                + "1. Nome do departamento: ");
        depSala = sc.next();
        System.out.print("2. Nome da Sala: ");
        nomeSala = sc.next();

        if (salas.isEmpty()) {
            System.out.println("A Sala " + nomeSala + " ainda não existe. Logo, vai ser criada.");
            sala = new Sala(depSala, nomeSala);
        } else {
            for (Sala s : salas) {
                if (s.compNome(nomeSala) == true) {
                    sala = s;
                    System.out.println("A Sala " + sala.toString() + " já existe.");
                } else {
                    System.out.println("A Sala " + sala.toString() + " ainda não existe. Logo, vai ser criada.");
                    sala = new Sala(depSala, nomeSala);
                }
            }
        }

        data = recolheData();

        if (sala.disponibilidade(data, duraçao) == true) {
            sala.setHorario(data, duraçao);
        }

        return sala;
    }

    public Data recolheData() {
        ArrayList<Integer> dat = null;
        Data data = new Data();
        String dataSala;

        Scanner sc = new Scanner(System.in);
        //Data (na Sala)
        do {
            System.out.print("3. Dia e hora em que pretende requisitar a sala: ");//aceita qualquer formato
            dataSala = sc.nextLine();
            dat = data.protegeData(dataSala);
            if (dat.isEmpty()) {
                dataSala = sc.nextLine();
                dat = data.protegeData(dataSala);
            }
        } while (dat == null);

        if (!dat.isEmpty()) {
            int ano, mes, dia, hora, minuto;
            ano = dat.get(0);
            mes = dat.get(1);
            dia = dat.get(2);
            hora = dat.get(3);
            minuto = dat.get(4);
            data = new Data(ano, mes, dia, hora, minuto);
        }
        return data;
    }

    public boolean inscreveAluno(Aluno aluno) {
        //faz addAluno e return true sempre que insere o aluno no exame e faz break dentro do ciclo para acabar no return false do final, sempre que não o insere
        ArrayList<Disciplina> disc;
        Disciplina disciplina;
        Exame exame;
        int i = 0, duracao, matricula;
        Scanner sc = new Scanner(System.in);
        String insc;

        System.out.println("Lista de exames disponiveis:");
        for (Exame exam : exames) {
            disciplina = exam.getDisciplina();
            disc = aluno.getCurso().getDisciplinas();
            if (disc.contains(disciplina)) {
                System.out.println(i + ".\n" + exam.toString()); //imprime o toString() dos exames das disciplinas a que o aluno esta inscrito
            } else {
                System.out.println("Não há nenhum exame disponivel.");
                return false;
            }
        }

        while (true) {
            System.out.println("Pretende increver em algum destes exames? (S/N)");
            insc = sc.nextLine();
            if (insc == "S") {
                System.out.println("Insira o número do exame: ");
                i = sc.nextInt();
                exame = exames.get(i);
                if (exame.epoca().equals("recurso") || exame.epoca().equals("normal")) {
                    exame.addAluno(aluno);
                } else {
                    duracao = aluno.getCurso().getDuracao();
                    matricula = aluno.getMatrícula();
                    if (aluno.getRegime().equals("trabalhador-estudante") || aluno.getRegime().equals("atleta") || aluno.getRegime().equals("dirigente associativo")) {
                        exame.addAluno(aluno);
                    } else if (duracao == matricula) {//ultimo ano do curso
                        exame.addAluno(aluno);
                    } else {
                        System.out.println("O estatuto do Aluno não lhe premite inscrever a exames de época ESPECIAL");
                        break;
                    }
                }
                return true;

            } else if (insc == "N") {
                break;
            } else {
                System.out.println("Insira S - Sim ou N - Nao.");
            }
        }
        return false;
    }

    public boolean separaAlunos(Pessoa p) {
        if (p.tipoPessoa() == 2) {
            return true;
        }
        return false;
    }

    void imprimeExames() {

    }
    
    /**
     * Função que imprime os exames em que um determinado aluno (escolhido pelo seu número), pelo utilizador, no decorrer da função,
     * está inscrito
     * @param exames ArrayList de Exames, todos os exames existentes
     * @param alunos ArrayList de alunos, todos os alunos registados na base de dados
     */
    public void ExamesDoAluno(ArrayList<Exame> exames, ArrayList<Aluno> alunos){
        //ArrayList<Exame> aux = new ArrayList<>();
        //Pede numero de estudante
        Scanner sc = new Scanner(System.in);
        int nEstudante;
        System.out.println("Insira o número do aluno que pretende consultar:");
        do{
            int flag = 0;
            System.out.print("-> ");
            nEstudante = sc.nextInt();
            //ver se nEstudante existe no array de alunos
            for(Aluno a : alunos){
                if(nEstudante == a.getNumero()){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
            System.out.println("Não foi encontrado nenhum estudante com o número " + String.valueOf(nEstudante) + ", por favor insira o número novamente." );
        }while(true);
        
        //print "Exames em que o aluno <nome> está inscrito"
        for(Exame e : exames){
            ArrayList<Notas> lista = e.getNotas();
            int flag = 0;
            for(Notas a : lista){
                if(a.getAluno().getNumero() == nEstudante){
                    flag = 1;
                    break;
                }
                //se o aluno foi encontrado
                if(flag == 1){
                    //aux.add(e);
                    System.out.print(e.getData().toString() + " " + e.getDisciplina());
                    if(a.getNota() != -1){
                        System.out.println("Nota: " + String.valueOf(a.getNota()));
                    }
                }
            }
        }
    }
    /**
     * Função que imprime todos os exames em que determinado funcionário docente ou não docente, escolhido pelo utilizador durante a execução
     * desta função, está inscrito.
     * @param exames ArrayList de Exames, todos os exames existentes.
     * @param docentes ArrayList de Docente, todos os docentes registados na base de dados.
     * @param naoDocentes ArrayList de NaoDocente, todos os funcionários não docentes registados na base de dados.
     */
    public void ExamesDoFuncionario(ArrayList<Exame> exames, ArrayList<Docente> docentes, ArrayList<NaoDocente> naoDocentes){
        //ArrayList<Exame> aux = new ArrayList<>();
        //Pede numero mecanográfico
        Scanner sc = new Scanner(System.in);
        //Scanner
        int nMecan;
        int auxi = 0;   //meramente para otimização
        System.out.println("Insira o número do funcionário que pretende consultar:");
        //----------------------inserir opção para retroceder?------------------------
        do{
            int flag = 0;
            System.out.print("-> ");
            nMecan = sc.nextInt();
            //procurar numero no array de funcionarios
            for(Docente d : docentes){
                if(nMecan == d.getNumeroMecanografico()){
                    flag = 1;
                    auxi = 1;
                    break;
                }
            }
            if(flag == 0){
                for(NaoDocente n : naoDocentes){
                    if(nMecan == n.getNumeroMecanografico()){
                        flag = 1;
                        auxi = 2;
                        break;
                    }
                }
            }
            if(flag == 1){
                break;
            }
            System.out.println("Não foi encontrado nenhum funcionario com o número " + String.valueOf(nMecan) + ", por favor insira o número novamente.");
        }while(true);
        
        for(Exame e : exames){
            ArrayList<Docente> lista = e.getVigilantes();
            ArrayList<NaoDocente> lista2 = e.getApoio();
            int flag = 0;
            
            if(auxi == 1){
                for(Docente f : lista){
                    if(f.getNumeroMecanografico() == nMecan){
                        flag = 1;
                        break;
                    }
                }
            }
            else if(auxi == 2){
                for(NaoDocente n : lista2){
                    if(n.getNumeroMecanografico() == nMecan){
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 1){
                //aux.add(e);
                System.out.println(e.getData().toString() + "Disciplina: " + e.getDisciplina());
            }
        }
    }

    void boot() {
        //load dos ficheiros todos
        //abre fich1

        //fecha fich1 & abre fich2
        //fecha fich2 & abre fich3
        //fecha fich3 & abre fich4
        //fecha fich4
    }
    
    public void guardaPessoas(String pessoasFich/*, ArrayList<Pessoa> list*/){
        ArrayList<Pessoa> list = new ArrayList<>();
        ArrayList<Disciplina> disc = new ArrayList<>();
        ArrayList<Data> dt = new ArrayList<>();
        list.add(new Aluno(2015235572, 2, new Curso("LEI", "Licenciatura", 3, disc), "normal", "José Monteiro", "ze_miguel97@hotmail.com"));
        list.add(new Docente("I.A.", 1234567890, "catedrático", "Nuno", "Nuno@dei.uc.pt", dt));
        list.add(new NaoDocente("apoio técnico", 234567890, "técnico superior", "Marco", "Marco@helper.dei.uc.pt"));
        GestorFicheiros fich = new GestorFicheiros();
        fich.writeObjectFileArray(salasFich, list);
    }

    void shutdown() {
        //grava ficheiros todos, termina o programa no final
    }

}
