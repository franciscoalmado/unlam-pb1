package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Nota;

public class PruebaNota {

	public static void main(String[] args) {
		
		Nota alumno1 = new Nota(3);
		
		System.out.println("La nota del primer alumno es: "+alumno1.getValor());
		
		System.out.println("¿Está aprobado?: "+alumno1.aprobado());
		
		Nota alumno2 = new Nota(7);

		System.out.println("La nota del segundo alumno es: "+alumno2.getValor());
		
		System.out.println("¿Está aprobado?: "+alumno2.aprobado());

		Nota alumno3 = new Nota(2);

		System.out.println("La nota del tercer alumno es: "+alumno3.getValor());
		
		System.out.println("¿Está aprobado?: "+alumno3.aprobado());
		
		alumno3.recuperar(8);
		
		System.out.println("La nueva nota del tercer alumno es: "+alumno3.getValor());
		
		System.out.println("¿Está aprobado?: "+alumno3.aprobado());		
	}
}