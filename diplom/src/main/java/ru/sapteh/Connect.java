package ru.sapteh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static  String URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    public static  String DRIVER="com.mysql.cj.jdbc.Driver";
    public static  String LOGIN="root";
    public static  String PASSWORD="1234";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Class.forName(DRIVER);
        connection= DriverManager.getConnection(URL,LOGIN,PASSWORD);
        return connection;
    }
    public void closeConnection(Connection connection){
        if (connection==null)return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
