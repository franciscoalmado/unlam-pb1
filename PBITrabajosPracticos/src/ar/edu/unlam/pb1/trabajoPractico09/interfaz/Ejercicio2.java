package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int[] vector;
		int sumatoria = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el tamaño del vector: ");
		vector = new int[teclado.nextInt()];
		
		for(int i = 0; i < vector.length; i++){
			vector[i] = (int)(Math.random() * 50) + 1;
			sumatoria += vector[i];
		}
		
		System.out.println("\n");
		for(int i=0;i<vector.length;i++){
			System.out.println("Valor en posición "+i+" es: "+vector[i]);
		}
		
		System.out.println("\nEl promedio de los números dentro del vector es de: " + (float)sumatoria/vector.length);
		
		teclado.close();
	}
}