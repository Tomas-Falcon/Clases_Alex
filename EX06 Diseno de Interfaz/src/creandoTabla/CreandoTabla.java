package creandoTabla;


import javax.swing.JFrame;
import javax.swing.JTable;

public class CreandoTabla extends JFrame{
	
	private Object [][] tabla = {
			{"Tomas","Falcon","Argentino",21},
			{"Daniel","Gonzales","Español",20},
			{"Diego","Manzano","Ecuatoriano",22},
			{"Manu","Melgar","Español",19},
			{"Mica","Perez","Argentina",22}
	};
	
	private String[] columnas = {"Nombre","Apellido","Nacionalidad","Edad"};
	
	public static void main(String[] args) {
		new CreandoTabla();
	}
	
	
	public CreandoTabla() {
		setSize(400,400);
		
		JTable tabla = new JTable();
		add(tabla);
		tabla.add(columnas, tabla);
		
		setVisible(true);
	}
}
