package ar.edu.unlam.pb1.trabajoPractico06.interfaz;

import ar.edu.unlam.pb1.trabajoPractico06.dominio.Automovil;

public class PruebaAutomovil {

	public static void main(String[] args) {
        
		Automovil miniCopper, ferrari, fitito;

        miniCopper = new Automovil(200,1,'h');
        ferrari = new Automovil(350,1,'h');
        fitito = new Automovil(90,1,'h');

        System.out.println("Mini Copper: "+miniCopper.alcanzaVelocidadMaxima(200, 15)+" segundos");
        System.out.println("Ferrari: "+ferrari.alcanzaVelocidadMaxima(350, 40)+" segundos");
        System.out.println("Fitito: "+fitito.alcanzaVelocidadMaxima(90, 4)+" segundos");
	}
}