package modelo;

public class Localidad {
	
	private Provincia provincia;
	private String nombre;
	
	public Localidad(Provincia provincia, String nombre) {
		this.provincia = provincia;
		this.nombre  =nombre;
	}

	/**
	 * @return the provincia
	 */
	public final Provincia getProvincia() {
		return provincia;
	}

	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}

}
