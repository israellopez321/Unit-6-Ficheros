package ejercicio05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre: ");
		String nombre = sc.next();
		
		System.out.print("Introduzca la edad: ");
		int edad = sc.nextInt();
		
		try {
			
			FileWriter fw = new FileWriter("src/ejercicio05/datos.txt", true);
			BufferedWriter datos = new BufferedWriter(fw);
			
			datos.write("nombre: " + nombre + " | edad: " + edad);
			datos.newLine();
			
			datos.close();
			
			System.out.println("Datos guardados exitosamente");
			
		} catch(IOException e) {
			System.out.println("Error de escritura");
		}
		
		sc.close();
		
	}
}
