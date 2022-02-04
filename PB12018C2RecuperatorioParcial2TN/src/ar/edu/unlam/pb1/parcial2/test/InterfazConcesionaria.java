package ar.edu.unlam.pb1.parcial2.test;

import java.util.Arrays;
import java.util.Scanner;

import ar.edu.unlam.pb1.parcial2.dominio.Coche;
import ar.edu.unlam.pb1.parcial2.dominio.Concesionaria;

public class InterfazConcesionaria {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido ");
		int cantidadDeCochesEnLaFlota = 5;
		Concesionaria autoCity = new Concesionaria(cantidadDeCochesEnLaFlota);
	
		int opcion = 0;
		
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
				case 1:
					ingresarVehiculo(autoCity);
					break;
				case 2:
					buscarVehiculosPorMarcaYModelo(autoCity);
					break;
				case 3:
					buscarVehiculosPorPrecio(autoCity);
					break;
				case 4:
					ordenarFlota(autoCity);
					break;
				case 9:
					System.out.println("Muchas gracias por preferirnos. ¡Hasta la próxima!");
					break;
				default:
					System.out.println("Opción Inválida");
					break;
				}
		} while (opcion != 9);
	}
	
	private static int seleccionarOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menú de opciones\n");
		System.out.println("1 - Ingresar vehículo");
		System.out.println("2 - Buscar vehículos por marca y modelo");
		System.out.println("3 - Buscar vehículos por precio");
		System.out.println("4 - Ordenar vehículos por precio");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opción");
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static void ingresarVehiculo(Concesionaria autoCity) {
		Scanner teclado = new Scanner(System.in);
		String marca, modelo;
		int kilometros, anio;
		double precio;		
		int eleccion = 0;
		boolean ingresoExitoso = false;
		
		do {
			System.out.println("Ingrese 1 para registrar un coche 0 KM o 2 para registrar un coche usado:");
			eleccion = teclado.nextInt();	
		}while(eleccion < 1 && eleccion > 2);
		
		if(eleccion == 1) {
			
			System.out.println("Ingrese la marca:");
			marca = teclado.next();
			
			System.out.println("Ingrese el modelo:");
			modelo = teclado.next();
			
			System.out.println("Ingrese el precio:");
			precio = teclado.nextDouble();
			
			Coche coche = new Coche(marca, modelo, precio);
			
			autoCity.ingresarCoche(coche);
		}
		
		if(eleccion == 2) {
			
			System.out.println("Ingrese la marca:");
			marca = teclado.next();
			
			System.out.println("Ingrese el modelo:");
			modelo = teclado.next();
			
			System.out.println("Ingrese los kilómetros:");
			kilometros = teclado.nextInt();

			System.out.println("Ingrese el año de fabricación:");
			anio = teclado.nextInt();
			
			System.out.println("Ingrese el precio:");
			precio = teclado.nextDouble();
			
			Coche coche = new Coche(marca, modelo, kilometros, anio, precio);
			
			autoCity.ingresarCoche(coche);		
		}
	}
	
	private static void buscarVehiculosPorMarcaYModelo(Concesionaria autoCity) {
		Scanner teclado = new Scanner(System.in);
		String marca, modelo;
		Coche[] cochesPorMarcaYModelo = null;
		
		System.out.println("Ingrese la marca:");
		marca = teclado.next();
		
		System.out.println("Ingrese el modelo:");
		modelo = teclado.next();
		
		System.out.println("Búsqueda de coches por marca y modelo");
		
		cochesPorMarcaYModelo = autoCity.buscarVehiculo(marca, modelo); 
		
		for(int i=0; i < cochesPorMarcaYModelo.length; i++) {
			if(cochesPorMarcaYModelo[i] != null && cochesPorMarcaYModelo[i].getMarca().compareTo(marca) == 0 && cochesPorMarcaYModelo[i].getModelo().compareTo(modelo) == 0) {
				System.out.println(cochesPorMarcaYModelo[i] + " ");	
			}
		}
	}
	
	private static void buscarVehiculosPorPrecio(Concesionaria autoCity) {
		Scanner teclado = new Scanner(System.in);
		Coche[] cochesPorPrecio = null;	
		double precio;
			
		System.out.println("Ingrese el precio:");
		precio = teclado.nextDouble();
		
		cochesPorPrecio = autoCity.buscarVehiculo(precio);

		System.out.println("Búsqueda de coches por precio");
		for(int i=0; i < cochesPorPrecio.length; i++) {
			if(cochesPorPrecio[i] != null && cochesPorPrecio[i].getPrecio() == precio) {
				System.out.println(cochesPorPrecio[i] + " ");	
			}	
		}
	}
	
	private static void ordenarFlota(Concesionaria autoCity) {
		
		Coche[] listaDeCochesOrdenadosPorPrecio = autoCity.getCoches();
		Coche auxiliar = null;
		
		System.out.println("Lista de coches ordenados por precio");
		for(int i=1; i < listaDeCochesOrdenadosPorPrecio.length; i++) {
			for(int j=0; j < listaDeCochesOrdenadosPorPrecio.length-1; j++){
				if(listaDeCochesOrdenadosPorPrecio[i] != null && listaDeCochesOrdenadosPorPrecio[j].getPrecio() > listaDeCochesOrdenadosPorPrecio[j+1].getPrecio()) {
					auxiliar = listaDeCochesOrdenadosPorPrecio[j+1];
					listaDeCochesOrdenadosPorPrecio[j+1] = listaDeCochesOrdenadosPorPrecio[j];
					listaDeCochesOrdenadosPorPrecio[j] = auxiliar;		
				}	
			}	
		}
		System.out.println(Arrays.toString(listaDeCochesOrdenadosPorPrecio));
	}
}