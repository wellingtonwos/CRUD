import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // --- C: Create (Criar) ---
            Usuario novoUsuario = new Usuario();
            usuarioDAO.criar(novoUsuario);
            System.out.println("Usuário criado com sucesso: " + novoUsuario.getNome());

            // --- R: Read (Ler) ---
            System.out.println("\nLista de usuários:");
            List<Usuario> usuarios = usuarioDAO.buscarTodos();
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", Email: " + u.getEmail());
            }

            // --- U: Update (Atualizar) ---
            if (!usuarios.isEmpty()) {
                Usuario usuarioParaAtualizar = usuarios.get(0);
                usuarioParaAtualizar.setNome("Wellington Sousa");
                usuarioDAO.atualizar(usuarioParaAtualizar);
                System.out.println("\nUsuário com ID " + usuarioParaAtualizar.getId() + " atualizado.");
            }

            // --- D: Delete (Deletar) ---
            if (usuarios.size() > 1) {
                int idParaDeletar = usuarios.get(1).getId();
                usuarioDAO.deletar(idParaDeletar);
                System.out.println("\nUsuário com ID " + idParaDeletar + " deletado.");
            }

            // Re-leitura para verificar as mudanças
            System.out.println("\nLista de usuários após operações:");
            usuarioDAO.buscarTodos().forEach(u -> System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome()));

        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
}

