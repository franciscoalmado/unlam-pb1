package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico09.dominio.Sistema;
import ar.edu.unlam.pb1.trabajoPractico09.dominio.Usuario;

public class PruebaSistema {

	static Scanner teclado = new Scanner(System.in);
	private static Sistema sistema;
	private static Usuario nuevoUsuario;
	
	public static void main(String[] args) {
		int selector = -1;
		
		while(selector != 4) {
			System.out.println("****************************************************");
			System.out.println("----------------------------------------------------");
			System.out.println("Sistema "+sistema.getNombreDelSistema().toUpperCase());
			System.out.println("----------------------------------------------------");
			System.out.println("Seleccione una opción:");
			System.out.println("1. Elegir nombre del sistema y cantidad de usuarios.");
			System.out.println("2. Agregar usuario al sistema.");
			System.out.println("3. Loguearse.");
			System.out.println("4. Salir.");
			System.out.println("****************************************************");
			selector = teclado.nextInt();
			
			switch (selector) {
				case 1:
					crearSistema();
					break;
				case 2:
					agregarUsuario(sistema);
					break;
				case 3:
					loguearUsuario();
					break;
				case 4:
					System.out.println("¡Gracias por preferirnos!");
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}	
		}
	}
	
	private static Sistema crearSistema() {
		System.out.println("Ingrese nombre del sistema");
		String nombre = teclado.next();
		System.out.println("Ingrese la cantidad máxima de usuarios");
		int cantidadMaximaDeUsuarios = teclado.nextInt();
		
		sistema = new Sistema(nombre, cantidadMaximaDeUsuarios);
		return sistema;
	}
	
	private static Usuario crearUsuario(Scanner teclado) {
		String usuario;
		String contrasenia;
		int cantidadDeUsuarios;
		
		System.out.println("Ingrese el nombre de usuario");
		usuario = teclado.next();
		
		System.out.println("Ingrese su contraseña");
		contrasenia = teclado.next();	
		
		nuevoUsuario = new Usuario(usuario, contrasenia);
				
		cantidadDeUsuarios = sistema.obtenerCantidadDeUsuarios();
		
		return nuevoUsuario;
	}
	
	private static void agregarUsuario(Sistema sistema) {

		nuevoUsuario = crearUsuario(teclado);
		
		if(sistema.agregarUsuario(nuevoUsuario) == true) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo agregar. El usuario ya existe.");
		}	
	}
	
	private static void loguearUsuario() {
	 
		String usuario;
		String contrasenia;
		
		System.out.println("Ingrese nombre de usuario");
		usuario = teclado.next();
		
		System.out.println("Ingrese su contraseña");
		contrasenia = teclado.next();
		
		if(sistema.loguearUsuario(usuario, contrasenia) == true) {
			System.out.println("Bienvenido al Sistema "+sistema.getNombreDelSistema());
		}else {
			System.out.println("El usuario no existe. Inténtelo de nuevo.");
		}
	}
}	