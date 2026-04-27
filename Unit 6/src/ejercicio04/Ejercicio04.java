package ejercicio04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejercicio04/Escritura.txt"))){
			
			Scanner sc = new Scanner(System.in);
		
			String cadena;
			System.out.println("Introduce el texto para terminar introduce 'fin'.");
		
			do {
			
				cadena = sc.next();
			
				bw.write(cadena);
				bw.newLine();
			
			}while(!cadena.equals("fin"));
			
			sc.close();
			
		}catch (IOException e) {
			System.out.println("Error de escritura.");
		} 
		
	}

	
}
