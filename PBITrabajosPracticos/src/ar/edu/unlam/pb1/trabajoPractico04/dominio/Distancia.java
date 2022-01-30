package ar.edu.unlam.pb1.trabajoPractico04.dominio;

public class Distancia {

	public static final int DECAMETRO = 10;
	public static final int HECTOMETRO = 100;
	public static final int KILOMETRO = 1000;
	private double longitud;
	
	public Distancia(double valor) {
		this.longitud = valor;
	}
	
	public void setValor(double valor) {
		this.longitud = valor;
	}
	
	public void setValor(double valor, int unidad) {
			
		switch(unidad) {
			case DECAMETRO:
				this.longitud = valor * DECAMETRO;
				break;
			case HECTOMETRO:
				this.longitud = valor * HECTOMETRO;
				break;
			case KILOMETRO:
				this.longitud = valor * DECAMETRO;
				break;
			default:
				break;
		}	
	}
	
	public double getValor() {
		return this.longitud;
	}
	
	public double convertir(int unidad) {
		double resultado = 0.0;
		
		switch(unidad) {
			case DECAMETRO:
				resultado = this.longitud / DECAMETRO;
				break;
			case HECTOMETRO:
				resultado = this.longitud / HECTOMETRO;
				break;
			case KILOMETRO:
				resultado = this.longitud / KILOMETRO;
				break;
			default:
				resultado = 0.0;
				break;
		}
		return resultado;
	}	
}