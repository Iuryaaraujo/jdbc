package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3307?verifyServerCertificate=false&useSSl=true";
        final String user = "root";
        final String password = "root";

        Connection connection = DriverManager
                .getConnection(url, user, password);


        Statement stmt = connection.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

        System.out.println("Banco criador com sucessor!");
        connection.close();
    }
}
