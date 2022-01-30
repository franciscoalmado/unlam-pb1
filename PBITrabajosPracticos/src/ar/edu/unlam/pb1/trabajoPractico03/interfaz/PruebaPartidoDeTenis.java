package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.PartidoDeTenis;

public class PruebaPartidoDeTenis {

	public static void main(String[] args) {
		
		PartidoDeTenis finalRolandGarros2021 = new PartidoDeTenis("Novak Djokovic","Stefanos Tsitsipas");
		
		System.out.println(finalRolandGarros2021.registrarPrimerSet(4, 6));
		
		System.out.println(finalRolandGarros2021.registrarSegundoSet(6, 3));
	
		System.out.println(finalRolandGarros2021.registrarTercerSet(2, 6));
		
		System.out.println(finalRolandGarros2021.informarJugadorGanador());
	}
}