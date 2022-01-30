package ar.edu.unlam.pb1.trabajoPractico.dominio;

public class Caja {
	
	private double montoInicial;
	private double montoTotalAcumulado;
	
	public Caja (double importeInicial){
		this.montoInicial = Math.abs(importeInicial);
		this.montoTotalAcumulado = montoInicial;
	}
	
	public void guardarDinero(double importe){
		this.montoTotalAcumulado += importe;
	}
	
	public void retirarDinero(double importe) {
		this.montoTotalAcumulado -= importe;
	}
	
	public double obtenerTotalAcumulado() {
		return montoTotalAcumulado - montoInicial;
	}
	
	public double getMontoInicial(){
		return this.montoInicial;
	}
	
	public void setMontoInicial(double montoInicial){
		this.montoInicial = montoInicial;
	}
	
	public double getMontoTotalAcumulado(){
		return this.montoTotalAcumulado;
	}
}