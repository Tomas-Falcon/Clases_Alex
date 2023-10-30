package App01;

import java.io.*;
import java.text.*;
import java.util.*;

public class EscribirFichero {
	private String ruta;
	private float valores[];
	public EscribirFichero(String ruta, float valores[]){
		ruta = ruta + ".conf";
		this.ruta = ruta;
		this.valores = valores;
		escribir();
	}
	
	private void escribir() {
		Properties configuracion = new Properties();

		String valor1 = String.valueOf(valores[0]);
		String valor2 = String.valueOf(valores[1]);
		String resultado = String.valueOf(valores[2]);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date bf = new Date();
		String fecha = sdf.format(bf); //fecha
		try{
			bf = sdf.parse(fecha);
		}catch(Exception e){
			System.out.println("------------ERROR en la cadena------------");
		}
		
		configuracion.setProperty("Valor1", valor1);
		configuracion.setProperty("Valor2", valor2);
		configuracion.setProperty("Resultado", resultado);
		configuracion.setProperty("Fecha", fecha);
		

		try {
			// sobre escribimos el fichero y le damos el nombre de "valorIngresado.conf" si no existe, se crea
			// y la primera linea de ese archivo dice "Fichero de cantidades", la segunda linea dice la ultima modificacion y la tercera linea 
			//contiene la clave cantidad con su valor
			
		  configuracion.store(new FileOutputStream(ruta),"Fichero de cantidades");
		 

		} catch (FileNotFoundException fnfe ) { 

				fnfe.printStackTrace(); 

			} catch (IOException ioe) { 

				ioe.printStackTrace();
		  
			}
	}
	
	
}
