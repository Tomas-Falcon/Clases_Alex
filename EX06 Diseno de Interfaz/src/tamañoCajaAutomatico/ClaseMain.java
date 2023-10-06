/**
 * 
 */
package tamañoCajaAutomatico;

import java.awt.*;
import java.util.ArrayList;
public class ClaseMain {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(500, 400);
		f.setTitle("Hola awt");
		
		ArrayList<String>  arraylistCajadeTexto = new ArrayList<>(5);
		
		arraylistCajadeTexto.add("Nombre");
		arraylistCajadeTexto.add("Apellido");
		arraylistCajadeTexto.add("Edad");
		arraylistCajadeTexto.add("Numero de telefono");
		
		TextArea cajaTexto1 = new TextArea(arraylistCajadeTexto.get(0));
		TextArea cajaTexto2 = new TextArea(arraylistCajadeTexto.get(1));
		TextArea cajaTexto3 = new TextArea(arraylistCajadeTexto.get(2));
		TextArea cajaTexto4 = new TextArea(arraylistCajadeTexto.get(3));
		
		int tamañoTotal = 0;
		
		for (String comparar : arraylistCajadeTexto) {
			if(tamañoTotal < comparar.length()) {
				tamañoTotal = comparar.length();
			}
		}
		TextField escribirTexto1 = new TextField();
		TextField escribirTexto2 = new TextField();
		TextField escribirTexto3 = new TextField();
		TextField escribirTexto4 = new TextField();
		
		tamañoTotal = tamañoTotal * 8;
		//boton.setBounds(x, y, ancho, alto);
		int x = 50;
		cajaTexto1.setBounds(x, 50, tamañoTotal, 20);
		cajaTexto2.setBounds(x, 100, tamañoTotal, 20);
		cajaTexto3.setBounds(x, 150, tamañoTotal, 20);
		cajaTexto4.setBounds(x, 200, tamañoTotal, 20);
		int x2 = (x*2) + tamañoTotal;
		escribirTexto1.setBounds(x2, 50, tamañoTotal, 20);
		escribirTexto2.setBounds(x2, 100, tamañoTotal, 20);
		escribirTexto3.setBounds(x2, 150, tamañoTotal, 20);
		escribirTexto4.setBounds(x2, 200, tamañoTotal, 20);
		
		
		f.setLayout(null);
		
		f.add(cajaTexto1);
		f.add(cajaTexto2);
		f.add(cajaTexto3);
		f.add(cajaTexto4);
		
		f.add(escribirTexto1);
		f.add(escribirTexto2);
		f.add(escribirTexto3);
		f.add(escribirTexto4);
		
		f.setBackground(Color.black);
		
		f.setVisible(true);
		
	}

}
