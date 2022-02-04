package ar.edu.unlam.pb1.parcial2.dominio;

public class Concesionaria {

	private Coche[] flota;
	private int cantidadDeCochesEnLaFlota;
	private int cantidadDeCochesAgregados;
	
	public Concesionaria (int cantidadDeCochesEnLaFlota) {
		this.cantidadDeCochesEnLaFlota = cantidadDeCochesEnLaFlota;
		this.flota = new Coche[this.cantidadDeCochesEnLaFlota];
		this.cantidadDeCochesAgregados = 0;
	}

	public void ingresarCoche (Coche nuevoCoche) {
		/*
		 *  Permite incorporar un coche a la flota.
		 */
		if(this.cantidadDeCochesAgregados < this.cantidadDeCochesEnLaFlota) {
			this.flota[this.cantidadDeCochesAgregados++] = nuevoCoche;
		}
	}
	
	public int calcularCantidadDeUsados(){
		/*
		 *  Calcula la cantidad de coches usados de la flota.
		 */
		int cantidadDeCochesUsados = 0;
		
		for(int i=0; i < this.flota.length; i++) {
			if(this.flota != null && this.flota[i].calcularAntiguedad() > 0) {
				cantidadDeCochesUsados++;
			}
		}
		
		return cantidadDeCochesUsados;
	}
	
	public int calcularCantidadDe0Km(){
		/*
		 *  Calcula la cantidad de coches 0 KM de la flota.
		 */
		int cantidadDeCoches0Km = 0;
		
		for(int i=0; i < this.flota.length; i++) {
			if(this.flota != null && this.flota[i].calcularAntiguedad() == 0) {
				cantidadDeCoches0Km++;
			}
		}
		
		return cantidadDeCoches0Km;
	}
	
	public double calcularPrecioPromedio(){
		/*
		 *  Calcula el precio promedio de la flota.
		 */
		double sumatoriaDePrecio = 0.0;
		double precioPomedioDeLaFlota = 0.0;
		
		for(int i=0; i < this.flota.length; i++) {
			if(this.flota != null) {
				sumatoriaDePrecio += this.flota[i].getPrecio();
			}
		}
		
		precioPomedioDeLaFlota = sumatoriaDePrecio / (double) this.flota.length;
		
		return precioPomedioDeLaFlota;
	}
	
	public Coche[] buscarVehiculo(String marca, String modelo) {
		/*
		 *  Busca coches por marca y modelo.
		 */
		for(int i=0; i < this.flota.length; i++) {
			if(this.flota != null && this.flota[i].getMarca().compareTo(marca) == 0 && this.flota[i].getModelo().compareTo(modelo) == 0) {
				return this.flota; 	
			}
		}		
		return null;
	}

	public Coche[] buscarVehiculo(double precio) {
		/*
		 *  Busca coches por precio.
		 */
		for(int i=0; i < this.flota.length; i++) {
			if(this.flota != null && this.flota[i].getPrecio() == precio) {
				return this.flota; 	
			}
		}		
		return null;
	}
	
	public void ordenarFlota() {
		/*
		 *  Ordena la flota de coches por su precio.
		 */
		Coche auxiliar = null;
		
		for(int i=1; i < this.flota.length; i++) {
			for(int j=0; j < this.flota.length-1; j++){
				if(this.flota[i] != null && flota[j].getPrecio() > this.flota[j+1].getPrecio()) {
					auxiliar = this.flota[j+1];
					this.flota[j+1] = this.flota[j];
					this.flota[j] = auxiliar;		
				}	
			}	
		}
	}
	
	public Coche[] getCoches() {
		return this.flota;
	}
}