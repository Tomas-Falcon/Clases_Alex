/**
 * 
 */
package usoDelGridLayout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

/**
 * 
 */
public class GridLayoutMain extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GridLayoutMain ugl = new GridLayoutMain();

	}
	
	public GridLayoutMain () {
		super("UGL");
		setSize(400, 400);

		GridLayout gl = new GridLayout(2,3);
		

		//gl.setHgap(1);
		//gl.setVgap(1);
		//gl.setAlignment(FlowLayout.RIGHT);
		setLayout(gl);


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
