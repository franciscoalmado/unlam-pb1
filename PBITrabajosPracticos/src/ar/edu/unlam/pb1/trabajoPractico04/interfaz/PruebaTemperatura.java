package ar.edu.unlam.pb1.trabajoPractico04.interfaz;

import ar.edu.unlam.pb1.trabajoPractico04.dominio.Temperatura;

public class PruebaTemperatura {

	public static void main(String[] args) {
		
		Temperatura buenosAires = new Temperatura(14.0);
		
		buenosAires.setValor(15.0);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(Temperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(Temperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(Temperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN CELSUIS***");
		buenosAires.setValor(20.0, Temperatura.CELSIUS);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(Temperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(Temperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(Temperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN FARENHEIT***");
		buenosAires.setValor(80, Temperatura.FARENHEIT);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(Temperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(Temperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(Temperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN KELVIN***");
		buenosAires.setValor(300, Temperatura.KELVIN);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(Temperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(Temperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(Temperatura.KELVIN));
	}
}