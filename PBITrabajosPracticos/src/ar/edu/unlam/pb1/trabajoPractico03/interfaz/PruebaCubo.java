package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Cubo;

public class PruebaCubo {

	public static void main(String[] args) {
		
		Cubo rubik = new Cubo(5.7f); 
		
		System.out.println("Superfice de una cara de Rubik: "+rubik.getSuperficieCara());
		
		System.out.println("Volumen de una cara de Rubik: "+rubik.getVolumen());
	}
}