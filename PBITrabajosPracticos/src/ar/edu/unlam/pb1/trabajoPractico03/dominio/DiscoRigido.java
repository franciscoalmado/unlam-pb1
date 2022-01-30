package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class DiscoRigido {

	private final double TAMANIO_DVD;
	private final double TAMANIO_BLUE_RAY;
	private double cantidadDeDvd;
	private double cantidadDeBlueRay;
	private double capacidadDeDvd;
	private double capacidadDeBlueRay;
	
	public DiscoRigido() {
		this.TAMANIO_DVD = 4.5;
		this.TAMANIO_BLUE_RAY = 15.0;
	}
	
	public void setCapacidadDeDvd(int capacidad) {
		this.capacidadDeDvd = capacidad;
	}
	
	public void setCapacidadDeBlueRay(int capacidad) {
		this.capacidadDeBlueRay = capacidad;
	}
	
	public double getCantidadDeDvd() {
		this.cantidadDeDvd = (double) (this.capacidadDeDvd / this.TAMANIO_DVD);
		
		double cantidadDeDvdConValorAproximado = ((double) Math.round(this.cantidadDeDvd*100)/100);
		
		return cantidadDeDvdConValorAproximado;
	}
	
	public double getCantidadDeBlueRay() {
		this.cantidadDeBlueRay = (double) (this.capacidadDeBlueRay / this.TAMANIO_BLUE_RAY);
		
		double cantidadDeBlueRayConValorAproximado = (double) (Math.round(this.cantidadDeBlueRay*100) / 100);
		
		return cantidadDeBlueRayConValorAproximado;
	}		
}