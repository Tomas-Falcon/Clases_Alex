
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private BufferedReader entrada;
	private PrintWriter salida;

	public ServidorHilo(ServerSocket server) {
		try {
			cliente = server.accept();
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new PrintWriter(cliente.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String nombre = null;
		String mensaje = null;
		salida.println("Hola, te has conectado al servidor");
		salida.println("Escribe tu nombre");
		try {
			nombre = entrada.readLine();
			System.out.println(nombre + " se ha conectado");
			salida.println("Escribe, esto es un chat");
			do {
				mensaje = entrada.readLine();
				System.out.println(nombre + ": " + mensaje);
			} while (!mensaje.equalsIgnoreCase("Adios"));
			System.out.println(nombre + " se ha desconectado");
			salida.println("Te has desconectado del servidor");
			cliente.close();
			entrada.close();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}