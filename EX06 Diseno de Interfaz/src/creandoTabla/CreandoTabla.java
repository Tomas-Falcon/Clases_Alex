package creandoTabla;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CreandoTabla extends JFrame {
	private Object [][] datin={
			{"Belen","Caseres","Alemania",18},
			{"Mabel","Derecho","españa",18},
			{"Malu","Toapanta","ecuador",18},
			{"Lucia","Iglesias","españa",18}
	};
	private String [] columnas= {"Nomre","aplido","Pais","Edad"};
	public static void main(String[] args) {
		new CreandoTabla();
	}
	CreandoTabla(){
		
		DataModel datitos=new DataModel();
		JTable tablin=new JTable(datitos);
		add(new JScrollPane(tablin));
		setSize(500,500);
		setVisible(true);
		
	}
}