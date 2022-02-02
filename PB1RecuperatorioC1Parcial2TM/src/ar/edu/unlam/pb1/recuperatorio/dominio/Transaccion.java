package ar.edu.unlam.pb1.recuperatorio.dominio;

public class Transaccion {
	private Operacion operacion;
	private int cantidad;
	private double valor;
	/*
	 * Constructor. Se deben generar los atributos necesarios para el correcto funcionamiento.
	 */
	public Transaccion(Operacion operacion, int cantidad, double valor) {
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.valor = valor;
	}
	
	public Transaccion(double valor) {
		this.valor = valor;
	}
	
	public Operacion getOperacion() {
		return this.operacion;
	}
	
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacción [Operación: " + operacion + ", cantidad: " + cantidad + ", valor: " + valor + "]";
	}	
}