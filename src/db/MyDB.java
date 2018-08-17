package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB {
     private static Connection conn;
     private static final String DRIVER="com.mysql.jdbc.Driver";
     private static final String URL="jdbc:mysql://localhost:3306/mydb";
     private static final String NAME="root";
     private static final String PASSWORD="root";
     static {
         try {
             Class.forName(DRIVER);
             conn= DriverManager.getConnection(URL,NAME,PASSWORD);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public static Connection getConnection(){
         return conn;
     }

}
