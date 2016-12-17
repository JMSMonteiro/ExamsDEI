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
    private static String cursosFich = "cursos.obj";
    private static String pessoasFich = "pessoas.obj";
    private static String salasFich = "salas.obj";         //.txt
    private static String examesFich = "exames.obj";

    public static void main(String[] args) {

        GestorDeExamesDoDEI gestor = new GestorDeExamesDoDEI();
        int opcao = 0, numero, opca;
        String nomeDisc;
        boolean encontrou = false;
        Exame exame;
        Aluno aluno;
        Docente docente;
        NaoDocente naoDocente;

        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Docente> docentes = new ArrayList<>();
        ArrayList<NaoDocente> naoDocentes = new ArrayList<>();

        exames = new ArrayList<>();
        salas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        pessoas = gestor.leArrays(pessoasFich);
        cursos = gestor.leArrays(cursosFich);
        exames = gestor.leArrays(examesFich);
        salas = gestor.leArrays(salasFich);
        /*
        cursos.add(new Curso("LEI", "Licenciatura"  , 3, new ArrayList<>()));
        cursos.add(new Curso("LDM", "Licenciatura"  , 3, new ArrayList<>()));
        cursos.add(new Curso("MEI", "Mestrado"  , 2, new ArrayList<>()));
        cursos.add(new Curso("MDM", "Mestrado"  , 2, new ArrayList<>()));
        */
        /*
        alunos.add(new Aluno(2015235572, 2, cursos.get(0), "normal", "José Monteiro", "jmonteiro@student.dei.uc.pt"));
        alunos.add(new Aluno(2015231261, 2, cursos.get(0), "normal", "Alexandre Rodrigues", "arodrigues@student.dei.uc.pt"));
        alunos.add(new Aluno(2015845632, 2, cursos.get(0), "normal", "João Gonçalves", "jgonçalves@student.dei.uc.pt"));
        alunos.add(new Aluno(2015878213, 2, cursos.get(0), "normal", "João Sopas", "sopas@student.dei.uc.pt"));
        */
        /* assistente, auxiliar, associado ou catedrático*/
        /*sistemas de informação, comunicação e telemática, engenharia de software*/
        /*
        docentes.add(new Docente("Engenharia de software", 1234567890, "catedrático", "Nuno","Nuno@dei.uc.pt", new ArrayList()));
        docentes.add(new Docente("Inteligencia artificial", 1234892325, "catedrático", "Ernesto","Ernesto@dei.uc.pt", new ArrayList()));
        docentes.add(new Docente("Sistemas de informação", 1234284325, "assistente", "RPP","rpp@dei.uc.pt", new ArrayList()));
        */
        /*
        naoDocentes.add(new NaoDocente(	"apoio técnico", 234567890, "técnico superior", "Marco", "Marco@helper.dei.uc.pt"));
        */
        /*
        //add alunos à lista de inscritos das disciplinas
        for(Curso c : cursos){
            int i = 0;
            if(i == 0){
                for(Disciplina d : c.getDisciplinas()){
                    d.setInscritos(alunos);
                }
            }
            i += 1;
        }*/
        
        for (Pessoa p : pessoas) {
            switch (p.tipoPessoa()) {
                case 1:
                    aluno = (Aluno) p;
                    alunos.add(aluno);
                    break;
                case 2:
                    docente = (Docente) p;
                    docentes.add(docente);
                    break;
                case 3:
                    naoDocente = (NaoDocente) p;
                    naoDocentes.add(naoDocente);
                    break;
                default:
                    break;
            }
        }
        
        /*
        //adiciona cadeira manualmente
        for(Curso c : cursos){
            if(c.getNome().compareToIgnoreCase("LEI") == 0){
                ArrayList aux = c.getDisciplinas();
                ArrayList<Docente> ax = new ArrayList();
                //ArrayList<Aluno> axu = new ArrayList();
                //ax.add(docentes.get(0));
                ax.add(docentes.get(2));
                //axu.add(alunos.get(1));
                
                aux.add(new Disciplina("TI", docentes.get(2), ax, new ArrayList(), new ArrayList()));
                c.setDisciplinas(aux);
            }
        }*/
        
        /*
        //prints de teste
        System.out.println(alunos.get(3).getNome());
        System.out.println(docentes.get(2).getNome());
        System.out.println(naoDocentes.get(0).getNome());
        */
        /*
        for(Curso c : cursos){
            System.out.println(c.getNome() + " " + c.getGrau() + " " + c.getDuracao());
            
            ArrayList<Disciplina> test = c.getDisciplinas();
            for(Disciplina d : test){
                System.out.println("____");
                System.out.println(d.getNome() + " " + d.getResponsavel().getNome());
                for(Aluno a :  d.getInscritos()){
                    System.out.println(a.getNome());
                }
            }
        }*/
        
	
        while(opcao!=6){                    

            System.out.print("\nEscolha uma opção:\n"
                    + "1.Criar Exame.\n"
                    + "2.Inscrever Alunos.\n"
                    + "3.Lançar Notas.\n"
                    + "4.Convocar vigilantes e funcionários para um exame.\n"
                    + "5.Listagem.\n"
                    + "6.Sair"
                    + "\nA sua opção: ");

            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    exame = gestor.novoExame();
                    if (exame != null) {
                        System.out.println("\nExame marcado para " + exame.getData().getCal().getTime() + " na sala " + exame.getSala().getNome());
	                    exames.add(exame);
	                    salas.add(exame.getSala());
                    }
                                                    
                    break;
                case 2:
                    System.out.println("\nInsira o número do aluno que pretende inscrever:");
                    numero = sc.nextInt();

                    if (alunos.isEmpty()) {
                        System.out.println("Não existem alunos listados.");
                    } else {
                        for (Aluno a : alunos) {
                            if (a.getNumero() == numero) {
                                if (gestor.inscreveAluno(a)) {
                                    encontrou = true;
                                    System.out.println("Aluno inscrito.");
                                }
                            }
                        }
                        if (encontrou == false) {
                            System.out.println("Não foi possivel inscrever o Aluno.\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Indique a disciplina do Exame:");
                    nomeDisc = sc.next();

                    if (exames.isEmpty()) {
                        System.out.println("Não existem exames listados.\n");
                    } else {
                        if (gestor.lançaNotas(nomeDisc)) {
                            System.out.println("Notas lançadas com sucesso!\n");
                        } else {
                            System.out.println("Não foi possivel lançar Notas\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Indique a disciplina do Exame:");
                    do {
                        try {
                            nomeDisc = sc.next();
                        } catch (Exception e) {
                            nomeDisc = null;
                            System.out.println("------Insira letras e não números-----");
                        }
                    } while (nomeDisc == null);

                    if (exames.isEmpty()) {
                        System.out.println("Não existem exames listados.\n");
                    } else {
                        if (gestor.convocaVigilantes(naoDocentes, nomeDisc)) {
                            System.out.println("Convocatória concluida com sucesso. \n");
                        } else {
                            System.out.println("Não foram convocados Docentes.\n");
                        }

                    }
                    break;
                case 5:
                    System.out.println("\nA Listar:\n"
                            + "1. Exames.\n"
                            + "2. Alunos inscritos num Exame.\n"
                            + "3. Exames em que um Aluno está inscrito.\n"
                            + "4. Docentes e funcionários associados a um Exame.\n"
                            + "5. Exames em que um Docente ou Funcionário está envolvido.\n"
                            + "6. Notas de um Exame.\n"
                            + "A sua opção: ");
                    opca = sc.nextInt();
                    switch (opca) {
                        case 1:
                            gestor.imprimeExames();
                            break;
                        case 2:
                            gestor.listaRefExame(1);
                            break;
                        case 3:
                            gestor.examesDoAluno(exames, alunos);
                            break;
                        case 4:
                            gestor.listaRefExame(3);
                            break;
                        case 5:
                            gestor.examesDoFuncionario(exames, docentes, naoDocentes);
                            break;
                        case 6:
                            gestor.listaRefExame(2);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("A terminar o programa.");
                    break;
            }
        }
        gestor.guardaPessoas(pessoasFich, alunos, docentes, naoDocentes);
        gestor.guardaArray(cursosFich, cursos);
        gestor.guardaArray(examesFich, exames);
        gestor.guardaArray(salasFich, salas);
    }

    private void escolheDisc(ArrayList<Curso> list, String curso, String disc){
        ArrayList<Disciplina> aux = new ArrayList<>();
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        //cursos
        System.out.println("Cursos Disponíveis:");
        for(Curso c : list){
            //lista os cursos
            System.out.println(c.getNome());
        }

        System.out.println("\nPor favor insira o nome do Curso que pretende:");
        do{
            //Scanner para String
            System.out.print("-> ");
            curso = sc.nextLine();
            for(Curso c : list){
                //procura o curso dado como input no array
                if(curso.compareToIgnoreCase(c.getNome()) == 0){
                    curso = c.getNome();
                    aux = c.getDisciplinas();
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                flag = 0;
                break;
            }
            System.out.println("Curso não encontrado, por favor insira o nome novamente.");
        }while(true);
    	
        //disciplinas
        System.out.println("Disciplinas disponíveis:");
        for(Disciplina d : aux){
            //Lista as disciplinas
            System.out.println(d.getNome());
        }

        System.out.println("\nPor favor insira o nome do Curso que pretende:");
        do{
            System.out.print("-> ");
            disc = sc.nextLine();
            for(Disciplina d : aux){
            if(disc.compareToIgnoreCase(d.getNome()) == 0){
                disc = d.getNome();
                flag = 1;
                break;
                }
            }
            if(flag == 1){
                return;
            }
            System.out.println("Disciplina não encontrada, por favor insira o nome novamente.");
        }while(true);
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
        
        do {
            System.out.println("A sua opção :");
            try {
                opcao = sc.nextInt();
            } catch (Exception e) {
                opcao = -1;
                System.out.println("---------Insira números e não letras---------");
            }
            if (opcao < 0 || opcao > 3) {
                System.out.println("Opcção Inválida.");
            }
        } while (opcao == -1 || opcao < 0 || opcao > 3);

        //Exame
        while (protege) {
            System.out.print("Preencha os dados do EXAME:\n"
                    + "Disciplina a que pertence: ");

            try {
                disc = sc.next();
                protege = false;
            } catch (Exception e) {
                protege = true;
                System.out.println("--------Insira letras e não números.-------");
            }

            System.out.print("Duraçao do exame: ");

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
                if (d.getNome().compareToIgnoreCase(disc) == 0) {
                    disciplina = d;
                    break;
                }
            }
            if (disciplina.getNome()==null) {
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
        //se configurar== true é para configurar uma sala existente, se configurar == false é para quando se cria a sala
        String depSala = null, nomeSala = null;
        Sala sala = new Sala();
        Data data;

        Scanner sc = new Scanner(System.in);

        //Sala
        System.out.print("-----------\n"
               + "Preencha os dados da SALA:\n");

        do {
            System.out.println("1. Nome do departamento: ");
            try {
                depSala = sc.next();
                System.out.print("2. Nome da Sala: ");
                nomeSala = sc.next();

            } catch (Exception e) {
                depSala = null;
                System.out.println("------Insira letras e não números-----");
            }
        } while (depSala == null || nomeSala == null);

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

        do {
            data = recolheData();
            if (data.disponibilidadeSala(data, duraçao, sala) == true) {
                sala.setHorario(data, duraçao);
            } else {
                System.out.println("A sala não se encontra disponivel nesse horário.");
            }
        } while (!data.disponibilidadeSala(data, duraçao, sala));

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
        } while (dat == null || dataSala == null);

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
        ArrayList<Exame> examesDisp = new ArrayList<>();
        Disciplina disciplina;
        Exame exame;
        int i = 0, duracao, matricula, num;
        Scanner sc = new Scanner(System.in);
        String insc;
        int flag = 0;

        System.out.println("Lista de exames disponiveis:");
        for (Exame exam : exames) {
            //so disponibiliza os exames das disciplinas do curso do aluno
            disciplina = exam.getDisciplina();
            disc = aluno.getCurso().getDisciplinas();
            //if (disc.contains(disciplina)) {
            for(Disciplina d : disc){
            	if(d.getNome().compareToIgnoreCase(disciplina.getNome()) == 0){
	                examesDisp.add(exam);
	                System.out.println(i + ".\n" + exam.toString()); //imprime o toString() dos exames das disciplinas a que o aluno esta inscrito
	                i++;
	                flag = 1;
            	}
            }
            if(flag == 0) {
                System.out.println("Não há nenhum exame disponivel.");
                return false;
            }
        }

        while (true) {
            System.out.println("Pretende increver em algum destes exames? (S/N)");
            insc = sc.nextLine();

            if ("S".equals(insc)) {
                System.out.println("Insira o número do exame: ");
                do {
                    try {
                        num = sc.nextInt();
                    } catch (Exception e) {
                        num = -1;
                        System.out.println("---------Insira números e não letras----------");
                    }
                } while (num == -1);

                if (num > i || num < 0) {
                    System.out.println("Opção Inválida");
                } else {
                    exame = examesDisp.get(num);
                    if (exame.epoca().equals("Recurso") || exame.epoca().equals("Normal")) {
                        exame.adicionaAluno(aluno);
                    } else {
                        duracao = aluno.getCurso().getDuracao();
                        matricula = aluno.getMatrícula();
                        if (aluno.verificaRegime()) {
                            exame.adicionaAluno(aluno);
                        } else if (duracao == matricula) {//ultimo ano do curso
                            exame.adicionaAluno(aluno);
                        } else {
                            System.out.println("O estatuto do Aluno não lhe permite inscrever a exames de época ESPECIAL");
                            break;
                        }
                    }
                    return true;
                }

            } else if ("N".equals(insc)) {
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

    private boolean lançaNotas(String nomeDisc) {
        int i = 0, num = -1;
        Scanner sc = new Scanner(System.in);
        ArrayList<Exame> examesDisp = new ArrayList<>();
        String insc;
        Exame exame;

        for (Exame exam : exames) {
            if (exam.getDisciplina().getNome().equals(nomeDisc)) {
                System.out.println(i + ".\n" + exam.toString()); //imprime o toString() dos exames da disciplina dada
                examesDisp.add(exam);
                i++;
            }
        }
        while (true) {
            System.out.println("Pretende lançar as notas de algum destes exames? (S/N)");
            insc = sc.nextLine();

            if ("S".equals(insc)) {
                System.out.println("Insira o número do exame: ");
                do {
                    try {
                        num = sc.nextInt();
                    } catch (Exception e) {
                        num = -1;
                        System.out.println("---------Insira números e não letras----------");
                    }
                } while (num == -1);

                if (num > i || num < 0) {
                    System.out.println("Opção Inválida");
                } else {
                    exame = examesDisp.get(num);
                    if (exame.atribuiNotas()) {
                        return true;
                    }
                }

            } else if ("N".equals(insc)) {
                break;
            } else {
                System.out.println("Insira S - Sim ou N - Nao.");
            }
        }
        return false;
    }

    public boolean convocaVigilantes(ArrayList<NaoDocente> naoDocente, String nomeDisc) {
        Data dataDocente;
        Exame exame;
        boolean convocaDocente = false;
        int j = 0, num = -1;
        String insc;

        Scanner sc = new Scanner(System.in);
        ArrayList<Exame> examesDisp = new ArrayList<>();
        ArrayList<Exame> examesDocente; //lista de exames vigiados pelo Docente

        for (Exame exam : exames) {
            if (exam.getDisciplina().getNome().equals(nomeDisc)) {
                System.out.println(j + ".\n" + exam.toString()); //imprime o toString() dos exames da disciplina dada
                examesDisp.add(exam);
                j++;
            }
        }
        while (true) {
            System.out.println("Pretende convocar funcionarios para algum destes exames? (S/N)");
            insc = sc.next();

            if ("S".equals(insc)) {
                System.out.println("Insira o número do exame: ");
                do {
                    try {
                        num = sc.nextInt();
                    } catch (Exception e) {
                        num = -1;
                        System.out.println("---------Insira números e não letras----------");
                    }
                } while (num == -1);

                if (num > j || num < 0) {
                    System.out.println("Opção Inválida");
                } else {
                    exame = examesDisp.get(num);
                    if (exame.getVigilantes().size() == 3) {//se a lista tiver 3 elementos nao procura mais
                        System.out.println("O Exame já tem 3 Docentes na lista de vigilantes, pretende convocar mais? (S/N)");
                        do {
                            insc = sc.nextLine();
                            if (insc.equals("N")) {
                                return false; //para fazer so 3
                            } else if (insc.equals("S")) {
                                break;
                            } else {
                                System.out.println("Insira S - Sim ou N - Nao.\nA sua resposta: ");
                            }
                        } while (true);
                    }
                    break;
                }

            } else if ("N".equals(insc)) {
                return false;
            } else {
                System.out.println("Insira S - Sim ou N - Nao.");
            }
        }

        dataDocente = exame.getData();

        for (Docente docenteD : exame.getDisciplina().getDocentes()) {//pega num docente da lista de docentes da Disciplina
            examesDocente = new ArrayList<>();

            for (Exame exam : exames) { //pega em cada exame existente                  
                if (exam.getVigilantes().contains(docenteD)) { //ve se o docente esta a vigiar o exame
                    examesDocente.add(exam);   //junta os exames que o Docente vigia                     
                }
            }
            //verifica se a data dos exames que o Docente vigia interferem com a Data em que o queremos por a vigiar
            if (dataDocente.disponibilidadeDocente(examesDocente, exame.getDuracao())) {
                exame.addVigilante(docenteD);
                System.out.println("Docente " + docenteD.getNome() + " convocado.");
                convocaDocente = true;

            }
        }

        for (int i = 0; i < naoDocente.size(); i++) { //convoca nao Docentes
            if (exame.getApoio().size() < 5) {
                exame.addApoio(naoDocente.get(i));
                System.out.println("Funcionario " + naoDocente.get(i).getNome() + " convocado.");
            }
        }
        System.out.println("Foram convocados " + exame.getVigilantes().size() + " Docentes para vigiar o exame.");
        System.out.println("Foram convocados " + exame.getApoio().size() + " Docentes para vigiar o exame.");

        return convocaDocente;
    }

    private void imprimeExames() {
        if (exames.isEmpty()) {
            System.out.println("Não existe nenhum Exame marcado.");
            return;
        }
        System.out.println("\n");
        for (Exame exame : exames) {
            System.out.println(exame.toString());
        }
        System.out.println("\n\n");
    }

    private void listaRefExame(int lista) {

        String disciplina;
        Scanner sc = new Scanner(System.in);
        ArrayList<Exame> examesDisp = new ArrayList<>();
        Exame exame;
        int j = 0, opcao;

        System.out.println("Insira a disciplina do Exame que pretende:");
        disciplina = sc.nextLine();

        if (exames.isEmpty()) {
            System.out.println("Não há nenhum exame marcado.");
            return;
        }
        System.out.println("Lista de Exames dessa Disciplina:");
        for (Exame exam : exames) {
            if (exam.getDisciplina().getNome().equals(disciplina)) {
                System.out.println(j + ".\n" + exam.toString()); //imprime o toString() dos exames da disciplina dada
                examesDisp.add(exam);
                j++;
            }
        }

        do {
            System.out.println("Escolha um opção: ");
            opcao = sc.nextInt();

            if (opcao > j || opcao < 0) {
                System.out.println("Opção Inválida.");
            } else {
                break;
            }
        } while (true);
        exame = examesDisp.get(opcao);
        if (lista == 1) {
            exame.listaAlunos();
        } else if (lista == 2) {
            exame.listaNotas();
        } else if (lista == 3) {
            exame.listaFuncionarios();
        }

    }

    /**
     * Função que imprime os exames em que um determinado aluno (escolhido pelo
     * seu número), pelo utilizador, no decorrer da função, está inscrito
     *
     * @param exames ArrayList de Exames, todos os exames existentes
     * @param alunos ArrayList de alunos, todos os alunos registados na base de
     * dados
     */
    public void examesDoAluno(ArrayList<Exame> exames, ArrayList<Aluno> alunos) {
        //ArrayList<Exame> aux = new ArrayList<>();
        //Pede numero de estudante
        Scanner sc = new Scanner(System.in);
        int nEstudante = -1;
        System.out.println("Insira o número do aluno que pretende consultar:");
        do {
            int flag = 0;
            System.out.print("-> ");
            try {
                nEstudante = sc.nextInt();
            } catch (Exception e) {
                nEstudante = -1;
                System.out.println("---------Insira números e não letras----------");

            }
            if (nEstudante != -1) {
                //ver se nEstudante existe no array de alunos
                for (Aluno a : alunos) {
                    if (nEstudante == a.getNumero()) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
                System.out.println("Não foi encontrado nenhum estudante com o número " + String.valueOf(nEstudante) + ", por favor insira o número novamente.");
            }

        } while (true);
        
        //print "Exames em que o aluno <nome> está inscrito"
        for(Exame e : exames){
            ArrayList<Notas> lista = e.getNotas();
            int flag = 0;
            if(lista.isEmpty()){
                for(Aluno a : e.getInscritos()){
                    if(a.getNumero() == nEstudante){
                        flag = 1;
                        //break;
                    }
                    if(flag == 1){
                        //aux.add(e);
                        System.out.print(e.getData().time() + "\t" + e.getDisciplina().getNome());
                        break;
                    }
                }
            }
            else{
               for(Notas a : lista){
                    if(a.getAluno().getNumero() == nEstudante){
                        flag = 1;
                        //break;
                    }
                    //se o aluno foi encontrado
                    if(flag == 1){
                        //aux.add(e);
                        System.out.print(e.getData().time()+ "\t" + e.getDisciplina().getNome());
                        if(a.getNota() != -1){
                            System.out.println("\tNota: " + String.valueOf(a.getNota()));
                            break;
                        }
                    }
                } 
            }
            
        }
    }
    /**
     * Função que imprime todos os exames em que determinado funcionário docente
     * ou não docente, escolhido pelo utilizador durante a execução desta
     * função, está inscrito.
     *
     * @param exames ArrayList de Exames, todos os exames existentes.
     * @param docentes ArrayList de Docente, todos os docentes registados na
     * base de dados.
     * @param naoDocentes ArrayList de NaoDocente, todos os funcionários não
     * docentes registados na base de dados.
     */
    public void examesDoFuncionario(ArrayList<Exame> exames, ArrayList<Docente> docentes, ArrayList<NaoDocente> naoDocentes){
        //ArrayList<Exame> aux = new ArrayList<>();
        //Pede numero mecanográfico
        Scanner sc = new Scanner(System.in);
        //Scanner
        int nMecan = -1;
        int auxi = 0;   //meramente para otimização
        System.out.println("Insira o número do funcionário que pretende consultar:");
        //----------------------inserir opção para retroceder?------------------------
        do{
            int flag = 0;
            System.out.print("-> ");
            try {
                nMecan = sc.nextInt();
            } catch (Exception e) {
                nMecan = -1;
                System.out.println("---------Insira números e não letras----------");
            }
            if (nMecan != -1) {
                //procurar numero no array de funcionarios
                for (Docente d : docentes) {
                    if (nMecan == d.getNumeroMecanografico()) {
                        flag = 1;
                        auxi = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    for (NaoDocente n : naoDocentes) {
                        if (nMecan == n.getNumeroMecanografico()) {
                            flag = 1;
                            auxi = 2;
                            break;
                        }
                    }
                }
            }
            if(flag == 1){
                break;
            }
            System.out.println("Não foi encontrado nenhum funcionario com o número " + String.valueOf(nMecan) + ", por favor insira o número novamente.");
        }while(true);
        
        System.out.println("\n\n");
        
        for(Exame e : exames){
            ArrayList<Docente> lista = e.getVigilantes();
            ArrayList<NaoDocente> lista2 = e.getApoio();
            int flag = 0;
            
            if(auxi == 1){
                if(e.getResponsavel().getNumeroMecanografico() == nMecan){
                    flag = 1;
                }
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
                System.out.println(e.getData().time() + "\tDisciplina: " + e.getDisciplina().getNome());
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
    
    private void guardaPessoas(String nomeFich, ArrayList<Aluno> al, ArrayList<Docente> dc, ArrayList<NaoDocente> nd){
        ArrayList<Pessoa> list;

        list = convergePessoas(al, dc, nd);

        //ArrayList<Disciplina> disc = new ArrayList<>();
        //ArrayList<Data> dt = new ArrayList<>();
        //list.add(new Aluno(2015235572, 2, new Curso("LEI", "Licenciatura", 3, disc), "normal", "José Monteiro", "ze_miguel97@hotmail.com"));
        //list.add(new Docente(		"I.A.", 			1234567890, "catedrático", 		"Nuno", 	"Nuno@dei.uc.pt", 			dt));
        //list.add(new NaoDocente(	"apoio técnico", 	234567890, 	"técnico superior", "Marco", 	"Marco@helper.dei.uc.pt"));
        GestorFicheiros fich = new GestorFicheiros();
        fich.writeObjectFileArray(nomeFich, list);
    }

    private ArrayList convergePessoas(ArrayList<Aluno> al, ArrayList<Docente> dc, ArrayList<NaoDocente> nd){
        ArrayList<Pessoa> out = new ArrayList<>();
        for(Aluno a : al){
            out.add(a);
        }
        for(Docente d : dc){
            out.add(d);
        }
        for(NaoDocente n : nd){
            out.add(n);
        } 
        return out;
    }
    
    private ArrayList leArrays(String nomeFich){
        GestorFicheiros fich = new GestorFicheiros();
        return fich.readObjectFileArray(nomeFich);
    }

    private void guardaArray(String nomeFich, ArrayList list){
    	GestorFicheiros fich = new GestorFicheiros();
        fich.writeObjectFileArray(nomeFich, list);
    }

	/*
    private void guardaExames(String nomeFich, ArrayList<Exame> list){
    	GestorFicheiros fich = new GestorFicheiros();
        fich.writeObjectFileArray(nomeFich, list);
    }
	*/
    void shutdown() {
        //grava ficheiros todos, termina o programa no final
    }
}