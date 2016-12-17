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

    /**
     * 
     * @return Devolve o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return Devolve o email da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define parametro "nome"
     * @param nome Nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o parametro "email"
     * @param email Email da pessoa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return Tipo de pessoa, 1 = aluno, 2 = docente, 3 = nao docente, 0 = pessoa
     */
    public int tipoPessoa(){ // 1 para funcionario 2 para aluno 3 pessoa 0 pessoa
        return 0;
    }
    
}
