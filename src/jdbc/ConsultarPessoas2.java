package jdbc;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Connection connection = DAOConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome like ?";

        System.out.println("Informe o valor pra pesquisa: ");
        String pesquisa = sc.nextLine();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + pesquisa + "%");
        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String nome = resultSet.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + "==> " + p.getNome());
        }
        statement.close();
        connection.close();
        sc.close();
    }
}
