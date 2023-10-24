/**
 * 
 */
package ConecionWildFly;
import java.sql.*;

import javax.naming.*;
import javax.sql.*;
/**
 * 
 */
public class ConexxionWilflyClaseMain {

	public static Connection obtenerConexion() {
		Context contextoInicial = null;
		
		try {
			contextoInicial = new InitialContext();
		} catch (NamingException e) {
			System.out.println("Error en el contexto");
			e.printStackTrace();
			
		}
		String url = "java:jboss/datasources/Mydatasource";
		DataSource ds = null;
		
		try {
			ds = (DataSource) contextoInicial.lookup(url);
		} catch (Exception e) {
			System.out.println("Error en el Datasourse");
			e.printStackTrace();
		}
		
		Connection conexion = null;
		try {
			conexion = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Error en la Conexion");
			e.printStackTrace();
		}
		return conexion;
	}   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		obtenerConexion();

	}
	
	ConexxionWilflyClaseMain() {
	
		
	}

}
