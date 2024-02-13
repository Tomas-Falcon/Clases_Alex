import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.text.SimpleDateFormat;

public class Examen extends JFrame {

    JPanel panel1, panel2;
    JTextArea nombreText, tamañoText, rutaText, fechaCreacionText;
    JLabel nombreLabel, tamañoLabel, rutaLabel, fechaCreacionLabel;
    JTree tree;
    DefaultMutableTreeNode root;
    private static int tamano = 1250;

    public static void main(String[] args) {
        new Examen();
    }

    public Examen() {
        super("FileTree");
        setSize(tamano, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem mItem = new JMenuItem("Seleccionar Carpeta");
        mItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
        fileMenu.add(mItem);


        root = new DefaultMutableTreeNode("C:\\Users\\Tomas\\Desktop");
        cargarDirectorios(new File(System.getProperty("user.home") + "/Desktop"), root);


        TreeModel treeModel = new DefaultTreeModel(root);


        tree = new JTree(treeModel);


        JScrollPane scrollPane = new JScrollPane(tree);


        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                TreePath path = e.getPath();
                File selectedFile = (File) ((DefaultMutableTreeNode) path.getLastPathComponent()).getUserObject();
                String ruta = selectedFile.getAbsolutePath();
                //todo no andaba x culpa de la puta ruta absoluta, soy un genio, alex dame jamon
                rutaText.setText(ruta);


                String fileName = selectedFile.getName();
                nombreText.setText(fileName);

         
                long fileSize = selectedFile.length();
                tamañoText.setText(String.valueOf(fileSize) + " bytes");

         
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String lastModified = dateFormat.format(selectedFile.lastModified());
                fechaCreacionText.setText(lastModified);
            }
        });

        mItem.addActionListener(e -> mostrarDialogo());

        nombreText = new JTextArea();
        tamañoText = new JTextArea();
        rutaText = new JTextArea();
        fechaCreacionText = new JTextArea();

        
        nombreText.setRows(2);
        tamañoText.setRows(2);
        rutaText.setRows(2);
        fechaCreacionText.setRows(2);

        nombreLabel = new JLabel("Nombre del archivo:");
        tamañoLabel = new JLabel("Tamaño:");
        rutaLabel = new JLabel("Ruta del archivo:");
        fechaCreacionLabel = new JLabel("Fecha de modificación:");

        panel1 = new JPanel();
        panel1.add(scrollPane);

        panel2 = new JPanel();
        panel2.add(nombreLabel);
        panel2.add(nombreText);

        panel2.add(tamañoLabel);
        panel2.add(tamañoText);

        panel2.add(rutaLabel);
        panel2.add(rutaText);

        panel2.add(fechaCreacionLabel);
        panel2.add(fechaCreacionText);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
        splitPane.setDividerLocation(tamano / 2); // Establece la ubicación del splitpanel

        setJMenuBar(menuBar);
        menuBar.add(fileMenu); // Agregar el menú al menú de la barra
        add(splitPane);
        setVisible(true);
    }

    private void cargarDirectorios(File directorio, DefaultMutableTreeNode parentNode) {
        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(archivo);
                parentNode.add(node);
                if (archivo.isDirectory()) {
                    cargarDirectorios(archivo, node);
                }
            }
        }
    }

    private void mostrarDialogo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

       
        int resultado = fileChooser.showDialog(this, "Seleccionar");

       
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener el directorio seleccionado
            File directorioSeleccionado = fileChooser.getSelectedFile();

         
            root.removeAllChildren();
            root.setUserObject(directorioSeleccionado);
            cargarDirectorios(directorioSeleccionado, root);

         
            ((DefaultTreeModel) tree.getModel()).reload();

         
            TreePath path = new TreePath(root.getPath());
            tree.expandPath(path);
        }
    }
}
