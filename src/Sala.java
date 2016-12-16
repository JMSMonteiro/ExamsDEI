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
public class Sala implements Serializable{

    private String departamento;
    private String nome;
    private ArrayList<Data> horario = new ArrayList<>();

    private ArrayList<Integer> duracao = new ArrayList<>();

    public Sala() {
    }

    public Sala(String departamento, String nome) {
        super();
        this.departamento = departamento;
        this.nome = nome;
    }

    public boolean disponibilidade(Data data, int duraçao) {
        boolean livre = true;
        Data ocupada, dataFim, fimData;     //dataFim -  hora a que acaba o exame do horario 
        //fimData - hora a que acaba o exame que queremos inscrever
        //ocupada - hora a que começa o exame do horario
        int durante, i = 0;

        if (horario == null) {
            return livre;
        }
        while (i < horario.size() && livre != false) {
            ocupada = horario.get(i);
            durante = duracao.get(i);
            dataFim = ocupada.consideraDuraçao(durante);
            fimData = data.consideraDuraçao(duraçao);
            if (ocupada.antes(data) && dataFim.depois(fimData)) {
                livre = false;
            } else if (ocupada.depois(data) && ocupada.antes(fimData)) {
                livre = false;
            }
            i++;
        }
        return livre;
    }

    public void setHorario(Data data, int duraçao) {
        this.horario.add(data);
        this.duracao.add(duraçao);
    }

    public boolean compNome(String nome) {
        return nome.equals(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(ArrayList<Data> horario) {
        this.horario = horario;
    }

    public void setDuracao(ArrayList<Integer> duracao) {
        this.duracao = duracao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public ArrayList<Data> getHorario() {
        return horario;
    }

    public ArrayList<Integer> getDuracao() {
        return duracao;
    }

}
