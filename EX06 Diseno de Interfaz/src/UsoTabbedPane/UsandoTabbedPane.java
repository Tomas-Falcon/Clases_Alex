package UsoTabbedPane;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class UsandoTabbedPane extends JFrame{
	
	public static void main(String[] args) {
		new UsandoTabbedPane();
	}
	
	public UsandoTabbedPane() {
		setSize(400,400);
		
		JTabbedPane panelPest = new JTabbedPane();
		
		JLabel etiqueta = new JLabel("Panel 1: ",SwingConstants.LEFT);
		JPanel panel = new JPanel();
		panel.add(etiqueta);
		panelPest.addTab("Ficah 0", null, panel, "Una ayudita");
		
		JLabel etiqueta1 = new JLabel("Panel 1: ",SwingConstants.CENTER);
		JPanel panel1 = new JPanel();
		panel1.add(etiqueta1);
		panel1.setBackground(Color.green);
		panelPest.addTab("Ficah 1", null, panel1, "Una ayudita");
		
		
		JLabel etiqueta2 = new JLabel("Panel 2: ", JLabel.LEFT);
		JPanel panel2 = new JPanel();
		panel2.add(etiqueta2);
		panel2.setBackground(Color.GRAY);
		panelPest.addTab("Ficah 2", null, panel2, "Otra ayudita");
		
		
		JLabel etiqueta3 = new JLabel("Panel 3: ", JLabel.LEFT);
		JPanel panel3 = new JPanel();
		panel3.add(etiqueta3);
		panel3.setBackground(Color.yellow);
		panelPest.addTab("Ficah 3", null, panel3, "Otra ayudita");
		
		add(panelPest);
		setVisible(true);
	}
	
}
