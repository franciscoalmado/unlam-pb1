package ar.edu.unlam.pb1.trabajoPractico02.dominio;

public class Usuario {

	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int dni, int edad) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getContrasenia() {
		return this.contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Nombre: " +this.nombre+ ", Apellido: " +this.apellido+ ", Usuario: " +this.usuario+ ", Contraseña: " +this.contrasenia+ ", DNI: " +this.dni+ ", Edad: " +this.edad;
	}	
}