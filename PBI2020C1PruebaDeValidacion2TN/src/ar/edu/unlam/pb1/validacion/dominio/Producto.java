package ar.edu.unlam.pb1.validacion.dominio;

public class Producto {
	/*
	 * Identificar e incorporar los atributos necesarios.
	 */	
	private Integer codigoDeProducto;
	private String descripcion;
	private Double precio;

	public Producto(Integer codigo, String descripcion, Double precio) {
		/*
		 * Costructor de la clase.
		 */
		this.codigoDeProducto = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getCodigo() {
		/*
		 * Devuelve el codigo del producto.
		 */
		return this.codigoDeProducto;
	}

	public String getDescripcion() {
		/*
		 * Devuelve la descripcion del producto.
		 */
		return this.descripcion;
	}

	public Double getPrecio() {
		/*
		 * Devuelve el precio del producto.
		 */
		return this.precio;
	}
	
	public String toString() {
		/*
		 * Devuelve la informacion del producto (codigo y descripcion).
		 */	
		String informacionDelProducto = "";
		
		informacionDelProducto = "Código: " +this.codigoDeProducto+ " - Descripción: "+this.descripcion;
		
		return informacionDelProducto;
	}	
}