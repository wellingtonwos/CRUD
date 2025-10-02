import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    public void criar(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO Projetos (nome, descricao, usuario_id) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getUsuarioId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) projeto.setId(rs.getInt(1));
            }
        }
    }

    public List<Projeto> buscarTodos() throws SQLException {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM Projetos";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Projeto p = new Projeto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setUsuarioId(rs.getInt("usuario_id"));
                projetos.add(p);
            }
        }
        return projetos;
    }

    public void atualizar(Projeto projeto) throws SQLException {
        String sql = "UPDATE Projetos SET nome = ?, descricao = ?, usuario_id = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getUsuarioId());
            stmt.setInt(4, projeto.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Projetos WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
