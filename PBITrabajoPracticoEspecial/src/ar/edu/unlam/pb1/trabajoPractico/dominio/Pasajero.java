package ar.edu.unlam.pb1.trabajoPractico.dominio;

public class Pasajero {

	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	
	public Pasajero(int dni, String nombre, String apellido, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "DNI: "+this.dni+" | Nombre y Apellido: "+this.nombre+" "+this.apellido;
	}	
}