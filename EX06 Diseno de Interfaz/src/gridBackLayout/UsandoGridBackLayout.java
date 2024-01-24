package gridBackLayout;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsandoGridBackLayout extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new UsandoGridBackLayout();
    }

    UsandoGridBackLayout() {
        super("Me he quedado muda de cantarte al oído");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        JPanel panelPrincipal = new JPanel();

        GridBagLayout layout = new GridBagLayout();
        layout.rowWeights = new double[]{0.2, 0.8};
        layout.columnWeights = new double[]{0.2, 0.2, 0.6};
        panelPrincipal.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();

        JButton boton1 = new JButton("Botón 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(boton1, gbc);

        JButton boton2 = new JButton("Botón 2");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(boton2, gbc);

        JButton boton3 = new JButton("Botón 3");
        gbc.gridx = 2;
        gbc.gridy = 2;
        panelPrincipal.add(boton3, gbc);

        add(panelPrincipal);
        setVisible(true); 
    }
}

