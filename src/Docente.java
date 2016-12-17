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
public class Docente extends Funcionario implements Serializable{
    private String areaInvestigacao;
    private ArrayList<Data> trabalho;

    /**
     * Builder da classe Docente
     * @param areaInvestigacao Área de investigação do docente
     * @param numeroMecanografico Número de identificação do docente
     * @param categoria Categoria do docente (ex:  assistente, auxiliar, associado ou catedrático)
     * @param nome  Nome do docente
     * @param email Email do docente
     * @param trabalho Horas ocupadas do docente
     */
    public Docente(String areaInvestigacao, int numeroMecanografico, String categoria, String nome, String email, ArrayList<Data> trabalho) {
        super(numeroMecanografico, categoria, nome, email);
        this.areaInvestigacao = areaInvestigacao;
        this.trabalho=trabalho;
    }
    
    /**
     * 
     * @param areaInvestigacao Área de investigação do docente
     */
    public void setAreaInvestigacao(String areaInvestigacao) {
        this.areaInvestigacao = areaInvestigacao;
    }
    
    /**
     * 
     * @param trabalho Horas ocupadas do docente
     */
    public void setTrabalho(ArrayList<Data> trabalho) {
        this.trabalho = trabalho;
    }

    /**
     * 
     * @return devolve o Arraylist de datas em que o docente está ocupado
     */
    public ArrayList<Data> getTrabalho() {
        return trabalho;
    }

    /**
     * 
     * @return devolve a String referente à área de investigação do docente
     */
    public String getAreaInvestigacao() {
        return areaInvestigacao;
    }
    

    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente
        return 2;
    }
    
}
