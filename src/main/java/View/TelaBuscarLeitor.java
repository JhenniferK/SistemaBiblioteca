package View;

import DAO.LeitorDAO;
import Model.Leitor;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class TelaBuscarLeitor extends TelaBuscar<Leitor> {
    private LeitorDAO leitorDAO;

    public TelaBuscarLeitor(GerenciadorDeTelas gerenciadorDeTelas, LeitorDAO leitorDAO) {
        super(gerenciadorDeTelas, new String[]{"ID", "Nome", "Email", "Telefone"});
        this.leitorDAO = leitorDAO;
    }

    @Override
    protected void buscarEspecifico(String termo, DefaultTableModel modeloTabela) {
        try {
            String cpf = termo.trim();
            Leitor leitor = leitorDAO.buscar(cpf);
            if (leitor != null) {
                modeloTabela.addRow(new Object[]{
                        leitor.getCpf(),
                        leitor.getNome(),
                        leitor.getEmail(),
                        leitor.getTelefone()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Leitor não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
        }
    }
}