package ejercicio4Boletin2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<Character,Character> codificador = cargarCodigo();
		
		codificarFichero(codificador);
		System.out.println("Archivo codificado correctamente.");
	}
	
	public static Map<Character,Character> cargarCodigo(){
		
		Map<Character,Character> codificador = new HashMap<>();
		
		try(BufferedReader br =  new BufferedReader(new FileReader("src/ejercicio4Boletin2/original.txt"))){
			
			 String lineaOriginal = br.readLine();
	         String lineaCifrada = br.readLine();

	         String[] original = lineaOriginal.split(" ");
	         String[] cifrado = lineaCifrada.split(" ");

	         for (int i = 0; i < original.length; i++) {
	        	 codificador.put(original[i].charAt(0), cifrado[i].charAt(0));
	         }
		}catch(IOException e) {
			System.out.println("ERROR de lectura");
		}
		
		return codificador;
	}
	
	public static void codificarFichero(Map<Character,Character> codificador) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/ejercicio4Boletin2/original.txt"));
	         BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejercicio4Boletin2/codificado.txt"))) {

	            int c;
	            while ((c = br.read()) != -1) {
	                char ch = (char) c;

	                if (codificador.containsKey(ch)) {
	                    bw.write(codificador.get(ch));
	                } else {
	                    bw.write(ch); 
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Error procesando el fichero.");
	        }
	}
}
