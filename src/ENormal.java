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
public class ENormal extends Exame{
    
    public ENormal(Disciplina disciplina, int duracao) {
        super(disciplina, duracao);
    }
    
    @Override
    String epoca(){
        return "Normal";
    }
}
