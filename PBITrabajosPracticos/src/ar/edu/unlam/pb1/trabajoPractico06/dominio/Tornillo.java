package ar.edu.unlam.pb1.trabajoPractico06.dominio;

public class Tornillo {

	private final char TIPO_DE_CABEZA;
	private final int LONGITUD;
	private final int CANTIDAD_DE_ROSCA;
	private int posicionActual;
	public static final char SENTIDO_HORARIO = 'H';
	public static final char SENTIDO_ANTIHORARIO = 'A';

	public Tornillo(char tipoDeCabeza, int longitud, int cantidadDeRosca) {
		this.TIPO_DE_CABEZA = tipoDeCabeza;
		this.LONGITUD = longitud;
		this.CANTIDAD_DE_ROSCA = cantidadDeRosca;
		this.posicionActual = 0;
	}

	public int getLongitud() {
		 return this.LONGITUD;
	}
	 
	public char getTipoCabeza() {
		return this.TIPO_DE_CABEZA;
	}

	public boolean girar(char sentido) {		
		boolean validacion = false;
			
		if(sentido == SENTIDO_HORARIO) {
			validacion = girarSentidoHorario();
		}
		if(sentido == SENTIDO_ANTIHORARIO) {
			validacion = girarSentidoAntihorario();
		}
		
		return validacion;
	 }
	 
	private boolean girarSentidoHorario() {
		boolean validacion = false;
		
		if(this.posicionActual < this.CANTIDAD_DE_ROSCA && this.posicionActual < this.LONGITUD) {
			this.posicionActual++;
			validacion = true;
		}
		
		return validacion;
	}
		
	private boolean girarSentidoAntihorario() {
		boolean validacion = false;
		
		if(this.posicionActual > 0) {
			this.posicionActual--;
			validacion = true;
		}
		
		return validacion;
	}
	 
	public int getPosicionActual() {
		return this.posicionActual;
	}
}