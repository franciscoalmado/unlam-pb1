package ar.edu.unlam.pb1.trabajoPractico02.dominio;

public class Calculadora {

	private double operador1;
	private double operador2;
	private double resultado;
	
	public Calculadora() {
		this.operador1 = 6.8;
		this.operador2 = 4.6;
		this.resultado = 0.0;
	}
	
	public Calculadora(double operador1, double operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
		this.resultado = 0.0;
	}
	
	public double sumar() {
			
		this.resultado = this.operador1 + this.operador2;
		
		return this.resultado;
	}
	
	public double sumar(double operador1, double operador2) {
				
		this.resultado = operador1 + operador2;
		
		return this.resultado;		
	}
	
	public double restar() {
				
		this.resultado = this.operador1 - this.operador2;
		
		return this.resultado;
	}
	
	public double restar(double operador1, double operador2) {
		
		this.resultado = operador1 - operador2;
		
		return this.resultado;		
	}	
	
	public double multiplicar() {
		
		this.resultado = this.operador1 * this.operador2;
		
		return this.resultado;
	}
	
	public double multiplicar(double operador1, double operador2) {
		
		this.resultado = operador1 * operador2;
		
		return this.resultado;		
	}
	
	public double dividir() {
		
		this.resultado = this.operador1 / this.operador2;	
				
		return this.resultado;
	}
	
	public double dividir(double numerador, double divisor) {
		
		this.resultado = numerador / divisor;			
		
		return this.resultado;		
	}
}