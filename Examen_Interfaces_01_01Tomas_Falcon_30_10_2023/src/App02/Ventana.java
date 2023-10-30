package App02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana  extends Frame implements ActionListener{
	
	private Button boton;
	private Label etiquetaRuta, etiquetaValor2, etiquetaResultado;
	private TextField cajaRuta, cajaValor1,  cajaValor2, cajaResultado, cajaFecha;;
	private Label etiquetaValor1;
	private String direccionArchivo, resultadoStr, fecha;
	public static boolean existe = false;

	public Ventana() {
		//no voy a utilizar los layout debido a que pierdo tiempo, si veo que sobra tiempo, puede que los implemente
		super("Calculadora Leer");
		setSize(900,600);
		setLayout (null);
		
		etiquetaRuta= new Label ("Nombre del archivo o ruta (C:\\ejemplo\\texto.txt):");
		etiquetaRuta.setBounds(20,60,260,70);
		add (etiquetaRuta);

		cajaRuta = new TextField ();
		cajaRuta.setBounds (300, 85, 300, 25);
		add (cajaRuta);

		etiquetaValor1= new Label ("Valor 1:");
		etiquetaValor1.setBounds(220,130,70,70);
		add (etiquetaValor1);

		cajaValor1 = new TextField ();
		cajaValor1.setBounds (300, 150, 300, 25);
		add (cajaValor1);

		etiquetaValor2 = new Label ("Valor 2:");
		etiquetaValor2.setBounds(220,195,70,70);
		add (etiquetaValor2);

		cajaValor2 = new TextField ();
		cajaValor2.setBounds (300, 215, 300, 25);
		add (cajaValor2);

		etiquetaResultado = new Label ("Resultado de la suma:");
		etiquetaResultado .setBounds(150,260,130,70);
		add (etiquetaResultado);

		cajaResultado = new TextField ();
		cajaResultado.setBounds (300, 280, 300, 25);
		add (cajaResultado);
		
		
		etiquetaResultado = new Label ("Fecha de la operacion");
		etiquetaResultado .setBounds(150,340,130,70);
		add (etiquetaResultado);
		
		cajaFecha = new TextField ();
		cajaFecha.setBounds (300, 340, 300, 25);
		add (cajaFecha);

		boton = new Button("Cargar archivo");
		boton.addActionListener(this);
		boton.setSize(100,40);
		boton.setLocation(90,150);
		add (boton);
		


		setVisible (true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 direccionArchivo = cajaRuta.getText();
		LeerFichero leerFichero = new LeerFichero(direccionArchivo);
		
		existe = leerFichero.noExiste(direccionArchivo);
		if(existe == false) {
		cajaRuta.setBackground(Color.red);
		cajaRuta.setText("Archivo no encontrado: "+ direccionArchivo);
		}else if(existe == true){
			cajaRuta.setBackground(Color.green);
		} 
		
		String valores [] = leerFichero.leerDatos();
		cajaValor1.setText(valores[0]);
		cajaValor2.setText(valores[1]);
		cajaResultado.setText(valores[2]);
		cajaFecha.setText(valores[3]);
		
		System.out.println("El valor 1 es: "+valores[0]);
		System.out.println("El valor 2 es: "+valores[1]);
		System.out.println("El resultado es: "+valores[2]);
		System.out.println("Fue modificado a la hora: "+valores[3]);
		
	}
	
}

