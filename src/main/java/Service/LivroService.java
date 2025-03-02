package Service;

import DAO.LivroDAO;
import Model.Livro;
import java.util.List;

public class LivroService {
    private LivroDAO livroDAO;

    public LivroService() {
        this.livroDAO = new LivroDAO();
    }

    public Livro buscarLivro(int id) {
        return livroDAO.buscar(id);
    }

    public List<Livro> listarLivros() {
        return livroDAO.listarLivros();
    }
}