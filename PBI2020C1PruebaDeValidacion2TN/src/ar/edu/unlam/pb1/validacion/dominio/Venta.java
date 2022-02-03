package ar.edu.unlam.pb1.validacion.dominio;

public class Venta {
	/*
	 * Identificar e incorporar los atributos necesarios.
	 */
	private Integer dni;
	private String nombreDelCliente;
	private Producto[] carrito;
	private int cantidadMaximaDeProductosEnElCarrito;
	private int cantidadDeProductosComprados;
	
	public Venta(Integer dni, String nombreDelCliente)  {
		/*
		 * Costructor de la clase.
		 */
		this.dni = dni;
		this.nombreDelCliente = nombreDelCliente;
		this.cantidadMaximaDeProductosEnElCarrito = 10;
		this.carrito = new Producto[this.cantidadMaximaDeProductosEnElCarrito];
		this.cantidadDeProductosComprados = 0;
	}
	
	public int getDni() {
		/*
		 * Devuelve el dni del cliente.
		 */
		return this.dni;
	}
	
	public String getNombrDelCliente() {
		/*
		 * Devuelve el dni del cliente.
		 */
		return this.nombreDelCliente;
	}
	
	public void agregarItem(Producto producto) {
		/*
		 * Agrega un producto a la venta
		 */
		for(int i=0; i < this.carrito.length; i++){
			if (this.carrito[i] == null && this.cantidadDeProductosComprados < this.cantidadMaximaDeProductosEnElCarrito){
				this.carrito[i] = producto;
				this.cantidadDeProductosComprados++;
				break;
			}
		}
	}
	
	public int getCantidadDeProductosComprados() {		
		/*
		 * Devuelve la cantidad de productos comprados 
		 */
		return this.cantidadDeProductosComprados;
	}
	
	public double getImporteTotal() {		
		/*
		 * Importe total de la venta o sumatoria del precio del producto
		 */
		double importeTotal = 0.0;
		
		for(int i=0; i < this.carrito.length; i++) {
			if (this.carrito[i] != null) {
				importeTotal += this.carrito[i].getPrecio();
			}
		}
		return importeTotal;
	}
	
	public String toString() {		
		/*
		 * Devuelve infomación de la venta (Nombre del cliente e importe total)
		 */		
		String informacionDeLaVenta = "";
		
		informacionDeLaVenta = "Nombre del cliente: " + this.nombreDelCliente +", importe: "+getImporteTotal(); 
		
		return informacionDeLaVenta;
	}	
}