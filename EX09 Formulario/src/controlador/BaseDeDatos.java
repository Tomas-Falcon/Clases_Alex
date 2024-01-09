package controlador;


import java.sql.*;
import java.util.ArrayList;
	
public class BaseDeDatos {

	
	
	

	    private String URL = "jdbc:sqlite:espana.db";

	    public void crearBaseDeDatos() {
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
	    
	    
	    public ArrayList<String> obtenerProvincias() {
	        ArrayList<String> provincias = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(URL);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT provincia FROM localidades")) {

	            while (resultSet.next()) {
	                String provincia = resultSet.getString("provincia");
	                provincias.add(provincia);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return provincias;
	    }
	    
	    public ArrayList<String> obtenerLocalidadesPorProvincia(String provincia) {
	        ArrayList<String> localidades = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(URL);
	             PreparedStatement pstmt = connection.prepareStatement("SELECT localidad FROM localidades WHERE provincia = ?")) {

	            pstmt.setString(1, provincia);

	            try (ResultSet resultSet = pstmt.executeQuery()) {
	                while (resultSet.next()) {
	                    String localidad = resultSet.getString("localidad");
	                    localidades.add(localidad);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return localidades;
	    }
	    
	    public void insertarLocalidad(String provincia, String localidad) {
	        // Verificar si la localidad ya existe
	        if (localidadYaExiste(provincia, localidad)) {
	            System.out.println("La localidad ya existe. No se insertaron datos duplicados.");
	            return;
	        }

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

	    private boolean localidadYaExiste(String provincia, String localidad) {
	        try (Connection connection = DriverManager.getConnection(URL);
	             PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM localidades WHERE provincia = ? AND localidad = ?")) {

	            pstmt.setString(1, provincia);
	            pstmt.setString(2, localidad);

	            try (ResultSet resultSet = pstmt.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt("count");
	                    return count > 0;
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }


	    public void iniciar() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            return;
	        }

	        crearBaseDeDatos();

	        // Ejemplo de inserción de datos
	        insertarLocalidad("Madrid","Madrid");
	        insertarLocalidad("Madrid", "Getafe");
	        insertarLocalidad("Madrid","Alcalá de Henares");
	        insertarLocalidad("Madrid","Móstoles");
	        insertarLocalidad("Madrid","Fuenlabrada");
	        insertarLocalidad("Madrid","Leganés");
	        insertarLocalidad("Madrid","Getafe");
	        insertarLocalidad("Madrid","Alcorcón");
	        insertarLocalidad("Madrid","Parla");
	        insertarLocalidad("Madrid","Torrejón de Ardoz");
	        insertarLocalidad("Madrid","Alcobendas");
	        insertarLocalidad("Madrid","Coslada");
	        insertarLocalidad("Madrid","Las Rozas de Madrid");
	        insertarLocalidad("Madrid","San Sebastián de los Reyes");
	        insertarLocalidad("Madrid","Pozuelo de Alarcón");
	        insertarLocalidad("Madrid","Rivas-Vaciamadrid");
	        insertarLocalidad("Barcelona","Badalona");
	        insertarLocalidad("Barcelona","L'Hospitalet de Llobregat");
	        insertarLocalidad("Barcelona","Terrassa");
	        insertarLocalidad("Barcelona","Sabadell");
	        insertarLocalidad("Barcelona","Mataró");
	        insertarLocalidad("Barcelona","Santa Coloma de Gramenet");
	        insertarLocalidad("Barcelona","Cornellà de Llobregat");
	        insertarLocalidad("Barcelona","Sant Boi de Llobregat");
	        insertarLocalidad("Barcelona","Manresa");
	        insertarLocalidad("Barcelona","Barcelona");
	        insertarLocalidad("Zaragoza","Zaragoza");
	        insertarLocalidad("Zaragoza","Calatayud");
	        insertarLocalidad("Zaragoza","Ejea de los Caballeros");
	        insertarLocalidad("Zaragoza","Utebo");
	        insertarLocalidad("Zaragoza","Caspe");
	        insertarLocalidad("Zaragoza","La Almunia de Doña Godina");
	        insertarLocalidad("Zaragoza","Tarazona");
	        insertarLocalidad("Zaragoza","Mores");
	        insertarLocalidad("Zaragoza","Daroca");
	        insertarLocalidad("Zaragoza","Borja");
	        insertarLocalidad("Alicante","Alicante");
	        insertarLocalidad("Alicante","Elche");
	        insertarLocalidad("Alicante","Benidorm");
	        insertarLocalidad("Alicante","Torrevieja");
	        insertarLocalidad("Alicante","Alcoy");
	        insertarLocalidad("Alicante","Orihuela");
	        insertarLocalidad("Alicante","Denia");
	        insertarLocalidad("Alicante","Villena");
	        insertarLocalidad("Alicante","San Vicente del Raspeig");
	        insertarLocalidad("Alicante","Jávea");
	        
	        
	    }
	}
