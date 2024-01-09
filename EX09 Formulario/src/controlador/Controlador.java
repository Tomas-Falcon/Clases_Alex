package controlador;

import java.util.ArrayList;

import modelo.Localidad;
import modelo.Provincia;

public class Controlador {
	
	private Provincia provincia1, provincia2;
	private Localidad localidad1, localidad2, localidad3;
	
	public Controlador(Provincia provincia1, Provincia provincia2, Localidad localidad1, Localidad localidad2, Localidad localidad3) {
		//se eliminan todos los objetos que hay aca y se establece la coneccion con la bbdd, ademas se llama al metodo de la clase bbdd
		//para que cree si no existe la bbdd con su tabla y provincias 
		this.provincia1 = provincia1;
		this.provincia2 = provincia2;
		
		this.localidad1 = localidad1;
		this.localidad2 = localidad2;
		this.localidad3 = localidad3;
	}
	
	public String[] getProvincias(){
		String [] provincias = {provincia1.getNombre(),provincia2.getNombre()};
		return provincias;
	}
	
	public ArrayList getLocalidades(String provincia){
		ArrayList localidades = new ArrayList();
		//se utilizaria un while con el next item o algo asi para obtener todas las localidades que coincidan en la provincia seleccionada
		//este while no haria falta, se encargaria la ocnsulta de obtener las localidades a base de esa provincia

		switch (provincia) {
		case "1": {
			
			String loc1 = localidad1.getNombre();
			String loc2 = localidad2.getNombre();
			localidades.add(loc1);
			localidades.add(loc2);
			break;
		}case "2":{
			String loc3 = localidad3.getNombre();
			localidades.add(loc3);
			break;
			}
		}
		
		return localidades;
	}
	
	
}
