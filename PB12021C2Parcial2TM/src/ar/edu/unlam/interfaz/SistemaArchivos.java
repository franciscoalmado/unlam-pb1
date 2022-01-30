package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Archivo;
import ar.edu.unlam.dominio.TiposDeArchivo;
import ar.edu.unlam.dominio.TiposDeUnidad;
import ar.edu.unlam.dominio.UnidadAlmacenamiento;

public class SistemaArchivos {
	
	/**
	 * DIIT - Tecnicatura Universitaria en Web / Mobile
	 * PB1 - 2C - Segundo Parcial - TM
	 * 
	 * Fecha: 30/11/2021
	 * 
	 * Se pide:
	 *	1 - Generar los constructores de las clases UnidadAlmacenamiento y Archivo.
	 *	2 - Generar los enums necesarios para satisfacer los tipos de unidad (hdd, usb) y tipos de archivo (jpg, png, txt, exe).
	 *	3 - Desarrollar el método agregarArchivo de la clase UnidadAlmacenamiento considerando que el array de archivos no esté lleno y la capacidad máxima no sea superada.
	 *	4 - Desarrollar el método obtenerAchivosTipoJpgOrdenadosPorNombreDesc de la clase UnidadAlmacenamiento.
	 *	5 - Desarrollar el método informarEspacioAlmacenado de la clase UnidadAlmacenamiento.
	 *	6 - Copia archivos de la Unidad hdd a usb,
	 *	7 - Agregar el código necesario en el main para satisfacer las operaciones solicitadas.
     *
	 * Importante:
	 * 	- El alumno podrá agregar todos atributos y/o generar métodos adicionales que considere necesarios para alcanzar dicha solución.
	 * 	- No es posible modificar los prototipos de métodos preexistentes.
	 *	- El criterio de condición de promoción es tener el 80% o más del exámen aprobado y el criterio para aprobar la cursada es del 60% del exámen aprobado.
	 *  - En la clase de pruebas, realice lo siguiente:
	 *  -   + Agregue el código necesario para resolver los casos del switch principal.
	 *	-	+ Sugiera mejoras que puedan aplicarse al código actual.
	 * */
	
	static final char SALIR = 'Z';
	static Scanner teclado = new Scanner(System.in);
	private static final int CANTIDAD_DE_ARCHIVOS_HDD = 2;
	private static final double CAPACIDAD_MAXIMA_HDD = 100.0;
	private static final int CANTIDAD_DE_ARCHIVOS_USB = 2;
	private static final double CAPACIDAD_MAXIMA_USB = 64.0;
	private static Archivo archivosEnHdd;
	private static UnidadAlmacenamiento unidadHdd = new UnidadAlmacenamiento(TiposDeUnidad.HDD, CANTIDAD_DE_ARCHIVOS_HDD, CAPACIDAD_MAXIMA_HDD);
	private static UnidadAlmacenamiento unidadUsb = new UnidadAlmacenamiento(TiposDeUnidad.USB, CANTIDAD_DE_ARCHIVOS_USB, CAPACIDAD_MAXIMA_USB);
	
	public static void main(String[] args) {		
		char opcion = '\0';
		char salir = 'Z';

		do {
			mostrarMenuPrincipal();
			opcion = teclado.next().charAt(0);
			
			switch (opcion) {
			case 'A': // Agregar un archivo a la unidad de almacenamiento tipo HDD e informar si el agregado fue exitoso.
			case 'a':
				ingresarArchivo(unidadHdd);
				break;
			case 'B': // Informar el espacio almacenado en el HDD
			case 'b':	
				System.out.println("Espacio almacenado actual: " +unidadHdd.informarEspacioAlmacenado() + " MB");
				break;
			case 'C': // Mostrar archivos JPG ordenados por nombre del HDD
			case 'c':
				mostrarArchivosTipoJpgOrdenadosPorNombreDescedentemente(unidadHdd);
				break;
			case 'D': // Copiar archivos desde el HDD a USB
			case 'd':
				copiarArchivosAUnidad(unidadHdd.getArchivos(), unidadUsb);
				mostrarArchivosEnUnidad(unidadUsb.getArchivos());
				break;
			case 'Z':
				System.out.println("�Muchas gracias por usar el sistema!");
				break;
			default:
				System.out.println("Opcion inv�lida. Ingrese nuevamente.");
			}
		} while (opcion != salir);

		teclado.close();
	}

	/**
	 * Muestra el menú principal del sistema con las opciones disponibles
	 */
	private static void mostrarMenuPrincipal() {
		System.out.println("\n¡Bienvenido al gestor de archivos!");
		System.out.println("\nIngrese:");
		System.out.println("A - Para agregar un archivo a la unidad de almacenamiento HDD.");
		System.out.println("B - Para informar el espacio almacenado en el HDD.");
		System.out.println("C - Para mostrar archivos JPG ordenados por nombre del HDD.");
		System.out.println("D - Para copiar los archivos desde el HDD a USB.");
		System.out.println("Z - Para salir.");
	}
	
	private static void ingresarArchivo(UnidadAlmacenamiento unidadHdd) {
		
		archivosEnHdd = crearArchivo(teclado);
		
		if(unidadHdd.agregarArchivo(archivosEnHdd) == true) {
			System.out.println("Ingreso satisfactorio.");
		}else {
			System.out.println("No se pudo ingresar. El archivo supera la capacidad disponible de la unidad.");
		}
	}
	
	private static Archivo crearArchivo(Scanner teclado) {
		int cantidad = 0;
		TiposDeArchivo tipoDeArchivo; 
		
		System.out.println("Ingrese el nombre que desea dar al archivo");
		String nombre = teclado.next();
		System.out.println("Ingrese el tama�o del archivo en KB (ejemplo 5,0)");
		double tamanio = teclado.nextDouble();
		
		tipoDeArchivo = elegirTipoDeArchivo(teclado);
		
		archivosEnHdd = new Archivo (tamanio, nombre, tipoDeArchivo);
		
		cantidad = unidadHdd.obtenerCantidadDeArchivos();
		
		return archivosEnHdd;
	}
	
	private static TiposDeArchivo elegirTipoDeArchivo(Scanner teclado) {
		TiposDeArchivo tipoDeArchivo = null;
		int minimo = 1; 
		int maximo = 4;
		int eleccion = 0;
	
		do {
			System.out.println("Ingrese el tipo de archivo (Ejemplo: 1):");
			System.out.println("1. JPG");
			System.out.println("2. PNG");
			System.out.println("3. TXT");
			System.out.println("4. EXE");
			eleccion = teclado.nextInt();
		} while (eleccion < minimo || eleccion > maximo);
		
		switch(eleccion) {
			case 1: 
				tipoDeArchivo = TiposDeArchivo.JPG;
				break;
			case 2: 
				tipoDeArchivo = TiposDeArchivo.PNG;
				break;
			case 3: 
				tipoDeArchivo = TiposDeArchivo.TXT;
				break;
			case 4: 
				tipoDeArchivo = TiposDeArchivo.EXE;
				break;
		}
		return tipoDeArchivo;
	}
	
	private static void mostrarArchivosTipoJpgOrdenadosPorNombreDescedentemente(UnidadAlmacenamiento unidadHdd) {
		
		Archivo[] archivosJpg = unidadHdd.obtenerAchivosTipoJpgOrdenadosPorNombreDesc();
		
		for(int i = 0; i < archivosJpg.length; i++) {
			System.out.println(archivosJpg[i] + " ");
		}
	}
	
	/**
	 * Copia archivos que recibe como parametro a una unidad de almacenamiento
	 * 
	 * @param archivosHDD Archivos a copiar en la unidad USB
	 * @param usb         Unidad de almacenamiento USB
	 */

	private static void copiarArchivosAUnidad(Archivo[] archivosEnHdd, UnidadAlmacenamiento unidadHdd) {
		
		for (int i = 0; i < archivosEnHdd.length; i++) {
			if (archivosEnHdd[i] != null) {
				unidadUsb.agregarArchivo(archivosEnHdd[i]);
			}
		}
	}
	
	private static void mostrarArchivosEnUnidad(Archivo[] archivos) {
		System.out.println("Archivos en unidad USB:");

		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i] != null) {
				System.out.println(archivos[i].toString());
			}
		}
	}	
}