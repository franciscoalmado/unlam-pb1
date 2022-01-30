package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Calculadora;

public class PruebaCalculadora {

	public static void main(String[] args) {
		
		double operador1 = 10.3;
		double operador2 = 0.0;
		
		Calculadora laCalculadoraDelCelular = new Calculadora();
		Calculadora casio = new Calculadora(operador1,operador2);
		
		System.out.println("Suma - La Calculadora del Celular: "+laCalculadoraDelCelular.sumar());
		System.out.println("Suma - Calculadora Casio: "+casio.sumar(operador1,operador2));
		
		System.out.println("Resta - La Calculadora del Celular: "+laCalculadoraDelCelular.restar());
		System.out.println("Resta - Calculadora Casio: "+casio.restar(operador1,operador2));
		
		
		System.out.println("Multiplicación - La Calculadora del Celular: "+laCalculadoraDelCelular.multiplicar());
		System.out.println("Multiplicación - Calculadora Casio: "+casio.multiplicar(operador1,operador2));
		
		System.out.println("División - La Calculadora del Celular: "+laCalculadoraDelCelular.dividir());
		System.out.println("División - Calculadora Casio: "+casio.dividir(operador1,operador2));	
		
		System.out.println("¿Los operadores son positivos?: "+laCalculadoraDelCelular.esPositivo()); 
		System.out.println("¿Los operadores son positivos?: "+casio.esPositivo());
	}
}