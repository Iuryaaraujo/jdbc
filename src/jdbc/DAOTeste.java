package jdbc;

public class DAOTeste {
    public static void main(String[] args) {
        Dao dao = new Dao();

        String sql = "Insert into pessoas (nome, codigo) Values (?, ?)";
        System.out.println(dao.incluir(sql, "João da Silva", 1000));
        System.out.println(dao.incluir(sql, "Ana Julia", 1001));
        System.out.println(dao.incluir(sql, "Djalma Pereira",1002));

        dao.close();
    }
}
