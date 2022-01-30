package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

public class PruebaReferencia {

	public static void main(String[] args) {
		
		String texto1 = new String("Hola");
		String texto2 = new String("Hola");
		
		if(texto1 == texto2) {
			System.out.println("Los textos son iguales.");
		}else {
			System.out.println("Los textos son distintos.");
		}
		
		/*
		 Respuesta: en Java, solo los tipos primitivos, por ejemplo int o char, se comparan con ==, los Strings (y los demás objetos) se comparan entre ellos con el método equals.
		 */
		if(texto1.equals(texto2)) {
			System.out.println("Los textos son iguales.");
		}else {
			System.out.println("Los textos son distintos.");
		}
		
	}
}