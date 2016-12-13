/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

/**
 *
 * @author jmmonteiro
 */
public class Notas {
    private Aluno aluno;
    private int nota;

    public Notas(Aluno aluno, int nota) {
        this.aluno = aluno;
        this.nota = nota;
    }
    
    //get & set
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public int getNota() {
        return nota;
    }
    
}
