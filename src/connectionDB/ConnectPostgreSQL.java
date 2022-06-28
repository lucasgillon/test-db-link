package connectionDB;

import java.sql.*;

public class ConnectPostgreSQL {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5050/", System.getenv("db-user"), System.getenv("db-password"));
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM person");
        while (res.next())
            System.out.println("name: " + res.getString(1) + ",  " + "age: " + res.getInt(2) + ",  " + "verified: " + res.getBoolean(3));
        conn.close();
    }
}
