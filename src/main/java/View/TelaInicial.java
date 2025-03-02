package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class TelaInicial extends JPanel {
    public TelaInicial(GerenciadorDeTelas gerenciador) {
        setLayout(new BorderLayout());

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("Background.png"));
                g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(null);

        JPanel overlayPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(new Color(245, 235, 225, 170));
                g2d.fillRect(0, 0, 400, getHeight());

                QuadCurve2D curve1 = new QuadCurve2D.Float(400, 0, 600, 250, 400, getHeight());
                g2d.fill(curve1);
            }
        };

        overlayPanel.setOpaque(false);
        overlayPanel.setBounds(0, 0, 1000, 700);
        backgroundPanel.add(overlayPanel);

        overlayPanel.setLayout(new BoxLayout(overlayPanel, BoxLayout.Y_AXIS));
        overlayPanel.add(Box.createRigidArea(new Dimension(50, 250)));

        JLabel titulo = new JLabel("Biblioteca");
        titulo.setFont(new Font("Arial", Font.BOLD, 70));
        titulo.setForeground(new Color(132, 48, 48));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        overlayPanel.add(titulo);

        overlayPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton btnAcessarSistema = new JButton("Acessar o sistema");
        btnAcessarSistema.setBackground(new Color(132, 48, 48));
        btnAcessarSistema.setForeground(Color.WHITE);
        btnAcessarSistema.setFont(new Font("Arial", Font.BOLD, 18));
        btnAcessarSistema.setFocusPainted(false);
        btnAcessarSistema.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnAcessarSistema.addActionListener(e -> gerenciador.mostrarTela("TelaFuncoes"));

        overlayPanel.add(btnAcessarSistema);
        add(backgroundPanel);
    }
}