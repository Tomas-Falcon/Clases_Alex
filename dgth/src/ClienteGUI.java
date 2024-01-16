
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteGUI extends JFrame {

    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    private JTextArea areaChat;
    private JTextField campoMensaje;
    private String nombreUsuario;

    public ClienteGUI() {
        solicitarNombreUsuario(); // Nuevo método para solicitar el nombre de usuario

        setTitle("Cliente GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        areaChat = new JTextArea();
        areaChat.setEditable(false);

        campoMensaje = new JTextField();
        JButton botonEnviar = new JButton("Enviar");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(areaChat), BorderLayout.CENTER);
        panel.add(campoMensaje, BorderLayout.SOUTH);
        panel.add(botonEnviar, BorderLayout.EAST);

        add(panel);

        campoMensaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        conectarAServidor();
    }

    private void solicitarNombreUsuario() {
        JDialog dialog = new JDialog(this, "Ingrese su nombre de usuario", true);
        dialog.setSize(300, 150);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

      

        JLabel label = new JLabel("Nombre de usuario:");
        panel.add(label);

        JTextField campoNombreUsuario = new JTextField(10);
        panel.add(campoNombreUsuario);


        JButton botonContinuar = new JButton("Continuar");
        panel.add(botonContinuar);

        
        botonContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreUsuario = campoNombreUsuario.getText();
                if (nombreUsuario.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Debe ingresar un nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dialog.dispose();
                }
            }
        });

        dialog.add(panel);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            	try {
            		salida.close();
					entrada.close();
	            	socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	System.exit(0); 
            }
        });

        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }


  
    
    private void conectarAServidor() {
        try {
            socket = new Socket("192.168.2.241", 8000);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);

           
            

            // Hilo para recibir mensajes del servidor
            Thread hiloRecepcion = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String mensajeServidor;
                        while ((mensajeServidor = entrada.readLine()) != null) {
                            mostrarMensaje(mensajeServidor);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            hiloRecepcion.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   

    private void enviarMensaje() {
        String mensaje = campoMensaje.getText();
        if (!mensaje.isEmpty()) {
            salida.println(nombreUsuario + ";" + mensaje);
            campoMensaje.setText("");
        }
    }


    private void mostrarMensaje(String mensaje) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                areaChat.append(mensaje + "\n");
            }
        });
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }
}
