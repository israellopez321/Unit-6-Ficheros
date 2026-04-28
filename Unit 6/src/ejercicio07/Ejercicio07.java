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
		
		listaContacto = cargarDatos(listaContacto);
		
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
			
		}catch(Exception e) {
			System.out.println("ERROR: Introduzca un número entero.");
		}
		
		switch(opcion) {
		
		case 1:
			añadirContacto(lista);
			break;
		case 2:
			buscarPorNombre(lista);
			break;
		case 3:
			mostrarContactos(lista);
			break;
		case 4:
			System.out.println("Saliendo del programa...");
			break;
		default:
			System.out.println("Introduzca una opcion valida");	
		}
		
		}while(opcion != 4);
		
		sc.close();
	}

	public static void añadirContacto(ArrayList<String> lista) {
			
		Scanner sc = new Scanner(System.in);
		
		if(lista.size() >= 20) {
			
			System.out.println("Introduzca su nombre: ");
			String nombre = sc.next();
		
			System.out.println("Introduzca su telefono: ");
			String telefono = sc.next();
		
			String contacto = "Nombre: " + nombre + " Teléfono: " + telefono + " | ";
			
			lista.add(contacto);			
		} else {
			System.out.println("Agenda llena.");
		}
	}
	
	public static void buscarPorNombre(ArrayList<String> lista) {
		
	}
	
	public static void mostrarContactos(ArrayList<String> lista) {
		
		
	}
	
	public static ArrayList<String> cargarDatos(ArrayList<String> lista) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/ejercicio07/Agenda.txt"))) {
			
			String contactos = br.readLine();
			
			if (contactos != null) {
				
				String[] partes = contactos.split("|");
				
				for (String p : partes) {
		            lista.add(p);
		        }
			}				
		} catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return lista;		
	}
}
