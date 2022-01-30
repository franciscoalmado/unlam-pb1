package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.trabajoPractico08.dominio.Persona;

public class PruebaEstadisticasDePersonas {

	static int opcion;
	static String nombre = "";
	static String genero = "";
	static long dni = 0;
	static int edad = 0;
	static double peso = 0.0;
	static double altura = 0.0;
	static int cantidadDePersonas = 0;
	static int contadorDePersonas = 0;
	static double pesoTotal = 0.0;
	static double pesoPromedio = 0.0;
	static double valorActualIMC = 0;
	static double VALOR_IMC_1 = 18.5;
	static double VALOR_IMC_2 = 25;
	static int contadorDePersonasConPesoNormal = 0;
	static int sumatoriaDeEdadPersonasConBajoPeso = 0;
	static int contadorDePersonasConBajoPeso = 0;
	static int sumatoriaDeEdadPersonasConSobrepeso = 0;
	static int contadorDePersonasConSobrepeso = 0;

	static Persona persona = new Persona(nombre, genero, dni, edad, peso, altura);
	static Scanner teclado = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		System.out.println("Ingrese la cantidad de personas que desea registrar: ");
		cantidadDePersonas = teclado.nextInt();
		
		while(opcion != 9) {
			
			do {
				mostrarMenu();
				
				System.out.println("Ingrese una opción: ");
				opcion = teclado.nextInt();
				
				switch(opcion) {
				case 1:
					registrarPersona(nombre, genero, dni, edad, peso, altura);
					break;
				case 2:
					System.out.println("El peso promedio es: "+informarPesoPromedio()+" kg");
					break;
				case 3:
					System.out.println("Cantidad de personas con bajo peso: "+getCantidadDePersonasConBajoPeso());
					break;
				case 4:
					System.out.println("Cantidad de personas con peso normal: "+getCantidadDePersonasConPesoNormal());
					break;
				case 5:
					System.out.println("Cantidad de personas con sobrepeso: "+getCantidadDePersonasConSobrepeso());
					break;
				case 6:
					System.out.println("Promedio de edades de personas con bajo peso: "+informarPromedioDeEdadDePersonasConBajoPeso());
					break;
				case 7:
					System.out.println("Promedio de edades de personas con bajo peso: "+informarPromedioDeEdadDePersonasConSobrepeso());
					break;				
				case 9:
					System.out.println("¡Muchas gracias por utilizar el programa!");
					break;
				default:
					System.out.println("La opción es inválida. Elija una nueva opción.");
					System.out.println();
					break;
				}	
			}while((opcion < 1 || opcion > 7) && opcion!= 9);	
		}	
		teclado.close();
	}
	
	private static void mostrarMenu() {
		System.out.println("******************");
		System.out.println("Estatísticas de Personas");
		System.out.println("1) Registrar nueva persona");
		System.out.println("2) Informar el peso promedio");
		System.out.println("3) Informar la cantidad de personas con bajo peso");
		System.out.println("4) Informar la cantidad de personas con peso normal");
		System.out.println("5) Informar la cantidad de personas con sobrepeso");
		System.out.println("6) Promedio de edad de las personas con bajo peso");
		System.out.println("7) Promedio de edad de las personas con sobrepeso");
		System.out.println("9) Salir");
		System.out.println("******************");	
	}
	
	private static void registrarPersona(String nombre, String genero, long dni, int edad, double peso, double altura) {
		
		do {
			System.out.println("Ingresar datos de la persona: ");
			System.out.println("Nombre");
			nombre = teclado.next();
			System.out.println("Genero: F para Femenino o M para Masculino");
			genero = teclado.next();
			System.out.println("DNI");
			dni = teclado.nextLong();
			System.out.println("Edad");
			edad = teclado.nextInt();
			System.out.println("Peso");
			peso = teclado.nextDouble();
			System.out.println("Altura");
			altura = teclado.nextDouble();
			persona = new Persona(nombre, genero, dni, edad, peso, altura);
			System.out.println(persona.toString());
			
			contadorDePersonas++;
			pesoTotal += peso;
			
			valorActualIMC = persona.calcularIndiceDeMasaCorporal(peso, altura);
			
			if(valorActualIMC < VALOR_IMC_1) {
				contadorDePersonasConBajoPeso++;
				sumatoriaDeEdadPersonasConBajoPeso += edad;
			}
			if(valorActualIMC >= VALOR_IMC_1 && valorActualIMC <= VALOR_IMC_2) {
				contadorDePersonasConPesoNormal++;
			}
			if(valorActualIMC  > VALOR_IMC_2) {
				contadorDePersonasConSobrepeso++;
				sumatoriaDeEdadPersonasConSobrepeso += edad;
			}
		}while (contadorDePersonas < cantidadDePersonas);	
	}
	
	private static double informarPesoPromedio() {
		
		pesoPromedio = pesoTotal / cantidadDePersonas;  
		
		return pesoPromedio;
	}
	
	private static int getCantidadDePersonasConBajoPeso() {
		return contadorDePersonasConBajoPeso;
	}
	
	private static int getCantidadDePersonasConPesoNormal() {
		return contadorDePersonasConPesoNormal;
	}
	
	private static int getCantidadDePersonasConSobrepeso() {
		return contadorDePersonasConSobrepeso;
	}
	
	private static double informarPromedioDeEdadDePersonasConBajoPeso() {
		double edadPromedioPersonasConBajoPeso = 0.0;
		
		edadPromedioPersonasConBajoPeso = sumatoriaDeEdadPersonasConBajoPeso / getCantidadDePersonasConBajoPeso();  
		
		return edadPromedioPersonasConBajoPeso;
	}
	
	private static double informarPromedioDeEdadDePersonasConSobrepeso() {
		double edadPromedioPersonasConSobrepeso = 0.0;
		
		edadPromedioPersonasConSobrepeso = sumatoriaDeEdadPersonasConSobrepeso / getCantidadDePersonasConSobrepeso();  
		
		return edadPromedioPersonasConSobrepeso;
	}
}