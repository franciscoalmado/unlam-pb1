package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.trabajoPractico08.dominio.Cuenta;

public class CajeroAutomatico {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al sistema de cajero automático");
		
		Cuenta cuenta = new Cuenta("Edward Snowden", 0.0);
		
		int opcion = -1;
		int salir = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				depositar(cuenta);
				break;
			case 2:
				extraer(cuenta);
				break;
			case 3:
				System.out.println("Saldo actual: "+consultar(cuenta)+" $");				
				break;
			case 0:
				System.out.println("¡Gracias por preferirnos!");
				break;
			default:
				System.out.println("Opcion Inválida");
				break;
			}
		} while (opcion != salir);	
	}
		
	private static int seleccionarOpcion() {		
		int opcionSeleccionada = -1;
		
		System.out.println("*******************************************");
		System.out.println("Menú de opciones\n");
		System.out.println("1 - Depositar");
		System.out.println("2 - Extraer");
		System.out.println("3 - Consultar");
		System.out.println("0 - Salir");
		System.out.println("*******************************************");
		System.out.println("Ingrese una opción");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static void depositar(Cuenta cuenta) {
		double montoADepositar = 0.0;
		
		do {
			System.out.println("Ingrese monto a depositar (ejemplo: 500.0): ");
			montoADepositar = teclado.nextDouble();
			
		}while(montoADepositar <= 0.0);
		
		cuenta.depositar(montoADepositar);
	}
	
	private static void extraer(Cuenta cuenta) {		
		double montoARetirar = 0.0;
		
		montoARetirar = seleccionarMontoARetirar();
		
		cuenta.retirar(montoARetirar);
	}
	
	private static double seleccionarMontoARetirar() {
		
		int elegirOpcion, minimo = 1, maximo = 7;
		double montoARetirar = 0.0;
		double PRIMER_MONTO = 100.0, SEGUNDO_MONTO = 200.0;
		double TERCER_MONTO = 300.0, CUARTO_MONTO = 400.0;
		double QUINTO_MONTO = 500.0, SEXTO_MONTO = 1000.0;
		double otroMonto = 0.0;
		
		do {
			System.out.println("*******************************************");
			System.out.println("Elije el monto a retirar (ejemplo: 1 - 100):");
			System.out.println("1 - 100");
			System.out.println("2 - 200");
			System.out.println("3 - 300");
			System.out.println("4 - 400");
			System.out.println("5 - 500");
			System.out.println("6 - 1000");
			System.out.println("7 - Otro monto");
			System.out.println("*******************************************");
			elegirOpcion = teclado.nextInt();	
		} while (elegirOpcion < minimo || elegirOpcion > maximo);
		
		switch(elegirOpcion) {
			case 1:
				montoARetirar = PRIMER_MONTO;
				break;
			case 2:
				montoARetirar = SEGUNDO_MONTO;
				break;
			case 3:
				montoARetirar = TERCER_MONTO;
				break;
			case 4:
				montoARetirar = CUARTO_MONTO;
				break;
			case 5:
				montoARetirar = QUINTO_MONTO;
				break;
			case 6:
				montoARetirar = SEXTO_MONTO;
				break;
			case 7:
				do {
					int multiplo = 10;
					System.out.println("Ingrese el monto a retirar (ejemplo: 2000)");
					otroMonto = teclado.nextDouble();
					if(otroMonto > 0 && otroMonto%multiplo == 0) {
						montoARetirar = otroMonto;
					}else {
						System.out.println("Ingrese un monto válido");
					}
				}while(otroMonto <= 0);
				break;
			default:
				System.out.println("Opcion Inválida");
				break;
		}	
		return montoARetirar;
	}
	
	private static double consultar(Cuenta cuenta) {	
		return cuenta.getSaldo();
	}	
}