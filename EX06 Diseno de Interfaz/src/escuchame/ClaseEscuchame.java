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
		b1.addActionListener(this);
		add(b1);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("botoncin precionado");
	}
	
	

}
