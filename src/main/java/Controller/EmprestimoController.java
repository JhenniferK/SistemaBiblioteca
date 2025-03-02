package Controller;

import Model.Emprestimo;
import Service.EmprestimoService;

import java.util.List;

public class EmprestimoController {
    private EmprestimoService emprestimoService;

    public EmprestimoController() {
        this.emprestimoService = new EmprestimoService();
    }

    public Emprestimo buscarEmprestimo(int id) {
        return emprestimoService.buscarEmprestimo(id);
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }
}