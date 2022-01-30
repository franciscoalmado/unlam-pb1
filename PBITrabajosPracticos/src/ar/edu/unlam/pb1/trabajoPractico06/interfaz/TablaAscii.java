package ar.edu.unlam.pb1.trabajoPractico06.interfaz;

import java.util.Scanner;

public class TablaAscii {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		char opcion;
		
		do {
			System.out.println("***TABLA ASCII***");
			System.out.println("Ingrese A para ver los caracteres numéricos");
			System.out.println("Ingrese B para ver los caracteres mayúsculas");
			System.out.println("Ingrese C para ver los caracteres minúsculas");
			System.out.println("Ingrese D para ver los caracteres especiales");
			System.out.println("Ingrese S para salir");
			System.out.println("***********************");
			opcion = teclado.next().charAt(0);
			
			switch(opcion) {			
				case 'A':
				case 'a':
					String numericos = "";
					char caracterInicial = '0'; 
					while (caracterInicial <= '9') {
						numericos += ((int)caracterInicial + " - " + caracterInicial + ", ");
						caracterInicial++;
					}
					System.out.println("Caracteres númericos:");
					System.out.println(numericos);
					break;
				case 'B':
				case 'b':
					String mayusculas = "";
					char caracterMayusculas = 'A';
					while (caracterMayusculas <= 'Z') {
						mayusculas += ((int)caracterMayusculas + " - " + caracterMayusculas + ", ");
						caracterMayusculas++;
					}
					System.out.println("Letras mayúsculas:");
					System.out.println(mayusculas);
					break;
				case 'C':
				case 'c':
					String minusculas = "";
					char caracterMinusculas = 'a';
					while (caracterMinusculas <= 'z') {
						minusculas += ((int)caracterMinusculas + " - " + caracterMinusculas + ", ");
						caracterMinusculas++;
					}
					System.out.println("Letras minúsculas:");
					System.out.println(minusculas);
					break;
				case 'D':
				case 'd':
					String especiales = "";
					char caracterEspeciales = '!';
					while (caracterEspeciales <= '/') {
						especiales += ((int)caracterEspeciales + " - " + caracterEspeciales + ", ");
						caracterEspeciales++;
					}
					caracterEspeciales = ':';
					while (caracterEspeciales <= '@') {
						especiales += ((int)caracterEspeciales + " - " + caracterEspeciales + ", ");
						caracterEspeciales++;
					}
					caracterEspeciales = '[';
					while (caracterEspeciales <= '`') {
						especiales += ((int)caracterEspeciales + " - " + caracterEspeciales + ", ");
						caracterEspeciales++;
					}
					caracterEspeciales = '{';
					while (caracterEspeciales <= '~') {
						especiales += ((int)caracterEspeciales + " - " + caracterEspeciales + ", ");
						caracterEspeciales++;
					}
					System.out.println("Caracteres especiales:");
					System.out.println(especiales);
					break;
				case 'S':
				case 's':
					System.out.println("¡Muchas gracias por utilizar el programa!");
					break;
				default:
					System.out.println("Opción inválida");
					break;
			}
		}while(opcion != 'S' || opcion != 's');
		teclado.close();
	}
}