package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import ar.edu.unlam.pb1.trabajoPractico08.dominio.Password;

public class PruebaPassword {

	public static void main(String[] args) {
		
		Password ejemploDeContrase�a = new Password(8);
		
		System.out.println("Contrase�a generada: "+ejemploDeContrase�a.getPassword());
		System.out.println("�Es Fuerte?: "+ejemploDeContrase�a.esFuerte());
	}
}