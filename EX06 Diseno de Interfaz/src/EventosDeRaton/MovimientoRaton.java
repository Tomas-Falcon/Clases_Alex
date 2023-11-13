package EventosDeRaton;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MovimientoRaton extends Frame implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	Label xPos,yPos;
	Button botoncin;
	
	public static void main(String[] args) {
		new MovimientoRaton();
	}
	
	MovimientoRaton() {
		String separador="   ";
		xPos= new Label("x=0"+separador);
		yPos= new Label("y=0"+separador);
	//	botoncin= new Button ("Aceptar");
		setLayout(new FlowLayout());
		
		add(xPos);
		//add(botoncin);
		add(yPos);
		
	
		addMouseMotionListener(this);
		setSize(400,400);
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xPos.setText("Dragged x="+ e.getX());
		yPos.setText("Dragged y="+ e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		xPos.setText("Movimiento x="+ e.getX());
		yPos.setText("Movimiento y="+ e.getY());
		
	}
}
