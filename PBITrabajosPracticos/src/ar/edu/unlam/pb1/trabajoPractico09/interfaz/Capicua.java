package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

public class Capicua {
	static String estado;
	static int valor;
	static Scanner teclado = new Scanner(System.in);
	static int[] numeros;

	public static void main(String[] args) {

		System.out.println("Ingrese número:");
		valor = teclado.nextInt();
		numeros = new int[String.valueOf(valor).length()];

		for(int i = 0; i < numeros.length; i++){
			numeros[i] = Character.getNumericValue(String.valueOf(valor).charAt(i));
		}

		for(int i = 0; i < numeros.length; i++){
			if (numeros[i] == numeros[numeros.length - i - 1]) {
				estado = "Es Capicua";
			}else{
				estado = "No es capicua";
				i = numeros.length;
			}
		}
		System.out.println(estado);
	}
}