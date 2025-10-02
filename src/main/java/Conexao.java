import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3312/banco_java";
    private static final String USER = "root";
    private static final String PASSWORD = "Wos031221Twd.";

    public static Connection getConnection() {
        try {
            // Tenta carregar o driver JDBC, necessário para versões mais antigas do Java
            // e boa prática para garantir que o driver está no classpath.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tenta estabelecer a conexão com o banco de dados.
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Exceção lançada se o driver JDBC do MySQL não for encontrado.
            System.err.println("Driver JDBC do MySQL não encontrado. Verifique suas dependências.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Exceção lançada se houver problemas na conexão com o banco.
            System.err.println("Erro ao conectar-se ao banco de dados.");
            // Oferece uma mensagem mais detalhada com base no código de erro SQL.
            System.err.println("Código do erro: " + e.getErrorCode());
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Retorna nulo se a conexão falhar.
    }
}