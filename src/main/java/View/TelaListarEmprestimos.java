package View;

import DAO.EmprestimoDAO;
import Model.Emprestimo;

import java.util.List;

public class TelaListarEmprestimos extends TelaListagem<Emprestimo> {

    public TelaListarEmprestimos(GerenciadorDeTelas gerenciador) {
        super(gerenciador);
    }

    @Override
    protected String getTitle() {
        return "Empréstimos";
    }

    @Override
    protected String[] getColunas() {
        return new String[]{"ID do Empréstimo", "ID do Livro", "CPF do Leitor", "Data de Retirada", "Data Prevista da Devolução", "Valor do Empréstimo", "Data Real da Devolução", "Status"};
    }

    @Override
    protected List<Emprestimo> listarItens() {
        return new EmprestimoDAO().listarEmprestimos();
    }

    @Override
    protected void preencherDados(String[] dados, Emprestimo emprestimo) {
        dados[0] = String.valueOf(emprestimo.getId());
        dados[1] = String.valueOf(emprestimo.getIdLivro());
        dados[2] = emprestimo.getIdLeitor();
        dados[3] = emprestimo.getDataRetirada();
        dados[4] = emprestimo.getDataPrevDevolucao();
        dados[5] = String.valueOf(emprestimo.getValor());
        dados[6] = emprestimo.getDataDevolucao();
        dados[7] = emprestimo.getStatus();
    }
}