package Componentes;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UsandoCheckBox extends Frame implements ItemListener{
	
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
				
		cb1.addItemListener(e-> itemStateChanged(e));
		cb2.addItemListener(e-> itemStateChanged(e));
		cb3.addItemListener(this);
		add(cb1);
		add(cb2);
		add(cb3);
		
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox cb = (Checkbox)(e.getSource());
		
		int operaciones = e.getStateChange();
		System.out.println("Operacion "+operaciones);
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("Seleccionado "+cb.getLabel());
			etiqueta.setText("Seleccionado! La "+cb.getLabel());
			cb.setBackground(Color.green);
		}
		
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			System.out.println("Deseleccionado "+cb.getLabel());
			etiqueta.setText("Deseleccionado! La "+cb.getLabel());
			cb.setBackground(Color.red);
		}
		
	}
}
