import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class EjemploArbolAleatorioA extends JFrame {

    private static final long serialVersionUID = 1;

    ModeloDeDatos modelo;
    JTree cerezo;
    JPanel panel;

    public static void main(String[] args) {
        new EjemploArbolAleatorioA();
    }

    public EjemploArbolAleatorioA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        setContentPane(panel);

        JButton generar = new JButton("Nuevo");
        generar.addActionListener(e -> {
            modelo.recargar("algo");
            cerezo.validate();
            System.out.println("Se re pinto");
        });
        panel.add(generar, BorderLayout.NORTH);
        modelo = new ModeloDeDatos();
        cerezo = new JTree(modelo);

        JScrollPane scrollPane = new JScrollPane(cerezo); // Modificado
        panel.add(scrollPane, BorderLayout.CENTER); // Modificado

        setSize(500, 500);
        setVisible(true);
    }
}
