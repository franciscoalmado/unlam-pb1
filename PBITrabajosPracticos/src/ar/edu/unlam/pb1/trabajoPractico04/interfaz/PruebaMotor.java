package ar.edu.unlam.pb1.trabajoPractico04.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico04.dominio.Motor;

public class PruebaMotor {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Elija un número del 1 al 4: ");
		int opcion = teclado.nextInt();
		
		Motor industriasUnlam = new Motor(opcion,"agua","nafta");

		System.out.println(industriasUnlam.dimeTipoMotor(opcion));
		
		teclado.close();
	}
}