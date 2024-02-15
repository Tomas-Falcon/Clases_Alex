import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Servidor {
    public static void main(String[] args) {
        // Configuración del servidor
        int puerto = 12345;

        try {
            // Crear socket UDP
            DatagramSocket serverSocket = new DatagramSocket(puerto);

            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                // Recibir solicitud del cliente
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Obtener datos del paquete recibido
                String requestType = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Procesar la solicitud y enviar la respuesta
                InetAddress direccionCliente = receivePacket.getAddress();
                int clientpuerto = receivePacket.getPort();
                
                // se espera 1 segundo antes de enviar la informacion al cliente para que los trozos de "salchichas", os paquetes no se superpongan
                Thread.sleep(1000);
                if (requestType.equals("1")) {
                    // Enviar direccion IP del servidor y mensaje de bienvenida
                    String respuestaParaCliente = "Bienvenido al servidor - IP: " + direccionCliente.getHostAddress();
                    enviarRespuesta(serverSocket, respuestaParaCliente, direccionCliente, clientpuerto);
                } else if (requestType.equals("2")) {
                    // Enviar fecha y hora del servidor (hora actual)
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String respuestaParaCliente = "Fecha y hora del servidor: " + dateFormat.format(new Date());
                    enviarRespuesta(serverSocket, respuestaParaCliente, direccionCliente, clientpuerto);
                }else {
                	String respuestaParaCliente = "ERROR: tiempo de coneccion superado o no se mando la informacion correcta";
                    enviarRespuesta(serverSocket, respuestaParaCliente, direccionCliente, clientpuerto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void enviarRespuesta(DatagramSocket socket, String respuestaParaCliente, InetAddress direccionCliente, int clientpuerto) {
        try {
        	System.out.println(respuestaParaCliente + " Cliente con la ip: " + direccionCliente.toString());
            byte[] datosParaCliente = respuestaParaCliente.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(datosParaCliente, datosParaCliente.length, direccionCliente, clientpuerto);
            socket.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

