import java.awt.*;
public class ClaseMain {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(400, 300);
		f.setTitle("Hola awt");
		
		Button boton = new Button(); 
		boton.setSize(200, 40);
		boton.setLocation(100, 100);
		f.setLayout(null);
		f.add(boton);
		
		Frame f2 = new Frame();
		f2.setSize(400, 300);
		f2.setTitle("Adios awt");
		f2.setVisible(true);
		f.setVisible(true);
		
	}

}
