import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Servidor extends JFrame {
    private static final List<ServidorHilo> hilos = new ArrayList<>();
    private static ServerSocket servidorCerrar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Servidor());
    }

    public Servidor() {
        setTitle("Servidor");
        setSize(400, 300);
        setLayout(new FlowLayout());

        JButton cerrar = new JButton("Cerrar Servidor");
        JTextArea estado = new JTextArea("          ");

        add(cerrar);
        add(estado);

        try {
            ServerSocket servidor = new ServerSocket(8000);
            servidorCerrar = servidor;

            cerrar.addActionListener(v -> {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            servidorCerrar.close();
                            estado.setBackground(Color.red);
                            estado.setText("Conexion cerrada");
                            Thread.sleep(5000);
                            System.exit(0);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();
            });

            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    if (!servidorCerrar.isClosed()) {
                        SwingUtilities.invokeLater(() -> {
                            estado.setBackground(Color.green);
                            estado.setText("Conexion abierta");
                        });
                    } else {
                        SwingUtilities.invokeLater(() -> {
                            estado.setBackground(Color.red);
                            estado.setText("Conexion cerrada");
                        });
                    }

                    while (true) {
                        ServidorHilo hilo = new ServidorHilo(servidor);
                        hilos.add(hilo);
                        hilo.start();
                    }
                }
            };

            worker.execute(); // Ejecutar el SwingWorker en segundo plano
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enviarMensajeATodos(String mensaje) {
        for (ServidorHilo hilo : hilos) {
            hilo.enviarMensaje(mensaje);
        }
    }
}
