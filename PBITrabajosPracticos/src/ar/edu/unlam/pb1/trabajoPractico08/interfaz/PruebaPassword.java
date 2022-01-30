package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import ar.edu.unlam.pb1.trabajoPractico08.dominio.Password;

public class PruebaPassword {

	public static void main(String[] args) {
		
		Password ejemploDeContraseña = new Password(8);
		
		System.out.println("Contraseña generada: "+ejemploDeContraseña.getPassword());
		System.out.println("¿Es Fuerte?: "+ejemploDeContraseña.esFuerte());
	}
}