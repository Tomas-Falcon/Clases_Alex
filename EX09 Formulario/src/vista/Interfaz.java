package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.util.ArrayList;

import controlador.Controlador;
import modelo.Localidad;
import modelo.Provincia;

public class Interfaz extends JFrame {
	 
	
	Choice choiceProvincias; 
	Choice choiceLocalidad;
	

	Controlador contro = new Controlador();
    
	public static void main(String[] args) {
        new Interfaz();
    }

    Interfaz() {
        super("vistin");
        setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(5,1)); 

        JPanel panel1 = crearPaneltextFild("Nombre:");
        JPanel panel2 = crearPaneltextFild("Apellido:");
        
        JPanel panel3 = crearPanelChoice("Provincia:",1);
        JPanel panel4 = crearPanelChoice("Localidad:",2);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        
        choiceProvincias.addItemListener(e -> {
            String provincia = choiceProvincias.getSelectedItem();
            ArrayList<String> localidades = contro.getLocalidades(provincia);
            choiceLocalidad.removeAll(); // Elimina todos los elementos del Choice
            for (String localidad : localidades) {
                choiceLocalidad.add(localidad);
            }
        });

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
    
    private JPanel crearPanelChoice(String texto, int a) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(texto));
        Choice choice = new Choice();
        if(a == 1) {
        	
        	String[]  provincias = contro.getProvincias();
        	
        	for (String provincia : provincias) {
        		choice.add(provincia);
        	}
        	choiceProvincias = choice;
        } else {
        	choiceLocalidad = choice;
        }
        panel.add(choice);
        return panel;
    }
}
