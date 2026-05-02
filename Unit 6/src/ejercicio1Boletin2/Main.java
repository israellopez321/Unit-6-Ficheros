	package ejercicio1Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		
		int numLineas = 0;
		int numPalabras = 0;
		int numCaracteres = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/ejercicio1Boletin2/carta.txt"))) {
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				
				numLineas++;
				
				numCaracteres += linea.length();
				
				 String[] palabras = linea.split(" ");
                 numPalabras += palabras.length;
			}
			
			
			
		}catch (IOException e) {
			System.out.println("ERROR de lectura de archivo");
		}
		
		 System.out.println("Líneas: " + numLineas);
	     System.out.println("Palabras: " + numPalabras);
	     System.out.println("Caracteres: " + numCaracteres);
		
	}
	
	
}
