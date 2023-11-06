package EventosDeTeclado;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTecladoClaseMain extends Frame implements KeyListener{

	private Label key;
	private TextField tf;
	
	public static void main(String[] args) {
		new EventosTecladoClaseMain();
		}
	
	public EventosTecladoClaseMain() {
		String separador = "           ";
		tf = new TextField(20);
		tf.addKeyListener(this);
		key = new Label("Key = "+separador);
		setLayout(new FlowLayout());
		add(key);
		add(tf);
		setSize(400, 400);
		setVisible(true);
		}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped() "+e.getKeyChar());
		key.setText("Tecla pulsada "+e.getKeyChar());		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed()");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased()");
		
	}

}
