package ar.edu.unlam.pb1.trabajoPractico09.dominio;

public class Sistema {

	private Usuario[] usuarios;
	private String nombreDelSistema;
	private int cantidadDeUsuarios;
	private final int CANTIDAD_MAXIMA_DE_USUARIOS;

	public Sistema(String nombreDelSistema, int cantidadMaximaDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.CANTIDAD_MAXIMA_DE_USUARIOS = cantidadMaximaDeUsuarios;
		this.usuarios = new Usuario[CANTIDAD_MAXIMA_DE_USUARIOS];
		this.cantidadDeUsuarios = 0;
	}
	
	public String getNombreDelSistema() {
		return this.nombreDelSistema;
	}

	public void setNombreDelSistema(String nombreDelSistema) {
		this.nombreDelSistema = nombreDelSistema;
	}
	
	public boolean agregarUsuario(Usuario nuevo) {
		boolean sePudoAgregar = false;
		
		if(this.cantidadDeUsuarios < this.CANTIDAD_MAXIMA_DE_USUARIOS && buscarUsuario(nuevo.getUsuario()) == null) {
			this.usuarios[this.cantidadDeUsuarios++]= nuevo;
			sePudoAgregar = true;
		}
		return sePudoAgregar;
	}

	public boolean loguearUsuario(String usuario, String contrasenia) {
		boolean sePudoLoguear = false;
		
		for (int i = 0; i < this.usuarios.length; i++) {
			if (this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario) == 0 && usuarios[i].getContrasenia().compareTo(contrasenia) == 0) {
				sePudoLoguear = true;	
			}
		}
		
		return sePudoLoguear;
	}
	
	public Usuario buscarUsuario(String usuario) {
		
		for(int i = 0; i < this.usuarios.length; i++) {
			if(this.usuarios[i] != null && this.usuarios[i].getUsuario().compareTo(usuario) == 0) {
				return this.usuarios[i];
			}
		}	return null;	
	}
	
	public String mostrarUsuariosRegistrados() {
		String listadoDeUsuarios = "";
		
		for(int i = 0; i < this.usuarios.length; i++) {
			listadoDeUsuarios += this.usuarios[i].getUsuario() + "\n";
		}	
		return listadoDeUsuarios;
	}
	
	public int obtenerCantidadDeUsuarios() {
		return this.cantidadDeUsuarios;
	}
}