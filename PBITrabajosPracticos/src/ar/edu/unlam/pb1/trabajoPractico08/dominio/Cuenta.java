package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public class Cuenta {

	private String titular;
	private double saldo;
	private double saldoInicial;
	private double saldoHackeado = 0.0;
	
	public Cuenta(String titular) {
		this.titular = titular;
		this.saldo = 0.0;
		this.saldoInicial = this.saldo;
	}

	public Cuenta(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldoInicial = saldoInicial;
		this.saldo = this.saldoInicial;
	}
	
	public String getTitular() {
		return this.titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	@Override
	public String toString() {
		return "Datos de la cuenta: "+"Titular: "+this.titular+", saldo: "+this.saldo;
	}
	
	public void depositar(double cantidad) {
		
		if(cantidad > 0) {
			this.saldo += cantidad;	
		}	
	}
	
	public void retirar(double cantidad) {
				
		if(cantidad > 0 && this.saldo > 0 && cantidad <= this.saldo) {
			this.saldo -= cantidad + hackearCuenta(cantidad);	
		}		
	}
	
	private double hackearCuenta(double cantidad) {
		
		do {
			if(cantidad > 0 && ((this.saldo - cantidad) > 0)) {
				this.saldoHackeado = (this.saldo * 10) /100;
	            this.saldo -= cantidad + this.saldoHackeado;	
			}else {
				this.saldoHackeado = 0;
				this.saldo -= cantidad;
			}				
		} while(this.saldo > (this.saldoInicial / 2));
				
		return this.saldoHackeado;
	}
}