package CalculadoraAlex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class CalculadoraClaseMain extends Frame {

    public static void main(String[] args) {
        CalculadoraClaseMain calculadoraMain = new CalculadoraClaseMain();
    }

    public CalculadoraClaseMain() {
        super("Calculadora");
        setSize(400, 400);

        // Panel para el diseño de la parte superior (FlowLayout)
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());

        // Botones de suma, resta, multiplicación y división
        Button sumar = new Button("Sumar");
        Button restar = new Button("Restar");
        Button multiplicar = new Button("Multiplicar");
        Button dividir = new Button("Dividir");

        topPanel.add(sumar);
        topPanel.add(restar);
        topPanel.add(multiplicar);
        topPanel.add(dividir);

        // Panel para el diseño del centro (GridLayout)
        Panel centroPanel = new Panel();
        centroPanel.setLayout(new GridLayout(4, 3));
        
        Button nueve = new Button("9");
        Button ocho = new Button("8");
        Button siete = new Button("7");
        Button seis = new Button("6");
        Button cinco = new Button("5");
        Button cuatro = new Button("4");
        Button tres = new Button("3");
        Button dos = new Button("2");
        Button uno = new Button("1");
        Button cero = new Button("0");
        Button igual = new Button("=");
        Button coma = new Button(",");
        
        centroPanel.add(siete);
        centroPanel.add(ocho);
        centroPanel.add(nueve);
        centroPanel.add(cuatro);
        centroPanel.add(cinco);
        centroPanel.add(seis);     
        centroPanel.add(uno);
        centroPanel.add(dos);
        centroPanel.add(tres); 
        centroPanel.add(igual);
        centroPanel.add(cero);
        centroPanel.add(coma);
        
        Panel derecharPanel = new Panel();
        derecharPanel.setLayout(new GridLayout(3, 1));
        Button ce = new Button("CE");
        Button c = new Button("C");
        Button ne = new Button("NE");
        
        derecharPanel.add(ce);
        derecharPanel.add(c);
        derecharPanel.add(ne);
        
        Panel surPanel = new Panel();
        surPanel.setLayout(new BorderLayout());
        TextField tf = new TextField("resultin");
        surPanel.add(tf);
        
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centroPanel, BorderLayout.CENTER);
        add(derecharPanel, BorderLayout.WEST);
        add(surPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
}
