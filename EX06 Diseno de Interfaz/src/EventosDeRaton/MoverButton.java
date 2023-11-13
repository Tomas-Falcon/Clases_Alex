package Raton;

import java.awt.Button;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MoverButton extends Frame implements MouseMotionListener{
	private static final long serialVersionUID = 1L;
	Label xPos,yPos;
	Button botoncin;

	public static void main(String[] args) {
		new MoverButton();
	}
	
	MoverButton() {
		String separador="   ";
		xPos= new Label("x=0"+separador);
		xPos.setBounds(40,40,90,70);
		yPos= new Label("y=0"+separador);
		yPos.setBounds(40,40,90,70);
		botoncin= new Button ("Aceptar");
		botoncin.setSize(50,30);
		botoncin.setLocation(200,40);
		setLayout(null);
		
		add(xPos);
		add(botoncin);
		add(yPos);
		
	
		addMouseMotionListener(this);
		setSize(400,400);
		setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		xPos.setText("Dragged x="+ e.getX());
		yPos.setText("Dragged y="+ e.getY());
		botoncin.setLocation(e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		xPos.setText("Movimiento x="+ e.getX());
		yPos.setText("Movimiento y="+ e.getY());
		
	}

}
