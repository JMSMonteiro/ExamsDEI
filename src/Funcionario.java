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
public class Funcionario extends Pessoa{
    private int numeroMecanografico;
    private String categoria;

    protected Funcionario(int numeroMecanografico, String categoria, String nome, String email) {
        super(nome, email);
        this.numeroMecanografico = numeroMecanografico;
        this.categoria = categoria;
    }

    public int getNumeroMecanografico() {
        return numeroMecanografico;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setNumeroMecanografico(int numeroMecanografico) {
        this.numeroMecanografico = numeroMecanografico;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
