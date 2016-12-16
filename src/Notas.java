/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.io.Serializable;

/**
 *
 * @author jmmonteiro
 */
public class Notas implements Serializable{
    private Aluno aluno;
    private float nota;

    /**
     * Builder da classe Notas
     * @param aluno Objeto da classe Aluno
     * @param nota nota que o aluno teve. Valor entre 0 e 20. Poderá ter casas decimais
     */
    public Notas(Aluno aluno, float nota) {
        this.aluno = aluno;
        this.nota = nota;
    }
    
    //get & set
    /**
     * define o aluno 
     * @param aluno define o objeto da classe Aluno.
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    /**
     * define o valor da nota que o aluno teve.
     * @param nota Valor da nota do aluno, vai de 0 a 20. Poderá ter casas decimais
     */
    public void setNota(float nota) {
        this.nota = nota;
    }
    
    /**
     * Devolve o Objeto da classe Aluno
     * @return devolve o Objeto aluno
     */
    public Aluno getAluno() {
        return aluno;
    }
    
    /**
     * Devolve o valor float da nota
     * @return devolve o valor da nota (float)
     */
    public float getNota() {
        return nota;
    }
    
}
