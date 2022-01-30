package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import ar.edu.unlam.pb1.trabajoPractico08.dominio.Temperatura;
import ar.edu.unlam.pb1.trabajoPractico08.dominio.UnidadDeTemperatura;

public class PruebaTemperatura {

	public static void main(String[] args) {
		
		Temperatura buenosAires = new Temperatura(14.0);
		
		buenosAires.setValor(15.0);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(UnidadDeTemperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(UnidadDeTemperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(UnidadDeTemperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN CELSUIS***");
		buenosAires.setValor(20.0, UnidadDeTemperatura.CELSIUS);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(UnidadDeTemperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(UnidadDeTemperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(UnidadDeTemperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN FARENHEIT***");
		buenosAires.setValor(80, UnidadDeTemperatura.FARENHEIT);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(UnidadDeTemperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(UnidadDeTemperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(UnidadDeTemperatura.KELVIN));
		
		System.out.println("***CONVERSIÓN EN KELVIN***");
		buenosAires.setValor(300, UnidadDeTemperatura.KELVIN);
		
		System.out.println("La temperatura de hoy en Buenos Aires, en °C, es: "+buenosAires.convertir(UnidadDeTemperatura.CELSIUS));
		System.out.println("La temperatura de hoy en Buenos Aires, en °F, es: "+buenosAires.convertir(UnidadDeTemperatura.FARENHEIT));
		System.out.println("La temperatura de hoy en Buenos Aires, en °K, es: "+buenosAires.convertir(UnidadDeTemperatura.KELVIN));
	}
}