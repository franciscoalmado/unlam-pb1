package ar.edu.unlam.pb1.trabajoPractico06.interfaz;

import ar.edu.unlam.pb1.trabajoPractico06.dominio.Destornillador;
import ar.edu.unlam.pb1.trabajoPractico06.dominio.Tarugo;
import ar.edu.unlam.pb1.trabajoPractico06.dominio.Tornillo;

public class PruebaDestornillador {

	public static void main(String[] args) {
		
		Tarugo tarugo = new Tarugo(10);
		Tornillo tornilloPhillips = new Tornillo('P',10,10);
		Destornillador destornilladorPhillips = new Destornillador('P');
		
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.atornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.desatornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.desatornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.desatornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.desatornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.atornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.atornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());
		
		destornilladorPhillips.desatornillar(tornilloPhillips, tarugo);
		System.out.println("Posición actual: "+tornilloPhillips.getPosicionActual());		
	}
}