package View;

import DAO.EmprestimoDAO;
import Model.Emprestimo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaBuscarEmprestimo extends TelaBuscar<Emprestimo> {
    private EmprestimoDAO emprestimoDAO;

    public TelaBuscarEmprestimo(GerenciadorDeTelas gerenciadorDeTelas, EmprestimoDAO emprestimoDAO) {
        super(gerenciadorDeTelas, new String[]{"ID", "ID do Livro", "ID do Leitor", "Data da Retirada", "Data Prevista da Devolução", "Valor do Empréstimo", "Data Real da Devolução", "Status"});
        this.emprestimoDAO = emprestimoDAO;
    }

    @Override
    protected void buscarEspecifico(String termo, DefaultTableModel modeloTabela) {
        try {
            int id = Integer.parseInt(termo);
            Emprestimo emprestimo = emprestimoDAO.buscar(id);
            if (emprestimo != null) {
                modeloTabela.addRow(new Object[]{
                        emprestimo.getId(),
                        emprestimo.getIdLivro(),
                        emprestimo.getIdLeitor(),
                        emprestimo.getDataRetirada(),
                        emprestimo.getDataPrevDevolucao(),
                        emprestimo.getValor(),
                        emprestimo.getDataDevolucao(),
                        emprestimo.getStatus()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Empréstimo não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
        }
    }
}