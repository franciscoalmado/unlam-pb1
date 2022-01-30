package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico09.dominio.Auto;
import ar.edu.unlam.pb1.trabajoPractico09.dominio.Concesionaria;

public class PruebaConcesionaria {

	private static Concesionaria concesionaria = new Concesionaria(2);
	private static 	Auto nuevo;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);
	
		while(opcion != 4) {
			System.out.println("******************************");
			System.out.println("------------------------------");
			System.out.println("CONCESIONARIA UNLAM");
			System.out.println("------------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Ingresar vehículo.");
			System.out.println("2. Listar todos los vehículos.");
			System.out.println("3. Listar por código.");
			System.out.println("4. Salir");
			System.out.println("******************************");
			opcion = teclado.nextInt();
			
			switch (opcion) {
			case 1: 
				ingresarAuto(concesionaria);
				break;
			case 2:
				System.out.println("Lista de autos de la concesionaria: ");
				System.out.println(concesionaria.mostrarListado());
				break;
			case 3:
				buscarAuto(concesionaria);
				break;
			case 4:
				System.out.println("¡Gracias por preferirnos!");
				break;
			default:
				System.out.println("Opción inválida");
			}
		}
		teclado.close();
	}
	
	private static void ingresarAuto(Concesionaria concesionaria) {
	
		nuevo = registrarAuto(teclado);
		
		if(concesionaria.ingresarAuto(nuevo) == true) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo ingresar");
		}
	}
	
	private static Auto registrarAuto(Scanner teclado) {
		
		String marca;
		String modelo;
		int codigo = 0;
				
		System.out.println("Ingrese Marca:");
		marca = teclado.next();
		
		System.out.println("Ingrese Modelo:");
		modelo = teclado.next();
		
		nuevo = new Auto(marca, modelo);
		
		codigo = nuevo.getCodigo();
		
		return nuevo; 
	}
	
	private static void buscarAuto(Concesionaria concesionaria) {

		System.out.println("Ingrese el código a buscar");
		int codigoABuscar = teclado.nextInt();
		
		nuevo = concesionaria.buscarAutoPorCodigo(codigoABuscar);
		
		if (nuevo != null) {
			System.out.println(nuevo.toString());	
		}else {
			System.out.println("No se encontró el vehículo.");
		} 							
	}
}