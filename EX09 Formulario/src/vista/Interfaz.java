package vista;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz extends JFrame{
	
	public static void main(String[] args) {
		new Interfaz();
	}
	
	Interfaz(){
		super("vistin");
		setSize(400, 400);
		
		JPanel panel = new JPanel();
	    crearPaneles("Nombre:");
		crearPaneles("Apellido:");
		crearPaneles("Nombew:");
		
		setVisible(true);
	}
	
	private JPanel crearPaneles(String texto){
		JPanel panel = new JPanel(new GridLayout(1,2));
		panel.add(new JLabel(texto));
		panel.add(new JTextField("            "));
		return panel;
	}
	
}
