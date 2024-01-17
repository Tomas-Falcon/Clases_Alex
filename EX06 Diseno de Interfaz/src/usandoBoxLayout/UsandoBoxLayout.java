package usandoBoxLayout;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsandoBoxLayout {
	
	public static void main(String[] args) {
		new UsandoBoxLayout();
	}
	
	UsandoBoxLayout(){
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");
		JButton jb4 = new JButton("4");
		JButton jb5 = new JButton("5");
		JButton jb6 = new JButton("6");
		JButton jb7 = new JButton("7");
		JButton jb8 = new JButton("8");

		JFrame frame =  new JFrame("Usando BoxLayout");
		frame.setSize(300,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		BoxLayout caja = new BoxLayout(panel1, BoxLayout.PAGE_AXIS);
		panel1.setLayout(caja);
		
		panel1.add(jb1);
		panel1.add(jb2);
		panel1.add(jb3);
		panel1.add(jb4);
		
		BoxLayout caja2 = new BoxLayout(panel2, BoxLayout.LINE_AXIS);
		panel2.setLayout(caja2);
		
		panel2.add(jb5);
		panel2.add(jb6);
		panel2.add(jb7);
		panel2.add(jb8);
		
		frame.add(panel1);
		frame.add(panel2);
		
		frame.setVisible(true);
	}
}
