package com.example.cmejercicio_1.utils;


import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Dates {
    public static Years returnAge(String birthday) {
        int anio = 2000;
        int mes = 1;
        int dia = 1;

        String[] d = birthday.split("/");

        if (!d[0].equals("")){
            anio = Integer.parseInt(d[0]);
        }
        if (!d[1].equals("")){
            mes =  Integer.parseInt(d[1]);;
        }
        if (!d[2].equals("")){
            dia =  Integer.parseInt(d[2]);;
        }

        if (mes > 12) {
            mes=6;
        }
        if(dia > 31 ){
            dia=15;
        }
        LocalDate birthdate = new LocalDate(anio, mes, dia);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);

        return age;

    }

}
