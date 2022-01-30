package PB12021RecSegundoParcial.Interfaz;

import java.util.Scanner;
import PB12021RecSegundoParcial.Dominio.Deposito;
import PB12021RecSegundoParcial.Dominio.Genero;
import PB12021RecSegundoParcial.Dominio.Libro;

/**
 * DIIT - Tecnicatura Universitaria en Web / Mobile PB1 - 2C - Recuperatorio Segundo Parcial - TM
 * 
 * Fecha: 07/12/2021
 * 
 */ 

public class AdministracionLibreria {
	
	static final int SALIR = 9;
	private static Deposito bibliotecaUnlam = new Deposito("Biblioteca Leopoldo Marechal", 3, 5);
	private static Libro libro;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("¡Bienvenido al mundo de los libros!");

		int opcion = 0;
		
		do {
			opcion = seleccionarOpcion(teclado);
			switch (opcion) {
			case 1: // Ingresar un nuevo libro e informar si fue exitoso
				ingresarUnLibro();
				break;
			case 2: // Cargar libros que van al deposito por autor e informar si fue exitoso
				cargarLibrosQueVanAlDepositoPorAutor();
				break;
			case 3: // Buscar libros por genero e informarlos
				buscarLibrosPorGenero(bibliotecaUnlam.getLibros());
				// informarLibros()
				System.out.println("---------------------------------------------");
				informarLibros(bibliotecaUnlam.getLibros());
				break;
			case 4: // Ordenar e informar libros por anio de publicacion
				ordenarLibrosAscendentementePorAnioDePublicacion(bibliotecaUnlam);
				// informarLibros()
				System.out.println("---------------------------------------------");
				informarLibros(bibliotecaUnlam.getLibros());
				break;
			case 5: // Informar cantidad de libros que van al deposito
				informarCantidadDeLibrosQueVanAlDeposito(bibliotecaUnlam);
				break;
			case SALIR:
				System.out.println("Gracias por preferirnos. �Hasta la pr�xima!");
				break;
			default:
				System.out.println("Opcion Inv�lida");
				break;
			}

		} while (opcion != SALIR);
	}

	private static int seleccionarOpcion(Scanner teclado) {
		
		int opcionSeleccionada = 0;

		System.out.println("************************");
		System.out.println("Men� de librer�a\n");
		System.out.println("1 - Ingresar un libro.");
		System.out.println("2 - Llevar libros al dep�sito por autor.");
		System.out.println("3 - Buscar libros por g�nero.");
		System.out.println("4 - Ordenar libros por a�o de publicaci�n.");
		System.out.println("5 - Informar cantidad de libros que van al dep�sito.");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opci�n");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}

	/**
	 * Muestra por pantalla los libros en un array
	 * @param libros Libros que se mostraran
	 * */
	private static void informarLibros(Libro[] libros) {
	
		for(int i=0; i < libros.length; i++) {
			if(libros[i] != null){
				System.out.println(libros.toString());
			}
		}	
	}
	
	private static void ingresarUnLibro() {
		
		if(bibliotecaUnlam.ingresarEjemplar(crearUnLibro(teclado)) == true) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo ingresar. Int�ntelo de nuevo.");
		}
		
	}
	
	private static Libro crearUnLibro(Scanner teclado) {
		
		String isbn = generarUnIsbnAleatorio();
		
		System.out.println("Ingrese el nombre del libro");
		String nombre = teclado.next();
		
		System.out.println("Ingrese el autor del libro");
		String autor = teclado.next();
		
		System.out.println("Ingrese la editorial");
		String editorial = teclado.next();
		
		System.out.println("Ingrese el precio");
		double precio = teclado.nextDouble();
		
		Genero genero = elegirUnGenero(teclado);
		
		System.out.println("Ingrese el a�o de publicaci�n");
		int anioDePublicacion = teclado.nextInt();
		
		libro = new Libro(isbn, nombre, autor, editorial, precio, genero, anioDePublicacion);
		
		return libro;		
	}
	
	private static String generarUnIsbnAleatorio() {
		int comienzoASCII = 48;
		int finASCII = 57;
		int valorRandom;
		int contador = 0;
		int longitud = 13;
		String isbn = "";

		while(contador < longitud){
			do {
				valorRandom = (int) ((Math.random() * finASCII) + comienzoASCII);
			}while(!(esNumero(valorRandom)));

			valorRandom = (char) valorRandom;
			isbn += String.valueOf((char) valorRandom);
			contador++;
		}	
		
		return isbn;
	}
	
	private static boolean esNumero(int valorATestear) {
		return ((valorATestear > 47) && (valorATestear < 58));
	}
	
	private static Genero elegirUnGenero(Scanner teclado) {
		Genero genero = null;
		int elegirGeneroDeLibro = 0;
		int limiteInferior = 1;
		int limiteSuperior = 6;
		
		do {
			System.out.println("Elija un g�nero (ejemplo: 1)");
			System.out.println("1. Anime   -   2. Cl�sico   -   3. Historia");
			System.out.println("4. Novela  -   5. Policial  -   6. Thriller");
			elegirGeneroDeLibro = teclado.nextInt();
		}while(elegirGeneroDeLibro < limiteInferior && elegirGeneroDeLibro > limiteSuperior);

		switch(elegirGeneroDeLibro) {
			case 1:
				genero = Genero.ANIME;
				break;
			case 2:
				genero = Genero.CLASICO;
				break;
			case 3:
				genero = Genero.HISTORIA;
				break;
			case 4:
				genero = Genero.NOVELA;
				break;
			case 5:
				genero = Genero.POLICIAL;
				break;
			case 6:
				genero = Genero.THRILLER;
				break;
		}
	
		return genero;
	}
	
	private static void cargarLibrosQueVanAlDepositoPorAutor() {
		
		System.out.println("Ingrese el autor del libro");
		String autor = teclado.next();
		
		if(bibliotecaUnlam.cargarEjemplaresQueVanAlDepositoPorAutor(autor) == true) {
			System.out.println("Carga satisfactoria");
		}else {
			System.out.println("No se pudo cargar. Int�ntelo de nuevo.");
		}		
	}
	
	private static void buscarLibrosPorGenero(Libro[] libros) {
		
		Genero genero = elegirUnGenero(teclado);
		
		System.out.println("Libros seg�n su g�nero: ");
		
		for(int i=0; i < libros.length; i++) {
			if(libros[i] != null && libros[i].getGenero() == genero){
				System.out.println(libros[i].toString());
			}
		}		
	}
	
	private static void ordenarLibrosAscendentementePorAnioDePublicacion(Deposito bibliotecaUnlam) {
		
		Libro[] ordenarLibros = bibliotecaUnlam.ordenarLibrosPorAnioPublicacion();
		
		System.out.println("Libros ordenados de forma ascendente seg�n su a�o de publicaci�n: ");
		
		for(int i=0; i < ordenarLibros.length; i++) {
			System.out.println(ordenarLibros[i] + " ");
		}
	}
	
	private static void informarCantidadDeLibrosQueVanAlDeposito(Deposito bibliotecaUnlam) {
		
		System.out.println("Cantidad de ejemplares en dep�sito: "+bibliotecaUnlam.getCantidadDeEjemplaresAlDeposito()+" unidades");
	}
}