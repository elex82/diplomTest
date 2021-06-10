package ru.sapteh.generate;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateValue {
    int defaultString =10;
    int defaultInt=100;

    public String generateString(String str){
        try {

        if (Integer.parseInt(str) < defaultString){
            this.defaultString= Integer.parseInt(str);
        }
        } catch (NumberFormatException e) {

        }
        byte [] b = new byte[defaultString];
        byte buf;
        for (int j = 0; j < defaultString; j++) {
            buf = ((byte) (97 + Math.random()*25));
            b[j] = buf;
        }
        this.defaultString = 10;
        return new String(b, StandardCharsets.UTF_8) ;
    }

    public static Date generateDate (){
        Date date= new Date();
        return new Date ( ( long ) ( Math.random ( ) * 1000000000) * 900 );
    }

    public String generateTime(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        return dateFormat.format(generateDate());

    }
    public String generateValueDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(generateDate());
    }


    public String generateDateTime(){
        return  generateValueDate()+" "+generateTime();
    }


    public String generateYear(){
        DateFormat dateFormat =new SimpleDateFormat("yyyy");
        return dateFormat.format(generateDate());
    }


    public String generateInt(String str ){
        try {
            if (Integer.parseInt(str) < defaultInt) {
                this.defaultInt = Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {

        }
        int a = (int) (Math.random()*defaultInt);
        this.defaultInt=100;
        return  String.valueOf(a);
    }
    public String generateFloat(){
        double a = Math.random();
        return String.valueOf(a);
    }


}
