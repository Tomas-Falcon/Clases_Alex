package UsandoLista;

import java.awt.*;


public class UsandoListaMain extends Frame{
	List lista;
	public static void main(String[] args) {
		new UsandoListaMain(); 
	}
	
	UsandoListaMain(){
		setSize(400,400);
		String listaNombres [] = {"Anamaria", "Bruno", "Caro", "Diego", "Tomas", "Micaela", "Nina"};
		lista = new List();
		lista.setMultipleMode(true);
		
		Panel panel = new Panel();
		panel.setSize(400,250);
		panel.setLayout(new BorderLayout());
		panel.add(lista, BorderLayout.CENTER);
		
		
		for(String a : listaNombres) {
			lista.add(a);
		}
		
		setLayout(new BorderLayout());
		add(lista);
		
		setVisible(true);
	}
}
