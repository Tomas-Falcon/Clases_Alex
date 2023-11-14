package ManejoDeCursores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class ManejoDeCursoresMain {

	static Connection conexion;
	static String url;
	static String usuario;
	static String passwd;
	static Statement stmt;

	public static void main(String[] args) {
		url = "jdbc:mysql://localhost:3306/inicial";
		usuario = "root";
		passwd = "mysql";
		
		establecerConexion();
	}

	public static void establecerConexion() {
		java.sql.ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			conexion = DriverManager.getConnection(url, usuario, passwd);
			System.out.println("Conexion establecida!!");
			
			int tipo = ResultSet.TYPE_SCROLL_INSENSITIVE;
			int concurrencia = ResultSet.CONCUR_READ_ONLY;
			
			stmt = conexion.createStatement(tipo, concurrencia);
			String preguntar = "select * from tablaLectura";
			 rs = stmt.executeQuery(preguntar);
			int i = 0;
			while (rs.next()) {
				System.out.println(++i+" registro"+"\n");
				System.out.printf("%10s %10s %10s",rs.getString("id"),rs.getString("Nombre"),rs.getString("Apellido"));
				System.out.println("\n"+"------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public static void insertarDatos(String tabla, String nombre, String apellido, Integer edad) {
	    String sql = "insert into "+tabla+"(Nombre, Apellido, Edad, Foto) values (?, ?, ?, ?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = conexion.prepareStatement(sql);
	        pstmt.setString(1, nombre);
	        pstmt.setString(2, apellido);
	        pstmt.setInt(3, edad);
	        pstmt.execute();
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	}

}
