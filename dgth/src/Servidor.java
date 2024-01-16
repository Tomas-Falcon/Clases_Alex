import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Servidor extends JFrame{
    private static List<ServidorHilo> hilos = new ArrayList<>();
    static ServerSocket servidorCerrar;
    public static void main(String[] args) {
    	new Servidor();
        
    }

    public Servidor(){
    	 setTitle("Servidor");
         setSize(400, 300);
         try {
             ServerSocket servidor = new ServerSocket(8000);
             servidorCerrar = servidor;
             while (true) {
                 ServidorHilo hilo = new ServidorHilo(servidor);
                 hilos.add(hilo); // Agregar el hilo a la lista
                 hilo.start();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         JButton cerrar = new JButton("Cerrar Servidor");
         JTextArea estado = new JTextArea();
         if(!servidorCerrar.isClosed()) {
        	 estado.setBackground(Color.green); estado.setText("Conexion abierta");        	 
         }else{estado.setBackground(Color.red); estado.setText("Conexion cerrada");}
         cerrar.addActionListener(v-> {try {
			servidorCerrar.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
         add(cerrar);
         add(estado);
         setVisible(true);
    }
    
    public static void enviarMensajeATodos(String mensaje) {
        // Iterar sobre todos los hilos y enviar el mensaje a cada cliente
        for (ServidorHilo hilo : hilos) {
            hilo.enviarMensaje(mensaje);
            
        }
    }
}
