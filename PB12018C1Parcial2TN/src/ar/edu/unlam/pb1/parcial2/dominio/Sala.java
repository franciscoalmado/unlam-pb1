package ar.edu.unlam.pb1.parcial2.dominio;

public class Sala {

	private String nombreDeLaSala;
	private final int CANTIDAD_DE_FILAS;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA;
	private Espectador[][] espectadores;
	private int cantidadDeEspectadores;

	public Sala(String nombreDeLaSala, int cantidadDeFilas, int cantidadDeAsientosPorFila) {
		/* 
		 * El constructor debe generar las acciones necesarias para garantizar el correcto funcionamiento de los 
		 * objetos de la clase.
		 */
		this.nombreDeLaSala = nombreDeLaSala;
		this.CANTIDAD_DE_FILAS = cantidadDeFilas;
		this.CANTIDAD_DE_ASIENTOS_POR_FILA = cantidadDeAsientosPorFila;
		this.espectadores = new Espectador[this.CANTIDAD_DE_FILAS][this.CANTIDAD_DE_ASIENTOS_POR_FILA];
		this.cantidadDeEspectadores = 0;
	}

	public boolean ingresarEspectador(int fila, int asiento, Espectador nuevoEspectador) {
		/*
		 * Realiza el ingreso de un espectador a la sala. Retorna true en caso de poder hacer la asignación o 
		 * false en caso contrario (Sólo se puede ingresar un espectador que tenga una reserva previa).
		 */
		boolean seIngreso = false;

		if(this.espectadores [fila][asiento] == null) {
			this.espectadores [fila][asiento] = nuevoEspectador;
			this.cantidadDeEspectadores++;
			seIngreso = true;
		}
		
		return seIngreso;
	}
	
	public void vaciarSala() {
		/*
		 * Al finalizar una función se invoca este método para liberar cada asiento de la sala
		 */
		
		for(int i=0; i < this.espectadores.length; i++) {
			for(int j=0; j < this.espectadores[i].length; j++) {
				if(this.espectadores[i][j] != null) {
				this.espectadores[i][j] = null;
				}
			}
		}
	}
	
	public int calcularCapacidadDeLaSala() {
		/*
		 * Devuelve la cantidad de asientos que tiene la sala
		 */
		int capacidadDeLaSala = 0;
		
		capacidadDeLaSala = this.CANTIDAD_DE_FILAS * this.CANTIDAD_DE_ASIENTOS_POR_FILA;
		
		return capacidadDeLaSala;
	}
	
	public String toString() {
		/*
		 * Devuelve un mapa de la sala del cine, de manera que se pueda seleccionar la ubicación deseada ante un 
		 * nuevo ingreso. Por cada asiento debe indicar "L" (si se encuentra libre) y "O" (si se encuentra ocupado)
		 */
		String asiento = "";
		
		for(int i=0; i < this.espectadores.length; i++) {
			for(int j=0; j < this.espectadores[i].length; j++) {
				if(this.espectadores[i][j] != null && j != 3) {
					asiento += "|" + "O" + "|" + "\t";
				}
				if(this.espectadores[i][j] == null && j != 3) {
					asiento += "|" + "L" + "|" + "\t";
				}
				if(this.espectadores[i][j] != null && j == 3) {
					asiento += "|" + "O" + "|" + "\n";
				}
				if(this.espectadores[i][j] == null && j == 3) {
					asiento += "|" + "L" + "|" + "\n";
				}
			}
		}
		
		return asiento;
	}
	
	public String getNombreDeLaSala() {
		return this.nombreDeLaSala;
	}
	
	public int getCantidadDeEspectadores() {
		return this.cantidadDeEspectadores;
	}
}