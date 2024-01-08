package modelo;

public class Contacto {
	
	private String nombre, apellido;
	private Provincia provincia;
	private Localidad localidad;
	
	Contacto(String nombre, String apellido, Provincia provincia, Localidad localidad){
		this.nombre = nombre;
		this.apellido = apellido;
		this.provincia = provincia;
		this.localidad = localidad;
		
	}

	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public final String getApellido() {
		return apellido;
	}

	/**
	 * @return the provincia
	 */
	public final Provincia getProvincia() {
		return provincia;
	}

	/**
	 * @return the localidad
	 */
	public final Localidad getLocalidad() {
		return localidad;
	}
}
