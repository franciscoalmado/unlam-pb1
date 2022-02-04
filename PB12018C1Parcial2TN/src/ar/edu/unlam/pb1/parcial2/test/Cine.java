package ar.edu.unlam.pb1.parcial2.test;

import java.util.Scanner;

import ar.edu.unlam.pb1.parcial2.dominio.Espectador;
import ar.edu.unlam.pb1.parcial2.dominio.Funcion;
import ar.edu.unlam.pb1.parcial2.dominio.Sala;

public class Cine {
	
	static Scanner teclado = new Scanner(System.in);
	private static int cantidadDeFunciones = 6;
	private static Funcion funciones[] = new Funcion[cantidadDeFunciones];
	private static Sala sala1 = new Sala("Sala 01", 70, 10);
	private static Sala sala2 = new Sala("Sala 02", 60, 10);
	private static Sala sala3 = new Sala("Sala 03", 50, 10);
	private static Espectador espectador;
	
	public static void main(String[] args) {

		System.out.println("Bienvenido(a) a Cine UNLAM");
		
		int opcion = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				ingresarFunciones(funciones, sala1, sala2, sala3);
				break;
			case 2:
				realizarReserva(funciones);
				break;
			case 3:
				ingresarNuevoEspectador(funciones);
				verMapaDeSala(sala1);
				verMapaDeSala(sala2);
				verMapaDeSala(sala3);
				break;
			case 4:
				mantenimientoDeSala(funciones);
				verMapaDeSala(sala1);
				verMapaDeSala(sala2);
				verMapaDeSala(sala3);
				break;
			case 9:
				System.out.println("Gracias por preferirnos. ¡Hasta la próxima!");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 9);
	}

	private static int seleccionarOpcion() {
		int opcionSeleccionada = 0;

		System.out.println("************************");
		System.out.println("Menú de opciones\n");
		System.out.println("1 - Ingresar las funciones del día");
		System.out.println("2 - Realizar una reserva ");
		System.out.println("3 - Ingresar un nuevo espectador");
		System.out.println("4 - Realizar mantenimiento de sala");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opción");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}
	
	private static void ingresarFunciones(Funcion funciones[], Sala sala1, Sala sala2, Sala sala3) {
		/*
		 * Interfaz de usuario encargada de definir qué funciones ofrecerá el cine en un día determinado. 
		 * Se debe considerar las salas que dispone el cine.
		 */
		String diaYHora, pelicula;
		int aptaParaMayoresDe, elegirUnaOpcion;

		Funcion SpidermanNoWayHome;
		Funcion RapidosYFuriosos9;
		Funcion MatrixResurrections;
		
		System.out.println("Ingrese el día y la hora de la función (ejemplo: 2021/11/30-18:30h):");
		diaYHora = teclado.next();
		
		System.out.println("Ingrese el nombre de la película:");
		pelicula = teclado.nextLine();
		
		teclado.nextLine();
		
		System.out.println("Es apta para público mayor de:");
		aptaParaMayoresDe = teclado.nextInt();
		
		elegirUnaOpcion = elegirUnaOpcionDePelicula(teclado);
		
		if (elegirUnaOpcion == 1) {
			SpidermanNoWayHome = new Funcion(diaYHora, pelicula, aptaParaMayoresDe, sala1);
			funciones[elegirUnaOpcion] = SpidermanNoWayHome;
		}
		if (elegirUnaOpcion == 2) {
			RapidosYFuriosos9 = new Funcion(diaYHora, pelicula, aptaParaMayoresDe, sala2);
			funciones[elegirUnaOpcion] = RapidosYFuriosos9;
		}
		if (elegirUnaOpcion == 3) {
			MatrixResurrections = new Funcion(diaYHora, pelicula, aptaParaMayoresDe, sala3);
			funciones[elegirUnaOpcion] = MatrixResurrections;
		}
	}
	
	private static int elegirUnaOpcionDePelicula(Scanner teclado) {
		
		int elegirUnaOpcion = 0;
		
		System.out.println("Ingrese las siguientes opciones de películas en cartelera:");
		System.out.println("1 - Spiderman No Way Home");
		System.out.println("2 - Rápidos y Furiosos 9");
		System.out.println("3 - Matriz Resurrections");
		
		elegirUnaOpcion = teclado.nextInt();
		
		return elegirUnaOpcion;
	}

	private static void realizarReserva(Funcion funciones[]) {
		/*
		 * Interfaz de usuario encargada de realizar una nueva reserva. Se debe seleccinar la función deseada
		 * e ingresar los datos del espectador
		 */
		String nombre, apellido;
		int dni, edad, elegirUnaOpcion;
		
		System.out.println("Ingrese el nombre del espectador:");
		nombre = teclado.next();
		
		System.out.println("Ingrese el apellido del espectador:");
		apellido = teclado.next();
		
		System.out.println("Ingrese la edad del espectador:");
		edad = teclado.nextInt();
		
		System.out.println("Ingrese el DNI del espectador:");
		dni = teclado.nextInt();
		
		espectador = new Espectador(dni, nombre, apellido, edad);
		
		elegirUnaOpcion = elegirUnaOpcionDePelicula(teclado);
		
		funciones[elegirUnaOpcion].reservar(espectador);
	}

	private static void ingresarNuevoEspectador(Funcion funciones[]) {
		/*
		 * Interfaz de usuario encargada de realizar el ingreso de un nuevo espectador. Se debe solicitar datos 
		 * de la funcion y espectador. Sólo se pueden ingresar espectadores que tengan una reserva previa
		 */
		int dni, elegirUnaOpcion;
		
		System.out.println("Ingrese el DNI del espectador");
		dni = teclado.nextInt();
		
		elegirUnaOpcion = elegirUnaOpcionDePelicula(teclado);
		
		if (funciones[elegirUnaOpcion].buscarReserva(dni) != null) {
			espectador = funciones[elegirUnaOpcion].buscarReserva(dni);	
			
			if (elegirUnaOpcion == 1) {
				asignarAsientoAEspectador(sala1);
			}
			
			if (elegirUnaOpcion == 2) {
				asignarAsientoAEspectador(sala2);
			}
			
			if (elegirUnaOpcion == 3) {
				asignarAsientoAEspectador(sala3);
			}
		}
		System.out.println(espectador.toString());
	}
	
	private static void asignarAsientoAEspectador(Sala sala) {
		int fila, columna;
		
		System.out.println("Ingrese la fila");
		fila = teclado.nextInt();
		
		System.out.println("Ingrese el número de asiento");
		columna = teclado.nextInt();
		
		if(sala.ingresarEspectador(fila, columna, espectador) == true) {
			System.out.println("El espectador ha sido ingresado exitosamente." );
		}else {
			System.out.println("No se ha podido ingresar. Inténtelo de nuevo");
		}
	}

	private static void mantenimientoDeSala(Funcion funciones[]) {
		/*
		 * Al finalizar una función, se solicita el mantenimiento de la sala, lo cual implica además de las tareas
		 * de limpieza, verificar que todos los asientos queden liberados para recibir una nueva función
		 */		
		int elegirUnaOpcion = 0;
		
		elegirUnaOpcion = elegirUnaOpcionDePelicula(teclado);

		if (elegirUnaOpcion == 1) {
			sala1.vaciarSala();
			funciones[elegirUnaOpcion] = null;
		}
		if (elegirUnaOpcion == 2) {
			sala2.vaciarSala();
			funciones[elegirUnaOpcion] = null;
		}
		if (elegirUnaOpcion == 3) {
			sala3.vaciarSala();
			funciones[elegirUnaOpcion] = null;
		}
	}
	
	private static void verMapaDeSala(Sala sala) {	
		System.out.println("Mapa de salas: \n");
		System.out.println(sala.toString());
	}
}