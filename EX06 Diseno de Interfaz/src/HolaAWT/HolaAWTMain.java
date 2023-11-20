package HolaAWT;

import java.awt.*;

public class HolaAWTMain {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(400, 300);
		f.setTitle("Hola awt");
		
		Button boton = new Button("Nombre"); 
		//boton.setBounds(x, y, ancho, alto);
		boton.setSize(200, 40);
		boton.setLocation(100, 100);
		f.setLayout(null);
		f.add(boton);
		
		f.setVisible(true);
		
	}

}
