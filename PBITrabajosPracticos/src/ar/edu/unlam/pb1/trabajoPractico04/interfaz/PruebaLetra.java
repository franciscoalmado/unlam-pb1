package ar.edu.unlam.pb1.trabajoPractico04.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico04.dominio.Letra;

public class PruebaLetra {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese una letra: ");
		char letra = teclado.next().charAt(0);
		
		Letra nuevaLetra = new Letra(letra);
		
		if(nuevaLetra.esVocal()) {
			System.out.println("Es una vocal.");
		}else {
			System.out.println("No es una vocal.");
		}	
		teclado.close();
	}
}