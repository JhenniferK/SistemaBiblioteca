package View;

import DAO.MultaDAO;
import Model.Multa;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class TelaBuscarMulta extends TelaBuscar<Multa> {
    private MultaDAO multasDAO;

    public TelaBuscarMulta(GerenciadorDeTelas gerenciadorDeTelas, MultaDAO multasDAO) {
        super(gerenciadorDeTelas, new String[]{"ID", "ID do Empréstimo", "Valor", "Motivo", "Status"});
        this.multasDAO = multasDAO;
    }

    @Override
    protected void buscarEspecifico(String termo, DefaultTableModel modeloTabela) {
        try {
            int id = Integer.parseInt(termo);
            Multa multa = multasDAO.buscar(id);
            if (multa != null) {
                modeloTabela.addRow(new Object[]{
                        multa.getId(),
                        multa.getIdEmprestimo(),
                        multa.getValor(),
                        multa.getMotivo(),
                        multa.getStatus()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Multa não encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
        }
    }
}