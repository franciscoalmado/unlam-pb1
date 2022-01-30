package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class Alarma {

	private boolean sensorDeMovimiento;
	private boolean sensorDeContacto;
	private boolean sensorDeSonido;
	private boolean encendida;
	private int codigoDeSeguridad;
	
	public Alarma(int codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.sensorDeMovimiento = false;
		this.sensorDeContacto = false;
		this.sensorDeSonido = false;
		this.encendida = false;
	}
	
	public void encender(int codigoDeSeguridad) {
		if(this.codigoDeSeguridad == codigoDeSeguridad) {
			this.encendida = true;
		}
	}
	
	public void apagar(int codigoDeSeguridad) {
		if(this.codigoDeSeguridad == codigoDeSeguridad) {
			this.encendida = false;
		}		
	}
	
	public boolean activada() {
		
		if(this.sensorDeMovimiento == true || this.sensorDeContacto == true || this.sensorDeSonido == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean estaEncendida() {
		return this.encendida;
	}
	
	public void activarSensorDeMovimiento() {
		this.sensorDeMovimiento = true;
	}
	
	public void desactivarSensorDeMovimiento() {
		this.sensorDeMovimiento = false;
	}
	
	public void activarSensorDeContacto() {
		this.sensorDeContacto = true;
	}
	
	public void desactivarSensorDeContacto() {
		this.sensorDeContacto = false;
	}
	
	public void activarSensorDeSonido() {
		this.sensorDeSonido = true;
	}
	
	public void desactivarSensorDeSonido() {
		this.sensorDeSonido = false;
	}	
}