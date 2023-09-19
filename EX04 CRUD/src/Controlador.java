import java.util.*;
public class Controlador{
	
	private static ArrayList <Alumno> alumnos = new ArrayList <> (5);
	public static void chequearEleccion(String eleccion){
		int eleccionInt = Integer.parseInt(eleccion);
		
		if (eleccionInt == 1){
			ClaseMain.agregarAlumno();
		}
		else if (eleccionInt == 2){
			listarAlumno();
		}
		else if (eleccionInt == 3){
			modificarAlumno();
		}
		else if (eleccionInt == 4){
			eliminarAlumno();
		}
		else if (eleccionInt == 5){
			salirDelPrograma();
		}
		else{
			System.out.println("La eleccion no fue correcta, sera llevado al menu para reingresar la opcion siguiendo los criterios de eleccion establecidos. ");
			System.out.println("#······························································································································#");
			
		}
	}
	
	public static void salirDelPrograma(){
		System.exit(0);
	}
	
	public static void ar(ArrayList <Alumno> alumnos1) {
		alumnos = alumnos1;
	}
	
	private static void listarAlumno() {
		int i = 0;
		while (i < alumnos.size()) {
			System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + alumnos.get(i).getBull() + " con el indice de: " + alumnos.get(i));
		}
	}
	
	private static void modificarAlumno() {
		int i = 0;
		while (i < alumnos.size()) {
			System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + alumnos.get(i).getBull() + " con el indice de: " + alumnos.get(i));
		}
		System.out.println("Ingrese el indice del alumno que quiere modificar: ");
		Scanner sc = new Scanner(System.in); 
		 int respuesta = sc.nextInt();
		 
		 borrar2(respuesta);
	}
	
	private static void eliminarAlumno() {
		
		
		int i = 0;
		System.out.println("Ingrese el indice del alumno que quiere borrar: ");
		while (i < alumnos.size()) {
			System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + alumnos.get(i).getBull() + " con el indice de: " + alumnos.get(i));
		}
		 Scanner sc = new Scanner(System.in); 
		 int respuesta = sc.nextInt();
		 
		 System.out.println(" Se a eliminado cin exito al alumno!");
		 System.out.println(" Sera enviado al menu");
		 
		 borrar(respuesta);
	}
	private static void borrar(int r) {
		alumnos.remove(r);
	}
	
	private static void borrar2(int r) {
		alumnos.remove(r);
		ClaseMain.agregarAlumno();
	}
	
}