public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private int usuarioId; // FK para Usuario

    public Projeto() {
    }

    public Projeto(String nome, String descricao, int usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
