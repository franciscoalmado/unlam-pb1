package ar.edu.unlam.pb1.trabajoPractico.dominio;

public class Cajero {
	
	private Caja caja;
	private double monto;
	
	public Cajero(double montoInicial){
		if (montoInicial > 0) {
			this.caja = new Caja(montoInicial);
		}else {
			this.monto = 0;
			this.caja = new Caja(monto);
		}
	}
	
	public void cobrar(double importe) {
		double dineroRecibido = 0;
		double cambio = 0;
		
		dineroRecibido = recibirDinero(importe);
		this.caja.guardarDinero(dineroRecibido);
		cambio = dineroRecibido - importe;
		
		if (this.caja.obtenerTotalAcumulado() >= cambio) {
			this.caja.retirarDinero(cambio);
		} else {
			this.caja.retirarDinero(dineroRecibido);
		}
	}

	private double recibirDinero(double importe) {
		
		double saldoDeLaVenta = 0;
		
		do {
			if (importe > 0){
			saldoDeLaVenta -= importe;
			} 
		}while (saldoDeLaVenta < importe);
		
		return saldoDeLaVenta;
	}
	
	public double cerrarCaja() {
		return this.caja.getMontoTotalAcumulado();
	}	
}