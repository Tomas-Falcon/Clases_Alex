/**
 * 
 */

/**
 * 
 */
public class ClaseMian {
	public static void main(String[] args) {
		String adios = "mundo"; 
		
		/*
		 * 
		 *%s --> String 
		 *%d --> Enteros
		 *%f --> Decimales
		 *%c --> Caracteres
		 *%b --> Booleanos
		 *
		 */
		 
		String patron = "Hola %s";
		
		System.out.printf(patron, adios);
		
		System.out.println();
		
		int numero = 1; 
		
		System.out.printf("Hola %d", numero);
		
		System.out.println();
		
		int a = 1;
		int b = 2;
		int c = 3;
		suma(a,b);
		suma(a,b,c);
		System.out.println();
		
		String patron2 = "Me llamo %s tengo %d y mido %f %n";
		String p1 = "Tomás";
		int p2 = 21;
		double p3 = 1.84;
		System.out.printf(patron2,p1,p2,p3);
	}
	public static void suma(int...a) {
		int c = 0;
		for (int b : a) {
			c = b + c;
		}
		System.out.println(c);
	}
	

}
