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
	public ClaseEscuchame() {
		
		super("Escuchame");
		setSize(400, 400);

		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		setLayout(fl);
		
		
		Button b1 = new Button("Bontoncin");
		b1.setActionCommand("i1");
		b1.addActionListener(this);
		add(b1);
		
		Button b2 = new Button("Bontoncito");
		b2.setActionCommand("i2");
		b2.addActionListener(this);
		add(b2);
		
		Button b3 = new Button("Bontoncin");
		b3.setActionCommand("i3");
		b3.addActionListener(this);
		add(b3);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String etiqueta = e.getActionCommand();
		/*
			var tiqueta = e.getSource(); 
			System.out.println(tiqueta);
			String etiqueta2 = tiqueta.toString();
			//16 23
			int a = 16, b = 23;
			String etiqueta3 = etiqueta2.substring(a,b);
		*/
		
		
			switch (etiqueta) {
			case "i1" : 
				System.out.println("Hola Bontoncin");
				break;
			case "i2" :
				System.out.println("Adios Bontoncito");
				break;
				
			case "i3" :
				System.out.println("no soy Bontoncin");
				break;
			}
		
	}
	
	
	
	
}


