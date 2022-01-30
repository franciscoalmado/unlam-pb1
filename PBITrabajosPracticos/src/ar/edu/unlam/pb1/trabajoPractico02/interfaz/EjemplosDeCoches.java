package ar.edu.unlam.pb1.trabajoPractico02.interfaz;

import ar.edu.unlam.pb1.trabajoPractico02.dominio.Coche;

public class EjemplosDeCoches {

	public static void main(String[] args) {
		
		Coche ceroKilometro = new Coche("Volkswagen","Gol Trend",2500000);
		
		Coche deLorean = new Coche("DeLorean","Back to the Future",200000,1985,2200000);
	
		System.out.println("Cantidad de coches disponibles: "+Coche.getCantidadCoches());
		
		System.out.println("<<Coche nuevo>> "+ceroKilometro.toString());
		
		System.out.println("<<Coche usado>> "+deLorean.toString());
		
		System.out.println("Antigüedad del coche nuevo: "+ceroKilometro.calcularAntiguedad()+" años");
		
		System.out.println("Antigüedad del coche usado: "+deLorean.calcularAntiguedad()+" años");
		
		ceroKilometro.setKilometrosActuales(10000);
		
		deLorean.setKilometrosActuales(300000);
		
		ceroKilometro.setPrecio(2800000);
		
		deLorean.setPrecio(2000000);
		
		System.out.println("Kilómetros del coche nuevo: "+ceroKilometro.getKilometros()+" KM");
		
		System.out.println("Kilómetros del coche usado: "+deLorean.getKilometros()+" KM");
		
		System.out.println("Precio del coche nuevo: "+ceroKilometro.getPrecio());
		
		System.out.println("Precio del coche usado: "+deLorean.getPrecio());
	}
}