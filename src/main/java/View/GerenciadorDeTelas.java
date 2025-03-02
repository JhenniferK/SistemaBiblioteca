package View;

import DAO.EmprestimoDAO;
import DAO.LeitorDAO;
import DAO.LivroDAO;
import DAO.MultaDAO;

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
            gerenciador.addTela("TelaBuscarLivro", new TelaBuscarLivro(gerenciador, new LivroDAO()));
            gerenciador.addTela("TelaBuscarEmprestimo", new TelaBuscarEmprestimo(gerenciador, new EmprestimoDAO()));
            gerenciador.addTela("TelaBuscarLeitor", new TelaBuscarLeitor(gerenciador, new LeitorDAO()));
            gerenciador.addTela("TelaBuscarMulta", new TelaBuscarMulta(gerenciador, new MultaDAO()));
            gerenciador.addTela("TelaListarLeitores", new TelaListarLeitores(gerenciador));
            gerenciador.addTela("TelaListarLivros", new TelaListarLivros(gerenciador));
            gerenciador.addTela("TelaListarEmprestimos", new TelaListarEmprestimos(gerenciador));
            gerenciador.addTela("TelaListarMultas", new TelaListarMultas(gerenciador));
            gerenciador.exibir();
        });
    }
}