package ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<String> registro = new ArrayList<>();
		
		cargarDatos(registro);
		
		iniciar(registro);
		
	}
	
	public static void iniciar(ArrayList<String> registro){
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {	
		
		System.out.println("1. Registrar nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir de programa.");
		System.out.println("Elige una de las opciones: ");
		
		try {
			opcion = sc.nextInt();
			sc.nextLine();
		}catch(Exception e) {
			System.out.println("ERROR: Introduzca un número entero.");
		}
		
		switch(opcion) {
		
		case 1:
			registrarTemperatura(registro, sc);
			break;
		case 2:
			System.out.println("Fecha,Temperatura máxima,Temperatura mínima");
			System.out.println(registro);
			break;
		case 3:
			salir(registro);
			break;
		default:
			System.out.println("Introduzca una opcion valida");	
		}
		
		}while(opcion != 3);
		
		sc.close();
	}
	
	public static void cargarDatos(ArrayList<String> registro) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/ejercicio08/registroTemperatura.txt"))) {
			
			String datos;
			
			while ((datos = br.readLine()) != null) {
		            registro.add(datos);
		        }
			
		} catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}	
	}
	
	public static void registrarTemperatura(ArrayList<String> registro, Scanner sc) {
		
		System.out.println("Introduzca la fecha(2000-12-23): ");
		String fecha = sc.next();
		
		System.out.println("Introduzca la temperatura máxima: ");
		String max = String.valueOf(sc.nextInt());
		
		System.out.println("Introduzca la temperatura mínima: ");
		String min = String.valueOf(sc.nextInt());
		
		String datos = fecha + "," + max + "," + min;
		
		registro.add(datos);
	}
	
	public static void salir(ArrayList<String> registro) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejercicio08/registroTemperatura.txt"))) {

			bw.newLine();
			
	        for (String datos : registro) {
	            bw.write(datos);
	            bw.newLine();
	        }

	    } catch (IOException e) {
	        System.out.println("ERROR de escritura");
	    }

	    System.out.println("Saliendo del programa...");
		
	}
		
		
	
	

}
