package seleccionar_ficheros;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SeleccionandoFichero extends Frame {
    private static final long serialVersionUID = 1L;
    private Button btBotonsin;
    private TextField tfcaja;

    public static void main(String[] args) {
        new SeleccionandoFichero();
    }

    SeleccionandoFichero() {
        setSize(600, 150);
        tfcaja = new TextField();
        btBotonsin = new Button("Pulse aqui");

        setLayout(new BorderLayout());
        add(tfcaja, BorderLayout.NORTH);
        add(btBotonsin, BorderLayout.CENTER);

        btBotonsin.addActionListener(e -> busca());

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void busca() {
        FileDialog dialogo = new FileDialog(this, "Dialogo");
        dialogo.setSize(new Dimension(400, 400));
        dialogo.setMaximumSize(new Dimension(400, 400));
        dialogo.setVisible(true);
        tfcaja.setText(dialogo.getDirectory() + " >>> " + dialogo.getFile());
    }
}
