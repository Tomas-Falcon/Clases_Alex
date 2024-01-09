package controlador;

import java.util.ArrayList;

import modelo.Localidad;
import modelo.Provincia;

public class Controlador {

    BaseDeDatos bbdd;

    public Controlador() {
    	bbdd = new BaseDeDatos();
        bbdd.iniciar();
    }

    public String[] getProvincias() {
        // Obtener provincias directamente de la base de datos
        ArrayList<String> provincias = bbdd.obtenerProvincias();
        return provincias.toArray(new String[0]);
    }

    public ArrayList<String> getLocalidades(String provincia) {
        // Obtener localidades directamente de la base de datos para la provincia seleccionada
        ArrayList<String> localidades = bbdd.obtenerLocalidadesPorProvincia(provincia);
        return localidades;
    }
}