package View;

import DAO.LivroDAO;
import Model.Livro;

import java.util.List;

public class TelaListarLivros extends TelaListagem<Livro> {

    public TelaListarLivros(GerenciadorDeTelas gerenciador) {
        super(gerenciador);
    }

    @Override
    protected String getTitle() {
        return "Livros";
    }

    @Override
    protected String[] getColunas() {
        return new String[]{"ID do Livro", "Título", "Autor", "Editora", "Ano", "Edição", "Núm. Páginas", "Gênero", "Status"};
    }

    @Override
    protected List<Livro> listarItens() {
        return new LivroDAO().listarLivros();
    }

    @Override
    protected void preencherDados(String[] dados, Livro livro) {
        dados[0] = String.valueOf(livro.getId());
        dados[1] = livro.getNome();
        dados[2] = livro.getAutor();
        dados[3] = livro.getEditora();
        dados[4] = String.valueOf(livro.getAnoPublicacao());
        dados[5] = livro.getEdicao();
        dados[6] = String.valueOf(livro.getNumPaginas());
        dados[7] = livro.getGenero();
        dados[8] = String.valueOf(livro.getStatus());
    }
}