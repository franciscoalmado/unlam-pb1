package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import ar.edu.unlam.pb1.trabajoPractico08.dominio.Tragamonedas;

public class PruebaTragamonedas {

	public static void main(String[] args) {
		
		Tragamonedas casinoWin=new Tragamonedas();
		
		casinoWin.girar();
		
		System.out.println(casinoWin.toString());

		if (casinoWin.estatus() == true) {
			System.out.println("¡¡¡Ganaste!!!");	
		}
		else {
			System.out.println("Sigue participando");
		}
	}
}