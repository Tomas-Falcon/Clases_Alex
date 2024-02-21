package usandoDialogos;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UsandoDialogos extends JFrame{
	
	JButton b1,b2,b3,b4,b5;
	
	public static void main(String[] args) {
		new UsandoDialogos();	
	}
	
	public UsandoDialogos() {
		setLayout(new FlowLayout());
		b1 = new JButton("Boton 1");
		add(b1);
		
		b2 = new JButton("Boton 2");
		add(b2);
		
		b3 = new JButton("Boton 3");
		add(b3);
		
		b4 = new JButton("Boton 4");
		add(b4);
		
		b5 = new JButton("Boton 5");
		add(b5);
		
		
		b1.addActionListener(v-> {
			JOptionPane.showMessageDialog(this, "esto es un dialogo");
		});	
		
		b2.addActionListener(v-> {
			JOptionPane.showMessageDialog(this, "esto es un dialogo","Titulin",JOptionPane.WARNING_MESSAGE);
		});	
		
		b3.addActionListener(v-> {
			JOptionPane.showConfirmDialog(this, "¿Hola?");
		});	
		
		
		b4.addActionListener(v-> {
			int valor = JOptionPane.showOptionDialog(this, "dialogo", "titulo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 1);
			JOptionPane.showMessageDialog(this, "ha respondido: "+valor);
		});
		
		
		b5.addActionListener(v-> {
			Object opciones [] = {"Chocolate 98%","Chocolate con leche","Chocolate con sal","Chocolate con picante"};
			int respuesta = JOptionPane.showOptionDialog(this, "Esta es uan pregunta", "Responde porfi!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[3]);
			JOptionPane.showConfirmDialog(this, "Ha respondido: "+opciones[respuesta]);
		});
		
		setSize(400,400);
		setVisible(true);
		
	}	
	

}
