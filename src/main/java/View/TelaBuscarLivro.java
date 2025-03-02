package View;

import DAO.LivroDAO;
import Model.Livro;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class TelaBuscarLivro extends TelaBuscar<Livro> {
    private LivroDAO livroDAO;

    public TelaBuscarLivro(GerenciadorDeTelas gerenciadorDeTelas, LivroDAO livroDAO) {
        super(gerenciadorDeTelas, new String[]{"ID", "Título", "Autor", "Ano", "Status"});
        this.livroDAO = livroDAO;
    }

    @Override
    protected void buscarEspecifico(String termo, DefaultTableModel modeloTabela) {
        try {
            int id = Integer.parseInt(termo);
            Livro livro = livroDAO.buscar(id);
            if (livro != null) {
                modeloTabela.addRow(new Object[]{
                        livro.getId(),
                        livro.getNome(),
                        livro.getAutor(),
                        livro.getAnoPublicacao(),
                        livro.getStatus()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Livro não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
        }
    }
}