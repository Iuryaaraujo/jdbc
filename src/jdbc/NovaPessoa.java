package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome:");
        String nome = sc.nextLine();

        Connection connection = DAOConexao.getConexao();

        String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?,?)";
        // Sempre usa o PreparedStatement porque é a forma mais segura
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2,100);
        preparedStatement.execute();
        System.out.println("Pessoa incluida com sucesso!");
        sc.close();
    }
}
