package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectPostgreSQL {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5050/", System.getenv("db-user"), System.getenv("db-password"));
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM product");
            while (res.next())
                System.out.println("name: " + res.getString(1) + ",  " + "age: " + res.getInt(2) + ",  " + "verified: " + res.getBoolean(3));
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
