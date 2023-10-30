package App01;

public class ClaseOperacion {
	private String ruta;
	private float resultado;
	

	

	public ClaseOperacion(float valor1, float valor2, String ruta) {
		this.ruta = ruta;
		 resultado = suma(valor1, valor2);
	}
	
	public float suma(float valor1, float valor2){
		float resultado = valor1 + valor2;
		float cuenta [] = {valor1, valor2, resultado};
		new EscribirFichero(ruta, cuenta);
		return resultado;
	}
		
	/**
	 * @return the resultado
	 */
	public final float getResultado() {
		return resultado;
	}
}
