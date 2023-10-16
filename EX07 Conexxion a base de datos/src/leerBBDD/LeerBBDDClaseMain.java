package leerBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class LeerBBDDClaseMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/inicial";
		String usuario = "root";
		String contraseña = "mysql";
		java.sql.ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try (Connection conexion = DriverManager.getConnection(url,usuario,contraseña); Statement stmt = conexion.createStatement();){
			
			if(conexion != null)
				System.out.println("Conectin!"+"\n");
			/*
			System.out.println(conexion);
			String insertar = "insert into tablin values (\"Oswaldo Diego\",\"mn\",22)";
			String modificar = "UPDATE tablin SET apellido = \"mn2\" WHERE apellido = 'mn'";
			String borrar = "delete from tablin where Apellido = \"mn\" ";
			stmt.execute(insertar);
			stmt.execute(modificar);
			stmt.execute(borrar);
			*/
			String preguntar = "select * from tablin";
			 rs = stmt.executeQuery(preguntar);
			int i = 0;
			while (rs.next()) {
				System.out.println(++i+" registro"+"\n");
				System.out.printf("%10s %10s %10s %n",rs.getString(1),rs.getString(2),rs.getInt(3));
				System.out.println("\n"+"------------------------------");
			}
			System.out.println("Esta cerada la coneccion? " + conexion.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}