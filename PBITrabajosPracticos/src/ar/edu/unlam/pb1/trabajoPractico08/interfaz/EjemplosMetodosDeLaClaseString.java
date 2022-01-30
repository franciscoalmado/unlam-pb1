package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import java.util.Arrays;

public class EjemplosMetodosDeLaClaseString {

	public static void main(String[] args) {
		
		String mensaje = "Bienvenido a la cursada de Java";
		char resultado = mensaje.charAt(0);
		System.out.println(resultado);
		
		String string1 = "Java";
		String string2 = "Java";
		String string3 = "Otro string";
		System.out.println(string1.equals(string2));
		System.out.println(string2.equals(string3));
		
		String string4 = "JaVa";
		String string5 = "java";
		System.out.println(string4.equalsIgnoreCase(string5));

		System.out.println(mensaje.length());
		System.out.println(string1.length());
		System.out.println(string3.length());
		
		System.out.println(mensaje.substring(4, 18));
		System.out.println(string1.substring(1, 2));
		System.out.println(string3.substring(3, 10));
		
		String string6 = "A-B-C-D";
		String[] stringArray = string6.split("-"); 
		System.out.println(Arrays.toString(stringArray));
		
		System.out.println(mensaje.toLowerCase());
		System.out.println(string1.toLowerCase());
		
		System.out.println(mensaje.toUpperCase());
		System.out.println(string1.toUpperCase());
		
		String string7 = "       Hola, me llamo Francisco y    ";
		String string8 = "  me gusta programar. ";
		System.out.println(string7.trim() + string8.trim());
		
		System.out.println(string1.compareTo(string2));
		System.out.println(string3.compareTo(string6));
		System.out.println(string4.compareTo(string5));
	}
}