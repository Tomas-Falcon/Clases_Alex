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
		try {
			Class.forName("com.mysql.jdbc.Drive");
			String url = "";
			String usuario = "root";
			String contraseña = "mysql";
			
			Conection conexion = DriverManager.getConnection(url,usuario,contraseña);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
