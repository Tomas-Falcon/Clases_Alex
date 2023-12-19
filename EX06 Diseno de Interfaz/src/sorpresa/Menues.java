package sorpresa;


import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Menues extends JFrame{

	public static void main(String[] args) {
		new Menues();

	}
	
	Menues() {
		super("Menu item");
		setSize(400,400);
		setLayout(new FlowLayout());
		JMenuItem m1 = new JMenuItem("Item 1");
		JMenuItem m2 = new JMenuItem("Item 2");
		JMenuItem m3 = new JMenuItem("Item 3");
		JMenuItem m4 = new JMenuItem("Item 4");
		JMenuItem m5 = new JMenuItem("Item 5");
		JMenuItem m6 = new JMenuItem("Item 6");
		JMenuItem m7 = new JMenuItem("Salir");
		
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem cortar = new JMenuItem("Cortar"); 
		JMenuItem pegar = new JMenuItem("Pegar"); 
		
		popup.add(copiar);
		popup.add(cortar);
		popup.add(pegar);
		
		JMenu menu = new JMenu("Archivo");
		
		JMenuItem mA = new JMenuItem("Item A");
		JMenuItem mB = new JMenuItem("Item B");
		JMenuItem mC = new JMenuItem("Item C");
		JTextArea textarea = new JTextArea(4,30);
		textarea.setComponentPopupMenu(popup);
		add(textarea);
		JMenu menu2 = new JMenu("PERACIONES");
		
		JMenu menu3 = new JMenu("SubMenu");
		
		JMenuItem m1A = new JMenuItem("M1A");
		JMenuItem m2B = new JMenuItem("M2B");
		JMenuItem m3C = new JMenuItem("M3C");
		
		JCheckBoxMenuItem item1 = new JCheckBoxMenuItem("Item 1");
		JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("Item 2");
		JCheckBoxMenuItem item3 = new JCheckBoxMenuItem("Item 3");
		
		ButtonGroup grp = new ButtonGroup();
		
		JRadioButtonMenuItem opcionA = new JRadioButtonMenuItem("Opcion A");
		JRadioButtonMenuItem opcionB = new JRadioButtonMenuItem("Opcion B");
		JRadioButtonMenuItem opcionC = new JRadioButtonMenuItem("Opcion C");
		
		grp.add(opcionA);
		grp.add(opcionB);
		grp.add(opcionC);
		
		menu3.add(m1A);
		menu3.add(m2B);
		menu3.add(m3C);
		m7.setMnemonic(KeyEvent.VK_R);
		
		m7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.ALT_MASK));
		
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		menu.add(m6);
		menu.add(m7);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		
		menu2.add(mA);
		menu2.add(mB);
		menu2.add(mC);
		menu2.add(opcionA);
		menu2.add(opcionB);
		menu2.add(opcionC);
		menu.add(menu3);
		
		m7.addActionListener(v-> {System.exit(0);});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		menuBar.add(menu2);
		
		
		setJMenuBar(menuBar);
		setVisible(true);
	}

}
