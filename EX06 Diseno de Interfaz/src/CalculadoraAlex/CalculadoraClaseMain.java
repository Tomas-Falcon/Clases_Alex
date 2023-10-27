package CalculadoraAlex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraClaseMain extends Frame {
	
	static String simbolo = "ñ";
	static String panelDeLosNumeros = "0";
    static String valorA = "";
    static String valorB = "";
    static TextField tf;
    
    public static void main(String[] args) {
        CalculadoraClaseMain calculadoraMain = new CalculadoraClaseMain();
    }

    public CalculadoraClaseMain() {
        super("Calculadora");
        setSize(400, 400);
        tf = new TextField("0");
       

        // Panel para el diseño de la parte superior (FlowLayout)
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());

        // Botones de suma, resta, multiplicación y división
        Button sumar = new Button("Sumar +");
        sumar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {simbolo = "+"; panelDeLosNumeros = panelDeLosNumeros + "+";tf.setText(panelDeLosNumeros);}});
        
        Button restar = new Button("Restar -");
        restar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {simbolo = "-";panelDeLosNumeros = panelDeLosNumeros + "-";tf.setText(panelDeLosNumeros);}});
        
        Button multiplicar = new Button("Multiplicar *");
        multiplicar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {simbolo = "*";panelDeLosNumeros = panelDeLosNumeros + "*";tf.setText(panelDeLosNumeros);}});
        
        Button dividir = new Button("Dividir ÷");
        dividir.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {simbolo = "/";panelDeLosNumeros = panelDeLosNumeros + "/";tf.setText(panelDeLosNumeros);}});
        
        topPanel.add(sumar);
        topPanel.add(restar);
        topPanel.add(multiplicar);
        topPanel.add(dividir);

        // Panel para el diseño del centro (GridLayout)
        Panel centroPanel = new Panel();
        centroPanel.setLayout(new GridLayout(4, 3));
        
        Button nueve = new Button("9");
        nueve.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "9"; tf.setText(panelDeLosNumeros);valorA = valorA + "9";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "9"; tf.setText(panelDeLosNumeros); valorB = valorB + "9";}}});
        
        Button ocho = new Button("8");
        ocho.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "8"; tf.setText(panelDeLosNumeros);valorA = valorA + "8";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "8"; tf.setText(panelDeLosNumeros); valorB = valorB + "8";}}});
        
        Button siete = new Button("7");
        siete.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "7"; tf.setText(panelDeLosNumeros);valorA = valorA + "7";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "7"; tf.setText(panelDeLosNumeros); valorB = valorB + "7";}}});
        
        Button seis = new Button("6");
        seis.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "6"; tf.setText(panelDeLosNumeros);valorA = valorA + "6";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "6"; tf.setText(panelDeLosNumeros); valorB = valorB + "6";}}});
        
        Button cinco = new Button("5");
        cinco.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "5"; tf.setText(panelDeLosNumeros);valorA = valorA + "5";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "5"; tf.setText(panelDeLosNumeros); valorB = valorB + "5";}}});
        
        Button cuatro = new Button("4");
        cuatro.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "4"; tf.setText(panelDeLosNumeros);valorA = valorA + "4";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "4"; tf.setText(panelDeLosNumeros); valorB = valorB + "4";}}});
        
        Button tres = new Button("3");
        tres.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "3"; tf.setText(panelDeLosNumeros);valorA = valorA + "3";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "3"; tf.setText(panelDeLosNumeros); valorB = valorB + "3";}}});
        
        
        Button dos = new Button("2");
        dos.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "2"; tf.setText(panelDeLosNumeros);valorA = valorA + "2";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "2"; tf.setText(panelDeLosNumeros); valorB = valorB + "2";}}});
        
        
        Button uno = new Button("1");
        uno.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "1"; tf.setText(panelDeLosNumeros);valorA = valorA + "1";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "1"; tf.setText(panelDeLosNumeros); valorB = valorB + "1";}}});
        
        Button cero = new Button("0");
        cero.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "0"; tf.setText(panelDeLosNumeros);valorA = valorA + "0";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "0"; tf.setText(panelDeLosNumeros); valorB = valorB + "0";}}});
        
        
        Button igual = new Button("=");
        igual.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
        	switch (simbolo) {
			case "+": {float valorAntes = Float.parseFloat(valorA); float valorDespues = Float.parseFloat(valorB); float resultado = valorAntes + valorDespues; String resultadoStr = String.valueOf(resultado); valorA = resultadoStr; panelDeLosNumeros = resultadoStr; valorB = ""; tf.setText(panelDeLosNumeros); break;}
			case "-": {float valorAntes = Float.parseFloat(valorA); float valorDespues = Float.parseFloat(valorB); float resultado = valorAntes - valorDespues; String resultadoStr = String.valueOf(resultado); valorA = resultadoStr; panelDeLosNumeros = resultadoStr; valorB = ""; tf.setText(panelDeLosNumeros); break;}
			case "*": {float valorAntes = Float.parseFloat(valorA); float valorDespues = Float.parseFloat(valorB); float resultado = valorAntes * valorDespues; String resultadoStr = String.valueOf(resultado); valorA = resultadoStr; panelDeLosNumeros = resultadoStr; valorB = ""; tf.setText(panelDeLosNumeros); break;}
			case "/": {float valorAntes = Float.parseFloat(valorA); float valorDespues = Float.parseFloat(valorB); float resultado = valorAntes / valorDespues; String resultadoStr = String.valueOf(resultado); valorA = resultadoStr; panelDeLosNumeros = resultadoStr; valorB = ""; tf.setText(panelDeLosNumeros); break;}
        	}simbolo = "ñ";}});
        
        Button coma = new Button(",");
        coma.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(simbolo.equalsIgnoreCase("ñ")) {panelDeLosNumeros = panelDeLosNumeros + "."; tf.setText(panelDeLosNumeros);valorA = valorA + ".";}
		else if(!simbolo.equalsIgnoreCase("ñ")){panelDeLosNumeros = panelDeLosNumeros + "."; tf.setText(panelDeLosNumeros); valorB = valorB + ".";}}});
        
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
        ce.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent e) {simbolo = "ñ"; panelDeLosNumeros = "0"; valorA = ""; valorB = ""; tf.setText("0");}});
        
        Button c = new Button("C");
        c.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent e) {tf.setText("0");}});
        
        Button ne = new Button("NE");
        
        derecharPanel.add(ce);
        derecharPanel.add(c);
        derecharPanel.add(ne);
        
        Panel surPanel = new Panel();
        surPanel.setLayout(new BorderLayout());
        
        surPanel.add(tf);
        
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centroPanel, BorderLayout.CENTER);
        add(derecharPanel, BorderLayout.WEST);
        add(surPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
}
