package ejercicio02;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
	double suma = 0;
	int contador = 0;
	
	try(Scanner sc = new Scanner(new FileReader("src/ejercicio02/Enteros.txt"))){
		
		while (sc.hasNextInt()) {
            double valor = sc.nextInt();
            suma += valor;
            contador++;
        }
		
		double media = suma / contador;
		
		System.out.println("Suma total: " + suma);
        System.out.println("Media: " + media);
		
	}catch (IOException e) {		
		System.out.println("Error al leer el archivo.");
	}
		
	}

}
