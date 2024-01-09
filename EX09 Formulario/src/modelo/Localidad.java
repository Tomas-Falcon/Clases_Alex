package modelo;

public class Localidad {
	
	private Provincia provincia;
	private String nombre, provinciaNombre;
	
	public Localidad(Provincia provincia, String nombre) {
		this.provincia = provincia;
		this.nombre  = nombre;
		provinciaNombre = provincia.getNombre();
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
	
	public final String getProvinciaNombre() {
		return provinciaNombre;
	}

}
