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
public class NaoDocente extends Funcionario implements Serializable{
    private String cargo;

    /**
     * Builder da classe NaoDocente
     * @param cargo Cargo do funcionário não docente (ex: secretaria, financeiro, apoio técnico)
     * @param numeroMecanografico Número de identificação do funcionário
     * @param categoria Categoria à qual o funcionário pertence (ex: assistente operacional, assistente técnico, técnico superior, técnico de informática ou especialista de informática)
     * @param nome Nome do funcionário
     * @param email Email do funcionário
     */
    public NaoDocente(String cargo, int numeroMecanografico, String categoria, String nome, String email) {
        super(numeroMecanografico, categoria, nome, email);
        this.cargo = cargo;
    }

    /**
     * 
     * @return Devolve o cargo do funcionário
     */
    public String getCargo() {
        return cargo;
    }

    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente
        return 3;
    }    
}
