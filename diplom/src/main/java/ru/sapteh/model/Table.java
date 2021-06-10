package ru.sapteh.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Table {
     String nameTable;
     List<Column> columnList=new ArrayList<>();
     List<ForinKey> forinKeyList= new ArrayList<>();
     List<String> valueTable= new ArrayList<>();

     public List<String> getValueTable() {
          return valueTable;
     }

     public void setValueTable(List<String> valueTable) {
          this.valueTable = valueTable;
     }

     public Table() {

     }

     public Table(String nameTable, List<Column> columnList, List<ForinKey> forinKeyList) {
          this.nameTable = nameTable;
          this.columnList = columnList;
          this.forinKeyList = forinKeyList;
     }


     public String getNameTable() {
          return nameTable;
     }

     public void setNameTable(String nameTable) {
          this.nameTable = nameTable;
     }

     public List<Column> getColumnList() {
          return columnList;
     }

     public void setColumnList(List<Column> columnList) {
          this.columnList = columnList;
     }

     public List<ForinKey> getForinKeyList() {
          return forinKeyList;
     }

     public void setForinKeyList(List<ForinKey> forinKeyList) {
          this.forinKeyList = forinKeyList;
     }
}
