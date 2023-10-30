package App02;

import java.io.*;
import java.util.*;

public class LeerFichero {
	private static String ruta;
	 static FileInputStream ficheroConfig;

	public LeerFichero(String ruta1) {
		ruta1 = ruta1 + ".conf";
		ruta = ruta1;
	}
	
	public static String[] leerDatos() {
		Properties configuracion = new Properties();
		//creamos un File con la "direction de la configuracion"
		 try {
			ficheroConfig = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String valores [] = {"no","existe","ese","fichero"};

		try {
			//Toma todos los "Datos" de configuracion
		  configuracion.load(ficheroConfig);
		
		 String valor1 = configuracion.getProperty("Valor1");
		 String valor2 = configuracion.getProperty("Valor2");
		 String resultado = configuracion.getProperty("Resultado");
		 String fecha = configuracion.getProperty("Fecha");
		 
		 String valor []= {valor1, valor2, resultado, fecha};
		 valores = valor;
		} catch (FileNotFoundException fnfe ) { 

		  fnfe.printStackTrace();

		} catch (IOException ioe) { 

		  ioe.printStackTrace();

		}
		return valores;
	}

	public boolean noExiste(String ruta) {
		ruta = ruta + ".conf";
		File fichero = new File(ruta);
		boolean existe = fichero.exists();
		return existe;
		
	}
	
}
