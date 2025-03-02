package View;

import javax.swing.*;
import java.awt.*;

public class GerenciadorDeTelas {
    private JFrame frame;
    private CardLayout cardLayout;

    public GerenciadorDeTelas() {
        frame = new JFrame("Sistema da Biblioteca");
        cardLayout = new CardLayout();

        JPanel contentPane = new JPanel(cardLayout);
        frame.setContentPane(contentPane);
        frame.setLayout(cardLayout);
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    public void addTela(String nome, JPanel tela) {
        frame.getContentPane().add(tela, nome);
    }

    public void mostrarTela(String nome) {
        cardLayout.show(frame.getContentPane(), nome);
    }

    public void exibir() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GerenciadorDeTelas gerenciador = new GerenciadorDeTelas();
            gerenciador.addTela("TelaInicial", new TelaInicial(gerenciador));
            gerenciador.addTela("TelaFuncoes", new TelaFuncoes(gerenciador));
            gerenciador.addTela("TelaListarLeitores", new TelaListarLeitores(gerenciador));
            gerenciador.addTela("TelaListarLivros", new TelaListarLivros(gerenciador));
            gerenciador.addTela("TelaListarEmprestimos", new TelaListarEmprestimos(gerenciador));
            gerenciador.addTela("TelaListarMultas", new TelaListarMultas(gerenciador));
            gerenciador.exibir();
        });
    }
}