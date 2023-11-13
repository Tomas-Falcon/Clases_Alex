package EventosDeRaton;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouseListener extends Frame implements ActionListener, MouseListener {
	Button b1,b2;
	public static void main(String[] args) {
		new EventosMouseListener();
	}
	EventosMouseListener(){
		super("NO SE QUE ES ESTO");
		setSize(500,500);
		b1=new Button ("Boton num1");
		b2=new Button ("Boton num2");
		FlowLayout layout=new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		setLayout(layout);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed");
				
			}
		});
		b2.addMouseListener(this);							
		b1.addActionListener(this);
		add(b1);
		add(b2);
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
		b2.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
		b2.setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("actionPerformed implements");
	}
}
