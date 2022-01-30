package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class Cerradura {

	private int claveDeApertura;
	private int cantidadDeFallosConsecutivosQueLaBloquean;
	private boolean estado;
	private int contadorDeFallosConsecutivosQueLaBloquean;
	
	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.claveDeApertura = claveDeApertura;
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
		this.estado = false;
		this.contadorDeFallosConsecutivosQueLaBloquean = 0;
	}	
	
	public boolean abrir(int clave) {
		boolean abrirCerradura = false;
		
		if(this.claveDeApertura == clave) {
			abrirCerradura = true;
			this.estado = true;
			contadorDeFallosConsecutivosQueLaBloquean = 0;
		}else {
			abrirCerradura = false;	
			contadorDeFallosConsecutivosQueLaBloquean++;
		}	
		return abrirCerradura;
	}
	
	public void cerrar() {
		
		this.estado = false; 
	}
	
	public boolean estaAbierta() {
		
		return this.estado;
	}
	
	public boolean fueBloqueada() {
		boolean estaBloqueada = false;
		
		if(getCantidadDeIntentosRestantes() == 0) {
			estaBloqueada = true;
		}
		return estaBloqueada;
	}
	
	public int getCantidadDeIntentosRestantes() {
		int cantidadIntentosRestantes = 0;
		
		cantidadIntentosRestantes = cantidadDeFallosConsecutivosQueLaBloquean - contadorDeFallosConsecutivosQueLaBloquean;
		
		return cantidadIntentosRestantes;
	}
	
	public int getContadorDeFallosConsecutivosQueLaBloquean() {
		return contadorDeFallosConsecutivosQueLaBloquean;
	}
}