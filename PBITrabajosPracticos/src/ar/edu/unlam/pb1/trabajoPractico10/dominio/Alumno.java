package ar.edu.unlam.pb1.trabajoPractico10.dominio;

public class Alumno {

	private String nombre;
	private int dni;

	public Alumno(String nombre, int dni){
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getDNI(){
		return this.dni;
	}

	public void setDNI(int dni){
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Alumno: "+this.nombre;
	}
}