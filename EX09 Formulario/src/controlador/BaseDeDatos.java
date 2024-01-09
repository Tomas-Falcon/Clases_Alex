package controlador;


import java.sql.*;
	
public class BaseDeDatos {

	
	
	

	    private static final String URL = "jdbc:sqlite:espana.db";

	    public static void crearBaseDeDatos() {
	        try (Connection connection = DriverManager.getConnection(URL);
	             PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS localidades ("
	                     + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	                     + "provincia TEXT NOT NULL,"
	                     + "localidad TEXT NOT NULL)")) {

	            pstmt.execute();

	            System.out.println("Base de datos y tabla creadas exitosamente.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void insertarLocalidad(String provincia, String localidad) {
	        try (Connection connection = DriverManager.getConnection(URL);
	             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO localidades (provincia, localidad) VALUES (?, ?)")) {

	            pstmt.setString(1, provincia);
	            pstmt.setString(2, localidad);
	            pstmt.execute();

	            System.out.println("Datos insertados correctamente.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            Class.forName("org.sqlite.JDBC");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            return;
	        }

	        crearBaseDeDatos();

	        // Ejemplo de inserción de datos
	        insertarLocalidad("Madrid", "Getafe");
	        insertarLocalidad("Madrid", "Parla");
	        insertarLocalidad("Alicante", "Alicante");
	        insertarLocalidad("Alicante", "Elche");
	        insertarLocalidad("Barcelona", "Barcelona");
	        insertarLocalidad("Barcelona", "Hospitalet de Llobregat");
	    }
	}
