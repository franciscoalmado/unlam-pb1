package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Persona;

public class EjemploDeVida {
	

	public static void main(String[] args) {
		
		Persona sofia = new Persona("Sofía","Mujer",38432153,2.8,0.50);
		
		System.out.println(sofia);
		
		System.out.println("El peso actual es: "+sofia.pesar());
		System.out.println("La altura actual es: "+sofia.medir());
		
		sofia.alimentar(1.0);
		sofia.crecer(0.5);
		sofia.cumplirAnos();
		
		System.out.println("El peso actual es: "+sofia.pesar());
		System.out.println("La altura actual es: "+sofia.medir());
		System.out.println("La edad actual es: "+sofia.mostrarEdad());
		System.out.println("¿Es mayor de edad?: "+sofia.esMayorDeEdad());
		
		System.out.println("¿Está viva?: "+sofia.estaViva());
		
		sofia.morir();
		
		System.out.println("¿Está viva?: "+sofia.estaViva());
		
		sofia.cumplirAnos();
		sofia.alimentar(1.0);
		sofia.crecer(0.5);
		System.out.println("La edad actual es: "+sofia.mostrarEdad());
		System.out.println("El peso actual es: "+sofia.pesar());
		System.out.println("La altura actual es: "+sofia.medir());
	}
}