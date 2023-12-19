
import java.awt.*; 
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraFechaVencimiento extends Frame {

    // Campos de texto para la interfaz gráfica
    private TextField txtFechaInicio, txtDiasFaltantes, txtFechaVencimiento, txtFechaFestivo;
    
    private Label texto;
    
    // Lista de días festivos y componentes relacionados
    private List lstDiasFestivos, colores;
    private ArrayList<String> diasFestivosList;
    
    
    // Opciones de cálculo de fecha
    private Checkbox chkDiasHabiles, chkDiasReales, permitirAgregarDiasFestivos;
    private CheckboxGroup chkGroup;

    // Constructor de la clase
    public CalculadoraFechaVencimiento() {
    	super("Gestor de avisos");
       // setLayout(new GridLayout(8, 2, 10, 5));
        setLayout(new FlowLayout());
        colores = new List(5);
        colores.setMultipleMode(false);
        texto = new Label("Color del aviso");
        
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Verde");
        colores.add("Blanco");
        colores.add("Gris");
        
        
        colores.addActionListener(v-> {int color = colores.getSelectedIndex();
        switch (color) {case 0 : {setBackground(Color.RED); break;}
		case 1 : {setBackground(Color.BLUE); break;}
		case 2 : {setBackground(Color.GREEN); break;}
		case 3 : {setBackground(Color.WHITE); break;}
		case 4 : {setBackground(Color.GRAY); break;}}});
		
        
        
        // Inicializa los campos de texto antes de llamar a addLabelAndTextField
        txtFechaInicio = new TextField(10);
        txtDiasFaltantes = new TextField(5);
        txtFechaFestivo = new TextField(10);
        txtFechaVencimiento = new TextField(10); // Asegúrate de inicializar este campo también

        // Agrega etiquetas y campos de texto a la interfaz gráfica
        addLabelAndTextField("Fecha de inicio (dd/MM/yyyy):", txtFechaInicio);
        addLabelAndTextField("Días para vencer:", txtDiasFaltantes);
        addLabelAndTextField("Fecha de festivo (dd/MM/yyyy):", txtFechaFestivo);
        addLabelAndTextField("Fecha de vencimiento:", txtFechaVencimiento); // Asegúrate de agregar este campo

        // Botones para agregar festivos y calcular fecha de vencimiento
        Button btnAgregarFestivo = new Button("Agregar Festivo");
        btnAgregarFestivo.addActionListener(e -> {if(permitirAgregarDiasFestivos.getState()){agregarFestivo();}else mostrarDialog("Advertencia","Para agregar fechas festivas, tendra que marcar la casilla para agregar fechas festivas");});
        add(btnAgregarFestivo);

        Button btnCalcular = new Button("Calcular");
        btnCalcular.addActionListener(e -> calcularFechaVencimiento());
        add(btnCalcular);

        // Lista de días festivos ingresados
        lstDiasFestivos = new List(5, false);
        diasFestivosList = new ArrayList<>();
        
        diasFestivosList.add("05/06/2002");
        lstDiasFestivos.add("05/06/2002");
        
        add(new Label("Días festivos ingresados:"));
        add(lstDiasFestivos);

        // Opciones de cálculo (días hábiles o días reales)
        chkGroup = new CheckboxGroup();
        chkDiasHabiles = new Checkbox("Días Hábiles", chkGroup, true);
        permitirAgregarDiasFestivos = new Checkbox("Permitir añadr nuevos festivos");
        chkDiasReales = new Checkbox("Días Reales", chkGroup, false);
        add(chkDiasHabiles);
        add(chkDiasReales);
        add(permitirAgregarDiasFestivos);
        
        add(texto);
        add(colores);
        
        // Configuración de la ventana principal
        setSize(300, 450);
        setVisible(true);
    }

    // Método para agregar una etiqueta y un campo de texto a la interfaz gráfica
    private void addLabelAndTextField(String label, TextField textField) {
        Label lbl = new Label(label);
        add(lbl);
        add(textField); // Asegúrate de que textField no sea nulo aquí
    }

    // Método para agregar un día festivo a la lista
    private void agregarFestivo() {
        String fechaFestivoStr = txtFechaFestivo.getText();
        try {
            validarFecha(fechaFestivoStr);  // Validar la fecha

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            // Validar que la fecha tenga el formato correcto
            Date fechaFestivo = dateFormat.parse(fechaFestivoStr);
            String fechaFestivoValida = dateFormat.format(fechaFestivo);

            if (!diasFestivosList.contains(fechaFestivoValida)) {
                diasFestivosList.add(fechaFestivoValida);
                lstDiasFestivos.add(fechaFestivoValida);
            } else {
                mostrarDialog("Error", "La fecha ya está en la lista de festivos.");
            }

        } catch (ParseException | NumberFormatException ex) {
            mostrarDialog("Error", "El día festivo ingresado es incorrecto.");
        }
    }

    // Método para calcular la fecha de vencimiento
    private void calcularFechaVencimiento() {
        String fechaInicioStr = txtFechaInicio.getText();
        String diasFaltantesStr = txtDiasFaltantes.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            Date fechaInicio = dateFormat.parse(fechaInicioStr);
            int diasFaltantes = Integer.parseInt(diasFaltantesStr);

            if (diasFaltantes <= 0) {
                mostrarDialog("Error", "Los días de vencimiento ingresados no son válidos.");
                return;
            }

            validarFecha(fechaInicioStr);  // Validar la fecha de inicio

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaInicio);

            while (diasFaltantes > 0) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);

                // Verificar si es fin de semana o festivo
                if ((chkDiasHabiles.getState() && esDiaLaboral(calendar)) || (chkDiasReales.getState())) {
                    diasFaltantes--;
                }
            }

            String fechaVencimiento = dateFormat.format(calendar.getTime());
            txtFechaVencimiento.setText(fechaVencimiento);

        } catch (NumberFormatException ex) {
            mostrarDialog("Error", "Los días de vencimiento ingresados no son válidos.");
        } catch (ParseException e) {
            mostrarDialog("Error", "La fecha de inicio ingresada no es válida.");
        }
    }

    // Método para validar el formato de la fecha
    private void validarFecha(String fecha) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            // Validar que la fecha tenga el formato correcto
            Date fechaValida = dateFormat.parse(fecha);
            String fechaStr = dateFormat.format(fechaValida);

            // Si la fecha convertida no coincide con la original, hay un error de formato
            if (!fecha.equals(fechaStr)) {
                throw new ParseException("Error en el formato de la fecha.", 0);
            }
        } catch (ParseException ex) {
            // Lanzar una nueva excepción con información detallada
            throw new ParseException("Error en el formato de la fecha: " + ex.getMessage(), ex.getErrorOffset());
        }
    }

    // Método para verificar si un día es laboral
    private boolean esDiaLaboral(Calendar calendar) {
        int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);

        // Si es sábado, domingo o festivo, no es un día laboral
        return diaDeLaSemana != Calendar.SATURDAY &&
                diaDeLaSemana != Calendar.SUNDAY &&
                !esFestivo(calendar);
    }

    // Método para verificar si una fecha es festivo
    private boolean esFestivo(Calendar calendar) {
        String fechaFestivoStr = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
        return diasFestivosList.contains(fechaFestivoStr);
    }

    // Método para mostrar un cuadro de diálogo con un mensaje
    private void mostrarDialog(String titulo, String mensaje) {
        Dialog dialog = new Dialog(this, titulo, true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(mensaje));
        Button btnAceptar = new Button("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(btnAceptar);
        dialog.setSize(550, 100);
        dialog.setVisible(true);
    }

    // Método principal que crea una instancia de la calculadora de fecha de vencimiento
    public static void main(String[] args) {
        new CalculadoraFechaVencimiento();
    }
}
