package com.example.chatapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_MySQL {


        static String user = "root";
        static String password = "wafae@123";
        static String url = "jdbc:mysql://localhost:3306/projet_java";
        static String driver = "com.mysql.jdbc.Driver";

        public static Connection getConnection() {

            Connection con = null;
            try {
                Class.forName(driver);
                try {
                    con = DriverManager.getConnection(url,user,password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            return con;
        }
    }


