package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int[] vector = new int[5];
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++){
			System.out.println("Ingrese un número: ");
			vector[i] = teclado.nextInt();
		}
		
		System.out.println("\n");
		for(int i=0; i <5; i++){
			System.out.println("Valor en posición "+i+" es: "+vector[i]);
		}
		
		teclado.close();
	}

}
