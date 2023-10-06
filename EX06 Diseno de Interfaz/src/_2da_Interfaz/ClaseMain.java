/**
 * 
 */
package _2da_Interfaz;

import java.awt.*;

/**
 * 
 */
public class ClaseMain extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Frame f = new Frame();
		f.setSize(400, 300);
		f.setTitle("Hola awt");
		
		Button boton = new Button("Nombre"); 
		Button boton2 = new Button("Apellido"); 
		//boton.setBounds(x, y, ancho, alto);
		boton.setSize(200, 40);
		boton.setLocation(100, 100);
		
		boton2.setBounds(100, 150, 200, 40);
		f.setLayout(null);
		f.add(boton);
		f.add(boton2);
		
		f.setVisible(true);
	}

	
}
