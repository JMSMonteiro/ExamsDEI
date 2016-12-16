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

    public Exame(Disciplina disciplina, int duracao) {
        this.disciplina = disciplina;
        this.duracao = duracao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void adicionaAluno(Aluno aluno) {
        this.inscritos.add(aluno);
    }
    
    public Data getData() {
        return data;
    }

    public int getDuracao() {
        return duracao;
    }

    public Sala getSala() {
        return sala;
    }

    public Docente getResponsavel() {
        return responsavel;
    }

    public ArrayList<Docente> getVigilantes() {
        return vigilantes;
    }

    public ArrayList<NaoDocente> getApoio() {
        return apoio;
    }

    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

    public void setVigilantes(ArrayList<Docente> vigilantes) {
        this.vigilantes = vigilantes;
    }

    public void setApoio(ArrayList<NaoDocente> apoio) {
        this.apoio = apoio;
    }

    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

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

    public void addVigilante(Docente docente){
        this.vigilantes.add(docente);
    }
    
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

    void configSala(ArrayList<Sala> salas, Data data) {
        for (Sala aux : salas) {
            //se a sala está ocupada durante o exame que estamos a configurar
        }
    }

    //Lista alunos e respectivas notas
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
