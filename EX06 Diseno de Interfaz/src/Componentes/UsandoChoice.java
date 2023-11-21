package Componentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsandoChoice extends Frame implements ActionListener{
	
	Label etiqueta;
	Choice combo;
	Button boton, boton2, boton3;
	TextField caja, caja2;
	
	public static void main(String[] args) {
		new UsandoChoice();

	}
	
	public UsandoChoice() {
		super("Usando Choice");
		setSize(330, 300);
		setLayout(new FlowLayout());
		
		etiqueta = new Label("Valores: ");
		combo = new Choice();      
		boton = new Button("Boton");
		boton2 = new Button("<- meter a la lista");
		boton3 = new Button("Seleccionar");
		caja = new TextField("                       ");
		caja2 = new TextField("                       ");
		
		combo.add("Opcion 1");
		combo.add("Opcion 2");
		combo.add("Opcion 3");
		combo.addItem("Opcion 4");
		combo.add("Opcion 5");
		combo.add("Opcion 6");
		
		combo.addItemListener(e-> {System.out.println(combo.getSelectedItem());});
		
		boton.addActionListener(e-> {
			System.out.println("El usuario a selecionado la "+combo.getSelectedItem()+" con el indice: "+combo.getSelectedIndex());
		});
		
		boton2.addActionListener(e-> {
			String valor = caja.getText().trim();
			combo.add(valor);
			});
		boton3.addActionListener(e-> {
			// int i = combo.getItemCount()-1;
			// combo.select(i);
			
			 String valor = combo.getSelectedItem();
			 caja2.setText(valor);
		});
		
		add(etiqueta);
		add(combo);
		add(boton);
		add(caja);
		add(boton2);
		add(caja2);
		add(boton3);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
