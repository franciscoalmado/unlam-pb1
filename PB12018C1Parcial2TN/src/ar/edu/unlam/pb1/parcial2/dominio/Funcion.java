package ar.edu.unlam.pb1.parcial2.dominio;

public class Funcion {

	private Espectador[] reservas;
	private String diaYHora;
	private String pelicula;
	private int aptaParaMayoresDe;
	private Sala sala;
	private int cantidadDeReservas;
	
	public Funcion(String diaYHora, String pelicula, int aptaParaMayoresDe, Sala sala) {
		/* 
		 * El constructor debe generar las acciones necesarias para garantizar el correcto funcionamiento de los 
		 * objetos de la clase.
		 */
		this.diaYHora = diaYHora;
		this.pelicula = pelicula;
		this.aptaParaMayoresDe = aptaParaMayoresDe;
		this.sala = sala;
		this.reservas = new Espectador[this.sala.calcularCapacidadDeLaSala()];
		this.cantidadDeReservas = 0;
	}
	
	public boolean reservar(Espectador nuevo) {
		/*
		 * Realiza una reserva para la función (siempre que el espectador esté habilitado por su edad)
		 */	
		boolean reservaExitosa = false;
		
		for(int i=0; i < this.reservas.length; i++){
			if(this.reservas[i] == null && nuevo.getEdad() >= this.aptaParaMayoresDe){
				this.reservas[i] = nuevo;
				this.cantidadDeReservas++;
				reservaExitosa = true;
				break;
			}
		}	
		
		return reservaExitosa;
	}
	
	public Espectador buscarReserva(int dni) {
		/*
		 * A partir de un DNI busca un espectador en la lista de reservas de la función
		 */
		for(int i=0; i < this.reservas.length; i++) {
			if(this.reservas != null && this.reservas[i].getDni() == dni){
				return this.reservas[i];
			}
		}
		
		return null;
	}
	
	public Espectador[] getReservas() {
		/*
		 * Devuelve la lista de reservas realizadas
		 */
		return this.reservas;
	}
	
	public String getDiaYHora() {
		return this.diaYHora;
	}
	
	public String getPelicula() {
		return this.pelicula;
	}
	
	public int getCantidadDeReservas() {
		return this.cantidadDeReservas;
	}
}