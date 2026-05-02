package ejercicio7Boletin2;

public class Cliente implements Comparable<Cliente> {

	private String dni;
	private String nombre;
	private String fecha;
	private double saldo;
	
	/**
	 * Contructor inicial
	 * @param dni
	 * @param nombre
	 * @param fecha
	 * @param precio
	 */
	public Cliente(String dni, String nombre, String fecha, double precio) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecha = fecha;
		this.saldo = precio;
	}
	
	//Setter and getter
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(dni.length() == 9) {
		this.dni = dni;
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double precio) {
		if(saldo >= 0)this.saldo = precio;
	}
	
	@Override
	public int compareTo(Cliente otroCliente) {
		
		return this.dni.compareTo(otroCliente.dni);
	}

	@Override
	public String toString() {
		return "Cliente | Dni:" + dni + ", Nombre:" + nombre + ", Fecha de nacimiento:" + fecha + ", Saldo:" + saldo + "|";
	}
	
	
	
	
	
	
}
