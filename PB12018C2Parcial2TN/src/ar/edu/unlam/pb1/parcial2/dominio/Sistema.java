package ar.edu.unlam.pb1.parcial2.dominio;

public class Sistema {

	private String nombreDelSistema;
	private Usuario[] usuarios;
	private int cantidadDeUsuarios;
	private int cantidadMaximaDeUsuarios;
	
	public Sistema(String nombreDelSistema, int cantidadDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.cantidadMaximaDeUsuarios = cantidadDeUsuarios;
		this.usuarios = new Usuario[this.cantidadMaximaDeUsuarios];
		this.cantidadDeUsuarios = 0;
	}
	
	public boolean incorporarUnUsuario(Usuario usuario) {
		/*
		 * Permite incorporar un usuario a su lista de usuarios. Dicho método devolverá true 
		 * si el usuario se puede ingresar en el sistema o false en caso contrario (no se puede 
		 * ingresar un nombre de usuario que ya exista).  
		 */
		boolean seAgrego = false;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] == null && this.cantidadDeUsuarios < this.cantidadMaximaDeUsuarios && verificarSiUnUsuarioYaExisteEnElSistema(usuario) == false){
				this.usuarios[i] = usuario;
				this.cantidadDeUsuarios++;
				break;
			}
		}
	
		return seAgrego;
	}
	
	private boolean verificarSiUnUsuarioYaExisteEnElSistema(Usuario usuario) {
		boolean estaEnElSistema = false;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario.getUsuario()) == 0) {
				estaEnElSistema = true;
			}
		}
		return estaEnElSistema;
	}
	
	public int calcularCantidadDeUsuariosMenores() {
		/*
		 * Calcula la cantidad de usuarios menores de edad registrados en el sistema.
		 */	
		int cantidadDeMenores = 0;
		int limiteDeEdad = 18;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] != null && this.usuarios[i].getEdad() < limiteDeEdad) {
				cantidadDeMenores++;
			}	
		}
		
		return cantidadDeMenores;
	}
	
	public int calcularCantidadDeUsuariosMayores() {
		/*
		 * Calcula la cantidad de usuarios mayores de edad registrados en el sistema.
		 */
		int cantidadDeMayores = 0;
		int limiteDeEdad = 18;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] != null && this.usuarios[i].getEdad() >= limiteDeEdad) {
				cantidadDeMayores++;
			}	
		}
		
		return cantidadDeMayores;
	}
	
	public double calcularEdadPromedio() {
		/*
		 * Calcula la edad promedio de usuarios registrados en el sistema.
		 */
		double sumatoriaDeEdades = 0.0;
		double promedioDeEdad = 0.0;
		
		for(int i=0; i < this.usuarios.length; i++){
			if(this.usuarios[i] != null) {
				sumatoriaDeEdades += this.usuarios[i].getEdad();
			}	
		}
		
		promedioDeEdad = sumatoriaDeEdades / (double) this.usuarios.length;

		return promedioDeEdad;
	}

	public boolean loguearUsuario (String usuario, String contrasenia) {
		/*
		 * Se debe loguear un usuario, el cual devolverá true si el usuario y la contraseña 
		 * ingresados son válidos o false en caso contrario. 
		 */		
		boolean sePudoLoguear = false;
	
		for(int i=0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario) == 0 && this.usuarios[i].getContrasenia().compareTo(contrasenia) == 0) {
				sePudoLoguear = true;
				break;
			}
		}
	
		return sePudoLoguear;	
	}

	@Override
	public String toString() {
		return "Nombre del Sistema=" + nombreDelSistema;
	}	
}