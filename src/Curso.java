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
public class Curso implements Serializable{

    private String nome;
    private String grau;
    private int duracao;
    private ArrayList<Disciplina> disciplinas;

    /**
     * Cria um novo curso.
     * @param nome Nome do curso.
     * @param grau Grau que este curso irá conferir.
     * @param duracao Duração do curso, em anos.
     * @param disciplinas Conjunto de disciplinas que fazem parte do curso.
     */
    public Curso(String nome, String grau, int duracao, ArrayList<Disciplina> disciplinas) {
        this.nome = nome;
        this.grau = grau;
        this.duracao = duracao;
        this.disciplinas = disciplinas;
    }

    /**
     * 
     * @return Devolve o nome do curso
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @return Devolve o grau que o curso confere
     */
    public String getGrau() {
        return grau;
    }

    /**
     * 
     * @return Devolve a duração do curso em anos
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * 
     * @return Devolve as disciplinas que constituem o curso
     */
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * Define as disciplinas do curso
     * @param disciplinas Disciplinas do curso
     */
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
