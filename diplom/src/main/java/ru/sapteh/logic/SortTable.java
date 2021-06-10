package ru.sapteh.logic;

import ru.sapteh.logic.FillTable;
import ru.sapteh.model.Table;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortTable {
    public List<Table> sort(List<Table> tableList) throws SQLException, ClassNotFoundException {
        int baff = tableList.size();

        List<Table> listTable = new ArrayList<>();
        for (int q = 0; q < baff; q++) {


            for (int i = 0; i < tableList.size(); i++) {

                if (tableList.get(i).getForinKeyList().size() == 0) {
                    listTable.add(tableList.get(i));
                    tableList.remove(i);

                }
            }
            for (int i = 0; i < listTable.size(); i++) {
                for (int j = 0; j < tableList.size(); j++) {
                    for (int k = 0; k < tableList.get(j).getForinKeyList().size(); k++) {
                        if (listTable.get(i).getNameTable().equals(tableList.get(j).getForinKeyList().get(k).getTableName())) {
                            tableList.get(j).getForinKeyList().remove(k);
                        }
                    }
                }
            }
        }



     return fkColumn(fk(listTable));
    }
    public List<Table> fk(List<Table> listTable) throws SQLException, ClassNotFoundException {
        FillTable fillTable = new FillTable();
        for (int i = 0; i < listTable.size(); i++) {
            listTable.get(i).setForinKeyList(fillTable.fillForinkey(listTable.get(i).getNameTable()));

        }
        return listTable;
    }
    public List<Table> fkColumn(List<Table> listTable){
        for (int i = 0; i < listTable.size(); i++) {
            for (int j = 0; j < listTable.get(i).getForinKeyList().size(); j++) {
                for (int k = 0; k < listTable.get(i).getColumnList().size(); k++) {
                    if (listTable.get(i).getForinKeyList().get(j).getColumn().equals(listTable.get(i).getColumnList().get(k).getField())){
                        listTable.get(i).getColumnList().get(k).setForinKey(listTable.get(i).getForinKeyList().get(j));
                    }

                }

            }

        }
        return listTable;
    }


}
