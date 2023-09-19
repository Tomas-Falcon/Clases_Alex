
public class Alumno {
	
	private String nombre;
	private int edad;
	private int altura;
	private boolean bull;
	
	public Alumno(String nombre, int edad, int altura, boolean bull) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.bull = bull;
		
	}
	
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return the bull
	 */
	public boolean getBull() {
		return bull;
	}

	/**
	 * @param bull the bull to set
	 */
	public void setBull(boolean bull) {
		this.bull = bull;
	}
}
