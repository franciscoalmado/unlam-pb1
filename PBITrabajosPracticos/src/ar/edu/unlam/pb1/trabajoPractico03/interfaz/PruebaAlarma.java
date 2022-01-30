package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Alarma;

public class PruebaAlarma {

	public static void main(String[] args) {
		
		Alarma adt = new Alarma(123);
		
		adt.encender(123);
		System.out.println("¿La alarma está encendida?: "+adt.estaEncendida());
		System.out.println("¿La alarma está activada?: "+adt.activada());		
		
		adt.apagar(123);
		System.out.println("¿La alarma está encendida?: "+adt.estaEncendida());
		System.out.println("¿La alarma está activada?: "+adt.activada());
		
		adt.encender(123);
		adt.activarSensorDeMovimiento();
		System.out.println("¿La alarma está encendida?: "+adt.estaEncendida());
		System.out.println("¿La alarma está activada?: "+adt.activada());
		
		adt.desactivarSensorDeMovimiento();
		System.out.println("¿La alarma está activada?: "+adt.activada());
	}
}