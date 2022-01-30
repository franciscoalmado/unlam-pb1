package ar.edu.unlam.pb1.trabajoPractico05.interfaz;

import ar.edu.unlam.pb1.trabajoPractico05.dominio.Calculadora;

public class PruebaCalculadora {

	public static void main(String[] args) {
		
		double operador1 = 8.0;
		double operador2 = 2.0;
		
		Calculadora laCalculadoraDelCelular = new Calculadora();
		Calculadora casio = new Calculadora(operador1,operador2);
		
		System.out.println("Suma - La Calculadora del Celular: "+laCalculadoraDelCelular.sumar());
		System.out.println("Suma - Calculadora Casio: "+casio.sumar(operador1,operador2));
		
		System.out.println("Resta - La Calculadora del Celular: "+laCalculadoraDelCelular.restar());
		System.out.println("Resta - Calculadora Casio: "+casio.restar(operador1,operador2));
		
		System.out.println("Multiplicaci�n - La Calculadora del Celular: "+laCalculadoraDelCelular.multiplicar());
		System.out.println("Multiplicaci�n - Calculadora Casio: "+casio.multiplicar(operador1,operador2));
		
		System.out.println("Divisi�n - La Calculadora del Celular: "+laCalculadoraDelCelular.dividir());
		System.out.println("Divisi�n - Calculadora Casio: "+casio.dividir(operador1,operador2));	
		
		System.out.println("�Los operadores son positivos?: "+laCalculadoraDelCelular.esPositivo()); 
		System.out.println("�Los operadores son positivos?: "+casio.esPositivo());
		
		System.out.println("Potencia - La Calculadora del Celular: "+laCalculadoraDelCelular.potencia());
		System.out.println("Potencia - Calculadora Casio: "+casio.potencia(operador1, operador2));
		
		System.out.println("Sumatoria - Calculadora Casio: "+casio.sumatoria((int)operador1));
		System.out.println("Sumatoria con l�mites (inferior y superior) - Calculadora Casio: "+casio.sumatoria((int)operador2, (int) operador1));
		
		System.out.println("Productoria - Calculadora Casio: "+casio.productoria((int)operador1));
		System.out.println("Productoria con l�mites (inferior y superior) - Calculadora Casio: "+casio.productoria((int)operador2, (int) operador1));
	
		System.out.println("Contar Divisores - Calculadora Casio: "+casio.contarDivisores((int)operador1));
	}
}