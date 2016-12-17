/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jmmonteiro
 */
public class Disciplina implements Serializable{
    private String nome;
    private Docente responsavel;
    private ArrayList<Docente> docentes;
    private ArrayList<Aluno> inscritos;
    private ArrayList<Exame> exames;
    
    public Disciplina(){}

    /**
     * Builder para a classe Disciplina
     * @param nome Nome da disciplina
     * @param responsavel Docente responsável pela disciplina
     * @param docentes Lista de docentes que lecionam a disciplina
     * @param inscritos Lista de alunos inscritos na disciplina
     * @param exames Lista de exames da disciplinaa
     */
    public Disciplina(String nome, Docente responsavel, ArrayList<Docente> docentes, ArrayList<Aluno> inscritos, ArrayList<Exame> exames) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.docentes = docentes;
        this.inscritos = inscritos;
        this.exames = exames;
    }
    
    /**
     * 
     * @return Devolve o nome da disciplina 
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return Devolve o docente responsável pela disciplina
     */
    public Docente getResponsavel() {
        return responsavel;
    }

    /**
     * 
     * @return Devolve a lista de docentes que lecionam a disciplina
     */
    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    /**
     * 
     * @return Devolve a lista de alunos inscritos na disciplina
     */
    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    /**
     * 
     * @return Devolve a lista de exames da disciplina
     */
    public ArrayList<Exame> getExames() {
        return exames;
    }

    /**
     * 
     * @param nome Nome da disciplina
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @param responsavel Docente responsável pela disciplina
     */
    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }
    
    /**
     * 
     * @param docentes Lista de docentes que lecionam a disciplina
     */
    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    /**
     * 
     * @param inscritos Lista de alunos inscritos na disciplina
     */
    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }

    /**
     * 
     * @param exames Lista de exames da disciplina
     */
    public void setExames(ArrayList<Exame> exames) {
        this.exames = exames;
    }
    
    
    
    
}
