import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DialogoHTML extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btBotonsin;
    private JTextField tfcaja;
    private String rutaCompleta1;
    private JTree tree;

    DialogoHTML() {
        super("Dialogo HTML");
        setSize(400, 300);

        tfcaja = new JTextField();
        btBotonsin = new JButton("Pulse aqui");

        setLayout(new FlowLayout());
        add(tfcaja);
        add(btBotonsin);

        btBotonsin.addActionListener(e -> {
        	buscar();
        	tfcaja.setText(rutaCompleta1);
           cargarArbolDesdeArchivo();
        });

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    
    private void cargarArbolDesdeArchivo() {
        try {
            File archivo = new File(tfcaja.getText());
            Document doc = Jsoup.parse(archivo, "UTF-8");

            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
            construirArbolDesdeElement(doc.body(), root);

            tree = new JTree(root);
            JOptionPane.showMessageDialog(this, new JScrollPane(tree), "Estructura del archivo", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void construirArbolDesdeElement(Element element, DefaultMutableTreeNode treeNode) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(element.tagName());

        for (Element child : element.children()) {
            construirArbolDesdeElement(child, newNode);
        }

        treeNode.add(newNode);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DialogoHTML());
    }
}
