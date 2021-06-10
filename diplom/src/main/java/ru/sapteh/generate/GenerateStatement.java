package ru.sapteh.generate;

import ru.sapteh.model.Column;
import ru.sapteh.model.Table;

import java.util.ArrayList;
import java.util.List;

public class GenerateStatement {
    public void statement (List<Table> tableList){



            for (int i = 0; i < tableList.size(); i++) {
                System.out.println(i);
                System.out.println(tableList.get(i).getNameTable());
                try {
                    for (int j = 0; j < 100; j++) {
                        System.out.println(sqlValueTable(tableList.get(i), j));

                    }

                } catch (Exception e) {

                }
            }



    }
    public String sqlValueTable(Table table , int p){

        String sql1 = "INSERT INTO 'test'.'"+table.getNameTable()+"'(";
        for (int i = 0; i <table.getColumnList().size() ; i++) {
            if (i==table.getColumnList().size()-1){
                sql1= sql1+"'"+table.getColumnList().get(i).getField()+"')";
            }
            else {
                sql1 = sql1 + "'" + table.getColumnList().get(i).getField() + "',";
            }
        }
        sql1= sql1+"VALUES ('";
        for (int i = 0; i <table.getColumnList().size() ; i++) {
            if (i==table.getColumnList().size()-1){
                sql1= sql1+"'"+table.getColumnList().get(i).getValueColumn().get(p)+"');";
            }
            else {
                sql1 = sql1  + table.getColumnList().get(i).getValueColumn().get(p) + "',";
            }
        }



        ;
        return sql1;
    }

}
