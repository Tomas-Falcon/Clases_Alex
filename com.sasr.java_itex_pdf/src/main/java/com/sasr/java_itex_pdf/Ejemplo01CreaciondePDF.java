package com.sasr.java_itex_pdf;

import java.io.IOException;  



import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

public class Ejemplo01CreaciondePDF {
	
	public static void main(String[] args) throws Exception {
		String destino = "C:/Users/Tomas/Desktop/HolaMundo.pdf";
		
			PdfWriter writer = new PdfWriter(destino);
			PdfDocument pdf = new PdfDocument(writer);
			Document doc = new Document(pdf);
			
			Text texto = new Text("Hola Mundo;\n Querida madre \n Este es un pdf");
			Text texto2 = new Text("\nLorem ipsum \"dolor\" sit \ramet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			Text texto3 = new Text("Los sítidos (Sittidae), conocidos vulgarmente como trepadores o sitas, son una familia de aves paseriformes que contiene un único género, Sitta, formado por veintiocho especies. Se caracterizan por tener cabeza grande, cola corta, pico puntiagudo y patas fuertes. La mayoría de las especies tienen las partes dorsales grises o azuladas y una lista ocular negra, que contrastan con las partes inferiores claras, aunque algunas especies del Sudeste Asiático, como S. azurea o S. formosa, tienen plumajes más complejos y coloridos.\r\n"
					+ "\r\n"
					+ "La mayoría de los trepadores habita en bosques templados o de montaña de las regiones holárticas e indomalayas, pero dos de sus especies se han adaptado a ambientes rocosos de zonas más cálidas y secas en Eurasia. No obstante, la mayor diversidad se encuentra en el sur de Asia y las similitudes entre especies hacen difícil la identificación. La mayoría son aves sedentarias y viven en la misma zona todo el año; sin embargo, la especie norteamericana S. canadensis migra hacia climas templados durante el invierno. Algunas especies tienen distribución restringida y están amenazadas por la deforestación.");
			Paragraph parrafo = new Paragraph();
			Paragraph parrafo2 = new Paragraph();
			
			parrafo.add(texto);
			
			PdfFont fuente = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			texto2.setFont(fuente);
			texto2.setFontColor(Color.GRAY);
			texto.setFontSize(9);
			
			parrafo.add(texto2);
			parrafo.setBackgroundColor(Color.GRAY);
			
			texto3.setFontColor(Color.RED);
			texto3.setFontSize(20);
			parrafo2.add(texto3);
			

			
			
			doc.add(parrafo);

			AreaBreak AreaBreak = new AreaBreak();
			doc.add(AreaBreak);
			
			List lista = new List();
			lista.add("Tomas");
			lista.add("Diego");
			lista.add("Dani");
			lista.add("Manu");
			doc.add(lista);
			
			Cell vacia = new Cell();
			vacia.setBorder(Border.NO_BORDER);
			vacia.setBackgroundColor(Color.ORANGE);
			
			float [] pointCol = {150f, 200f, 300f};
			Table tabla = new Table(pointCol);
			tabla.addCell(vacia.add("Nombre"));
			
			tabla.addCell(new Cell().add("Apellido"));
			
			tabla.addCell(new Cell().add("Edad"));
			
			tabla.addCell(new Cell().add("Tomas"));
			
			
			tabla.addCell(new Cell().add("Falcon"));
			
			
			tabla.addCell(new Cell().add("21"));
			
			
			
			doc.add(parrafo2);
			Image img = new Image(ImageDataFactory.create("C:\\Users\\Tomas\\Desktop\\gatito-naranja.png"));
			
			doc.add(img);
			
			doc.add(tabla);
			
			doc.close();
			pdf.close();
			System.out.println("Creado!");
		
	}
	
}
