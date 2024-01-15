package dgth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket cliente = new Socket("192.168.7.156", 8000);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			System.out.println(entrada.readLine());
			System.out.println(entrada.readLine());
			String nombre = sc.nextLine();
			salida.println(nombre);
			System.out.println(entrada.readLine());
			String mensaje = null;
			do {
				mensaje = sc.nextLine();
				salida.println(mensaje);
			} while (!mensaje.equalsIgnoreCase("Adios"));
			System.out.println(entrada.readLine());
			sc.close();
			cliente.close();
			entrada.close();
			salida.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}