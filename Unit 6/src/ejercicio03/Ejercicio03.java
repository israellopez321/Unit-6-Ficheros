package ejercicio03;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		int sumaEdad = 0;
		double sumaEstatura = 0;
		int contador = 0;
		
		try(Scanner sc = new Scanner(new FileReader("src/ejercicio03/Alumnos.txt"))){
			
			while (sc.hasNext()) {
				
				String nombre = sc.next();
				int edad = Integer.parseInt(sc.next());
				double estatura = Double.parseDouble(sc.next()); 
						
				System.out.println("Alumno: " + nombre);
				
				sumaEdad += edad;
				sumaEstatura += estatura;
	            contador++;
	        }
			
			double mediaEdad = sumaEdad / contador;
			double mediaEstatura = sumaEstatura / contador;
			
			System.out.println("Media de edad: " + mediaEdad);
			System.out.println("Media de estatura: " + mediaEstatura);
			
		} catch (IOException e) {
			
			System.out.println("Error al leer el archivo.");
		}
		
	}
	

}
