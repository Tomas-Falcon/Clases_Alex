/**
 * 
 */

/**
 * 
 */
public class ClaseMainControlInterface  implements Interface1, Interface2 {
	public static void main (String arg []) {
		Interface3.metodo1();
		Interface2.metodo4();
		
		//Preguntarle a ALEX
		
		metodo1();
		metodo2();
		metodo3();
		//Preguntarle a ALEX
	}
	@Override
	public void metodo1() {
		System.out.print("metodo 1 re escrito que viene de la interface 1 o 2");
	}

	@Override
	public void metodo2() {
		System.out.print("metodo 2 re escrito que viene de la interface 1 o 2");
	}

	@Override
	public void metodo3() {
		System.out.print("metodo 3 re escrito que viene de la interface 1 o 2");		
	}
	
	
}

