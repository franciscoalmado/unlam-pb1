package ar.edu.unlam.pb1.trabajoPractico02.dominio;

public class Coche {

	private final int CERO_KM = 0;
	private final int ANO_ACTUAL = 2021;
	private static int cantidadCoches;
	private String marca;
	private String modelo;
	private int kilometrosActuales;
	private int anioDeFabricacion;
	private double precio;
	
	public Coche (String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.kilometrosActuales = CERO_KM;
		this.anioDeFabricacion = ANO_ACTUAL;
		Coche.cantidadCoches++;
	}
	
	public Coche(String marca, String modelo, int kilometros, int ano, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.kilometrosActuales = kilometros;
		this.anioDeFabricacion = ano;
		this.precio = precio;
		Coche.cantidadCoches++;
	}
	
	public static int getCantidadCoches() {
		return Coche.cantidadCoches;
	}
	
	public void setKilometrosActuales(int kilometros) {
		
		if(this.kilometrosActuales > CERO_KM) {
			this.kilometrosActuales = kilometros;	
		}else {
			this.kilometrosActuales = CERO_KM;
		}
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public int calcularAntiguedad() {
		int antiguedad = 0;
		
		if(this.ANO_ACTUAL >= this.anioDeFabricacion) {
			antiguedad = this.ANO_ACTUAL - this.anioDeFabricacion;
		} else {
			antiguedad = 0;
		}
		return antiguedad;
	}
	
	public int getKilometros() {
		return this.kilometrosActuales;
	}
	
	@Override
	public String toString() {
		return "Marca: "+this.marca+", modelo: "+this.modelo+", año de fabricación: "+this.anioDeFabricacion+", kilómetros: "+this.kilometrosActuales+", precio: "+this.precio;
	}
}