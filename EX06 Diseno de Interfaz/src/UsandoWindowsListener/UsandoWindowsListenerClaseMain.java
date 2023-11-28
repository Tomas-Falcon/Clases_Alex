package UsandoWindowsListener;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UsandoWindowsListenerClaseMain extends Frame implements WindowListener{

	public static void main(String[] args) {
		new UsandoWindowsListenerClaseMain();

	}
	
	UsandoWindowsListenerClaseMain(){
		super("Usando Windows Listener");
		setSize(500,500);
		addWindowListener(this);
		
		
		
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println(e);
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println(e);
		
	}
}
