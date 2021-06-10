package ru.sapteh.generate;

import ru.sapteh.model.Column;
import ru.sapteh.model.ForinKey;
import ru.sapteh.model.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateValueTable {
    GenerateValue generateValue = new GenerateValue();
    List<String> str = new ArrayList<>();

    public List<Table> generate(List<Table> tableListt) {
        for (int i = 0; i < tableListt.size(); i++) {
            for (int j = 0; j < tableListt.get(i).getColumnList().size(); j++) {
                        generateColumnValue(tableListt.get(i).getColumnList().get(j));
                        try {
                            if (!tableListt.get(i).getColumnList().get(j).getForinKey().getColumn().equals("")){
                                tableListt.get(i).getColumnList().get(j).getValueColumn().clear();

                            }

                        } catch (Exception e) {

                        }

            }
        }
        return tableListt;
    }

    public Column generateValuePK(Column column) {
        if (column.getKey().equals("PRI")) {
            Set<String> set = new HashSet<>();
            set.addAll(column.getValueColumn());
            column.getValueColumn().clear();
            column.getValueColumn().addAll(set);
        }
        return column;

    }

    public List<String> generateFK(List<Table> tableList, Column column) {
        return null;
    }

    public void generateColumnValue(Column column) {
        switch (column.getType()) {
            case "int", "tinyint", "smallint", "bigint" -> {
                column.getValueColumn().add(generateValue.generateInt(column.getLength()));
            }
            case "char", "longtext", "mediumtext", "tinytext", "varchar" -> {
                column.getValueColumn().add(generateValue.generateString(column.getLength()));
            }
            

        }
    }
}
