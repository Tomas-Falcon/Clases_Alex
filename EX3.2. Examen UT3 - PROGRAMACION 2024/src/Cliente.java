
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        // Configuración del cliente y servidor
        String host = "localhost";
        int port = 12345;

        try {
            // Crear socket UDP
            DatagramSocket clientSocket = new DatagramSocket();

            // Obtener el tipo de solicitud del usuario (1, 2 o 3)
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el tipo de solicitud (1 para bienvenida, 2 para fecha y hora, 3 para salir del programa): ");
            String respuestaUsuario = scanner.nextLine();
            
            if(respuestaUsuario.equals("3")) {
            	System.out.println("¡Que tenga un buen dia!, el programa ha finalizado. . .");
            	System.exit(0);
            }

            // Enviar solicitud al servidor
            byte[] enviarMsj = respuestaUsuario.getBytes();
            InetAddress direccionServidor = InetAddress.getByName(host);
            DatagramPacket sendPacket = new DatagramPacket(enviarMsj, enviarMsj.length, direccionServidor, port);
            clientSocket.send(sendPacket);

            // Configurar tiempo de espera para recibir la respuesta
            clientSocket.setSoTimeout(3000);
            

            // Esperar y recibir la respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // Mostrar la respuesta del servidor
            String respuesta = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar el escáner y el socket del cliente
            scanner.close();
            clientSocket.close();
        } catch (Exception e) {
        	//manejo de excepciones, si el servidor no esta o no se establece la coneccion, saltara la exepcion 
        	System.out.println("Tiempo de coneccion exedido");
            e.printStackTrace();
        }
    }
}