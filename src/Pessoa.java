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
public class Pessoa implements Serializable{
    private String nome;
    private String email;
    
    /**
     * Builder para a classe Pessoa.
     * @param nome Nome da pessoa.
     * @param email  E-mail da pessoa.
     */
    protected Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }   

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int tipoPessoa(){ // 1 para funcionario 2 para aluno 3 pessoa 0 pessoa
        return 0;
    }
    
}
