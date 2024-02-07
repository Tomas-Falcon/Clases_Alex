import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogoHTML extends JFrame {

    public static void main(String[] args) {
        new DialogoHTML();
    }

    private static final long serialVersionUID = 1L;
    private JButton btBotonsin;
    private JTextField tfcaja;
    private String rutaCompleta1;

    DialogoHTML() {
        super("Dialogo HTML");
        setSize(400, 300);

        tfcaja = new JTextField();
        btBotonsin = new JButton("Pulse aqui");

        setLayout(new FlowLayout()); 
        add(tfcaja);
        add(btBotonsin);

        btBotonsin.addActionListener(e -> {
            String comparar = tfcaja.getText();
            if (!comparar.trim().isEmpty()) {//no anda
                buscar();
            } else {
                arbolin();
            }
        });


        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    private void arbolin() {
    	
    }

    private void buscar() {
        FileDialog dialogoArchivo = new FileDialog((Frame)null, "Seleccione un archivo HTML", FileDialog.LOAD);
        dialogoArchivo.setVisible(true);

        String nombreArchivoSeleccionado = dialogoArchivo.getFile();
        if (nombreArchivoSeleccionado != null) {
            String rutaCompleta = dialogoArchivo.getDirectory() + nombreArchivoSeleccionado;
            tfcaja.setText(rutaCompleta);
            rutaCompleta1 = rutaCompleta;
            System.out.println(rutaCompleta);
        }
    }

}
