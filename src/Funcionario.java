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
public class Funcionario extends Pessoa implements Serializable{
    private int numeroMecanografico;
    private String categoria;

    /**
     * 
     * @param numeroMecanografico Número de identificação do funcionário
     * @param categoria categoria a que o funcionário pertence
     * @param nome Nome do funcionário
     * @param email Email do funcionário
     */
    protected Funcionario(int numeroMecanografico, String categoria, String nome, String email) {
        super(nome, email);
        this.numeroMecanografico = numeroMecanografico;
        this.categoria = categoria;
    }

    /**
     * 
     * @return Devolve o número de identificação do funcionário
     */
    public int getNumeroMecanografico() {
        return numeroMecanografico;
    }

    /**
     * 
     * @return Devolve a categoria do funcionário
     */
    public String getCategoria() {
        return categoria;
    }
    
    /**
     * Define o parametro "numeroMecanografico"
     * @param numeroMecanografico Número de identificação do funcionário
     */
    public void setNumeroMecanografico(int numeroMecanografico) {
        this.numeroMecanografico = numeroMecanografico;
    }

    /**
     * Define o parametro "categoria"
     * @param categoria Categoria do funcionário
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
