package EventosFoco;

import java.awt.Button;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EventosFocoMain extends Frame implements FocusListener {
	private TextField cajaTexto = new TextField("                               ");
	private Label lnom, msj, lapellido, msj2;
	private TextField tfnom, tapellido;
	
	public static void main(String[] args) {
		new EventosFocoMain();
	}
	
	private EventosFocoMain(int x) {
		super("Clase Main FocusListener");
		setLayout(new FlowLayout());
		add(cajaTexto);
		setSize(800, 800);
		
		Button b1 = new Button("B1");
		add(b1);
		//b1.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent e) {cajaTexto.setText("B1");}});
		Button b2 = new Button("B2");
		add(b2);
		
		Button b3 = new Button("B3");
		add(b3);
		
		setVisible(true);
	}
	
	private EventosFocoMain() {
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	setSize(10000, 600);
	FlowLayout diegoTieneFlow = new FlowLayout();
	
	panel1.setLayout(diegoTieneFlow);
	panel1.add(lnom = new Label("Nombre:"));
	panel1.add(tfnom = new TextField(10));
	panel1.add(msj = new Label(""));
	
	panel2.setLayout(diegoTieneFlow);
	panel2.add(lapellido = new Label("Apellido:"));
	panel2.add(tapellido = new TextField(10));
	panel2.add(msj2 = new Label(""));
	
	setLocationRelativeTo(null);
	tfnom.addFocusListener(this);
	tapellido.addFocusListener(this);
	
	GridLayout gbl = new GridLayout(2,1);
	setLayout(gbl);
	add(panel1);
	add(panel2);
	
	setVisible(true);
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained(FocusEvent e)");
		if(e.getSource()==tfnom) {
			this.msj.setText("<--Escribe tu Nombre");
			this.msj2.setText("");
		}else if(e.getSource()==tapellido) {
			this.msj2.setText("<--Escribe tu Apellido");
			this.msj.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("focusLost(FocusEvent e)");
		
	}
	
	
}
