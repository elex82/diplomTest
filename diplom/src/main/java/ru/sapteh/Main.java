package ru.sapteh;

import ru.sapteh.generate.GenerateStatement;
import ru.sapteh.generate.GenerateValue;
import ru.sapteh.generate.GenerateValueTable;
import ru.sapteh.logic.FillTable;
import ru.sapteh.logic.SortTable;
import ru.sapteh.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {





     public static void main(String[] args)throws SQLException, ClassNotFoundException {
         FillTable fillTable = new FillTable();
         List <Table> tableList=fillTable.fill();
         SortTable sortTable = new SortTable();
         List<Table> tableList1 =new ArrayList<>();
         GenerateValueTable generateValueTable = new GenerateValueTable();
         GenerateStatement generateStatement = new GenerateStatement();




         tableList1.addAll(sortTable.sort(tableList));
         generateStatement.statement(generateValueTable.generate(tableList1));


//         for (int i = 0; i < tableList1.size(); i++) {
//             System.out.println(tableList1.get(i).getNameTable());
//             System.out.println();
//             System.out.println();
//             for (int j = 0; j < tableList1.get(i).getColumnList().size(); j++) {
//                 try {
//                     for (int k = 0; k < tableList1.get(i).getColumnList().get(j).getValueColumn().size(); k++) {
////                         System.out.println(tableList1.get(i).getColumnList().get(j).getForinKey().getColumn());
//                     }
//                     System.out.println(tableList1.get(i).getColumnList().get(j).getField()+"    "+tableList1.get(i).getColumnList().get(j).getType()+"   "+tableList1.get(i).getColumnList().get(j).getValueColumn().size() );
//
//                 } catch (Exception e) {
//
//                 }
//

//             }

//         }

     }

}
