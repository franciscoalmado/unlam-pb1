package ar.edu.unlam.pb1.validacion.dominio;

import java.util.Arrays;

public class Empresa {
	/*
	 * Identificar e incorporar los atributos necesarios.
	 */
	private String nombre;
	private final int TAMANIO_DEL_CATALOGO;
	private int cantidadMaximaDeVentas;
	private Producto[] productos;
	private Venta[] ventasRealizadas;
	private int cantidadDeProductos;
	private int cantidadDeVentas;
	
	public Empresa(String nombre) {
		/*
		 * Costructor de la clase.
		 */
		this.nombre = nombre;
		this.TAMANIO_DEL_CATALOGO = 4;
		this.cantidadMaximaDeVentas = 10;
		this.productos = new Producto[this.TAMANIO_DEL_CATALOGO];
		this.ventasRealizadas = new Venta[this.cantidadMaximaDeVentas];
		this.cantidadDeProductos = 0;
		this.cantidadDeVentas = 0;
	}

	public String getNombre() {
		/*
		 * Devuelve el nombre de la empresa.
		 */
		return this.nombre;
	}

	public void agregarProducto(Producto nuevo) {
		/*
		 * Agrega un producto al catálogo
		 */		
		for(int i=0; i < this.productos.length; i++){
			if(this.productos[i] == null && this.cantidadDeProductos < this.TAMANIO_DEL_CATALOGO){
				this.productos[i] = nuevo;
				this.cantidadDeProductos++;
				break;
			}
		}
	}

	public void realizarVenta(Venta nueva) {
		/*
		 * Registra una venta
		 */
		for(int i=0; i < this.ventasRealizadas.length; i++){
			if(this.ventasRealizadas[i] == null && this.cantidadDeVentas < this.cantidadMaximaDeVentas){
				this.ventasRealizadas[i] = nueva;
				this.cantidadDeVentas++;
				break;
			}
		}
	}

	public Producto getProductoPorNombre(String nombreDelProducto) {
		/*
		 * Busca y devuelve un producto basado en su nombre
		 */
		for(int i=0; i < this.productos.length; i++){
			if(this.productos[i] != null && this.productos[i].getDescripcion().compareTo(nombreDelProducto) == 0){
				return this.productos[i];
			}
		}
		return null;
	}

	public double getImportePromedioDeVentas() {
		/*
		 * Devuelve el importe promedio de las ventas
		 */
		double importe = 0.0;
		double promedioDeVentas = 0.0;

		for(int i=0; i < this.ventasRealizadas.length; i++){
			if(this.ventasRealizadas[i] != null){
				importe += this.ventasRealizadas[i].getImporteTotal();
			}
		}
		
		promedioDeVentas = importe / (double) this.ventasRealizadas.length;

		return promedioDeVentas;
	}

	public void ordenarLosProductosPorCodigo() {
		/*
		 * Ordena el catálogo de productos por código
		 */
		Producto auxiliar = null;
		
		for(int i=1; i < this.productos.length; i++) {
			for(int j=0; j < this.productos.length-1; j++) {
				if (this.productos[i] != null && this.productos[j].getCodigo() > this.productos[j+1].getCodigo()) {
					auxiliar = this.productos[j+1];
					this.productos[j+1] = this.productos[j];
					this.productos[j] = auxiliar;			
				}
			}			
		}
	}

	public String toString() {
		/*
		 * Devuelve un listado con el catálogo de productos
		 */
		String listado = "";
		
		listado = Arrays.toString(this.productos);
		
		return listado;
	}	
}