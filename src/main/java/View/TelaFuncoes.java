package View;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class TelaFuncoes extends JPanel {
    private final GerenciadorDeTelas gerenciador;

    public TelaFuncoes(GerenciadorDeTelas gerenciador) {
        this.gerenciador = gerenciador;
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        mainPanel.setBackground(new Color(245, 235, 225, 170));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {"Buscar", "Listar"};
        mainPanel.add(createCard("Leitores", "/IconeLeitor.png", buttonLabels));
        mainPanel.add(createCard("Livros", "/IconeLivros.png", buttonLabels));
        mainPanel.add(createCard("Empréstimos", "/IconeEmprestimos.png", buttonLabels));
        mainPanel.add(createCard("Multas", "/IconeMultas.png", buttonLabels));

        add(mainPanel);
    }

    private JPanel createCard(String title, String iconPath, String[] buttonLabels) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        card.setBackground(Color.WHITE);

        card.add(Box.createVerticalGlue());

        JLabel titleLabel = new JLabel(title, CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(132, 48, 48));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);

        JLabel iconLabel = new JLabel(resizeIcon(iconPath, 130, 130), CENTER);
        iconLabel.setAlignmentX(CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        card.add(iconLabel);
        card.add(Box.createRigidArea(new Dimension(0, 20)));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setBackground(new Color(132, 48, 48));
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(150, 40));
            button.setMaximumSize(new Dimension(150, 40));
            button.setAlignmentX(CENTER_ALIGNMENT);
            card.add(button);
            card.add(Box.createRigidArea(new Dimension(0, 10)));

            if (label.equals("Listar") && title.equals("Leitores")) {
                button.addActionListener(e -> gerenciador.mostrarTela("TelaListarLeitores"));
            }

            if (label.equals("Listar") && title.equals("Livros")) {
                button.addActionListener(e -> gerenciador.mostrarTela("TelaListarLivros"));
            }

            if (label.equals("Listar") && title.equals("Empréstimos")) {
                button.addActionListener(e -> gerenciador.mostrarTela("TelaListarEmprestimos"));
            }

            if (label.equals("Listar") && title.equals("Multas")) {
                button.addActionListener(e -> gerenciador.mostrarTela("TelaListarMultas"));
            }
        }

        card.add(Box.createVerticalGlue());

        return card;
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}