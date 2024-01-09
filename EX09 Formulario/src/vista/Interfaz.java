package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.Localidad;
import modelo.Provincia;

public class Interfaz extends JFrame {
	 
	
	List listaProvincias; 
	List listaLocalidad;
	
	
	
	
	
	Provincia madrid = new Provincia("1");
	Provincia santander = new Provincia("2");
	Localidad localidad1 = new Localidad(madrid, "Getafe");
	Localidad localidad2 = new Localidad(madrid, "Parla");
	Localidad localidad3 = new Localidad(santander, "Cantabria");
	
	
	
	Controlador contro = new Controlador(madrid, santander,localidad1,localidad2,localidad3);
    
	public static void main(String[] args) {
        new Interfaz();
    }

    Interfaz() {
        super("vistin");
        setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(5,1)); 

        JPanel panel1 = crearPaneltextFild("Nombre:");
        JPanel panel2 = crearPaneltextFild("Apellido:");
        
        JPanel panel3 = crearPanelList("Provincia:",1);
        JPanel panel4 = crearPanelList("Localidad:",2);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        
        listaProvincias.addActionListener(v-> {String provincia = listaProvincias.getSelectedItem(); ArrayList<String> localidades = contro.getLocalidades(provincia);  while (listaLocalidad.getItemCount() > 0) {
        	listaLocalidad.remove(0);
        } for(String localidad : localidades) {listaLocalidad.add(localidad);}});
        
        panel.add(panel4);
        
        
        
        JButton agregar = new JButton("Agregar a la agenda");
        panel.add(agregar);
        add(panel);

        setVisible(true);
    }

    private JPanel crearPaneltextFild(String texto) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(texto));
        panel.add(new JTextField("            "));
        return panel;
    }
    
    private JPanel crearPanelList(String texto, int a) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(texto));
        List lista = new List();
        if(a == 1) {
        	
        	String[]  provincias = contro.getProvincias();
        	
        	for (String provincia : provincias) {
        		lista.add(provincia);
        	}
        	listaProvincias = lista;
        }else {
        	listaLocalidad = lista;
        }
        panel.add(lista);
        return panel;
    }
   
}
