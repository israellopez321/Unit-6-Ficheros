package ejercicio3Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	 private static final int LINEAS_PAGINA = 24;
	
	 public static void main(String[] args) {
	 	String fichero = "src/ejercicio3Boletin2/fichero.txt";
	 	
	 	try (BufferedReader br = new BufferedReader(new FileReader(fichero));
				Scanner sc = new Scanner(System.in)){
	 		
	 		String linea;
	 		int contador = 0;
	 		
	 		while((linea = br.readLine()) != null) {
	 			
	 			System.out.println(linea);
	 			contador++;
	 			if(contador == LINEAS_PAGINA) {
	 				
	 				System.out.println("-- Pulsa ENTER para continuar --");
	 				sc.nextLine();
	 				contador = 0;
	 			}
	 		}	
	 	}catch(IOException e) {
	 		System.out.println("ERROR de lectura de archivo.");
	 	}	
	}
}