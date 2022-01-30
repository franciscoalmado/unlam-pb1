package ar.edu.unlam.pb1.trabajoPractico10.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico10.dominio.Alumno;
import ar.edu.unlam.pb1.trabajoPractico10.dominio.Aula;

public class PruebaAula {
	
	static Scanner teclado = new Scanner(System.in);
	private static Aula aula;
	private static Alumno alumno;
	
	public static void main(String[] args) {
	
		int selector = -1;
		
		while(selector != 5) {
			System.out.println("*************************************************************");
			System.out.println("-------------------------------------------------------------");
			System.out.println("Sistema UNLAM para la administración de las aulas del futuro:");
			System.out.println("-------------------------------------------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Asignar aula.");
			System.out.println("2. Sentar alumno.");
			System.out.println("3. Mostrar el mapa del aula.");
			System.out.println("4. Mostrar cantidad de asistentes.");
			System.out.println("5. Salir.");
			System.out.println("************************************************************");
			selector = teclado.nextInt();
			
			switch (selector) {
				case 1:
					asignarAula();
					break;
				case 2:
					sentarAlumno(aula);
					break;
				case 3:
					mostrarMapaDelAula(aula);
					break;
				case 4:
					mostrarAsistencia(aula);
					break;
				case 5:
					System.out.println("¡Gracias por su visita!");
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}	
		}
	}
	
	private static Aula asignarAula() {
		System.out.println("Ingrese el número del aula");
		int numero = teclado.nextInt();
		System.out.println("Ingrese el número de filas de asientos");
		int cantidadDeFilas = teclado.nextInt();
		System.out.println("Ingrese el número de columnas de asientos");
		int cantidadDeColumnas = teclado.nextInt();
		
		aula = new Aula(numero, cantidadDeFilas, cantidadDeColumnas);
		return aula;
	}
	
	private static Alumno crearAlumno(Scanner teclado) {
		
		System.out.println("Ingrese el nombre del alumno");
		String nombre = teclado.next();
		
		System.out.println("Ingrese DNI");
		int dni = teclado.nextInt();	
		
		alumno = new Alumno(nombre, dni);
		
		return alumno;
	}
	
	private static void sentarAlumno(Aula aula) {
		int fila;
		int columna;
		
		do {
			alumno = crearAlumno(teclado);
			
			System.out.println("Ingrese el número del asiento en fila");
			fila = teclado.nextInt();
			System.out.println("Ingrese el número del asiento en columna");
			columna = teclado.nextInt();			
		}while(fila >= aula.getCantidadDeFilas() && columna >= aula.getCantidadDeColumnas());
	
		aula.sentarUnAlumno(fila, columna, alumno.getNombre());
	}
	
	private static void mostrarMapaDelAula(Aula aula) {
		System.out.println("Mapa del aula "+aula.getNumero());
		System.out.println(aula.tostring());
	}
	
	private static void mostrarAsistencia(Aula aula) {
		int aforoTotal = aula.getCantidadDeFilas() * aula.getCantidadDeColumnas();
		int cantidadDeAsistentes = aula.mostrarCantidadDeAsistentes();
		int asientosDisponibles = aforoTotal - cantidadDeAsistentes; 
		
		System.out.println("Aforo total: "+aforoTotal);
		System.out.println("Cantidad de aistentes al aula: "+cantidadDeAsistentes+" alumnos");
		
		if(cantidadDeAsistentes < aforoTotal) {
			System.out.println("Asientos disponibles: "+asientosDisponibles+" asientos");	
		}
		if(cantidadDeAsistentes == aforoTotal){
			System.out.println("Asistencia completa");
		}
		if(cantidadDeAsistentes > aforoTotal){
			System.out.println("No hay asientos disponibles");
		}
	}
}