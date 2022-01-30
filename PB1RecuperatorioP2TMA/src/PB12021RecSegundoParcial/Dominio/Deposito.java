package PB12021RecSegundoParcial.Dominio;

/**
 * Se necesita almacenar en el deposito los libros que llegaron
 */
public class Deposito {
	/*
	 * Genere todos los atributos y métodos que crea que sean conveniente
	 */
	private String nombre;
	private Libro[] libros;
	private int cantidadMaximaDeEjemplares;
	private int cantidadDeEjemplares;
	private int cantidadDeEjemplaresAlDeposito;

	// Complete el constructor
	public Deposito(String nombreDeposito, int cantidadDeEjemplares, int cantidadMaximaDeEjemplares) {
		this.nombre = nombreDeposito;
		this.cantidadDeEjemplares = cantidadDeEjemplares;
		this.cantidadMaximaDeEjemplares = cantidadMaximaDeEjemplares;
		this.libros = new Libro[cantidadMaximaDeEjemplares];
		this.cantidadDeEjemplaresAlDeposito = 0;
	}

	/**
	 * Ingresa un ejemplar al array de libros solo si hay lugar en el array
	 * @param ejemplar	Libro que se ingresara
	 * @return verdadero en caso de exito
	 * */
	public boolean ingresarEjemplar(Libro ejemplar) {
		
		boolean ejemplarIngresado = false;
		
		for(int i=0; i < this.libros.length; i++) {
			if(this.libros[i] == null && this.cantidadDeEjemplares < this.cantidadMaximaDeEjemplares) {
				this.libros[i] = ejemplar;
				ejemplarIngresado = true;
				break;
			}
		}
		
		return ejemplarIngresado;
	}

	/**
	 * Se copiaran a un nuevo array los libros del autor pasado por parametro para llevarlos
	 * al deposito
	 * @param autor		Autor para filtrar
	 * @return verdadero en caso de exito
	 * */
	public boolean cargarEjemplaresQueVanAlDepositoPorAutor(String autor) {

		boolean seCopiaron = false;
		Libro[] librosPorAutor = new Libro[this.libros.length];
		
		for(int i=0; i < this.libros.length; i++) {
			if(this.libros[i] != null && this.libros[i].getAutor().compareTo(autor) == 0) {
				librosPorAutor[i] = libros[i];
				this.cantidadDeEjemplaresAlDeposito++;
				seCopiaron = true;
			}
		}
		
		return seCopiaron;
	}

	/**
	 * Devuelve un array de libros para un genero especifico
	 * @param genero	Genero para filtrar
	 * @return array de libros de un genero
	 * */
	public Libro[] buscarLibrosPorGenero(Genero genero) {
		
		for(int i=0; i < this.libros.length; i++) {
			if(this.libros[i] != null && this.libros[i].getGenero().equals(genero)) {
				return this.libros;
			}			
		}
		return null;
	}

	/**
	 * Ordena la lista de libros por anio de publicacion ascendente
	 * @return lista de libros ordenados por anio
	 * */
	public Libro[] ordenarLibrosPorAnioPublicacion() {

		Libro auxiliar = null;
		
		for(int i=1; i < this.libros.length; i++) {
			for(int j=0; j < this.libros.length-1; j++) {
				if(this.libros[i] != null && this.libros[j].getAnioPublicacion() > this.libros[j+1].getAnioPublicacion()) {
					auxiliar = this.libros[j+1];
					this.libros[j+1] = this.libros[j];
					this.libros[j] = auxiliar;					
				}
			}
		}
		
		return this.libros;
	}
	
	/**
	 * Obtiene la cantidad de ejemplares que se enviaran al deposito
	 * */
	public int getCantidadDeEjemplaresAlDeposito() {
		return this.cantidadDeEjemplaresAlDeposito;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Libro[] getLibros() {
		return this.libros;
	}
}