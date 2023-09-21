package demoPasoParametros;

public class DemoPasoParametros {
	
	public static void main(String[] args) {
		int numeros []  = {0,1,2,3,4,5,6,7,8,9};
		
		modificarArray(numeros);
		System.out.println("");
		for (int n : numeros) {
			System.out.println(n);
			
		}
	}
	
	public static void modificarArray(int numeros []) {
		System.out.println("modificarArray()");
		System.out.println("");
		for (int n : numeros) {
			System.out.println(n);
			
		}
		
		numeros[0] = 10;
		numeros[1] = 20;
		numeros[2] = 30;
		
	}
	
}
