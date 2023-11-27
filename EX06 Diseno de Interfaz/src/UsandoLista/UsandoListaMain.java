package UsandoLista;

import java.awt.*;


public class UsandoListaMain extends Frame{
	
	List lista;
	Button anadir, eliminar;
	TextField textin;
	
	public static void main(String[] args) {
		new UsandoListaMain(); 
	}
	
	UsandoListaMain(){
		setSize(400,400);
		String listaNombres [] = {"Anamaria", "Bruno", "Caro", "Diego", "Tomas", "Micaela", "Nina"};
		lista = new List(3);
		lista.setMultipleMode(true);
		
		anadir = new Button("Aañadir");
		eliminar = new Button("Eliminar");
		textin = new TextField("                ");
		
		setLayout(new FlowLayout());
		
		
		for(String a : listaNombres) {
			lista.add(a);
		}
		
		anadir.addActionListener(v-> {lista.add(textin.getText());});
		eliminar.addActionListener(v-> {/*lista.remove(lista.getSelectedIndex());*/ int a[] = lista.getSelectedIndexes();
		for(int b : a) {System.out.println(b + " " + lista.getItem(b));}});
		
		// lista.remove(6);
		
		
		
		add(lista);
		add(textin);
		add(anadir);
		add(eliminar);
		
		
		setVisible(true);
	}
}
