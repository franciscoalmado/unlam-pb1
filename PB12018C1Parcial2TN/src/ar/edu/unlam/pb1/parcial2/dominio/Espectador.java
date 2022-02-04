package ar.edu.unlam.pb1.parcial2.dominio;

public class Espectador {
	
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	
	public Espectador(int dni, String nombre, String apellido, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public String toString() {
		return "Espectador: DNI: "+ this.dni +", nombre: "+ this.nombre +", apellido: "+ this.apellido;
	}
}