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

    public NaoDocente(String cargo, int numeroMecanografico, String categoria, String nome, String email) {
        super(numeroMecanografico, categoria, nome, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public int tipoPessoa() { // 1 para aluno 2 para docente 3 para naodocente
        return 3;
    }    
}
