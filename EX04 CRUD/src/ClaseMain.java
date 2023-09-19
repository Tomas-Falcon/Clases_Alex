import java.util.*;
import java.text.*;
import java.io.*;
public class ClaseMain {
	
	static Scanner sc = new Scanner(System.in); 
	static ArrayList <Alumno> alumnos = new ArrayList <> (5);
	
	public static void main(String [] args){
		menu();
	}
	
	public static void menu(){
		
		System.out.print(" Opciones disponibles:\n-Introducir a un nuevo alumno (1)\n-Listar a los alumnos (2)\n-Eliminar alumnos (3)\n-Salir del programa (4)\n-Utiice el numero de opcion correspondiente para eligir (1, 2, 3, 4)\n-Ingrese su eleccion: ");
		
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
		
		//No anda
		//No anda
		//No anda
		//No anda
		System.out.print("¿Trabaja? S/N");
		String consulta = "S";
		//No anda
		//No anda
		//No anda
		//No anda
		boolean bull = sc.hasNext(consulta);
		//No anda
		//No anda
		//No anda
		//No anda
		
		System.out.println();
		
		Alumno alumno = new Alumno(nombre, edadInt, alturaInt, bull);
		alumnos.add(alumno);
		Controlador.ar(alumnos);
		
		menu();
		}
}
