package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.trabajoPractico08.dominio.Calculadora;

public class PruebaCalculadora {

	static double operador1;
	static double operador2;
	static int opcion;
	static char eleccion;
	
	static Calculadora casio = new Calculadora(operador1, operador2);	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Bienvenidos: ");
		System.out.println("Ingrese operador 1 ");
		operador1 = teclado.nextDouble();
		System.out.println("Ingrese operador 2 ");
		operador2 = teclado.nextDouble();
		
		while(opcion != -1) {		
			do {
				mostrarMenu();
				
				System.out.println("Ingrese una opción: ");
				opcion = teclado.nextInt();
				
				switch(opcion) {
				case 0:
					System.out.println("Resultado: "+casio.sumar(operador1, operador2));
					break;
				case 1:
					System.out.println("Resultado: "+casio.restar(operador1, operador2));
					break;
				case 2:
					System.out.println("Resultado: "+casio.multiplicar(operador1, operador2));
					break;
				case 3:
					System.out.println("Resultado: "+casio.dividir(operador1, operador2));
					break;
				case 4:
					System.out.println("Resultado: "+casio.esPositivo(operador1, operador2));	
					break;
				case 5:
					System.out.println("Resultado: "+casio.potencia(operador1, operador2));
					break;
				case 6:
					System.out.println("Elija 'A' para sumatoria con 1 límite o 'B' para sumatoria con 2 límites");
					eleccion = teclado.next().charAt(0);
					if(eleccion == 'A' || eleccion == 'a') {
						System.out.println("Resultado: "+sumatoriaConUnOperador(operador1));	
					}
					if(eleccion == 'B' || eleccion == 'b') {
						System.out.println("Resultado: "+sumatoriaConDosOperadores(operador1, operador2));	
					}
					break;
				case 7:
					System.out.println("Elija 'A' para productoria con 1 límite o 'B' para productoria con 2 límites");
					eleccion = teclado.next().charAt(0);
					if(eleccion == 'A' || eleccion == 'a') {
						System.out.println("Resultado: "+productoriaConUnOperador(operador1));	
					}
					if(eleccion == 'B' || eleccion == 'b') {
						System.out.println("Resultado: "+productoriaConDosOperadores(operador1, operador2));	
					}
					break;
				case 8:
					System.out.println("Elija 'A' para divisores del operador 1 o 'B' para divisores del operador 2");
					eleccion = teclado.next().charAt(0);
					if(eleccion == 'A' || eleccion == 'a') {
						System.out.println("Resultado: "+casio.contarDivisores((int)operador1));	
					}
					if(eleccion == 'B' || eleccion == 'b') {
						System.out.println("Resultado: "+casio.contarDivisores((int)operador2));	
					}
					break;
				case 9:
					System.out.println("Elija 'A' para factorial del operador 1 o 'B' para factorial del operador 2");
					eleccion = teclado.next().charAt(0);
					if(eleccion == 'A' || eleccion == 'a') {
						System.out.println("Resultado: "+casio.factorial((int)operador1));	
					}
					if(eleccion == 'B' || eleccion == 'b') {
						System.out.println("Resultado: "+casio.factorial((int)operador2));	
					}
					break;
				case -1:
					System.out.println("¡Muchas gracias por utilizar el programa!");
					break;
				default:
					System.out.println("La opción es inválida. Elija una nueva opción.");
					System.out.println();
					break;
				}	
			}while(opcion > 0);
		}	
		teclado.close();
	}
	
	private static void mostrarMenu() {
		System.out.println("******************");
		System.out.println("***CALCULADORA CASIO***");
		System.out.println("0) Calcular Suma");
		System.out.println("1) Calcular Resta");
		System.out.println("2) Calcular Multiplicación");
		System.out.println("3) Calcular División");
		System.out.println("4) Informar si los operadores son positivos");
		System.out.println("5) Calcular Potencia");
		System.out.println("6) Calcular Sumatoria");
		System.out.println("7) Calcular Productoria");
		System.out.println("8) Mostrar divisores");
		System.out.println("9) Calcular factorial");
		System.out.println("-1) Salir");
		System.out.println("******************");	
	}
	
	private static int sumatoriaConUnOperador(double operador1) {
		int resultado = 0;
		
		resultado = casio.sumatoria((int)operador1);		
		
		return resultado;
	}
	
	private static int sumatoriaConDosOperadores(double operador1, double operador2) {
		int resultado = 0;
		
		if(operador1 < operador2) {
			resultado = casio.sumatoria((int)operador1, (int)operador2);	
		}
		if(operador1 > operador2) {
			resultado = casio.sumatoria((int)operador2, (int)operador1);	
		}		
		
		return resultado;
	}
	
	private static int productoriaConUnOperador(double operador1) {
		int resultado = 0;
		
		resultado = casio.productoria((int)operador1);		
		
		return resultado;
	}
	
	private static int productoriaConDosOperadores(double operador1, double operador2) {
		int resultado = 0;
		
		if(operador1 < operador2) {
			resultado = casio.productoria((int)operador1, (int) operador2);	
		}
		if(operador1 > operador2) {
			resultado = casio.productoria((int)operador2, (int) operador1);	
		}
		
		return resultado;
	}
}