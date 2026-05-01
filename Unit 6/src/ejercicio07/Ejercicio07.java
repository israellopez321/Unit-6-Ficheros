package ejercicio07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		
		ArrayList<String> listaContacto = new ArrayList<>();
		
		cargarDatos(listaContacto);
		
		iniciar(listaContacto);
	}
	
	public static void iniciar(ArrayList<String> lista) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {	
		
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
		System.out.println("Elige una de las opciones: ");
		
		try {
			opcion = sc.nextInt();
			sc.nextLine();
		}catch(Exception e) {
			System.out.println("ERROR: Introduzca un número entero.");
		}
		
		switch(opcion) {
		
		case 1:
			añadirContacto(lista, sc);
			break;
		case 2:
			buscarPorNombre(lista, sc);
			break;
		case 3:
			System.out.println(lista);
			break;
		case 4:
			salir(lista);
			break;
		default:
			System.out.println("Introduzca una opcion valida");	
		}
		
		}while(opcion != 4);
		
		sc.close();
	}

	public static void añadirContacto(ArrayList<String> lista, Scanner sc) {
		
		if(lista.size() <= 20) {
			
			System.out.println("Introduzca su nombre: ");
			String nombre = sc.nextLine();
		
			System.out.println("Introduzca su telefono: ");
			String telefono = sc.next();
		
			String contacto = "Nombre: " + nombre + " Teléfono: " + telefono;
			
			lista.add(contacto);			
		} else {
			System.out.println("Agenda llena.");
		}
	}
	
	public static void buscarPorNombre(ArrayList<String> lista, Scanner sc) {
		
		System.out.print("Introduce el nombre a buscar en contacto: ");
		String nombreBuscar = sc.next().toUpperCase();
		
		for(String datos: lista) {
			 
			String nombre = datos.substring(
			        datos.indexOf("Nombre: ") + 8,
			        datos.indexOf(" Teléfono:")
			).trim().toUpperCase();
			
			if (nombreBuscar.equals(nombre)) {
				
				System.out.println(datos);
			}
		}
	}
	
	public static ArrayList<String> cargarDatos(ArrayList<String> lista) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/ejercicio07/Agenda.txt"))) {
			
			String contactos;
			
			while ((contactos = br.readLine()) != null) {
		            lista.add(contactos);
		        }
			
		} catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return lista;		
	}
	
	public static void salir(ArrayList<String> lista) {

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejercicio07/Agenda.txt"))) {

	        for (String datos : lista) {
	            bw.write(datos);
	            bw.newLine();
	        }

	    } catch (IOException e) {
	        System.out.println("ERROR de escritura");
	    }

	    System.out.println("Saliendo del programa...");
	}

}
