import javax.swing.*; 
import javax.swing.table.DefaultTableModel;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class GeneradorPDFexamen {
	//debido al estres de tener 2 finales en en mismo dia y la falta de tiempo, se podria decir que no
	//estuve tan bien con el nobre de las variables y seguramente que me quises puntos x eso, con un 5 me vale 
    private JFrame frame;
    private JTextField descripcionField, unidadesField, precioUnitarioField, precTotalField;
    private JTextField precTotalFieldFinal, ivaFinal, netoFinal;
    private DefaultTableModel tableModel;
    private JPanel panel3;
    private int id = 0;
    private float precioFinalTotal = 0, ivaFinalTotal = 0, precioNetoFinalTotal = 0;
    
    public GeneradorPDFexamen() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Generador de PDF");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        precTotalFieldFinal = new JTextField();
        ivaFinal = new JTextField();
        netoFinal = new JTextField();
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane);

        // Panel para ingresar datos
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("Entrada de Facturas", null, panel1, null);
        panel1.setLayout(null);

        // Componentes para ingresar datos
        JLabel lbldescripcion = new JLabel("Descripcion:");
        lbldescripcion.setBounds(10, 20, 200, 20);
        panel1.add(lbldescripcion);

        descripcionField = new JTextField();
        descripcionField.setBounds(150, 20, 120, 20);
        panel1.add(descripcionField);
        descripcionField.setColumns(10);

        JLabel lblunidades = new JLabel("Unidades:");
        lblunidades.setBounds(10, 50, 200, 20);
        panel1.add(lblunidades);

        unidadesField = new JTextField();
        unidadesField.setBounds(150, 50, 120, 20);
        panel1.add(unidadesField);
        unidadesField.setColumns(10);

        JLabel lblprecioUni = new JLabel("Precio Unitario:");
        lblprecioUni.setBounds(10, 80, 200, 20);
        panel1.add(lblprecioUni);

        precioUnitarioField = new JTextField();
        precioUnitarioField.setBounds(150, 80, 120, 20);
        panel1.add(precioUnitarioField);
        precioUnitarioField.setColumns(10);

        JLabel lblprecioTotal = new JLabel("Precio Total: ");
        lblprecioTotal.setBounds(10, 110, 200, 20);
        panel1.add(lblprecioTotal);

        precTotalField = new JTextField();
        precTotalField.setBounds(150, 110, 70, 20);
        panel1.add(precTotalField);
        precTotalField.setColumns(10);

        // Botón para agregar datos
        JButton btnGenerarPDF = new JButton("Continuar");
        btnGenerarPDF.setBounds(10, 150, 150, 25);
        panel1.add(btnGenerarPDF);
        btnGenerarPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarDatos();
            }
        });

        // Panel para mostrar datos guardados
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Lineas de Factura", null, panel2, null);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        
        panel3 = new JPanel();
        tabbedPane.addTab("Totales", null, panel3, null);
        panel3.setLayout(null);
        
        JLabel lblprecioTotalFinal = new JLabel("Precio Total: ");
        lblprecioTotalFinal.setBounds(10, 25, 200, 20);
        panel3.add(lblprecioTotalFinal);
        
        
        precTotalFieldFinal.setBounds(150, 25, 70, 20);
        panel3.add(precTotalFieldFinal);
        precTotalFieldFinal.setColumns(10);
        
        JLabel lblivaFinal = new JLabel("Cuota IVA (16%): ");
        lblivaFinal.setBounds(10, 50, 200, 20);
        panel3.add(lblivaFinal);
        
        
        ivaFinal.setBounds(150, 50, 70, 20);
        panel3.add(ivaFinal);
        ivaFinal.setColumns(10);
        
        JLabel lblNetoFinal = new JLabel("Precio neto: ");
        lblNetoFinal.setBounds(10, 75, 200, 20);
        panel3.add(lblNetoFinal);
        
        netoFinal.setBounds(150, 75, 70, 20);
        panel3.add(netoFinal);
        netoFinal.setColumns(10);
        
        // Definir las columnas
        String[] columnNames = {"ID", "Descripcion", "Unidades", "Precio Unidad", "Precio Total"};

        // Crear el modelo de la tabla con las columnas definidas
        tableModel = new DefaultTableModel(columnNames, 0);

        // Tabla para mostrar datos
        JTable table = new JTable(tableModel);
        panel2.add(new JScrollPane(table));

        // Botón "Crear PDF"
        JButton bt2 = new JButton("Crear PDF");
        bt2.setBounds(10, 105, 100, 25);
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    crearPDF(tableModel);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panel3.add(bt2);

        frame.setVisible(true);
    }

    private void agregarDatos() {
        String descripcion = descripcionField.getText();
        String unidades = unidadesField.getText();
        String precioUni = precioUnitarioField.getText();
        float unidades2 = 0;
        float precioUni2 = 0;
        try {
        	  unidades2 = Float.parseFloat(unidades);
              precioUni2 = Float.parseFloat(precioUni);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Los valores ingresados en \"Unidades\" y \"Precio Unidad\", tienen que ser valores numericos","Error",JOptionPane.WARNING_MESSAGE);
		}
        
        float precioTotal = unidades2 * precioUni2;
        precTotalField.setText(""+precioTotal);

        if (descripcion.isEmpty() || unidades.isEmpty() || precioUni.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "descripcion, unidades y precio unidad son campos requeridos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
                // Insertar datos en la tabla
                Vector<String> row = new Vector<>();
                row.add(id+"");
                row.add(descripcion);
                row.add(unidades);
                row.add(precioUni);
                row.add(precioTotal+"");
                tableModel.addRow(row);
                precioFinalTotal = (precioFinalTotal + precioTotal);
                precTotalField.setText(precioFinalTotal+"");
               
                ivaFinalTotal = (float) (precioFinalTotal * 0.16);
                precioNetoFinalTotal = precioFinalTotal + ivaFinalTotal;
                
                ivaFinal.setText(ivaFinalTotal+"");
                netoFinal.setText(precioNetoFinalTotal+"");
                
               /*
                // Limpiar campos
                descripcionField.setText("");
                unidadesField.setText("");
                precioUnitarioField.setText("");
                precTotalField.setText("");
                */
                id++;
            
        }
    }

    private void crearPDF(DefaultTableModel model) throws IOException {
        // Abrir el cuadro de diálogo para seleccionar la ruta y descripcion del archivo PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf"));

        int userSelection = fileChooser.showSaveDialog(frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Verificar si la extensión ".pdf" está presente en el nombre del archivo
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf"; // Agregar la extensión si no está presente
            }

            // Crear PDF con la ruta proporcionada
            String destino = filePath;
            PdfWriter writer = new PdfWriter(destino);
            Document doc = new Document(new PdfDocument(writer));

            // Encabezado del documento
            doc.add(new Paragraph("Factura")
                    .setBold()
                    .setFontSize(18)
                    .setBackgroundColor(Color.LIGHT_GRAY)
                    .setMarginBottom(10)
                    .setTextAlignment(TextAlignment.CENTER));

            // Crear tabla
            float[] columnWidths = {150f, 150f, 150f, 100f, 150f};
            Table table = new Table(columnWidths);

            // Encabezados de la tabla
            table.addCell(new Cell().add("ID").setBackgroundColor(Color.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add("Desacripcion").setBackgroundColor(Color.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add("Unidades").setBackgroundColor(Color.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add("Precio Unitario").setBackgroundColor(Color.LIGHT_GRAY).setBold());
            table.addCell(new Cell().add("Precio Total").setBackgroundColor(Color.LIGHT_GRAY).setBold());

            // Datos de la tabla
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    table.addCell(model.getValueAt(i, j).toString());
                }
            }

            // Agregar tabla al documento
            doc.add(table);
            
            Paragraph parrafo = new Paragraph();
            Text texto = new Text("Precio Total Bruto: "+precioFinalTotal + "\nPrecio Total: "+precioNetoFinalTotal);
            parrafo.add(texto);
            doc.add(parrafo);
            doc.close();
            writer.close();

            JOptionPane.showMessageDialog(frame, "PDF creado correctamente en: " + destino, "PDF Creado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeneradorPDFexamen());
    }
}
