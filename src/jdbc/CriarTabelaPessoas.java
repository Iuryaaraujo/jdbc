package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
    public static void main(String[] args) throws SQLException {
        Connection connection = DAOConexao.getConexao();
        // Test blocks java 13
        String sql = """
                CREATE TABLE IF NOT EXISTS pessoas(
                codigo INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(80) NOT NULL
                );
                """;
        // Use preparestatement forma segura de registra dados e não statement

        Statement statement = connection.createStatement();
        statement.execute(sql);

        System.out.println("Tabela criada com sucesso!");
        connection.close();
    }
}
