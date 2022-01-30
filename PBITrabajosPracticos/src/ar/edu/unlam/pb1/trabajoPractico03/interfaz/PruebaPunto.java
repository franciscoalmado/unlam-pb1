package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Punto;

public class PruebaPunto {

	public static void main(String[] args) {
		
		Punto coordenada = new Punto(0.0,0.0);
		
		System.out.println("¿Está sobre el origen?: "+coordenada.estaSobreElOrigen());
		
		coordenada.setX(13.4);
		coordenada.setY(-5.1);
		System.out.println("¿Está sobre el origen?: "+coordenada.estaSobreElOrigen());
		System.out.println("¿Está sobre el eje X?: "+coordenada.estaSobreElEjeX());
		System.out.println("¿Está sobre el eje Y?: "+coordenada.estaSobreElEjeY());

		coordenada.setX(-15.8);
		coordenada.setY(0.0);
		System.out.println("¿Está sobre el eje X?: "+coordenada.estaSobreElEjeX());

		coordenada.setX(0.0);
		coordenada.setY(50.3);
		System.out.println("¿Está sobre el eje Y?: "+coordenada.estaSobreElEjeY());
	}
}