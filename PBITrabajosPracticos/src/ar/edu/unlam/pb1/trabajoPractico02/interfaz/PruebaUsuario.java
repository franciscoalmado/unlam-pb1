package ar.edu.unlam.pb1.trabajoPractico02.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico02.dominio.Usuario;

public class PruebaUsuario {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese usuario: ");
		String usuario = teclado.next();
		System.out.println("Ingrese contraseña: ");
		String contrasenia = teclado.next();
		System.out.println("Ingrese nombre: ");
		String nombre = teclado.next();
		System.out.println("Ingrese apellido: ");
		String apellido = teclado.next();
		System.out.println("Ingrese DNI: ");
		int dni = teclado.nextInt();
		System.out.println("Ingrese edad: ");
		int edad = teclado.nextInt();
		
		Usuario nuevoUsuario = new Usuario(usuario, contrasenia, nombre, apellido, dni, edad);
		
		teclado.close();
		
		System.out.println(nuevoUsuario.toString());
		
		nuevoUsuario.setContrasenia("654321");
		
		nuevoUsuario.setEdad(30);
		
		System.out.println("Usuario: "+nuevoUsuario.getUsuario());
		
		System.out.println("Contraseña: "+nuevoUsuario.getContrasenia());
		
		System.out.println(nuevoUsuario.toString());
	}
}