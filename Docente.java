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
public class Docente extends Funcionario{
    private String areaInvestigacao;
    private ArrayList<Data> trabalho;

    public Docente(String areaInvestigacao, int numeroMecanografico, String categoria, String nome, String email, ArrayList<Data> trabalho) {
        super(numeroMecanografico, categoria, nome, email);
        this.areaInvestigacao = areaInvestigacao;
        this.trabalho=trabalho;
    }

    public void setAreaInvestigacao(String areaInvestigacao) {
        this.areaInvestigacao = areaInvestigacao;
    }

    public void setTrabalho(ArrayList<Data> trabalho) {
        this.trabalho = trabalho;
    }

    public ArrayList<Data> getTrabalho() {
        return trabalho;
    }

    public String getAreaInvestigacao() {
        return areaInvestigacao;
    }
    

    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente
        return 2;
    }
    
}
