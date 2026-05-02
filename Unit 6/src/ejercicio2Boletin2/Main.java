package ejercicio2Boletin2;

import java.io.*;
import java.util.*;

public class Main {
	
	


	    private static final String FICHERO = "src/ejercicio2Boletin2/firmas.txt";

	    public static void main(String[] args) {
	        try (Scanner sc = new Scanner(System.in)) {
				int opcion;

				do {
				    System.out.println("\n--- LIBRO DE FIRMAS ---");
				    System.out.println("1. Mostrar firmas");
				    System.out.println("2. Añadir firma");
				    System.out.println("3. Salir");
				    System.out.print("Elige opción: ");
				    opcion = sc.nextInt();
				    sc.nextLine();

				    switch (opcion) {
				        case 1:
				            mostrarFirmas();
				            break;
				        case 2:
				            System.out.print("Introduce un nombre: ");
				            String nombre = sc.nextLine().trim();
				            anadirFirma(nombre);
				            break;
				        case 3:
				            System.out.println("Saliendo...");
				            break;
				        default:
				            System.out.println("Opción no válida");
				    }

				} while (opcion != 3);
			} catch(Exception e) {
				System.out.println("ERROR: Al introducir los datos");
			}
	    }

	    private static void mostrarFirmas() {
	        File archivo = new File(FICHERO);

	        if (!archivo.exists()) {
	            System.out.println("Aún no hay firmas.");
	            return;
	        }

	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            System.out.println(" FIRMAS REGISTRADAS");
	            while ((linea = br.readLine()) != null) {
	                System.out.println("- " + linea);
	            }
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo.");
	        }
	    }

	    
	    private static void anadirFirma(String nombre) {
	        List<String> firmas = new ArrayList<>();
	        File archivo = new File(FICHERO);

	        
	        if (archivo.exists()) {
	            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	                String linea;
	                while ((linea = br.readLine()) != null) {
	                    firmas.add(linea.trim());
	                }
	            } catch (IOException e) {
	                System.out.println("Error al leer el archivo.");
	                return;
	            }
	        }

	     
	        if (firmas.contains(nombre)) {
	            System.out.println("Ese nombre ya está registrado.");
	            return;
	        }

	        
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
	            bw.write(nombre);
	            bw.newLine();
	            System.out.println("Firma añadida correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al escribir en el archivo.");
	        }
}
	    
}
