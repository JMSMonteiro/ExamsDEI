/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author jmmonteiro
 */
public class Exame implements Serializable{

    private Disciplina disciplina;
    private Data data;
    private int duracao;
    private Sala sala;
    private Docente responsavel;
    private ArrayList<Docente> vigilantes;
    private ArrayList<NaoDocente> apoio;
    private ArrayList<Aluno> inscritos;
    private ArrayList<Notas> notas;

    /**
     * Builder da classe
     * @param disciplina Disciplina a qual o exame pertence
     * @param duracao Duração do exame em minutos
     */
    public Exame(Disciplina disciplina, int duracao) {
        this.disciplina = disciplina;
        this.duracao = duracao;
    }
    
    /**
     * 
     * @return Nome da disciplina à qual o exame pertence
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Adiciona um aluno à lista de inscritos
     * @param aluno Objeto da classe Aluno a ser adicionado
     */
    public void adicionaAluno(Aluno aluno) {
        this.inscritos.add(aluno);
    }
    
    /**
     * 
     * @return Data na qual o exame se realiza
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @return Duração do exame em minutos
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * 
     * @return Objeto da calsse Sala, onde o exame será realizado
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * 
     * @return Objeto da classe Docente, docente responsavel pelo exame
     */
    public Docente getResponsavel() {
        return responsavel;
    }
    
    /**
     * 
     * @return Arraylist de objetos da classe Docente, docentes responsaveis por vigiar o exame
     */
    public ArrayList<Docente> getVigilantes() {
        return vigilantes;
    }

    /**
     * 
     * @return ArrayList de objetos da classe NaoDocente, funcionários auxiliares, de apoio ao exame
     */
    public ArrayList<NaoDocente> getApoio() {
        return apoio;
    }

    /**
     * 
     * @return Arraylist de objetos da classe Aluno, alunos inscritos no exame
     */
    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    /**
     * 
     * @return ArrayList da classe Notas, Alunos e respetivas notas
     */
    public ArrayList<Notas> getNotas() {
        return notas;
    }

    /**
     * 
     * @param disciplina Disciplina à qual o exame está associado
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * 
     * @param data Data em que o exame se realiza
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * 
     * @param duracao Duração do exame em minutos
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * 
     * @param sala Sala onde o exame se realiza
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    /**
     * 
     * @param responsavel Docente responsavel pelo exame
     */
    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * 
     * @param vigilantes Vigilantes do exame
     */
    public void setVigilantes(ArrayList<Docente> vigilantes) {
        this.vigilantes = vigilantes;
    }

    /**
     * 
     * @param apoio Funcionários Não docentes de apoio ao exame
     */
    public void setApoio(ArrayList<NaoDocente> apoio) {
        this.apoio = apoio;
    }

    /**
     * 
     * @param inscritos Alunos inscritos no exame
     */
    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }

    /**
     * 
     * @param notas Notas obtidas no exame
     */
    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    /**
     * Lança Notas do exame
     * @return true ou false, dependendo se consegue atribuir as notas ou se houve algum problema
     */
    public boolean atribuiNotas() {
        Notas nota;
        float cotaçao;
        Scanner sc = new Scanner(System.in);
        if(inscritos.isEmpty()){
            System.out.println("Não existem Alunos inscritos neste Exame.");
            return false;
        }
        for (Aluno aluno : inscritos) {
            do {
                System.out.print("\nNota obtida pelo Aluno " + aluno.getNome() + ": ");
                cotaçao = sc.nextInt();
                if(cotaçao>20 ||cotaçao<0){
                    System.out.println("Só são aceites cotações entre 0 e 20 valores.");
                }
                else{
                    break;
                }
            } while(true);
            nota = new Notas(aluno, cotaçao);
            notas.add(nota);
        }
        if(inscritos.isEmpty()){
            System.out.println("Ocorreu um erro ao lançar as notas.");
            return false;
        }
        return true;
    }
    
    /**
     * Adiciona um docente à lista de vigilantes
     * @param docente Docente a ser adicionado
     */
    public void addVigilante(Docente docente){
        this.vigilantes.add(docente);
    }
    
    /**
     * Adiciona um não docente à lista de funcionários de apoio
     * @param naoDocente Não docente a ser adicionado
     */
    public void addApoio(NaoDocente naoDocente){
        this.apoio.add(naoDocente);
    }

    /**
     * Método utilizado para obter a época em que o exame se realiza.
     *
     * @return Devolve a época em que o exame é realizado no formato String.
     */
    String epoca() {
        return null;
    }
    /*
    void configSala(ArrayList<Sala> salas, Data data) {
        for (Sala aux : salas) {
            //se a sala está ocupada durante o exame que estamos a configurar
        }
    }*/

    //Lista alunos e respectivas notas
    /**
     * Imprime todos os alunos e as respectivas notas, caso existam
     */
    public void listaAlunos() {
        System.out.println("Alunos inscritos:\n\n");
        for (Notas aux : notas) {
            Aluno al = aux.getAluno();
            System.out.print("-" + al.getNome());
            if (aux.getNota() != -1) {
                System.out.print("; Nota: " + aux.getNota());
            }
            System.out.println("");
        }
    }

    //lista funcionários docentes, e não docentes
    /**
     * Imprime todos os funcionários associados ao exame, sendo eles docentes ou não docentes
     */
    public void listaFuncionarios() {
        System.out.println("Funcionários associados ao exame:\n\n");
        System.out.println("Docentes:\n");
        for (Docente aux : vigilantes) {
            System.out.println("-" + aux.getNome());
        }
        System.out.println("Não Docentes:\n");
        for (NaoDocente aux : apoio) {
            System.out.println("-" + aux.getNome());
        }
    }
    /*
    //lançar as notas
    public void lancaNotas() {
        System.out.println("Por favor Insira as notas aluno a aluno.");
        Scanner sc = new Scanner(System.in);
        for(Notas n : this.notas) {
            System.out.print(n.getAluno().getNome() + "Nota atribuida: ");
            int nota = sc.nextInt();
            System.out.println("");
            n.setNota(nota);
        }
    }*/
    
    //lista todas as notas obtidas no exame
    /**
     * Imprime todas as notas obtidas no exame (números apenas)
     */
    public void listaNotas() {
        System.out.println("Notas do exame:\n\n");
        for (Notas aux : notas) {
            System.out.println("-" + aux.getNota());
        }
    }
    
    @Override
    public String toString(){
    return "Época: " + epoca()
            + "\nDisciplina: " + disciplina
            + "\nData de realização: " + data.getCal().toString()
            + "\nDuracao: " + duracao
            + "\nSala: " + sala.getNome()
            + "\nNumero de Vigilantes: " + vigilantes.size()
            + "\nNumero de Alunos: " + inscritos.size();
    }
     
}
