package SentenciasPreparadas;

import java.sql.*;

public class SentenciasPreparadas {
	
	static Connection conexion;
	static String url;
	static String usuario;
	static String passwd;


	public static void main(String[] args) {
		establecerConexion();
	}

	public static void establecerConexion() {
		String url = "jdbc:mysql://localhost:3306/inicial";
		String usuario = "root";
		String passwd = "mysql";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conexion1 = DriverManager.getConnection(url, usuario, passwd);) {
			conexion = conexion1;
			System.out.println("Conexion establecida!!");
			
			PantallaParaIngresarDatos pantallaParaIngresarDatos = new PantallaParaIngresarDatos();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarDatos(String tabla,  String rutaFoto, String nombre, String apellido, int edad) {
		
		String sql = "insert into "+tabla+"(Nombre, Apellido, Edad, Foto) values (?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, nombre);
			pstmt.setString(2, apellido);
			pstmt.setInt(3, edad);
			pstmt.setString(4, rutaFoto);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ejecutarLotesDeConsultas() {
		Statement lote;
		try {
			lote = conexion.createStatement();
			lote.addBatch("insert into tablin (Nombre, Apellido, Edad, Foto) values (Jhon, Doe, 0, C:\\imagen.jpg)");
			int camposModificado [] = lote.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}