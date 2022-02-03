package ar.edu.unlam.pb1.validacion.test;

import ar.edu.unlam.pb1.validacion.dominio.Empresa;
import ar.edu.unlam.pb1.validacion.dominio.Producto;
import ar.edu.unlam.pb1.validacion.dominio.Venta;

public class Prueba {
	
	public static void main(String[] args) {
		Empresa samsung = new Empresa("Samsung");
		samsung.agregarProducto(new Producto(90, "S10", 100000.0));
		samsung.agregarProducto(new Producto(20, "Note", 90000.0));
		samsung.agregarProducto(new Producto(10, "Heladera", 80000.0));
		samsung.agregarProducto(new Producto(50, "Televisor", 50000.0));
		
		Venta nueva = new Venta(1000, "Camila");
		nueva.agregarItem(samsung.getProductoPorNombre("S10"));
		nueva.agregarItem(samsung.getProductoPorNombre("Televisor"));
		samsung.realizarVenta(nueva);
		
		nueva = new Venta(2000, "Celeste");
		nueva.agregarItem(samsung.getProductoPorNombre("Heladera"));
		samsung.realizarVenta(nueva);

		nueva = new Venta(3000, "Lucas");
		nueva.agregarItem(samsung.getProductoPorNombre("Note"));
		samsung.realizarVenta(nueva);
		
		samsung.ordenarLosProductosPorCodigo();
		
		System.out.println(samsung);
	}
}