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

    /**
     * Builder da classe Sala
     * @param departamento Departamento onde a sala se localiza
     * @param nome Nome da sala
     */
    public Sala(String departamento, String nome) {
        super();
        this.departamento = departamento;
        this.nome = nome;
    }

    /**
     * Verifica a disponibilidade da sala numa certa data, durante um certo tempo
     * @param data Data a averiguar se a sala está ocupada
     * @param duraçao Tempo que a sala é pretendida em minutos
     * @return devolve true caso a sala esteja livre na data pretendida, false caso esteja ocupada
     */
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

    /**
     * Adiciona um horário de ocupação à sala
     * @param data Data de ocupação
     * @param duraçao Periodo de ocupação em minutos
     */
    public void setHorario(Data data, int duraçao) {
        this.horario.add(data);
        this.duracao.add(duraçao);
    }

    /**
     * Compara o nome da sala com um nome fornecido
     * @param nome nome a ser comparado com o da sala
     * @return true se os nomes forem iguais, false caso sejam diferentes
     */
    public boolean compNome(String nome) {
        return nome.equals(this.nome);
    }

    /**
     * 
     * @return Devolve o nome da sala
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o parametro "departamento"
     * @param departamento Departamento onde a sala se localiza
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Define o parametro "nome"
     * @param nome Nome da sala
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o parametro "horario"
     * @param horario Horario de ocupação da sala
     */
    public void setHorario(ArrayList<Data> horario) {
        this.horario = horario;
    }

    /**
     * Define o parametro "duração"
     * @param duracao Tempo durante o qual a sala irá estar ocupada, em minutos
     */
    public void setDuracao(ArrayList<Integer> duracao) {
        this.duracao = duracao;
    }

    /**
     * 
     * @return Devolve o departamento onde a sala se localiza
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * 
     * @return Devovolve os horários em que a sala está ocupada
     */
    public ArrayList<Data> getHorario() {
        return horario;
    }

    /**
     * 
     * @return Devolve os periodos de ocupação da sala
     */
    public ArrayList<Integer> getDuracao() {
        return duracao;
    }

}
