package Componentes;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

public class UsandoCheckBox extends Frame{
	
	Checkbox cb1, cb2, cb3;
	TextField etiqueta, etiqueta2;
	
	public static void main(String[] args) {
		new UsandoCheckBox();
	}
	
	public UsandoCheckBox() {
		super("Usando CheckBox");
		setSize(500, 160);
		
		cb1 = new Checkbox("Opcion 1");
		cb2 = new Checkbox("Opcion 2");
		cb3 = new Checkbox("Opcion 3");
		etiqueta = new TextField("Etiqueta", 60);
		etiqueta2 = new TextField("Etiqueta", 60);
		
		setLayout(new FlowLayout());
		
		
		etiqueta.setEditable(false);
		etiqueta2.setEnabled(false);
		add(etiqueta);
		add(etiqueta2);
		add(cb1);
		add(cb2);
		add(cb3);
		
		setVisible(true);
	}
}
