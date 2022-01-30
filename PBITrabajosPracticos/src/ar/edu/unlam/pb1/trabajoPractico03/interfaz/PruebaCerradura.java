package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Cerradura;

public class PruebaCerradura {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int clave = 1234;
		int claveActual = 0;
		int cantidadDeFallos = 3;
		
		Cerradura cerradura = new Cerradura(clave, cantidadDeFallos);
		
		if(cerradura.fueBloqueada() == false) {
			System.out.println("Puerta habilitada");
			
			if(cerradura.estaAbierta() == false) {
				System.out.println("Ingrese la clave: ");
				claveActual = teclado.nextInt();
				
					if(cerradura.abrir(claveActual) == true) {
						System.out.println("Se ha abierto la puerta");
					} else {
						System.out.println("Clave incorrecta");
						System.out.println("Intentos restantes: "+cerradura.getCantidadDeIntentosRestantes());
							if(cerradura.getCantidadDeIntentosRestantes() > 0) {
								System.out.println("Ingrese nuevamente la clave: ");
								claveActual = teclado.nextInt();
								if(cerradura.abrir(claveActual) == true) {
									System.out.println("Se ha abierto la puerta");
								}else {
									System.out.println("Clave incorrecta");
									System.out.println("Intentos restantes: "+cerradura.getCantidadDeIntentosRestantes());
									if(cerradura.getCantidadDeIntentosRestantes() > 0) {
										System.out.println("Ingrese nuevamente la clave: ");
										claveActual = teclado.nextInt();
										if(cerradura.abrir(claveActual) == true) {
											System.out.println("Se ha abierto la puerta");	
										}else {
											System.out.println("Clave incorrecta");
											System.out.println("Intentos restantes: "+cerradura.getCantidadDeIntentosRestantes());
											if(cerradura.getCantidadDeIntentosRestantes() == 0) {
												System.out.println("¿Se ha bloqueado?: "+cerradura.fueBloqueada());
												System.out.println("La cerradura ha sido bloqueada");
											}
										}
									}

								}
							}
						}
			}
			if(cerradura.estaAbierta() == true) {
				cerradura.cerrar();
				System.out.println("Se ha cerrado la puerta");
			}
		}
		teclado.close();
	}
}