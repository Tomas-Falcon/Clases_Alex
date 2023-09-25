import java.util.*;
public class ClaseMain {
	
	static Scanner sc = new Scanner(System.in); 
	static ArrayList <Alumno> alumnos = new ArrayList <> (1);
	
	public static void main(String [] args){
		menu();
	}
	
	public static void menu(){
		
		System.out.print(" Opciones disponibles:\n-Introducir a un nuevo alumno (1)\n-Listar a los alumnos (2)\n-Modificar alumnos (3)\n-Eliminar alumnos (4)\n-Salir del programa (5)\n-Utiice el numero de opcion correspondiente para eligir (1, 2, 3, 4, 5)\n-Ingrese su eleccion: ");
		
		String eleccion = sc.nextLine();
		System.out.println("#···································································#");
		
		Controlador.chequearEleccion(eleccion);
	}
	
	public static void agregarAlumno(){
		System.out.print("Ingrese el nombre");
		String nombre = sc.nextLine();
		System.out.println();
		
		System.out.print("Ingrese la edad");
		String edad = sc.nextLine();
		System.out.println();
		int edadInt = Integer.parseInt(edad);
		
		System.out.print("Ingrese la altura");
		String altura = sc.nextLine();
		System.out.println();
		int alturaInt = Integer.parseInt(altura);
		
		System.out.print("¿Trabaja? S/N");
		String consulta = sc.nextLine();
		boolean bull = false;
		switch (consulta) {
		case "S" : 
			bull = true;
			break;
		case "s" : 
			bull = true;
			break;
		case "N" : 
			bull = false;
			break;
		case "n" : 
			bull = false;
			break;
		}
		System.out.println();
		Alumno alumno = new Alumno(nombre, edadInt, alturaInt, bull);
		alumnos.add(alumno);
		Controlador.ar(alumnos);
		
		menu();
		}
}
