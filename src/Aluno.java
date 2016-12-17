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

    /**
     * 
     * @param numero Número de identificação do aluno
     * @param matrícula Número de matrículas no curso
     * @param curso Curso em que o aluno está inscrito
     * @param regime Regime sob o qual o aluno está inscrito (ex: normal, trabalhador estudante, atleta, ...)
     * @param nome Nome do aluno
     * @param email Email do aluno
     */
    public Aluno(int numero, int matrícula, Curso curso, String regime, String nome, String email) {
        super(nome, email);
        this.numero = numero;
        this.matrícula = matrícula;
        this.curso = curso;
        this.regime = regime;
    }

    /**
     * 
     * @return Devolve true caso o aluno esteja num regine não "normal"
     */
    public boolean verificaRegime(){
        return regime.equals("trabalhador-estudante")||regime.equals("atleta")||regime.equals("dirigente associativo");
    }

    /**
     * 
     * @return Devolve o número de identificação do aluno
     */
    public int getNumero() {
        return numero;
    }

    /**
     * 
     * @return Devolve o número de matriculas do aluno
     */
    public int getMatrícula() {
        return matrícula;
    }

    /**
     * 
     * @return Devolve o curso em que o aluno está inscrito
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * 
     * @return devolve o regime sob o qual o aluno é abrangido
     */
    public String getRegime() {
        return regime;
    }

    /**
     * 
     * @return Tipo de pessoa, 1 = aluno, 2 = docente, 3 = nao docente, 0 = pessoa
     */
    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente 0 pessoas
        return 1;
    }

}
