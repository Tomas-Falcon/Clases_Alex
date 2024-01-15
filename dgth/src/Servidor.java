import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(8000);
			while (true) {
				ServidorHilo hilo = new ServidorHilo(servidor);
				hilo.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

