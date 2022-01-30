package ar.edu.unlam.dominio;

public class Archivo {
	private double tamanio;
	private String nombre;
	private TiposDeArchivo tipoDeArchivo;
	
	public Archivo() {
		this.tamanio = 0.0;
		this.nombre = "";
	}
	
	public Archivo (double tamanio, String nombre, TiposDeArchivo tipoDeArchivo) {
		this.tamanio = tamanio;
		this.nombre = nombre;
		this.tipoDeArchivo = tipoDeArchivo;
	}

	public double getTamanio() {
		return tamanio;
	}

	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TiposDeArchivo getTipoDeArchivo() {
		return tipoDeArchivo;
	}

	public void setTipoDeArchivo(int valor, TiposDeArchivo nuevo) {
		
		switch(valor) {
			case 1:
				tipoDeArchivo = TiposDeArchivo.JPG;
				break;
			case 2:
				tipoDeArchivo = TiposDeArchivo.PNG;
				break;
			case 3:
				tipoDeArchivo = TiposDeArchivo.TXT;
				break;
			case 4:
				tipoDeArchivo = TiposDeArchivo.TXT;
				break;
		}					
	}

	@Override
	public String toString() {
		return "Archivo [Tipo de archivo= " +tipoDeArchivo+ ", Nombre= " +nombre+ ", Tamaño= " +tamanio+ " kb" + "]";
	}	
}