import java.util.*;
public class Controlador{
	
	private static ArrayList <Alumno> alumnos = new ArrayList <> (1);
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
		System.out.println("Adios!");
		System.exit(0);
	}
	
	public static void ar(ArrayList <Alumno> alumnos1) {
		alumnos = alumnos1;
	}
	
	private static void listarAlumno() {
		int i = 0;
		if (alumnos.get(0) != null) {
			String trabaja = ""; 
			
			while (i < alumnos.size()) {
				if (alumnos.get(i).getBull() != false) {
					trabaja = "Si trabaja";
				}else {
					trabaja = "No trabaja";
				}
				System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + trabaja + " con el indice de: " + i);
				i++;
			}
			System.out.println("Sera enviado al menu");
			ClaseMain.menu();
		}else {
			System.out.println("Primero se necesitan agregar alumnos, sera enviado al menu");
			ClaseMain.menu();
		}
	}
	
	private static void modificarAlumno() {
		int i = 0;
		if (alumnos.get(0) != null) {	
			while (i < alumnos.size()) {
				String trabaja = ""; 
				if (alumnos.get(i).getBull() == true) {
					trabaja = "Si trabaja";
				}else {
					trabaja = "No trabaja";
				}
				System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + trabaja + " con el indice de: " + i);
				i++;
			}
		}else{
			System.out.println("Primero se necesitan agregar alumnos, sera enviado al menu");
			ClaseMain.menu();
		}
		System.out.println("Ingrese el indice del alumno que quiere modificar: ");
		Scanner sc = new Scanner(System.in); 
		 int respuesta = sc.nextInt();
		 
		 borrar2(respuesta);
		 sc.close();
	}
	
	private static void eliminarAlumno() {		
		int i = 0;
		if (alumnos.get(0) != null){	
			System.out.println("Ingrese el indice del alumno que quiere borrar: ");
			while (i < alumnos.size()) {
				String trabaja = ""; 
				if (alumnos.get(i).getBull() == true) {
					trabaja = "Si trabaja";
				}else {
					trabaja = "No trabaja";
				}
				System.out.println("El alumno con los datos de nombre, edad altura y trabaja: "+alumnos.get(i).getNombre() + "  " + alumnos.get(i).getEdad() + "  " + alumnos.get(i).getAltura() + "  " + trabaja + " con el indice de: " + i);
				i++;
			}
		}else{
			System.out.println("Primero se necesitan agregar alumnos, sera enviado al menu");
			ClaseMain.menu();
		}
		 Scanner sc = new Scanner(System.in); 
		 int respuesta = sc.nextInt();
		 
		 System.out.println(" Se a eliminado cin exito al alumno!");
		 System.out.println(" Sera enviado al menu");
		 
		 borrar(respuesta);
		 sc.close();
	}
	private static void borrar(int r) {
		alumnos.remove(r);
	}
	
	private static void borrar2(int r) {
		alumnos.remove(r);
		System.out.println("Ahora puede agregar correctamente al alumno");
		ClaseMain.agregarAlumno();
	}
	
}