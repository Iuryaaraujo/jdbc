package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlteraNomePessoas {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o codigo de pessoas: ");
        int codigo = sc.nextInt();

        String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String updateSQL = "UPDATE pessoas SET nome = ? WHERE CODIGO = ?";

        Connection connection = DAOConexao.getConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, codigo);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            Pessoa p = new Pessoa(resultSet.getInt(1), resultSet.getString(2));
            System.out.println("O nome atual é " + p.getNome());
            sc.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = sc.nextLine();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, novoNome);
            preparedStatement.setInt(2,codigo);
            preparedStatement.execute();
            System.out.println("Pessoa alterada com sucesso!");
        }else {
            System.out.println("Pessoa não encontrada");
        }
    }
}
