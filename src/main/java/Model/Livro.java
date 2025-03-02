package Model;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String edicao;
    private int numPaginas;
    private String genero;
    private String status;

    public Livro(int id, String nome, String autor, String editora, int anoPublicacao, String edicao, int numPaginas, String genero, String status) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
        this.numPaginas = numPaginas;
        this.genero = genero;
        this.status = status;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro: " + "Título - " + nome + ", Autor - " + autor + ", Editora - " + editora + ";";
    }
}
