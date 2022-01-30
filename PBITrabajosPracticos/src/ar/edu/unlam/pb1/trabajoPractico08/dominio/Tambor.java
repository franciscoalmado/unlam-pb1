package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public class Tambor {

	private final int POSICION_MINIMA = 1;
	private final int POSICION_MAXIMA = 8;
	private int posicion = 1;
	 
	public void girar() {
		this.posicion=(int) (Math.random() * (this.POSICION_MINIMA-this.POSICION_MAXIMA) + this.POSICION_MAXIMA);
	}

	public int getPosicion() {
		return this.posicion;
	}	
}