package ar.edu.unlam.pb1.parcial2.dominio;

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
	
	public int getEdad() {
		return this.edad;
	}
		
	public boolean laContraseniaEsValida() {
		/*
		 * Considera que una contraseña es válida si cumple con las siguientes condiciones: 
			a. Contiene al menos un carácter numérico. 
			b. Tiene una longitud de al menos 8 caracteres. 
		 */
		boolean esContraseniaValida = false;
		int cantidadDeCaracteres = this.contrasenia.length();
		int longitudMinima = 8;
		int valor = 0;
		
		for(int i = 0; i < this.contrasenia.length(); i++) {
			valor = this.contrasenia.charAt(i);
			if((valor > 47 && valor < 58) && cantidadDeCaracteres >= longitudMinima){
				esContraseniaValida = true;
				break;
			}
		}
		
		return esContraseniaValida;
	}
	
	public boolean esMayorDeEdad() {
		/*
		 * Considerando como mayores aquellos usuarios que tienen al menos 18 años. 
		 *  
		 */
		boolean esMayor = false;
		
		if(this.edad >= 18) {
			esMayor = true;
		}
		
		return esMayor;		
	}

	@Override
	public String toString() {
		return "Usuario [DNI: " + this.dni + ", nombre: " + nombre + ", apellido: " + apellido + "]";
	}	
}