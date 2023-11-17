package Componentes;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxEvolucionMain extends Frame implements ItemListener{
	
	Checkbox rd1, rd2, rd3;
	CheckboxGroup grp;
	TextField etiqueta1, etiqueta2;
	
	
	public static void main(String[] args) {
		new CheckBoxEvolucionMain();
	}

	public CheckBoxEvolucionMain() {
		
		super("CheckBoxEvolucionMain");
		
		setSize(340, 300);
		setLayout(new FlowLayout());
		
		grp = new CheckboxGroup();
		rd1 = new Checkbox("Opcion 1", grp, false);
		rd2 = new Checkbox("Opcion 2", grp, false);
		rd3 = new Checkbox("Opcion 3", grp, true);
		
		rd1.addItemListener(e -> manejarGrupo(e));
		rd2.addItemListener(e -> manejarGrupo(e));
		rd3.addItemListener(e -> manejarGrupo(e));
		
		etiqueta1 = new TextField("                                 ");
		etiqueta2 = new TextField("                                 ");
		

		add(etiqueta1);
		add(etiqueta2);
		add(rd1);
		add(rd2);
		add(rd3);
		add(new Button("<<<NO HACE NADA>>>"));
		
		setVisible(true);
		
	}
	
	public void manejarGrupo(ItemEvent e) {
		Checkbox cb = (Checkbox) (e.getSource());
		int operacion = e.getStateChange(); 
				switch (operacion) {
					case ItemEvent.DESELECTED: {
						//no hace nada
						etiqueta1.setBackground(Color.blue);
						etiqueta2.setBackground(Color.yellow);
						break;
					}
					case ItemEvent.SELECTED: {
						//hace cosas
						break;
					}
				}
	}
	
	public void itemStateChanged(ItemEvent e) {
				
	}
}
