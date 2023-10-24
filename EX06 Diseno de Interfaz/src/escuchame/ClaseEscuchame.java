/**
 * 
 */
package escuchame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;

/**
 * 
 */
public class ClaseEscuchame extends Frame implements ActionListener{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClaseEscuchame claseEscuchame = new ClaseEscuchame();
	}
	
	Button b1 = new Button("Bontoncin");
	Button b2 = new Button("Bontoncito");
	Button b3 = new Button("Bontoncin");
	
	public ClaseEscuchame() {
		
		super("Escuchame");
		setSize(400, 400);

		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		setLayout(fl);
		
		
	
		b1.setActionCommand("i1");
		b1.addActionListener(this);
		add(b1);
		
		
		b2.setActionCommand("i2");
		b2.addActionListener(this);
		add(b2);
		
		
		b3.setActionCommand("i3");
		b3.addActionListener(this);
		add(b3);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button boton = (Button)e.getSource();
		if(boton==b1) {
			System.out.println("Hola Bontoncin    (i1 || button0 || b1)");
			b1.setBackground(Color.getHSBColor(118, 100, 69));
			
		}else if(boton==b2) {
			System.out.println("Adios Bontoncito    (i2 || button1 || b2)");
			b2.setBackground(Color.gray);
		}else if(boton==b3) {
			System.out.println("no soy Bontoncin    (i3 || button2 || b3)");
			b3.setBackground(Color.getHSBColor(14, 96, 100));
		}
		
		
		
		/*
		 // Tu no
		  var etiqueta2 = e.getSource();
		String etiqueta3 = etiqueta2.toString();
		int a = 16, b = 23;
		etiqueta3 = etiqueta3.substring(a,b);
		System.out.println(etiqueta3);	
			switch (etiqueta3) {
			case "button0" : 
				System.out.println("Hola Bontoncin    (i1 || button0 || b1)");
				break;
			case "button1" :
				System.out.println("Adios Bontoncito    (i2 || button1 || b2)");
				break;
			case "button2" :
				System.out.println("no soy Bontoncin    (i3 || button2 || b3)");
				break;
			}*/
		
	}
	
}