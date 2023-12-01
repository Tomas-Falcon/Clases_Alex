package examen;
import java.awt.*;
import java.awt.event.*;


public class ClaseMain extends Frame implements ActionListener{
	
	Button botCalcularFecha, botAnadirfest;
	Checkbox diasHabiles, diasNaturales;
	CheckboxGroup cbg;
	Label lbFechaInicial, lbDiasVen, lbFechaVen, lbNuevaFechaFest, lbFechasFest;  
	TextField tfFechaIni, tfDiasVen, tfFechaVen, tfNuevaFechaFest;
	Choice fechasFestivas;
	CalcularFechas calcularFechas;
	
	public static void main(String[] args) {
		new ClaseMain();
	}
	
	public ClaseMain() {
		super("Gestor de Avisos");
		setSize(240, 400);
		setLayout(new FlowLayout());
		
		calcularFechas = new CalcularFechas();
		
		lbFechaInicial = new Label("Fecha Inicial");
		tfFechaIni  = new TextField("          ");
		lbDiasVen = new Label("Dias Vencimiento");
		tfDiasVen = new TextField("          ");
	    lbFechaVen = new Label("Fecha Vencimiento");
		tfFechaVen = new TextField("          ");
		botCalcularFecha = new Button("Calcular Fecha");
		cbg = new CheckboxGroup();
		diasHabiles = new Checkbox("Dias Habiles", cbg, true);
		diasNaturales = new Checkbox("Dias Naturales", cbg, false);
		lbNuevaFechaFest = new Label("Nueva Fecha Festiva");
		tfNuevaFechaFest = new TextField("          ");
		botAnadirfest = new Button("Añadir festivo");
		lbFechasFest = new Label("Fechas Festivas:");
		fechasFestivas = new Choice();
		
		
		fechasFestivas.add("05/06/2002");
		
		botCalcularFecha.addActionListener(e-> {String fecha = tfFechaIni.getText().trim(); boolean respuesta = cbg.getSelectedCheckbox().getLabel().equals("Dias Habiles"); String numero = tfDiasVen.getText().trim(); calcularFechas.calcuFechas(respuesta,fecha,numero);});
		botAnadirfest.addActionListener(e-> {String fecha = tfNuevaFechaFest.getText().trim(); fechasFestivas.add(fecha); });
		
		add(lbFechaInicial);
		add(tfFechaIni);
		add(lbDiasVen);
		add(tfDiasVen);
		add(botCalcularFecha);
		add(lbFechaVen);
		add(tfFechaVen);
		add(diasHabiles);
		add(diasNaturales);
		add(lbNuevaFechaFest);
		add(tfNuevaFechaFest);
		add(botAnadirfest);
		add(lbFechasFest);
		add(fechasFestivas);
		
		setVisible(true);
	}
		public void Main2(String a) {
			mostrarDialogoError(a);
		}
	protected void mostrarDialogoError(String mensajeError) {
		Dialog dialogo = new Dialog(this, true);
		dialogo.setLayout(new FlowLayout());
		Label mensajeLabel = new Label(mensajeError);
		Button okButton = new Button("Cerrar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogo.dispose();
			}
		});
		dialogo.add(mensajeLabel);
		dialogo.add(okButton);
		dialogo.setSize(300, 100);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
