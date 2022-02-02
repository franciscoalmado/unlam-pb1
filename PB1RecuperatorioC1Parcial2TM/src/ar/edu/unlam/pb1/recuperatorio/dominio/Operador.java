package ar.edu.unlam.pb1.recuperatorio.dominio;

public class Operador {
	private String nombre;
	private String apellido;
	private String nickName;
	private String contrasenia;
	private boolean habilitadoParaRealizarTransacciones;
	private boolean seInicioSesion;
	private boolean isAutenticado;
	/*
	 * Constructor. Se deben generar los atributos necesarios para el correcto funcionamiento.
	 */
	public Operador (String nombre, String apellido, String nickName, String contrasenia, boolean habilitadoParaRealizarTransacciones) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickName = nickName;
		this.contrasenia = contrasenia;
		this.habilitadoParaRealizarTransacciones = habilitadoParaRealizarTransacciones;
		this.habilitadoParaRealizarTransacciones = false;
		this.seInicioSesion = false;
		this.isAutenticado = false;
	}
	/**
	 * Realiza la validación del nick y la contraseña para iniciar sesión
	 * @param nickName String		Nombre de usuario
	 * @param contrasenia String	Contraseña del usuario
	 * @return Verdadero en caso de exito
	 * */
	public boolean iniciarSesion(String nickName, String contrasenia) {
		
		if(this.nickName.compareTo(nickName) == 0 && this.contrasenia.compareTo(contrasenia) == 0) {
			this.seInicioSesion = true;
		}
		
		return seInicioSesion;
	}
	/**
	 * Cierra la sesión del operador
	 * @return boolean		Verdadero en caso de exito
	 * */
	public boolean cerrarSesion() {		
		
		if(this.seInicioSesion == true) {
			this.seInicioSesion = false;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isLaSesionEstaAbierta() {	
		
		if(this.seInicioSesion == true) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Verifica si el usuario tiene la sesión iniciada
	 * @return boolean		Verdadero en caso de estar autenticado
	 * */
	public boolean estaAutenticado() {
		
		if(this.seInicioSesion == true) {
			this.isAutenticado = true;
		}
		
		return this.isAutenticado;
	}
	
	public boolean estaHabilitadoParaRealizarTransacciones() {
		
		if(estaAutenticado() == true) {
			this.habilitadoParaRealizarTransacciones = true;
		}
		
		return this.habilitadoParaRealizarTransacciones;
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
	
	public String toString() {		
		return this.nombre+ " " +this.apellido;
	}
}