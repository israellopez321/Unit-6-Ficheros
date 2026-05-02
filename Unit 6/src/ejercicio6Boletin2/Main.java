package ejercicio6Boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {

        String fichero = "src/ejercicio6Boletin2/deportistas.txt";

        String mayorEdadNombre = "";
        int mayorEdad = -1;

        String mayorPesoNombre = "";
        double mayorPeso = -1;

        String mayorEstaturaNombre = "";
        double mayorEstatura = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea = br.readLine(); 

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(" ");

                String nombre = partes[0] + " " + partes[1];

                int edad = Integer.parseInt(partes[2]);
                double peso = Double.parseDouble(partes[3]);
                double estatura = Double.parseDouble(partes[4]);

                // Mayor edad
                if (edad > mayorEdad) {
                    mayorEdad = edad;
                    mayorEdadNombre = nombre;
                }

                // Mayor peso
                if (peso > mayorPeso) {
                    mayorPeso = peso;
                    mayorPesoNombre = nombre;
                }

                // Mayor estatura
                if (estatura > mayorEstatura) {
                    mayorEstatura = estatura;
                    mayorEstaturaNombre = nombre;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        System.out.println("Deportista de mayor edad: " + mayorEdadNombre + " (" + mayorEdad + " años)");
        System.out.println("Deportista de mayor peso: " + mayorPesoNombre + " (" + mayorPeso + " kg)");
        System.out.println("Deportista de mayor estatura: " + mayorEstaturaNombre + " (" + mayorEstatura + " m)");
    }
}
