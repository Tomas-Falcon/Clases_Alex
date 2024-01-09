package modelo;

public class Provincia {
		private String nombre;
		//Ya no se utiliza, esta deprecated
		public Provincia(String nombre) {
		this.nombre = nombre;
		}

		/**
		 * @return the nombre
		 */
		public final String getNombre() {
			return nombre;
		}
}
