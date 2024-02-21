package usandoJSlider;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class UsandoJslider extends JFrame{
	
	JSlider jslider;
	JLabel etiqueta;
	
	public static void main(String[] args) {
		new UsandoJslider();	
	}
	
	UsandoJslider(){
		jslider = new JSlider();
		jslider.setValue(70);
		etiqueta = new JLabel();
		
		jslider.addChangeListener(v-> {
			int valor = jslider.getValue();
			etiqueta.setText(String.valueOf(valor));
		});
		
		JPanel panel = new JPanel();
		
		panel.add(new Label("Valor: "));
		panel.add(etiqueta);
		panel.add(jslider);
		
		add(panel);
		setSize(400,400);
		setVisible(true);
	}
}
