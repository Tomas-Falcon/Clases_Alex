package lista;

import javax.swing.JFrame;
import javax.swing.*;

import java.awt.*;


public class ClaseListaMain extends JFrame{

	JTextField cajaNombre;
	JLabel jLNombre; 
	List listaA, listaB;
	JButton botA, botB, botAñadir;
	JPanel panelSuperior, panelInferiosUno,panelInferiosDos, panelInferiosTres;
	
	public static void main(String[] args) {
		new ClaseListaMain();
	}
	
	ClaseListaMain(){
		super("Lista");
		setSize(350,200);
		
		
		panelSuperior = new JPanel();
		panelInferiosUno = new JPanel();
		panelInferiosDos = new JPanel();
		panelInferiosTres = new JPanel();
		
		listaA = new List();
		listaB = new List();

		
		
		add(panelSuperior,BorderLayout.NORTH);
		
		
		
		jLNombre = new JLabel("Nombre ");
		cajaNombre = new JTextField("                        ");
		botAñadir = new JButton("Añadir");
		botA = new JButton(">>");
		botB = new JButton("<<");

		
		panelSuperior.add(jLNombre);
		panelSuperior.add(cajaNombre);
		panelSuperior.add(botAñadir);
		
		
		
		add(panelInferiosUno,BorderLayout.EAST);
		add(panelInferiosDos,BorderLayout.CENTER);
		add(panelInferiosTres,BorderLayout.WEST);
		
		panelInferiosUno.add(listaA);
		panelInferiosDos.add(botA);
		panelInferiosDos.add(botB);
		panelInferiosTres.add(listaB);
		
		botAñadir.addActionListener(v -> {
		    String nombre = cajaNombre.getText().trim(); listaA.add(nombre);
		});
		botA.addActionListener(v-> {int indice = listaA.getSelectedIndex();	String seleccion = listaA.getItem(indice);
		listaB.add(seleccion); listaA.remove(indice);});
		botB.addActionListener(v-> {int indice = listaB.getSelectedIndex();	String seleccion = listaB.getItem(indice);
		listaA.add(seleccion); listaB.remove(indice);});
		
		setVisible(true);
	}

}
