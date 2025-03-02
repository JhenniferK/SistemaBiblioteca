package Controller;

import Model.Livro;
import Service.LivroService;

import java.util.List;

public class LivroController {
    private LivroService livroService;

    public LivroController() {
        this.livroService = new LivroService();
    }

    public Livro buscarLivro(int id) {
        return livroService.buscarLivro(id);
    }

    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }
}
