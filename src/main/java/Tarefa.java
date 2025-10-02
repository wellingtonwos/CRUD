public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private int projetoId;   // FK para Projeto
    private int categoriaId; // FK para Categoria

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String status, int projetoId, int categoriaId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.projetoId = projetoId;
        this.categoriaId = categoriaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", projetoId=" + projetoId +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
