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
		Connection conexion = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 conexion = DriverManager.getConnection(url,usuario,contraseña);
			
			if(conexion != null)
				System.out.println("Conectin!");
			
			
			System.out.println(conexion);
			
			conexion.close();
			
			System.out.println(conexion.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
