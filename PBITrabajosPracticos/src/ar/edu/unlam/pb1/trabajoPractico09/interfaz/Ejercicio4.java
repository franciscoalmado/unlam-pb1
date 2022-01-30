package ar.edu.unlam.pb1.trabajoPractico09.interfaz;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		String[] nombres = new String[10];
		float[] notas = new float[10];
		Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
		
		for(int i = 0; i < 10; i++){
			System.out.println("Ingrese nombre del alumno: ");
			nombres[i] = teclado.next();
			do{
				System.out.println("Ingrese la nota del alumno: ");
				notas[i] = teclado.nextFloat();
			}while(notas[i] > 10 || notas[i] < 0);
		}
		
		for(int i = 0; i < 10 ; i++){
			String estado;
			
			if(notas[i] >= 7){
				estado = "Promocionado";
			}
			if(notas[i] >= 4 && notas[i] < 7){
				estado = "Aprobado";
			}else{
				estado = "Desaprobado";
			}			
			System.out.println("Nombre: "+nombres[i]+" - Nota: "+notas[i]+" - Estado: "+estado);
		}
		teclado.close();
	}
}