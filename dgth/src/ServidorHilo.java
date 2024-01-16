
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
	    try {
	        nombre = entrada.readLine();
	        Servidor.enviarMensajeATodos(nombre + " se ha conectado");

	        do {
	            mensaje = entrada.readLine();
	            String usuario[] = mensaje.split(";");
	            nombre = usuario[0];
	            mensaje = usuario[1];
	            String mensajeA_Cliente = nombre + ": " + mensaje;

	            // Enviar el mensaje a todos los clientes
	            Servidor.enviarMensajeATodos(mensajeA_Cliente);
	        } while (!mensaje.equalsIgnoreCase("Adios"));

	        Servidor.enviarMensajeATodos(nombre + " se ha desconectado");
	        salida.println("Te has desconectado del servidor");

	        cliente.close();
	        entrada.close();
	        salida.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void enviarMensaje(String mensaje) {
		   salida.println(mensaje);
    }
	
}




    

