package EventosDeTeclado;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoverButtonTeclado extends Frame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Label key;
	private TextField tf;
	private Button boton;
	
	
	public static void main(String[] args) {
		new MoverButtonTeclado();
	}
	
	public MoverButtonTeclado() {
		super("sigo sin saber que hago ");
		setLayout(new FlowLayout());
		setSize(700,500);
		String separador ="";
		boton=new Button("Aceptar");
		boton.setLocation(350,250);
		tf= new TextField();
		tf.addKeyListener(this);
		key=new Label("key="+separador);
		
		
		add(key);
		add(tf);
		add(boton);
	
		setVisible(true);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed()"+e.getKeyCode());
		key.setText("Tecla Pulsada "+e.getKeyCode());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//este se ejecuta siempre 
		
		switch(e.getKeyCode()) {}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key.setText("keyReleased "+e.getKeyChar());
		System.out.println("KR"+e.getKeyChar());
		
		
	}
}