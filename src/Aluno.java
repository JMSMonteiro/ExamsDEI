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
public class Aluno extends Pessoa implements Serializable{

    private int numero;
    private int matrícula;
    private Curso curso;
    private String regime;

    public Aluno(int numero, int matrícula, Curso curso, String regime, String nome, String email) {
        super(nome, email);
        this.numero = numero;
        this.matrícula = matrícula;
        this.curso = curso;
        this.regime = regime;
    }

    public boolean verificaRegime(){
        return regime.equals("trabalhador-estudante")||regime.equals("atleta")||regime.equals("dirigente associativo");
    }

    public int getNumero() {
        return numero;
    }

    public int getMatrícula() {
        return matrícula;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getRegime() {
        return regime;
    }

    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente 0 pessoas
        return 1;
    }

}
