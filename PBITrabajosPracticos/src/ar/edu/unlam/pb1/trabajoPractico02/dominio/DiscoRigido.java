package ar.edu.unlam.pb1.trabajoPractico02.dominio;

public class DiscoRigido {

	private final double TAMANIO_DVD;
	private final int TAMANIO_BLUE_RAY;
	private int cantidadDeDvd;
	private int cantidadDeBlueRay;
	private int capacidadDeDvd;
	private int capacidadDeBlueRay;
	
	public DiscoRigido() {
		this.TAMANIO_DVD = 4.5;
		this.TAMANIO_BLUE_RAY = 15;
	}
	
	public void setCapacidadDeDvd(int capacidad) {
		this.capacidadDeDvd = capacidad;
	}
	
	public void setCapacidadDeBlueRay(int capacidad) {
		this.capacidadDeBlueRay = capacidad;
	}
	
	public double getCantidadDeDvd() {
		this.cantidadDeDvd = (int) (this.capacidadDeDvd / this.TAMANIO_DVD);
		
		return this.cantidadDeDvd;
	}
	
	public double getCantidadDeBlueRay() {
		this.cantidadDeBlueRay = this.capacidadDeBlueRay / this.TAMANIO_BLUE_RAY;
		
		return this.cantidadDeBlueRay;
	}		
}