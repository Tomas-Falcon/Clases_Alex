/**
 * 
 */
package UsoFlowLayout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

import usos_del_border_layout.UsosDelBorderLayoutMain;

/**
 * 
 */
public class UsoFlowLayout extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsoFlowLayout interfaz = new UsoFlowLayout();

	}
	public UsoFlowLayout () {
		super("Botones");
		setSize(400, 400);

		FlowLayout layout = new FlowLayout();

			layout.setHgap(1);
			layout.setVgap(1);
		setLayout(layout);


		Button boton1 = new Button("Boton 1");
		add(boton1);

		Button boton2 = new Button("Boton 2");
		add(boton2);

		Button boton3 = new Button("Boton 3");
		add(boton3);

		Button boton4 = new Button("Boton 4");
		add(boton4);

		Button boton5 = new Button("Boton 5");
		add(boton5);
		setVisible(true);
	}
}
