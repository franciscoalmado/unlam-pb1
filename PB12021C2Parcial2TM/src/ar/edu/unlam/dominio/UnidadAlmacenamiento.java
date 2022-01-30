package ar.edu.unlam.dominio;

public class UnidadAlmacenamiento {
	private Archivo[] archivos;
	private double capacidadMaxima;
	private char letra;	
	private TiposDeUnidad unidad;
	private int cantidadDeArchivos;
	private double espacioAlmacenado;
	
	public UnidadAlmacenamiento() {
		
	}
	
	public UnidadAlmacenamiento(TiposDeUnidad unidad, int cantidadDeArchivos, double capacidadMaxima, char letra) {
		this.unidad = unidad;
		this.cantidadDeArchivos = cantidadDeArchivos;
		this.archivos = new Archivo[this.cantidadDeArchivos];
		this.capacidadMaxima = capacidadMaxima;
		this.letra = letra;
	}
	
	public UnidadAlmacenamiento(TiposDeUnidad unidad, int cantidadDeArchivos, double capacidadMaxima) {
		this.unidad = unidad;
		this.cantidadDeArchivos = cantidadDeArchivos;
		this.archivos = new Archivo[this.cantidadDeArchivos];
		this.capacidadMaxima = capacidadMaxima;
	}
	
	/**
	 * Agrega un archivo al array de archivos, solo si hay espacio en el array
	 * y el archivo que se agregará no supera la capacidad máxima.
	 *
	 * @param archivo Archivo que se agregará.
	 * @return Verdadero en caso de éxito
	 */
	public boolean agregarArchivo(Archivo archivo) {

		boolean archivoAgregado = false;
		
		for(int i=0; i < this.archivos.length; i++) {
			if(this.archivos[i] == null && verificarCapacidad(archivo.getTamanio()) == true) {
				this.archivos[i] = archivo;
				archivoAgregado = true;
				break;
			}
		}		
		return archivoAgregado;
	}
	
	private boolean verificarCapacidad(double tamanioArchivo) {
		
		double espacioDisponible = this.capacidadMaxima - this.espacioAlmacenado;
		boolean isDisponible = false;
		
		if(espacioDisponible >= tamanioArchivo) {
			isDisponible = true;
		}
		
		return isDisponible;
	}

	/**
	 * Obtiene un array de archivos de tipo JPG ordenados por nombre descendente
	 *
	 * @return 	Array de archivos JPG con orden descendente por nombre 
	 */
	public Archivo[] obtenerAchivosTipoJpgOrdenadosPorNombreDesc() {
		Archivo auxiliar = null;
		
		for(int i = 1; i < this.archivos.length; i++) {
			for(int j = 0; j < this.archivos.length-1; j++){
				if(this.archivos[i] != null && this.archivos[j].getNombre().compareTo(this.archivos[j+1].getNombre()) < 0 && this.archivos[i].getTipoDeArchivo().equals(TiposDeArchivo.JPG)) {
					auxiliar = this.archivos[j+1];
					this.archivos[j+1] = this.archivos[j];
					this.archivos[j] = auxiliar;
				}
			}	
		}
		return this.archivos;
	}

	/**
	 * Calcula el espacio ocupado por los archivos en la unidad de almacenamiento
	 *
	 * @return 	valor del espacio almacenado 
	 */
	public double informarEspacioAlmacenado() {

		for (int i = 0; i < this.archivos.length; i++) {
			if (this.archivos[i] != null) {
				this.espacioAlmacenado += this.archivos[i].getTamanio();
			}
		}
		return this.espacioAlmacenado;
	}
	/**
	 * Otros m�todos agregados.
	 *
	 * 
	 */	
	public Archivo[] getArchivos() {
		return this.archivos;
	}
	
	public int obtenerCantidadDeArchivos() {
		return this.cantidadDeArchivos;
	}
	
	public double obtenerCapacidadMaxima() {
		return this.capacidadMaxima;
	}
	
	public TiposDeUnidad obtenerTipoDeUnidad() {
		return this.unidad;
	}
}