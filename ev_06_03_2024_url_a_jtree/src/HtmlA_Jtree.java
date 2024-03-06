import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HtmlA_Jtree extends JFrame {
    private JTextField urlTextField;
    private JButton parseButton;
    private JTree htmlTree;

    public HtmlA_Jtree() {
        // Configuración del marco
        setTitle("url a HTML ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Creación de componentes
        urlTextField = new JTextField(10);
        parseButton = new JButton("Generar Jtree");
        htmlTree = new JTree();

        // Configuración del layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("URL:"));
        inputPanel.add(urlTextField);
        inputPanel.add(parseButton);

        // Manejador de eventos para el botón
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseHtmlAndUpdateTree();
            }
        });

        // Agregar componentes al marco
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(htmlTree), BorderLayout.CENTER);
    }

    private void parseHtmlAndUpdateTree() {
        String url = urlTextField.getText();

        try {
            // Realizar la solicitud HTTP y obtener el HTML
            Document document = Jsoup.connect(url).get();

            // Analizar el HTML y construir el JTree
            DefaultMutableTreeNode root = createTreeNodeFromElement(document);
            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            htmlTree.setModel(treeModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener HTML desde la URL", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultMutableTreeNode createTreeNodeFromElement(Element element) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(element.tagName());

        for (Element child : element.children()) {
            node.add(createTreeNodeFromElement(child));
        }

        return node;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HtmlA_Jtree app = new HtmlA_Jtree();
                app.setVisible(true);
            }
        });
    }
}
