package App01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana  extends Frame implements ActionListener{
	
	private Button boton;
	private Label etiquetaRuta, etiquetaValor2, etiquetaResultado;
	private TextField cajaRuta, cajaValor1,  cajaValor2, cajaResultado;
	private Label etiquetaValor1;
	private String direccionArchivo;
	private String resultadoStr;
	

	public Ventana() {
		//no voy a utilizar los layout debido a que pierdo tiempo, si veo que sobra tiempo, puede que los implemente
		super("Calculadora Escribir");
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

		boton = new Button("Sumar y Guardar");
		boton.addActionListener(this);
		boton.setSize(100,40);
		boton.setLocation(400,350);
		add (boton);
	
			
			
		setVisible (true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		float valor1, valor2; 
		 direccionArchivo = cajaRuta.getText();
		
		valor1 = Float.parseFloat(cajaValor1.getText()); 
		valor2 = Float.parseFloat(cajaValor2.getText());
		
		ClaseOperacion operacion = new ClaseOperacion(valor1, valor2, direccionArchivo);
		resultadoStr = String.valueOf(operacion.getResultado());
		cajaResultado.setText(resultadoStr);
		cajaRuta.setBackground(Color.green);
		
		float resultado = valor1 + valor2;
		
		System.out.println("El valor 1 es: "+valor1);
		System.out.println("El valor 2 es: "+valor2);
		System.out.println("El resultado es: "+resultado);
	}
	
}

