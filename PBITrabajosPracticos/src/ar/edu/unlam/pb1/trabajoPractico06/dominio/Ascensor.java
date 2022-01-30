package ar.edu.unlam.pb1.trabajoPractico06.dominio;

public class Ascensor {

	private final int PISO_MAXIMO;
	private final int PISO_MINIMO;
	private final double PESO_MAXIMO;
	private final int CAPACIDAD_MAXIMA;
	private boolean puertaAbierta;
	private boolean sobrecarga;
	public static long pisoActual;
	private double pesoActual;
	private int capacidadActual;
	private int contadorDeUsuario;

	public Ascensor(int capacidadMaxima, double pesoMaximo) {
		this.PISO_MAXIMO = 10;
		this.PISO_MINIMO = -2;
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
		this.PESO_MAXIMO = pesoMaximo;
		this.sobrecarga = false;
		this.puertaAbierta = false;
		this.contadorDeUsuario = 0;
		Ascensor.pisoActual = PISO_MAXIMO;
	}
	
	public void ingresar(Persona elQueSube) {
		
	}
	
	public void ingresar(double peso) {
		
		if(abrirPuerta() == true || isPuertaAbierta() == true) {
			this.pesoActual += peso;
			this.contadorDeUsuario++;			
		}
	}
	
	public void salir(double peso) {
		
		if(abrirPuerta() == true || isPuertaAbierta() == true) {
			this.pesoActual -= peso;	
			this.contadorDeUsuario--;
			this.sobrecarga = false;
			this.puertaAbierta = false;
		}
	}
	
	public void salir(Persona elQueBaja) {
		
	}
	
	public boolean abrirPuerta() {
		boolean abrirPuerta = false;
		
		if(Ascensor.pisoActual <= this.PISO_MAXIMO && Ascensor.pisoActual >= this.PISO_MINIMO) {
			abrirPuerta = true;
		}
		return abrirPuerta;
	}
	
	public boolean cerrarPuerta() {
		boolean cerrarPuerta = false;
		
		if(Ascensor.pisoActual <= this.PISO_MAXIMO && Ascensor.pisoActual >= this.PISO_MINIMO && isSobrecarga() == false) {
			cerrarPuerta = true;
		}
		return cerrarPuerta;
	}
	
	public void subir() {
		
		if(Ascensor.pisoActual < this.PISO_MAXIMO && isSobrecarga() == false) {
			Ascensor.pisoActual++;
		}
	}
	
	public void bajar() {
		
		if(Ascensor.pisoActual > this.PISO_MINIMO && isSobrecarga() == false) {
			Ascensor.pisoActual--;
		}
	}
	
	public int getPisoActual() {	
		return (int) Ascensor.pisoActual;
	}
	
	public void  irAlPiso(int pisoDeseado){
    	if (pisoDeseado >= PISO_MINIMO && pisoDeseado <= PISO_MAXIMO) {
	    	if (pisoDeseado < Ascensor.pisoActual) {					
		    	while (pisoDeseado < Ascensor.pisoActual) {
					Ascensor.pisoActual--;			
				}
		    }
	    	if (pisoDeseado > Ascensor.pisoActual) {
				while (pisoDeseado > Ascensor.pisoActual) {
					Ascensor.pisoActual++;
				}
			}
		}
    }
	
	public boolean isSobrecarga() {
		
		if(this.pesoActual > this.PESO_MAXIMO || this.capacidadActual > this.CAPACIDAD_MAXIMA) {
			this.sobrecarga = true;
		}
		return this.sobrecarga;
	}
	
	public boolean isPuertaAbierta() {
		
		if(isSobrecarga() == true) {
			this.puertaAbierta = true;
		}
		return this.puertaAbierta;
	}
	
	public double getPesoActual() {
		return this.pesoActual;
	}

	public int getCapacidadActual() {
		
		this.capacidadActual = this.contadorDeUsuario;
		
		return this.capacidadActual;
	}
	
	public int getPISO_MAXIMO() {
		return this.PISO_MAXIMO;
	}

	public int getPISO_MINIMO() {
		return this.PISO_MINIMO;
	}
}