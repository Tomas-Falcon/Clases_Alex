package app;
import java.sql.*;

/**
 * 
 */
public class ClaseMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/inicial";
		String usuario = "root";
		String contraseña = "mysql";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try (Connection conexion = DriverManager.getConnection(url,usuario,contraseña); Statement stmt = conexion.createStatement();){
			
			if(conexion != null)
				System.out.println("Conectin!");
			
			System.out.println(conexion);
			String insertar = "insert into tablin values (\"Dani\",\"??\",19)";
			//String modificar = "UPDATE tablin SET apellido = \"mn2\" WHERE apellido = 'mn'";
			//String borrar = "delete from tablin where Apellido = \"mn\" ";
			stmt.execute(insertar);
			//stmt.execute(modificar);
			//stmt.execute(borrar);
			
			//String preguntar = "select * from tablin";
  
			
			System.out.println(conexion.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
