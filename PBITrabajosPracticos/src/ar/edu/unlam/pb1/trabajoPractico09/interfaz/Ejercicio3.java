package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		char[] abecedario = new char[52];
		Scanner teclado = new Scanner(System.in);
		
		int valor;
		String cadenaDeTexto = "";
		
		for(int i=0; i < 52; i++){
			if(i <= 25) {
				abecedario[i] = (char)(i + 65);
			} else {
				abecedario[i] = (char)(i + 71);
			}
		}
		
		do{
			System.out.println("Ingrese número: ");
			valor = teclado.nextInt();
			if(valor < 52 && valor >= 0) {
				cadenaDeTexto += abecedario[valor];
				System.out.println(cadenaDeTexto + "\n");
			}
		}while(valor != -1);
		
		teclado.close();
	}
}