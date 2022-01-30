package ar.edu.unlam.pb1.trabajoPractico06.dominio;

public class Persona {

	private String nombre;
	private String genero;
	private long dni;
	private double peso;
	private double altura;
	private int edad;
	private boolean viva;
	private double valorIMC = 0;
	
	public Persona(String nombre, String genero, long dni, double peso, double altura) {
		this.nombre = nombre;
		this.genero = genero;
		this.dni = dni;
		this.peso = peso;
		this.altura = altura;
		this.edad++;
		this.viva = true;
	}
	
	public Persona(String nombre, String genero, long dni, int edad, double peso, double altura) {
		this.nombre = nombre;
		this.genero = genero;
		this.dni = dni;
		this.peso = peso;
		this.altura = altura;
		this.edad = edad;
		this.viva = true;
	}
	
	public void alimentar(double kilos) {
		if(this.viva == true) {
			this.peso += kilos;	
		}
		else {
			this.peso = 0;
		}
	}
	
	public void crecer(double metros) {
		if(this.viva == true) {
			this.altura += metros;
		}
		else {
			this.altura = 0;
		}
	}
	
	public void cumplirAnos() {
		if(this.viva == true) {
			this.edad++;	
		}
		else {
			this.edad = 0;
		}
	}
	
	public void morir() {
		this.viva = !viva;
	}
	
	public double pesar() {
		return this.peso;
	}
	
	public double medir() {
		return this.altura;
	}
	
	public int mostrarEdad() {
		return this.edad;
	}
	
	public boolean estaViva() {
		return this.viva;
	}
	
	public boolean esMayorDeEdad() {
		boolean esMayorDeEdad = false;
		
		if(this.edad >= 18) {
			esMayorDeEdad = true;
		}else {
			esMayorDeEdad = false;
		}
		return esMayorDeEdad;
	}
	
	@Override
	public String toString() {
		return "Nombre: "+this.nombre+", Genero: "+this.genero+", DNI: "+this.dni+", Edad: "+this.edad+", Peso: "+this.peso+", Altura: "+this.altura;
	}
	
	public double calcularIndiceDeMasaCorporal(double peso, double altura) {
		
		this.valorIMC = peso / (Math.pow(altura, 2));
		
		return this.valorIMC;
	}
}