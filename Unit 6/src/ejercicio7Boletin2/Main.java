package ejercicio7Boletin2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	final static String archivo = "src/ejercicio7Boletin2/datos.txt";
	
	public static void main(String[] args) {
		
		ArrayList<Cliente> datosClientes = new ArrayList<>();
		
		datosClientes = cargarDatos();
		
		menuEjecutable(datosClientes);
		
	}
	/**
	 * Funcion que carga los datos de los clientes guardado en el archivo en la array
	 * @return
	 */
	public static ArrayList<Cliente> cargarDatos(){
		
		ArrayList<Cliente> datos = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
			String linea[];
			
			while((linea = br.readLine().split(";")) != null) {	
				Cliente cliente = new Cliente(linea[0],linea[1],linea[2],Double.parseDouble(linea[3]));
				datos.add(cliente);
			}
			datos.sort(null);
			
		}catch(IOException e) {
			System.out.println("ERROR de lectura del archivo");
		}catch(Exception e) {
		}
		
		return datos;
	}
	
	public static void menuEjecutable(ArrayList<Cliente> datosClientes) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
		
			System.out.println("-- Datos de Clientes del Banco --");
			System.out.println("1. Alta cliente.");
			System.out.println("2. Baja cliente.");
			System.out.println("3. Listar clientes.");
			System.out.println("4. Salir del programa.");
		
			try {
				opcion = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				System.out.println("ERROR: Introduce un número entero valido.");
			}
			
			switch(opcion) {
			
			case 1: 
				añadirCliente(datosClientes, sc);
				
				break;
			case 2:
				eliminarCliente(datosClientes, sc);
				break;
			case 3:
				listarCliente(datosClientes);
				break;
				
			case 4: 
				salir(datosClientes);
				break;
			default:
				System.out.println("ERROR: Elige una de las opciones dadas");
			}
			
		
		}while(opcion != 4);
	}
	
	/**
	 * Funcion para añadir un cliente al array
	 * @param datosClientes
	 * @param sc
	 */
	public static void añadirCliente(ArrayList<Cliente> datosClientes, Scanner sc) {
		
		try {
		System.out.print("Introduzca el dni: ");
		String dni = sc.next();
		
		System.out.print("Introduzca el nombre: ");
		String nombre = sc.next();
		
		System.out.print("Introduzca la fecha de nacimiento(1909-4-15): ");
		String fecha = sc.next();
		
		System.out.print("Introduzca el saldo: ");
		double saldo =  sc.nextDouble();
		
		Cliente cliente = new Cliente(dni,nombre,fecha,saldo);
		
		if(datosClientes.add(cliente)) {
			System.out.println("Cliente en alta");
			datosClientes.sort(null);
		}
		
		}catch(Exception e) {
			System.out.println("Introduzca los datos correctamente.");
		}

	}
	
	/**
	 * Funcion para eliminar a un cliente por su dni
	 * @param datosClientes
	 * @param sc
	 */
	public static void eliminarCliente(ArrayList<Cliente> datosClientes, Scanner sc) {
		
		try {
			Cliente clienteAEliminar = null;
			
			System.out.println("Introduzca el DNI del cliente a eliminar: ");
			String dni = sc.next();
			
			for(Cliente cliente: datosClientes) {
				
				if(cliente.getDni().equalsIgnoreCase(dni)) {
					clienteAEliminar = cliente;
				}
			}
			
			if(datosClientes.remove(clienteAEliminar)) {
				System.out.println("Cliente eliminado exitosamente");
			}else {
				System.out.println("Cliente no encontrado.");
			}			
		}catch(Exception e) {
			System.out.println("Introduzca el Dni correctamente.");
		}
	}
	
	/**
	 * Funcion que permite mostrar los datos de los cliente y saldo minimo, maximo y promedio
	 * @param datosClientes
	 */
	public static void listarCliente(ArrayList<Cliente> datosClientes) {
		
		
		double saldoMax = 0;
		double saldoMin = 0;
		double sumaSaldo = 0;
		int contadorCliente = 0;
		
		for(Cliente cliente: datosClientes) {
			
			System.out.println(cliente);
			
			saldoMax = Math.max(saldoMax, cliente.getSaldo());
			saldoMin = Math.min(saldoMin, cliente.getSaldo());
			
			 sumaSaldo += cliente.getSaldo();
			 contadorCliente++;
		}
		
		double saldoPromedio = sumaSaldo/contadorCliente;
		
		System.out.println("Saldo máximo: " + saldoMax + " | Saldo mínimo: " + saldoMin + " | Saldo promedio: " + saldoPromedio);
	}
	
	/**
	 *Funcion que permite guardar los datos de la array al archivo y sale del programa
	 * @param datosClientes
	 */
	public static void salir(ArrayList<Cliente> datosClientes) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
			
			for(Cliente cliente: datosClientes) {
				
				bw.write(cliente.getDni() + ";" + cliente.getNombre() + ";" + cliente.getFecha() + ";" + cliente.getSaldo());
				bw.newLine();
			}
			
		}catch(IOException e) {
			System.out.println("ERROR: Escritura del archivo fallida.");
		}
		
		System.out.println("Saliendo del programa...");
	}
}
