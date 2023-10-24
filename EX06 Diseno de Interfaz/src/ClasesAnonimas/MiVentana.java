/**
 * 
 */
package ClasesAnonimas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class MiVentana extends Frame{
	Button b1, b2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MiVentana();

	}
	public MiVentana() {
		super("ClasesAnonimas");
	setLayout(new FlowLayout());
	setSize(800,800);
	b1 = new Button("Botoncin 1");
	b2 = new Button("Botoncito 2");
	add(b1);
	add(b2);
	b1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Boton 1 \"b1\"");
			
			}
		});
	
	b2.addActionListener(new ActionListener() {		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Boton 2 \"b2\"");
		}
	});
	
	setVisible(true);
	}

}
