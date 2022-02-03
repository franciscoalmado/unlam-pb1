package ar.edu.unlam.pb1.parcial2.dominio;

public class Pasajero {

	private int dni;
	private String nombre;
	private String apellido;
	
	public Pasajero(int dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pasajero [DNI: " + dni + ", nombre: " + nombre + ", apellido: " + apellido + "]";
	}
}