package UsandoWindowsListener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;

public class DialogoClaseMain extends Frame{
	
	private static final long SerianVersionUID = 1L;
	Button bt1, bt2;
	Dialog dialogo; 
	
	public static void main(String[] args) {
		new DialogoClaseMain();
	}
	
	public DialogoClaseMain() {
		super("Usando Dialogo");
		setSize(500,500);
		setLayout(new FlowLayout());
		
		bt1 = new Button("Abrir");
		bt1.addActionListener(e-> crearDialogo(e));
		
		bt2 = new Button("Cerrar");
		bt2.addActionListener(e-> cerrarDialogo(e));
		
		add(bt2);
		add(bt1);
		setVisible(true);
	}
	
	public void crearDialogo(ActionEvent e) {
		System.out.println("abrir()");
		dialogo = new Dialog(this, "Esto es un dialogo");
		dialogo.setSize(200,100);
		Label lb1 =new Label("Esto es una");
		Label lb2 =new Label("etiqueta");
		dialogo.setLayout(new FlowLayout());
		dialogo.add(lb1);
		dialogo.add(lb2);
		dialogo.setVisible(true);
		
	}
	
	public void cerrarDialogo(ActionEvent e) {
		System.out.println("cerrar()");
		if(dialogo.isShowing()){dialogo.dispose();}
		
	}
}
