
public class PasoReferencial {

	public static void main(String[] args) {
		int numeros []  = {0,1,2,3,4,5,6,7,8,9};
		
		System.out.println(" Usando el While ");
		usandoWhile(numeros);
		
		
		System.out.println();
		System.out.println(" Usando el ForEach ");
		usandoForEach(numeros);
		
		System.out.println();
		System.out.println(" Usando el For ");
		usandoFor(numeros);
		
		var otroArray = numeros;
		System.out.println();
		usandoFor(otroArray);
	}
	
	public static void usandoWhile(int numeros []) {
		int i = 0;
		while (i < numeros.length) {
			System.out.println(numeros[i]);
			i++;
		}
		
	}
	
	public static void usandoForEach(int numeros []) {
		for (int b : numeros) {
			System.out.println(b);
		}
		
	}
	
	public static void usandoFor(int numeros []) {
		for (int c = 0; c < numeros.length; c++) {
			System.out.println(numeros[c]);	
		}
		
	}

}
