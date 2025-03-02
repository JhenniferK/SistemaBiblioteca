package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class TelaListagem<T> extends JPanel {
    private final GerenciadorDeTelas gerenciador;

    public TelaListagem(GerenciadorDeTelas gerenciador) {
        this.gerenciador = gerenciador;
        setLayout(new BorderLayout());
        setBackground(new Color(245, 235, 225, 170));

        JLabel titleLabel = new JLabel(getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(132, 48, 48));
        add(titleLabel, BorderLayout.NORTH);

        String[] colunas = getColunas();
        List<T> itens = listarItens();

        String[][] dados = new String[itens.size()][colunas.length];
        for (int i = 0; i < itens.size(); i++) {
            preencherDados(dados[i], itens.get(i));
        }

        JTable tabela = new JTable(dados, colunas);
        tabela.setFillsViewportHeight(true);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        btnVoltar.setBackground(new Color(132, 48, 48));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.addActionListener(e -> gerenciador.mostrarTela("TelaFuncoes"));
        add(btnVoltar, BorderLayout.SOUTH);
    }

    protected abstract String getTitle();
    protected abstract String[] getColunas();
    protected abstract List<T> listarItens();
    protected abstract void preencherDados(String[] dados, T item);
}