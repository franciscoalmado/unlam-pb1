package ar.edu.unlam.pb1.trabajoPractico04.interfaz;

import ar.edu.unlam.pb1.trabajoPractico04.dominio.Distancia;

public class PruebaDistancia {

	public static void main(String[] args) {
		
		Distancia maraton = new Distancia(0.0);

		maraton.setValor(3000.0);
		
		System.out.println("La distancia en Dec�metro (dam) es: "+maraton.convertir(Distancia.DECAMETRO));
		
		System.out.println("La distancia en Hect�metro (hm) es: "+maraton.convertir(Distancia.HECTOMETRO));
	
		System.out.println("La distancia en Kil�metro (km) es: "+maraton.convertir(Distancia.KILOMETRO));
		
		System.out.println("***CONVERSI�N DE DEC�METRO***");
		
		maraton.setValor(1000.0, Distancia.DECAMETRO);
	
		System.out.println("La distancia en Dec�metro (dam) es: "+maraton.convertir(Distancia.DECAMETRO));

		System.out.println("La distancia en Hect�metro (hm) es: "+maraton.convertir(Distancia.HECTOMETRO));
		
		System.out.println("La distancia en Kil�metro (km) es: "+maraton.convertir(Distancia.KILOMETRO));
	
		System.out.println("***CONVERSI�N DE HECT�METRO***");
		
		maraton.setValor(1500.0, Distancia.HECTOMETRO);
		
		System.out.println("La distancia en Dec�metro (dam) es: "+maraton.convertir(Distancia.DECAMETRO));

		System.out.println("La distancia en Hect�metro (hm) es: "+maraton.convertir(Distancia.HECTOMETRO));
		
		System.out.println("La distancia en Kil�metro (km) es: "+maraton.convertir(Distancia.KILOMETRO));

		System.out.println("***CONVERSI�N DE KIL�METRO***");
		
		maraton.setValor(750.0, Distancia.KILOMETRO);
		
		System.out.println("La distancia en Dec�metro (dam) es: "+maraton.convertir(Distancia.DECAMETRO));

		System.out.println("La distancia en Hect�metro (hm) es: "+maraton.convertir(Distancia.HECTOMETRO));
		
		System.out.println("La distancia en Kil�metro (km) es: "+maraton.convertir(Distancia.KILOMETRO));
	}
}