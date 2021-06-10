package ru.sapteh.logic;

import ru.sapteh.Connect;
import ru.sapteh.model.Column;
import ru.sapteh.model.ForinKey;
import ru.sapteh.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FillTable {
    Connection connection;
    public List<Table> fill() throws SQLException, ClassNotFoundException {
        connection = Connect.getConnection();
        String sqlh="SHOW TABLES ";
        List<Table> tableList =new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(sqlh);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            String str = resultSet.getString(1);
             tableList.add(new Table(str,fillColumn("testtyp", str),fillForinkey(str)));
        }

        return tableList;
    }

    public List<Column>fillColumn(String name, String tableName) throws SQLException, ClassNotFoundException {
        connection = Connect.getConnection();
        List<Column> columnList = new ArrayList<>();
        String sqlh="SELECT COLUMN_NAME,COLUMN_DEFAULT, " +
                "IS_NULLABLE, DATA_TYPE," +
                " CHARACTER_MAXIMUM_LENGTH, " +
                "COLUMN_KEY, EXTRA FROM information_schema.COLUMNS" +
                " where TABLE_SCHEMA = 'test' and TABLE_NAME= '" +tableName+"'";
        PreparedStatement statement = connection.prepareStatement(sqlh);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
                Column column = new Column(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
                columnList.add(column);
        }
        return columnList;
    }

    public List<ForinKey> fillForinkey(String str) throws SQLException, ClassNotFoundException {
        connection = Connect.getConnection();
        String sqlh="SELECT " +
                "TABLE_NAME, " +
                "COLUMN_NAME, " +
                "REFERENCED_TABLE_NAME," +
                " REFERENCED_COLUMN_NAME " +
                "FROM " +
                "INFORMATION_SCHEMA.KEY_COLUMN_USAGE" +
                " where TABLE_SCHEMA = '"+"test"+"' and POSITION_IN_UNIQUE_CONSTRAINT and TABLE_NAME ='"+str+"'";
        PreparedStatement statement = connection.prepareStatement(sqlh);
        ResultSet resultSet = statement.executeQuery();


        List <ForinKey> forinK = new ArrayList<>();
        if (!resultSet.equals(null)) {
            while (resultSet.next()){
                forinK.add(new ForinKey(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
        }
      return forinK ;
    }
}
