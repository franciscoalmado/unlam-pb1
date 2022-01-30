package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.trabajoPractico08.dominio.Dia;

public class PruebaDia {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese un número: ");
		int numeroDia = teclado.nextInt();
		
		Dia dia = new Dia(numeroDia);
		
		System.out.println("El día es: "+dia.mostrarNombreDelDia());
		
		teclado.close();
	}
}