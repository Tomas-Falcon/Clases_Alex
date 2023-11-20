package Componentes;

import java.awt.*;

public class UsandoChoice extends Frame{
	
	Label etiqueta;
	Choice combo;
	
	public static void main(String[] args) {
		new UsandoChoice();

	}
	
	public UsandoChoice() {
		super("Usando Choice");
		setSize(500,500);
		setLayout(new FlowLayout());
		
		etiqueta = new Label("Valores: ");
		combo = new Choice();
		
		combo.add("Opcion 1");
		combo.add("Opcion 2");
		combo.add("Opcion 3");
		combo.addItem("Opcion 4");
		combo.add("Opcion 5");
		combo.add("Opcion 6");
				
		add(etiqueta);
		add(combo);
		
		setVisible(true);
	}

}
