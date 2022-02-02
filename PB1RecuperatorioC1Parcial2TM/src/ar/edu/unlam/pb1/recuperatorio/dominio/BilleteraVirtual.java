package ar.edu.unlam.pb1.recuperatorio.dominio;

public class BilleteraVirtual {
	
	private double TIPO_DE_CAMBIO_ETHEREUM = 1859.00;
	private final int CANTIDAD_DE_CRIPTOMONEDAS_EN_TRANSACCION = 100000;
	
	private Transaccion[] transacciones;
	private String nombreBilletera;
	private final int CANTIDAD_MAXIMA_DE_TRANSACCIONES;
	private int cantidadDeTransacciones;
	private double saldoActual;
	/*
	 * Constructor. Se deben generar los atributos necesarios para el correcto funcionamiento.
	 */
	public BilleteraVirtual(String nombreBilletera) {
		this.nombreBilletera = nombreBilletera;
		this.CANTIDAD_MAXIMA_DE_TRANSACCIONES = 10;
		this.transacciones = new Transaccion[CANTIDAD_MAXIMA_DE_TRANSACCIONES];
		this.cantidadDeTransacciones = 0;
		this.saldoActual = 0;
	}
	/**
	 * Compra o vende una criptomoneda debiendo indicarse la cantidad. Agrega la transaccion al array de 
	 * transacciones.
	 * @param cantidad int		Cantidad de criptomoneda a comprar
	 * @return Verdadero en caso de éxito
	 * */
	public boolean comprarVenderCriptomoneda(int cantidad) {
		
		boolean sePuedeComprarOVender = false;
		
		if(cantidad <= CANTIDAD_DE_CRIPTOMONEDAS_EN_TRANSACCION) {
			sePuedeComprarOVender = true;
		}
		
		return sePuedeComprarOVender;
	}
	
	public boolean realizarNuevaOperacion(Transaccion nueva) {
		
		boolean sePudoRealizarOperacion = false;
		
		for(int i=0; i < this.transacciones.length; i++) {
			if(this.transacciones[i] == null && cantidadDeTransacciones < CANTIDAD_MAXIMA_DE_TRANSACCIONES) {	
				transacciones[i] = nueva; 
				this.cantidadDeTransacciones++;
				sePudoRealizarOperacion = true;
				break;
			}
		}
		
		return sePudoRealizarOperacion;
	}
	
	public double calcularValorDeLaOperacion(int cantidad) {
		
		double valor = 0.00;
		
		valor = cantidad * this.TIPO_DE_CAMBIO_ETHEREUM;
		
		return valor;
	}
	/**
	 * Obtiene el saldo actual calculado en base a las transacciones realizadas
	 * @return Saldo actual o cero
	 * */
	public double obtenerSaldoActual() {
		// TODO: Redondear el resultado para ver solo 2 decimales.	
		
		double compra = 0.00;
		double venta = 0.00;
		
		for(int i=0; i < this.transacciones.length; i++) {
			if(this.transacciones[i] != null && this.transacciones[i].getOperacion().equals(Operacion.COMPRA)) {
				compra += transacciones[i].getValor();
			}
			if(this.transacciones[i] != null && this.transacciones[i].getOperacion().equals(Operacion.VENTA)) {
				venta += transacciones[i].getValor();
			}
		}
		
		if(compra > venta) {
			this.saldoActual = compra - venta;
		}else {
			this.saldoActual = 0.00;
		}
		
		return saldoActual;
	}
	/**
	 * Obtiene la transaccion realizada de mayor monto
	 * @return Transaccion		Transaccion de mayor monto o null
	 * */
	public Transaccion obtenerTransaccionMayorMonto() {
		
		Transaccion mayorTransaccion = this.transacciones[0];		
		
		for(int i=1; i < this.transacciones.length; i++) {	
			if(this.transacciones[i].getValor() > mayorTransaccion.getValor()) {
				mayorTransaccion = transacciones[i];
			}	
		}
		
		return mayorTransaccion;	
	}
	/**
	 * Obtiene las transacciones realizadas ordenadas descendentemente
	 * @return Transaccion[]	Array de transacciones ordenadas
	 * */
	public Transaccion[] listrarTransaccionesDescendentemente() {

		Transaccion auxiliar = null;
		
		for(int i=1; i < this.transacciones.length; i++) {
			for(int j=0; j < this.transacciones.length-1; j++){
				if(this.transacciones[i] != null && this.transacciones[j].getValor() < this.transacciones[j+1].getValor()) {
					auxiliar = this.transacciones[j+1];
					this.transacciones[j+1] = this.transacciones[j];
					this.transacciones[j] = auxiliar;		
				}	
			}	
		}		
		
		return this.transacciones;
	}
	
	public String getNombreBilletera() {
		return this.nombreBilletera;
	}
	
	public Transaccion[] getTransacciones() {
		return this.transacciones;	
	}
	
	public int getCantidadDeTransacciones() {
		return this.cantidadDeTransacciones;
	}
 }