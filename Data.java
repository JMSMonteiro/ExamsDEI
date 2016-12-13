/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jmmonteiro
 */
public class Data {

    private Calendar cal;

    public Data() {
    }

    public Data(int ano, int mes, int dia, int hora, int minuto) {
        cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(ano, mes, dia, hora, minuto); //tem de ser testado

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
        return numbers;//isto devia retornar null mas acho que da merda se o fizer
    }

    public Calendar getCal() {
        return cal;
    }
    

}
