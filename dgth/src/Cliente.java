import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends JFrame {

    private JTextArea areaChat;
    private JTextField campoMensaje;
    private String nombreUsuario;

    public Cliente() {
        setTitle("Cliente");
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

        obtenerNombreUsuario();
        conectarAServidor();
    }

    private void obtenerNombreUsuario() {
        nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar vacío. Saliendo.");
            System.exit(0);
        }
    }

    private void conectarAServidor() {
        try {
            Socket cliente = new Socket("192.168.2.241", 12345);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            salida.println(nombreUsuario); // Enviar el nombre de usuario al servidor

            String mensaje = entrada.readLine();
            areaChat.append(mensaje + "\n");

            do {
                mensaje = JOptionPane.showInputDialog("Ingrese su mensaje:");
                if (mensaje != null) {
                    salida.println(nombreUsuario + ": " + mensaje);
                }
            } while (mensaje != null && !mensaje.equalsIgnoreCase("Adios"));

            cliente.close();
            entrada.close();
            salida.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void enviarMensaje() {
        String mensaje = campoMensaje.getText();
        if (!mensaje.isEmpty()) {
            areaChat.append(nombreUsuario + ": " + mensaje + "\n");
            campoMensaje.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Cliente().setVisible(true);
        });
    }
}

