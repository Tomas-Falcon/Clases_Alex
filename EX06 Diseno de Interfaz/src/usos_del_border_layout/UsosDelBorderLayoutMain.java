/**
 * 
 */
package usos_del_border_layout;

import java.awt.*;

/**
 * 
 */
public class UsosDelBorderLayoutMain extends Frame{
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsosDelBorderLayoutMain interfaz = new UsosDelBorderLayoutMain();

	}
	
	public UsosDelBorderLayoutMain() {
		
		super("Botones cardinales");
		setSize(400, 400);
				
		BorderLayout layout = new BorderLayout();
		
		layout.setHgap(50);
		layout.setVgap(50);
		setLayout(layout);
		
		
		Button botonNorte = new Button("Boton Norte");
		add(botonNorte, "North");
		
		Button botonSur = new Button("Boton Sur");
		add(botonSur, "South");
		
		Button botonEste = new Button("Boton Este");
		add(botonEste, "East");
		
		Button botonOeste = new Button("Boton Oeste");
		add(botonOeste, "West");
		
		Button botonCentro = new Button("Boton Centro");
		add(botonCentro, "Center");
		setVisible(true);
	}

}
