package ar.edu.unlam.pb1.trabajoPractico06.dominio;

public class Automovil {
	private double velocidad;
    private double horas;
    private char horaMinutos;
    private int cantidadDeSegundos;

    public Automovil(double velocidad, double horas, char horaMinutos) {
	    this.velocidad = velocidad;
	    this.cantidadDeSegundos = 0;
	    this.horaMinutos = horaMinutos;	    
	
	    if(this.horaMinutos == 'h' || this.horaMinutos == 'H'){
	    	this.horas = horas;
	    } else if (this.horaMinutos == 'm' || this.horaMinutos == 'M'){
	    	this.horas = horas/60;
	    }
	    else {
	    	this.horas = 0;
	    }
    }

    public double getVelocidad() {
    	return this.velocidad;
    }
    
    public double getHoras() {
    	return this.horas;
    }
    
    public double distanciaRecorrida() {
    	double distanciaRecorrida = 0.0;
    	
    	distanciaRecorrida = this.horas * this.velocidad;
    	
    	return distanciaRecorrida;
    }

    public int alcanzaVelocidadMaxima(double velocidadMaxima, double aceleracion) {
    	double velocidadEnElTiempo = 0;
    	
        while(velocidadMaxima > velocidadEnElTiempo){
                velocidadEnElTiempo = (aceleracion * this.cantidadDeSegundos * this.cantidadDeSegundos) / 1000;
                this.cantidadDeSegundos++;
        }
        return this.cantidadDeSegundos;
    }
}