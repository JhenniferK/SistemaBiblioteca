package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class TelaBuscar<T> extends JPanel {
    protected GerenciadorDeTelas gerenciadorDeTelas;
    protected JTextField textBusca;
    protected JButton botaoBuscar;
    protected JTable tabelaResultados;
    protected DefaultTableModel modeloTabela;

    public TelaBuscar(GerenciadorDeTelas gerenciadorDeTelas, String[] colunas) {
        this.gerenciadorDeTelas = gerenciadorDeTelas;

        setLayout(new BorderLayout());

        JPanel painelBusca = new JPanel();
        textBusca = new JTextField(20);
        botaoBuscar = new JButton("Buscar");
        botaoBuscar.setForeground(new Color(0xffffff));
        botaoBuscar.setBackground(new Color(132, 48, 48));
        botaoBuscar.addActionListener(e -> buscarDados(getTermoBusca()));

        painelBusca.add(textBusca);
        painelBusca.add(botaoBuscar);

        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaResultados = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaResultados);

        add(painelBusca, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        btnVoltar.setBackground(new Color(132, 48, 48));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.addActionListener(e -> gerenciadorDeTelas.mostrarTela("TelaFuncoes"));
        add(btnVoltar, BorderLayout.SOUTH);
    }

    protected void buscarDados(String termo) {
        modeloTabela.setRowCount(0);
        buscarEspecifico(termo, modeloTabela);
    }

    protected abstract void buscarEspecifico(String termo, DefaultTableModel modeloTabela);

    public String getTermoBusca() {
        return textBusca.getText();
    }
}