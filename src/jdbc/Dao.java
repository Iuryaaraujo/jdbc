package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

    private Connection connection;

    public int incluir(String sql, Object... atributos) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(statement, atributos);

            if (statement.executeUpdate() > 0){
                ResultSet resultSet = statement.getGeneratedKeys();

                if (resultSet.next()){
                    return resultSet.getInt(1);
                }
            }
            return -1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void close(){
        try {
            getConnection().close();
        } catch (SQLException e) {

        }finally {
            connection = null;
        }
    }
    private void adicionarAtributos(PreparedStatement statement, Object[] atributos) throws SQLException {
        int indice = 1;
        for (Object atributo: atributos){
            if (atributo instanceof String){
                statement.setString(indice, (String) atributo);
            } else if (atributo instanceof Integer) {
                statement.setInt(indice, (Integer) atributo);
            }
            indice++;
        }
    }
    private Connection getConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection = DAOConexao.getConexao();
        return connection;
    }
}
