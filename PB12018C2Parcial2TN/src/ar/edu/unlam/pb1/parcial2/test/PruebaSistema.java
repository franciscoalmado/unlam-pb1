package ar.edu.unlam.pb1.parcial2.test;

import ar.edu.unlam.pb1.parcial2.dominio.Sistema;
import ar.edu.unlam.pb1.parcial2.dominio.Usuario;

public class PruebaSistema {

	public static void main(String[] args) {		
		/*
		 * En la siguiente clase de prueba realice lo siguiente: 
			a. Instance la clase Sistema “Juego de apuestas” con 3 usuarios 
			b. Instancie el usuario “usuario001”, “AaaBbb000”, “Jorge”, “Perez”, 45214596, 25
			c. Instancie el usuario “usuario002”, “BbbAaaCcc”, “Fernanda”, “Salah”, 23546213, 33 
			d. Instance el usuario “usuario003”, “Abcde12”, “Lorena”, “Loniski”, 46321543, 22 
			e. Ingresar el usuario001 al Sistema 
			f. Ingresar el usuario002 al Sistema 
			g. Ingresar el usuario003 al Sistema 
			h. Intentar loguearse con el usuario 
		 */
		
		Sistema juegoDeApuestas = new Sistema("Juego de Apuestas", 3);
		Usuario usuario001 = new Usuario("usuario001", "AaaBbb000", "Jorge", "Pérez", 45214596, 25);
		Usuario usuario002 = new Usuario("usuario002", "BbbAaaCcc", "Fernanda", "Salah", 23546213, 33);
		Usuario usuario003 = new Usuario("usuario003", "Abcde12", "Lorena", "Loniski", 46321543, 22);
	
		if(usuario001.laContraseniaEsValida() == true) {
			juegoDeApuestas.incorporarUnUsuario(usuario001);
			System.out.println(juegoDeApuestas.loguearUsuario("usuario001", "AaaBbb000"));
		}
		if(usuario002.laContraseniaEsValida() == true) {
			juegoDeApuestas.incorporarUnUsuario(usuario002);
			System.out.println(juegoDeApuestas.loguearUsuario("usuario002", "BbbAaaCcc"));
		}
		if(usuario003.laContraseniaEsValida() == true) {
			juegoDeApuestas.incorporarUnUsuario(usuario003);
			System.out.println(juegoDeApuestas.loguearUsuario("usuario003", "Abcde12"));
		}
	}
}