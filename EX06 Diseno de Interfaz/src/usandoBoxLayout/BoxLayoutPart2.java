package usandoBoxLayout;


import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutPart2 {
	
	public static void main(String[] args) {
		new BoxLayoutPart2();
	}
	
	BoxLayoutPart2(){
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");
		JButton jb4 = new JButton("4");
		JButton jb5 = new JButton("5");
		JButton jb6 = new JButton("6");
		
		jb1.setAlignmentX(Component.LEFT_ALIGNMENT);
		jb2.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		jb3.setAlignmentX(Component.CENTER_ALIGNMENT);
		jb4.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		jb5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jb6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JFrame frame =  new JFrame("Usando BoxLayout alineado");
		frame.setSize(400,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		
		panel1.setBorder(BorderFactory.createTitledBorder("LEFT"));
		panel2.setBorder(BorderFactory.createTitledBorder("CENTER"));
		panel3.setBorder(BorderFactory.createTitledBorder("RIGHT"));
		
		BoxLayout caja = new BoxLayout(panel1, BoxLayout.PAGE_AXIS);
		panel1.setLayout(caja);
		
		panel1.add(jb1);
		panel1.add(jb2);
		
		BoxLayout caja3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		panel3.setLayout(caja3);
		
		BoxLayout caja2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(caja2);
		
		panel2.add(jb4);
		panel2.add(jb3);	
		
		panel3.add(jb5);
		panel3.add(jb6);

		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		
		frame.setVisible(true);
	}
}
