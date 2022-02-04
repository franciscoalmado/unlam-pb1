package ar.edu.unlam.pb1.parcial2.dominio;

public class Coche {

	private String marca;
	private String modelo;
	private int kilometros;
	private int anio;
	private double precio;
	
	private static int cantidadCoches = 0;
	
	private final int CERO_KM = 0;
	private final int ANIO_ACTUAL = 2018;
	
	private String id;
	
	public Coche(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.kilometros = CERO_KM;
		this.anio = ANIO_ACTUAL;
		Coche.cantidadCoches++;
		this.id = calcularID();
	}
	
	public Coche(String marca, String modelo, int kilometros, int anio, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.kilometros = kilometros;
		this.anio = anio;
		Coche.cantidadCoches++;
		this.id = calcularID();
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String calcularID() {
		/*
		 *Incorpora un atributo ID, el cual está compuesto por la concatenación del modelo del coche más un valor aleatorio. 
		 */
		String idCalculado = "";
		int valorAleatorio = (int) (Math.random() * 1000 + 1);
	
		idCalculado = modelo+""+valorAleatorio;
		
		return idCalculado;
	}
	
	public int calcularAntiguedad() {
		/*
		 *Calcula la antigüedad del coche. 
		 */
		int antiguedad = 0;
		
		if(this.anio < this.ANIO_ACTUAL) {
			antiguedad = this.ANIO_ACTUAL - this.anio;
		}else {
			antiguedad = 0;
		}
				
		return antiguedad;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public int getCantidadDeCoches() {
		return Coche.cantidadCoches;
	}
	
	public int getKilometros() {
		return this.kilometros;
	}

	@Override
	public String toString() {
		return "Coche [ID: " + id + ", marca: " + marca + ", modelo: " + modelo + ", precio: " + precio + "]";
	}	
}