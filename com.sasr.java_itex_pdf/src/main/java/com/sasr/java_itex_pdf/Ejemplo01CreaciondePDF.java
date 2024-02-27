package com.sasr.java_itex_pdf;

import java.io.FileNotFoundException;

import javax.swing.JTextArea;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class Ejemplo01CreaciondePDF {
	
	public static void main(String[] args) throws FileNotFoundException {
		String destino = "C:/Users/Tomas/Desktop/HolaMundo.pdf";
		
			PdfWriter writer = new PdfWriter(destino);
			PdfDocument pdf = new PdfDocument(writer);
			Document doc = new Document(pdf);
			
			Text texto = new Text("Hola Mundo;\n Querida madre \n Este es un pdf \n Seguo te parece una estupides pero no lo es");
			Paragraph parrafo = new Paragraph();
			
			parrafo.add(texto);
			
			doc.add(parrafo);
			doc.close();
			pdf.close();
			System.out.println("Creado!");
		
	}
	
}
