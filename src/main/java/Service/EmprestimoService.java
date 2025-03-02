package Service;

import DAO.EmprestimoDAO;
import Model.Emprestimo;
import java.util.List;

public class EmprestimoService {
    private EmprestimoDAO emprestimoDAO;

    public EmprestimoService() {
        this.emprestimoDAO = new EmprestimoDAO();
    }

    public Emprestimo buscarEmprestimo(int id) {
        return emprestimoDAO.buscar(id);
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoDAO.listarEmprestimos();
    }
}