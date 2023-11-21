package Componentes;

import java.awt.*;
import java.awt.event.ActionListener;

public class UsandoChoice extends Frame implements ActionListener{
	
	Label etiqueta;
	Choice combo;
	Button boton;
	
	public static void main(String[] args) {
		new UsandoChoice();

	}
	
	public UsandoChoice() {
		super("Usando Choice");
		setSize(500,500);
		setLayout(new FlowLayout());
		
		etiqueta = new Label("Valores: ");
		combo = new Choice();      
		boton = new Button("Boton");
		combo.add("Opcion 1");
		combo.add("Opcion 2");
		combo.add("Opcion 3");
		combo.addItem("Opcion 4");
		combo.add("Opcion 5");
		combo.add("Opcion 6");
		boton.addActionListener(e-> {
			System.out.println("El usuario a selecionado la "+combo.getSelectedItem()+" con el indice: "+combo.getSelectedIndex());
		});
		
		add(etiqueta);
		add(combo);
		add(boton);
		
		setVisible(true);
	}

}
