package database;
import java.sql.*;

public class db {

    public static Connection conn(){

        String url, user, pass;
        url = "jdbc:mysql://localhost:3306/passwordManager";
        user = "root";
        pass = "";

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Verbunden");

        } catch (Exception e) {

            System.out.println(e);
        }

        return con;
    }
}