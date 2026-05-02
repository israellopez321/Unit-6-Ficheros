package ejercicio5Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("-- Analisis de Archivos --");
		comp();
		
	}
	
	public static void comp() {
		
		try (BufferedReader primer = new BufferedReader(new FileReader("src/ejercicio5Boletin2/primerArchivo.txt"));
			     BufferedReader segundo = new BufferedReader(new FileReader("src/ejercicio5Boletin2/segundoArchivo.txt"))) {

			    String linea1;
			    String linea2;
			    int numLinea = 1;

			    while ((linea1 = primer.readLine()) != null &&
			           (linea2 = segundo.readLine()) != null) {

			        int max = Math.max(linea1.length(), linea2.length());

			        for (int i = 0; i < max; i++) {

			            char ch1 = (i < linea1.length()) ? linea1.charAt(i) : ' ';
			            char ch2 = (i < linea2.length()) ? linea2.charAt(i) : ' ';

			            if (ch1 != ch2) {
			                System.out.println("Diferencia en línea " + numLinea +
			                                   ", carácter " + (i + 1) +
			                                   " (" + ch1 + " - " + ch2 + ")");
			            }
			        }

			        numLinea++;
			    }

			} catch (IOException e) {
			    System.out.println("ERROR de lectura de archivos");
			}
	}
}
