package ar.edu.unlam.dominio;

public enum TiposDeArchivo {
	JPG(1),
	PNG(2),
	TXT(3),
	EXE(4);
	
	int tipoDeArchivo;
	
	TiposDeArchivo(int tipoDeArchivo) {
		this.tipoDeArchivo = tipoDeArchivo;
	}

	public int getTipoDeArchivo() {
		return tipoDeArchivo;
	}

	public void setTipoDeArchivo(int tipoDeArchivo) {
		this.tipoDeArchivo = tipoDeArchivo;
	}		
}