package sorpresa;


import java.awt.*;


public class Menues extends Frame{

	public static void main(String[] args) {
		new Menues();

	}
	
	Menues() {
		super("Menu item");
		setSize(400,400);
		
		MenuItem m1 = new MenuItem("Item 1");
		MenuItem m2 = new MenuItem("Item 2");
		MenuItem m3 = new MenuItem("Item 3");
		MenuItem m4 = new MenuItem("Item 4");
		MenuItem m5 = new MenuItem("Item 5");
		MenuItem m6 = new MenuItem("Item 6");
		MenuItem m7 = new MenuItem("Salir");
		
		Menu menu = new Menu("Archivo");
		
		MenuItem mA = new MenuItem("Item A");
		MenuItem mB = new MenuItem("Item B");
		MenuItem mC = new MenuItem("Item C");
		
		Menu menu2 = new Menu("PERACIONES");
		
		Menu menu3 = new Menu("SubMenu");
		
		MenuItem m1A = new MenuItem("M1A");
		MenuItem m2B = new MenuItem("M2B");
		MenuItem m3C = new MenuItem("M3C");
		
		menu3.add(m1A);
		menu3.add(m2B);
		menu3.add(m3C);
		
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		menu.add(m6);
		menu.add(m7);
		
		menu2.add(mA);
		menu2.add(mB);
		menu2.add(mC);
		menu.add(menu3);
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menu);
		menuBar.add(menu2);
		
		
		setMenuBar(menuBar);
		setVisible(true);
	}

}
