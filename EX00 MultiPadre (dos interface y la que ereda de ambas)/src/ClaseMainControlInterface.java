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
		Interface1.metodo5();
		Interface2.metodo5();
	}
	
	public void metoto1() {
		metodo1();
		metodo2();
		
	}
	
	@Override
	public void metodo1() {
		System.out.println("metodo 1 re escrito que viene de la interface 1 o 2");
	}

	@Override
	public void metodo2() {
		System.out.println("metodo 2 re escrito que viene de la interface 1 o 2");
	}

	
	
	
	
}