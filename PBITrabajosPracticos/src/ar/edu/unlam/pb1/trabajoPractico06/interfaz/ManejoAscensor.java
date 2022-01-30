package ar.edu.unlam.pb1.trabajoPractico06.interfaz;

import ar.edu.unlam.pb1.trabajoPractico06.dominio.Ascensor;
import ar.edu.unlam.pb1.trabajoPractico03.dominio.Persona;

public class ManejoAscensor {

	public static void main(String[] args) {
		
		Ascensor consorcioCallePeron = new Ascensor(4,150.0);
	
		System.out.println("***ESTADO INICIAL***");
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		System.out.println("Piso mínimo: "+consorcioCallePeron.getPISO_MINIMO());
		System.out.println("Piso máximo: "+consorcioCallePeron.getPISO_MAXIMO());
		System.out.println("¿Hay sobrecarga?: "+consorcioCallePeron.isSobrecarga());
		System.out.println("¿La puerta está abierta?: "+consorcioCallePeron.isPuertaAbierta());
		
		System.out.println("***PRUEBAS SUBIR/BAJAR/IR AL PISO***");
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();

		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		consorcioCallePeron.bajar();
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
	
		consorcioCallePeron.subir();
		consorcioCallePeron.subir();
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		consorcioCallePeron.irAlPiso(8);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		consorcioCallePeron.irAlPiso(11);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		consorcioCallePeron.irAlPiso(-3);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		System.out.println("************************************");
		//Datos a trabajar en el TP N° 9
		Persona persona1 = new Persona("María", "F", 11123456, 60.0, 1.55);
		Persona persona2 = new Persona("Lucas", "M", 13456789, 80.0, 1.75);
		Persona persona3 = new Persona("Martín", "M", 14523741, 90.0, 1.85);
		
		persona1.pesar();
		persona2.pesar();
		persona3.pesar();
		//Datos a trabajar en el TP N° 9
		System.out.println("************************************");
	
		System.out.println("***INGRESO DEL PRIMER USUARIO***");
		
		consorcioCallePeron.irAlPiso(4);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());

		consorcioCallePeron.abrirPuerta();
		consorcioCallePeron.ingresar(80.0);
		consorcioCallePeron.cerrarPuerta();
		
		System.out.println("Peso actual: "+consorcioCallePeron.getPesoActual());
		System.out.println("Capacidad actual: "+consorcioCallePeron.getCapacidadActual());
		
		System.out.println("¿Hay sobrecarga?: "+consorcioCallePeron.isSobrecarga());
		System.out.println("¿La puerta está abierta?: "+consorcioCallePeron.isPuertaAbierta());
		
		System.out.println("***INGRESO DEL SEGUNDO USUARIO***");
		
		consorcioCallePeron.irAlPiso(7);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		consorcioCallePeron.abrirPuerta();
		consorcioCallePeron.ingresar(90.0);
		consorcioCallePeron.cerrarPuerta();
		
		System.out.println("Peso actual: "+consorcioCallePeron.getPesoActual());
		System.out.println("Capacidad actual: "+consorcioCallePeron.getCapacidadActual());
		
		System.out.println("¿Hay sobrecarga?: "+consorcioCallePeron.isSobrecarga());
		System.out.println("¿La puerta está abierta?: "+consorcioCallePeron.isPuertaAbierta());
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
	
		System.out.println("***HACER SUBIR/BAJAR/IR AL PISO CON SOBRECARGA***");
		
		consorcioCallePeron.irAlPiso(2);
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		System.out.println("***HACER SALIR A UN USUARIO E INTENTAR SUBIR/BAJAR***");
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		consorcioCallePeron.salir(80.0);
		consorcioCallePeron.cerrarPuerta();
		
		System.out.println("Peso actual: "+consorcioCallePeron.getPesoActual());
		System.out.println("Capacidad actual: "+consorcioCallePeron.getCapacidadActual());
		
		System.out.println("¿Existe sobrecarga?: "+consorcioCallePeron.isSobrecarga());
		System.out.println("¿La puerta está abierta?: "+consorcioCallePeron.isPuertaAbierta());
		
		consorcioCallePeron.irAlPiso(2);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
		
		System.out.println("***HACER INGRESAR A UN USUARIO E INTENTAR SUBIR/BAJAR***");
		
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());

		consorcioCallePeron.abrirPuerta();
		consorcioCallePeron.ingresar(55.0);
		consorcioCallePeron.cerrarPuerta();
		
		System.out.println("Peso actual: "+consorcioCallePeron.getPesoActual());
		System.out.println("Capacidad actual: "+consorcioCallePeron.getCapacidadActual());
		
		System.out.println("¿Existe sobrecarga?: "+consorcioCallePeron.isSobrecarga());
		System.out.println("¿La puerta está abierta?: "+consorcioCallePeron.isPuertaAbierta());
		
		consorcioCallePeron.irAlPiso(0);
		System.out.println("Piso actual: "+consorcioCallePeron.getPisoActual());
	}
}