package ar.edu.unlam.pb1.trabajoPractico04.dominio;

public class Temperatura {
	
	public static final int CELSIUS = 0;
	public static final int FARENHEIT = 1;
	public static final int KELVIN = 2;
	private double valor;
	private final double FACTOR_MULTIPLICADOR_FARENHEIT = 1.8;
	private final int FACTOR_DE_CONVERSION_FARENHEIT = 32;
	private final double FACTOR_DE_CONVERSION_KELVIN = 273.15;
	
	public Temperatura(double valor) {
		this.valor = 0.0;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor, int unidad) {

		switch(unidad) {
			case CELSIUS:
				this.valor = valor;
				break;
			case FARENHEIT:
				this.valor = (valor - FACTOR_DE_CONVERSION_FARENHEIT) / FACTOR_MULTIPLICADOR_FARENHEIT;
				break;
			case KELVIN:
				this.valor = valor - FACTOR_DE_CONVERSION_KELVIN;
				break;
			default:
				break;
		}
	}

	public double convertir(int unidad) {
		double conversion = 0.0;
		double conversionConValorAproximado = 0.0;
		
		switch(unidad) {
			case CELSIUS:
				conversion = this.valor;
				conversionConValorAproximado = ((double) Math.round(conversion*100)/100);
				break;
			case FARENHEIT:
				conversion = (this.valor * FACTOR_MULTIPLICADOR_FARENHEIT) + FACTOR_DE_CONVERSION_FARENHEIT;
				conversionConValorAproximado = ((double) Math.round(conversion*100)/100);
				break;
			case KELVIN:
				conversion = this.valor + FACTOR_DE_CONVERSION_KELVIN;
				conversionConValorAproximado = ((double) Math.round(conversion*100)/100);
				break;
			default:
				break;	
		}
		return conversionConValorAproximado;
	}
}