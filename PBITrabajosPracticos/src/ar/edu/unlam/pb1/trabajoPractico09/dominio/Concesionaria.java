package ar.edu.unlam.pb1.trabajoPractico09.dominio;

public class Concesionaria {

	private Auto[] auto;
	private int cantidadDeVehiculosEnConcesionaria;
	private final int CAPACIDAD_MAXIMA_DE_AUTOS;

	public Concesionaria(int capacidadMaximaDeAutos) {
		this.CAPACIDAD_MAXIMA_DE_AUTOS = capacidadMaximaDeAutos;
		this.auto = new Auto[CAPACIDAD_MAXIMA_DE_AUTOS];
	}
	
	public boolean ingresarAuto(Auto nuevo) {
		boolean sePudoIngresar = false;
		
		if(this.cantidadDeVehiculosEnConcesionaria  < this.CAPACIDAD_MAXIMA_DE_AUTOS) {
			this.auto[this.cantidadDeVehiculosEnConcesionaria++]= nuevo;
			sePudoIngresar = true;
		}
		return sePudoIngresar;
	}
	
	public String mostrarListado() {
		String listadoCompleto = "";
		
		for(int i=0; i < this.cantidadDeVehiculosEnConcesionaria; i++) {
			listadoCompleto += this.auto[i]+"\n";
		}	
		return listadoCompleto;
	}
	
	public Auto buscarAutoPorCodigo(int codigoABuscar) {

		for (int i = 0; i < this.auto.length; i++) {
			if (this.auto[i] != null)
				if (this.auto[i].getCodigo() == codigoABuscar)
					return this.auto[i];
		}
		return null;
	}
	
	public int getCantidadDeVehiculosEnConcesionaria() {
		return this.cantidadDeVehiculosEnConcesionaria;
	}
}