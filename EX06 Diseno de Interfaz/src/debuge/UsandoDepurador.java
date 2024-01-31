package debuge;

public class UsandoDepurador {
		static int i = 0;
	   public static void main(String[] args) {
	        paso1();
	        paso2();
	        paso3();
	        paso4();
	    }

	    static void paso1() {
	        System.out.println("Paso 1: "+i);
	        i = i*2;
	    }

	    static void paso2() {
	    	i = i-1;
	    	System.out.println("Paso 2: "+i);
	     }

	    static void paso3() {
	        i = i -5;
	    	System.out.println("Paso 3: "+i);
	    }

	    static void paso4() {
	    	i = i + 7;
	        System.out.println("Paso 4: "+i);
	    }
	}