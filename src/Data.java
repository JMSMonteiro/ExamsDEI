/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jmmonteiro
 */
public class Data implements Serializable{

    private Calendar cal;

    public Data() {
    }

    public Data(int ano, int mes, int dia, int hora, int minuto) {
        cal = new GregorianCalendar(ano, mes, dia, hora, minuto);

        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.HOUR, hora);
        cal.set(Calendar.MINUTE, mes);

        //cal.set(ano, mes-1, dia, hora, minuto);
        //cal.setTimeInMillis(0);
        //tem de ser testado
    }

    public Data consideraDuraçao(int duraçao) {
        Data dataFim = new Data();
        dataFim.cal = this.cal;
        dataFim.cal.add(Calendar.MINUTE, duraçao);
        return dataFim;
    }

    public boolean depois(Data data) {
        if (data.cal.after(this.cal)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean antes(Data data) {
        if (data.cal.before(this.cal)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> protegeData(String date) {
        Matcher m = Pattern.compile("\\d+").matcher(date);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }

        if (numbers.size() == 5) {
            return numbers;
        }
        return null;//isto devia retornar null mas acho que da merda se o fizer
    }

    public boolean disponibilidadeSala(Data data, int duraçao, Sala sala) {
        boolean livre = true;
        ArrayList<Data> horario = sala.getHorario();
        ArrayList<Integer> duraçoes = sala.getDuracao();

        Data ocupada, dataFim, fimData;     //dataFim -  hora a que acaba o exame do horario 
        //fimData - hora a que acaba o exame que queremos inscrever
        //ocupada - hora a que começa o exame do horario
        int durante, i = 0;

        if (horario == null) {
            return livre;
        }
        while (i < horario.size() && livre != false) {
            ocupada = horario.get(i);
            durante = duraçoes.get(i);
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

    public boolean disponibilidadeDocente(ArrayList<Exame> examesDocente, int duraçao) {
        boolean livre = true;
        int i = 0;
        Exame exame;
        Data fimDocente, fimExame, dataExame;
        while (i < examesDocente.size() || livre == true) {
            exame = examesDocente.get(i);
            dataExame = exame.getData();//data dos exames em que o docente ja esta incrito
            fimExame = exame.getData().consideraDuraçao(exame.getDuracao());//fim da data dos exames em que o docente esta inscrito
            fimDocente = this.consideraDuraçao(duraçao);    //fim da data do exame em que o queremos meter (data desta classe)
            if (this.antes(dataExame)) {
                if (fimDocente.depois(fimExame)) {
                    livre = false;
                } else if (fimDocente.depois(dataExame) && fimDocente.antes(fimExame)) {
                    livre = false;
                }

            } else if (this.depois(dataExame)) {
                if (fimDocente.antes(fimExame) || this.antes(fimExame)) {
                    livre = false;
                }
            }
        }
        return livre;
    }

    public Calendar getCal() {
        return cal;
    }

}
