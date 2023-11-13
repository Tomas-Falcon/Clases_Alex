package SentenciasPreparadas;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaParaIngresarDatos extends Frame implements ActionListener{
	
	private Button boton;
	private Label etiquetaRuta,etiquetaValor1, etiquetaValor2, etiquetaResultado, etiquetaTabla;
	private TextField cajaRuta, cajaValor1,  cajaValor2, cajaResultado, cajaTabla;
	
	private String direccionArchivo, nombre, apellido, edad, tabla;	
	
	PantallaParaIngresarDatos(){
		super("Ingresar datos a la tabla Inicial");
		setSize(900,600);
		setLayout (null);
		
		etiquetaRuta= new Label ("Nombre del archivo o ruta (C:\\ejemplo\\texto.txt):");
		etiquetaRuta.setBounds(20,60,260,70);
		add (etiquetaRuta);

		cajaRuta = new TextField ();
		cajaRuta.setBounds (300, 85, 300, 25);
		add (cajaRuta);

		etiquetaValor1= new Label ("Nombre:");
		etiquetaValor1.setBounds(220,130,70,70);
		add (etiquetaValor1);

		cajaValor1 = new TextField ();
		cajaValor1.setBounds (300, 150, 300, 25);
		add (cajaValor1);

		etiquetaValor2 = new Label ("Apellido:");
		etiquetaValor2.setBounds(220,195,70,70);
		add (etiquetaValor2);

		cajaValor2 = new TextField ();
		cajaValor2.setBounds (300, 215, 300, 25);
		add (cajaValor2);

		etiquetaResultado = new Label ("Edad:");
		etiquetaResultado .setBounds(150,260,130,70);
		add (etiquetaResultado);

		cajaResultado = new TextField ();
		cajaResultado.setBounds (300, 280, 300, 25);
		add (cajaResultado);
		
		etiquetaTabla = new Label ("tabla:");
		etiquetaTabla .setBounds(150,310,130,70);
		add (etiquetaTabla);

		cajaTabla = new TextField ();
		cajaTabla.setBounds (300, 330, 300, 25);
		add (cajaTabla);

		boton = new Button("Cargar a la BBDD");
		boton.addActionListener(this);
		boton.setSize(100,40);
		boton.setLocation(400,370);
		add (boton);
		
			
			
		setVisible (true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String datos [] = {etiquetaTabla.getText(), etiquetaRuta.getText(), etiquetaValor1.getText(), etiquetaValor2.getText(), etiquetaResultado.getText()};
		retornarArray(datos);
	}
	public static void retornarArray(String datos[]) {
		String tabla = datos[0];
		String rutaFoto = datos[1];
		String nombre = datos[2];
		String apellido = datos[3];
		int edad = Integer.parseInt(datos[4]);
		System.out.println(edad);
		SentenciasPreparadas.insertarDatos(tabla, rutaFoto, nombre, apellido, edad);
		
	}
}
