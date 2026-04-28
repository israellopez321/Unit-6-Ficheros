package ejercicio06;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
	
		ArrayList<Integer> lista = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new FileReader("src/ejercicio06/EnterosNoOrdenados.txt"))) {
			
			while(sc.hasNextInt()) {
				lista.add(sc.nextInt());
			}
			
			if(!lista.isEmpty()) {
				
				lista.sort(null);
				
				FileWriter fw = new FileWriter("src/ejercicio06/EnterosOrdenados.txt");
				BufferedWriter enteros = new BufferedWriter(fw);
				
				for(int numero: lista) {
					enteros.write(numero + " ");
				}
				
				enteros.close();
			}
			
		} catch(IOException e) {
			
			System.out.println("Error de escritura");
		}
	}
}
