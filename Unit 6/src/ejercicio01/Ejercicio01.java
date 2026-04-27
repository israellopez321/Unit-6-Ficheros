package ejercicio01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		double suma = 0;
		
		int contador = 0;
		
		try(BufferedReader reales = new BufferedReader(new FileReader ("src/ejercicio01/NumerosReales.txt"))){
			
			String linea = reales.readLine();
			
			if (linea != null) {
				
				String[] numeros = linea.split(" ");
			
				for(String num : numeros) {
				
					double valor = Double.parseDouble(num);
					
					suma += valor;
					contador++;
				}
			}
			
			double media = suma / contador;
			
			 System.out.println("Suma total: " + suma);
	         System.out.println("Media: " + media);
			
		}catch (IOException e){
			
			System.out.println("Error al leer el archivo.");
		}
	}
}
