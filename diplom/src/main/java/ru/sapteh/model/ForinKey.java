package ru.sapteh.model;

import java.util.List;

public class ForinKey {
   public String column;
   public String tableName;
   public String columnMain;

    public ForinKey() {

    }

    public ForinKey(String column, String tableName, String columnMain) {
        this.column = column;
        this.tableName = tableName;
        this.columnMain = columnMain;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnMain() {
        return columnMain;
    }

    public void setColumnMain(String columnMain) {
        this.columnMain = columnMain;
    }

}
