package ar.edu.unlam.pb1.trabajoPractico02.interfaz;

import ar.edu.unlam.pb1.trabajoPractico02.dominio.Circulo;

public class PruebaCirculo {

	public static void main(String[] args) {
	
		Circulo circulo1 = new Circulo(6370);
		Circulo circulo2 = new Circulo(2439.7);
		
		System.out.println("Área 1: "+circulo1.calcularElArea());
		System.out.println("Perímetro 1: "+circulo1.calcularElPerimetro());
		
		System.out.println("Área 2: "+circulo2.calcularElArea());
		System.out.println("Perímetro 2: "+circulo2.calcularElPerimetro());
		
		circulo1.setRadio(3389.5);
		circulo2.setRadio(6051.8);
		
		System.out.println("Área 1: "+circulo1.calcularElArea());
		System.out.println("Perímetro 1: "+circulo1.calcularElPerimetro());
		
		System.out.println("Área 2: "+circulo2.calcularElArea());
		System.out.println("Perímetro 2: "+circulo2.calcularElPerimetro());
	}
}