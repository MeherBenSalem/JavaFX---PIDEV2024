package com.example.projectpi.Connectors;

import java.sql.*;
public class MySQLConnector {

    private static MySQLConnector instance;
    private Connection cn;
    private final String databaseUrl = "localhost:3306";
    private final String username = "root";
    private final String password = "";
    private final String databaseName = "databasetest";

    private MySQLConnector() {
    }

    public static MySQLConnector getInstance(){
        if(instance == null)
            instance = new MySQLConnector();
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if(cn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://" + databaseUrl + "/" + databaseName
                    , username, password
            );
            System.out.println("Connected to Database");
        }
        return cn;
    }
}
