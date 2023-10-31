package UsandoLamddas;

import java.awt.*;
import java.awt.event.*;

public class ClaseMain extends Frame implements ActionListener{

	public static void main(String[] args) {
		ClaseMain cm = new ClaseMain();

	}
	public ClaseMain(){
	super("Lamddas");
	setSize(900,600);
	setLayout (new GridLayout(1,2));
	
	Button boton = new Button("Boton 1");
	boton.addActionListener(ev-> System.out.println("Boton 1, Lambda" + ev.getActionCommand()));
	add (boton);
	
		
	Button boton2 = new Button("Boton 2");
	boton2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {System.out.println("Boton 2 tradicional");}});
	add (boton2);
	
	Button boton3 = new Button("Boton 3");
	boton3.addActionListener(ev-> { System.out.println("Boton 3, Lambda" + ev.getActionCommand()); });
	add (boton3);
	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
