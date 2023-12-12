package lista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClaseListaMain extends JFrame{

	JTextField cajaNombre;
	JLabel jLNombre; 
	JList<String> listaA, listaB;
	JButton botA, botB, botAñadir;
	JPanel panelSuperior, panelInferiosUno,panelInferiosDos, panelInferiosTres, panel;
	
	public static void main(String[] args) {
		new ClaseListaMain();
	}
	
	ClaseListaMain(){
		super("Lista");
		setSize(400,400);
		
		panel = new JPanel();
		panelSuperior = new JPanel();
		panelInferiosUno = new JPanel();
		panelInferiosDos = new JPanel();
		panelInferiosTres = new JPanel();
		
		listaA = new JList<String>();
		listaB = new JList<String>();
		
		add(panel);
		panel.add(panelSuperior);
		
		panelSuperior.setLayout(new FlowLayout());
		
		jLNombre = new JLabel("Nombre ");
		cajaNombre = new JTextField("                        ");
		botAñadir = new JButton("Añadir");
		
		panelSuperior.add(jLNombre);
		panelSuperior.add(cajaNombre);
		panelSuperior.add(botAñadir);
		
		
		
		panel.add(panelInferiosUno);
		panel.add(panelInferiosDos);
		panel.add(panelInferiosTres);
		
		panelInferiosUno.add(listaA);
		panelInferiosDos.add(botA);
		panelInferiosDos.add(botB);
		panelInferiosTres.add(listaB);
		
		botAñadir.addActionListener(v-> {String nombre = cajaNombre.getText().trim(); listaA.add(nombre);});
		botA.addActionListener(v-> {});
		botB.addActionListener(v-> {});
		
		setVisible(true);
	}

}
