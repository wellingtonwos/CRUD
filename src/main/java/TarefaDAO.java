import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    public void criar(Tarefa tarefa) throws SQLException {
        String sql = "INSERT INTO Tarefas (titulo, descricao, status, projeto_id, categoria_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setInt(4, tarefa.getProjetoId());
            stmt.setInt(5, tarefa.getCategoriaId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) tarefa.setId(rs.getInt(1));
            }
        }
    }

    public List<Tarefa> buscarTodos() throws SQLException {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM Tarefas";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tarefa t = new Tarefa();
                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setDescricao(rs.getString("descricao"));
                t.setStatus(rs.getString("status"));
                t.setProjetoId(rs.getInt("projeto_id"));
                t.setCategoriaId(rs.getInt("categoria_id"));
                tarefas.add(t);
            }
        }
        return tarefas;
    }

    public void atualizar(Tarefa tarefa) throws SQLException {
        String sql = "UPDATE Tarefas SET titulo = ?, descricao = ?, status = ?, projeto_id = ?, categoria_id = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setInt(4, tarefa.getProjetoId());
            stmt.setInt(5, tarefa.getCategoriaId());
            stmt.setInt(6, tarefa.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Tarefas WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

