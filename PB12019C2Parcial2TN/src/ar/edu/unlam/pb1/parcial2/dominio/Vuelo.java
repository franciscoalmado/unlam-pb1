package ar.edu.unlam.pb1.parcial2.dominio;

public class Vuelo {

	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos;
	private int cantidadActualDePasajeros;
	
	public Vuelo(String origen, String destino, int cantidadPasajero) {
		/*
		* El constructor debe generar las acciones necesarias para
		garantizar el correcto funcionamiento de los objetos de la clase
		*/
		this.origen = origen;
		this.destino = destino;
		this.pasajeros = new Pasajero[cantidadPasajero];
		this.asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
		this.cantidadActualDePasajeros = 0;
	}
	
	public boolean agregarPasajero(Pasajero pasajero) {	
		/*
		* Incorpora un nuevo pasajero a la lista de pasajeros del vuelo.
		Devuelve true si se pudo agregar o false si la capacidad del vuelo se
		encuentra completa.
		*/
		boolean seAgregoPasajero = false;
		
		for(int i=0; i < this.pasajeros.length; i++) {
			if(this.pasajeros[i] == null && this.cantidadActualDePasajeros < this.asientos.length && verificarQueDNIDelPasajeroNoEsteRepetido(pasajero) == false) {
				this.pasajeros[i] = pasajero;
				seAgregoPasajero = true;
				this.cantidadActualDePasajeros++;
				break;
			}
		}
		
		return seAgregoPasajero;
	}
	
	private boolean verificarQueDNIDelPasajeroNoEsteRepetido(Pasajero pasajero) {
		boolean esDniRepetido = false;
		
		for(int i=0; i < this.pasajeros.length; i++) {
			if(this.pasajeros[i] != null && this.pasajeros[i].getDni() == pasajero.getDni()) {
				esDniRepetido = true;
				break;
			}
		}
		
		return esDniRepetido;
	}
	
	public boolean verificarDisponibilidadAsiento(int fila, int columna) {		
		/*
		* Verifica si el asiento indicado se encuentra disponible.
		*/
		boolean isDisponible = false;
		
		for(int i=0; i < asientos.length; i++){
			for(int j=0; j < asientos.length; j++) {
				if(asientos[i][j] == null){
					isDisponible = true;
					break;
				}
			}
		}
	
		return isDisponible;
	}
	
	public Pasajero buscarPasajero(int dni) {
		/*
		* Busca un pasajero en la lista de pasajeros a partir del DNI. Si no
		lo encuentra devuelve null.
		*/
		
		for(int i=0; i < this.pasajeros.length; i++){
			if(this.pasajeros[i].getDni() == dni){
				return this.pasajeros[i];
			}	
		}
		
		return null;
	}
	
	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {	
		/*
		* Asigna el asiento al pasajero recibido por parámetro. Devuelve
		true si lo pudo asignar o false en caso que el asiento no se encuentre disponible.
		*/
		boolean sePudoAsignar = false;
		
		if(verificarDisponibilidadAsiento(fila, columna) == true){
			this.asientos[fila][columna] = pasajero;
			sePudoAsignar = true;
		}
		
		return sePudoAsignar;
	}
	
	public void ordenarListaDePasajerosPorDNI() {
		/*
		* Ordena la lista de pasajeros por DNI.
		*/
		
		Pasajero auxiliar = null;
		
		for(int i=1; i < this.pasajeros.length; i++) {
			for(int j=0; j < this.pasajeros.length-1; j++){
				if(this.pasajeros[i] != null && pasajeros[j].getDni() > this.pasajeros[j+1].getDni()) {
					auxiliar = this.pasajeros[j+1];
					this.pasajeros[j+1] = this.pasajeros[j];
					this.pasajeros[j] = auxiliar;		
				}	
			}	
		}
	}
	
	public Pasajero[] getPasajeros() {		
		/*
		* Devuelve la lista de pasajeros
		*/
		return this.pasajeros;
	}

	public String toString() {		
		/*
		* Devuelve un mapa de los asientos del vuelo indicando por cada uno
		si se encuentra libre "L" u ocupado "O".
		*/
		String mapaDeAsientos = "";
		
		for(int i=0; i < asientos.length; i++){
			for(int j=0; j < asientos[i].length; j++){
				if(asientos[i][j] == null){
					mapaDeAsientos += ("L"+"\t");
				}
				else{
					mapaDeAsientos += ("O"+"\t");
				}
			}
			mapaDeAsientos += "\n";
		}

		return mapaDeAsientos;
	}
	
	public String getOrigen() {
		return this.origen;
	}
	
	public String getDestino() {
		return this.destino;
	}
	
	public int getCantidadActualDePasajeros() {
		return this.cantidadActualDePasajeros;
	}
}