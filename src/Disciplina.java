/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.util.ArrayList;

/**
 *
 * @author jmmonteiro
 */
public class Disciplina {
    private String nome;
    private Docente responsavel;
    private ArrayList<Docente> outros;
    private ArrayList<Aluno> inscritos;
    private ArrayList<Exame> exames;
    
    public Disciplina(){}

    public String getNome() {
        return nome;
    }

    public Docente getResponsavel() {
        return responsavel;
    }

    public ArrayList<Docente> getOutros() {
        return outros;
    }

    public ArrayList<Aluno> getInscritos() {
        return inscritos;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResponsavel(Docente responsavel) {
        this.responsavel = responsavel;
    }

    public void setOutros(ArrayList<Docente> outros) {
        this.outros = outros;
    }

    public void setInscritos(ArrayList<Aluno> inscritos) {
        this.inscritos = inscritos;
    }

    public void setExames(ArrayList<Exame> exames) {
        this.exames = exames;
    }
    
    
    
    
}
