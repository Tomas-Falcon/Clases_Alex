package SentenciasPreparadas;

import java.sql.*;

public class SentenciasPreparadas {
	
	static Connection conexion;
	static String url;
	static String usuario;
	static String passwd;;

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
		try (Connection conexion = DriverManager.getConnection(url, usuario, passwd);) {
			System.out.println("Conexion establecida!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarDatos( String nombre, String apellido, int edad,  Blob foto, String tabla) {
		
		String sql = "insert into "+tabla+"(Nombre, Apellido, Edad) values (?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sql);
			pstmt.setString(0, nombre);
			pstmt.setString(1, apellido);
			pstmt.setInt(2, edad);
			pstmt.setBlob(3, foto);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}