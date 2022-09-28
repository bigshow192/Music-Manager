package com.example.musicmanager.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSql {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=MusicManager;"
            + "integratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "duy123456";
    public Connection conn() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        return conn;
    }
}
