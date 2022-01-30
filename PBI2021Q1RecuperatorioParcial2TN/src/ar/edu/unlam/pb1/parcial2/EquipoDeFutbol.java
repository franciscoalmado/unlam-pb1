package ar.edu.unlam.pb1.parcial2;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	private final int CANTIDAD_MAXIMA_DE_JUGADORES = 5;
	private int cantidadDeJugadores;
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		this.jugadores = new Jugador[CANTIDAD_MAXIMA_DE_JUGADORES];
		this.cantidadDeJugadores = 0;
	}
	/*
	 * La capacidad máxima de un equipo es 5. No se permiten jugadores repetidos (ya sea el número o nombre del jugador)
	 * Se retorna el resultado de la operación
	 */
	public boolean agregarJugador(Jugador nuevo) {
		
		boolean sePudoAgregar = false;
		
		for(int i=0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] == null && this.cantidadDeJugadores < this.CANTIDAD_MAXIMA_DE_JUGADORES && verificarSiElNombreDelJugadorEstaRepetido(nuevo) == false && verificarSiElNumeroDelJugadorEstaRepetido(nuevo) == false){
				this.jugadores[i] = nuevo;
				this.cantidadDeJugadores++;
				sePudoAgregar = true;
				break;
			}
		}
		
		return sePudoAgregar;
	}
	
	private boolean verificarSiElNombreDelJugadorEstaRepetido(Jugador nuevo) {
		
		boolean isRepetido = false;
		
		for(int i=0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] != null && this.jugadores[i].getNombre().compareTo(nuevo.getNombre()) == 0) {
				isRepetido = true;
			}
		}
		
		return isRepetido;
	}
	
	private boolean verificarSiElNumeroDelJugadorEstaRepetido(Jugador nuevo) {
		
		boolean isRepetido = false;
		
		for(int i=0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] != null && this.jugadores[i].getNumero() == nuevo.getNumero()) {
				isRepetido = true;
			}
		}
		
		return isRepetido;
	}
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		
		for(int i=0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] != null && this.jugadores[i].getNumero() == numero) {
				return this.jugadores[i];
			}
		}
			
		return null;
	}
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		
		for(int i=0; i < this.jugadores.length; i++) {
			if(this.jugadores[i] != null && this.jugadores[i].getNombre().compareTo(nombre) == 0) {
				return this.jugadores[i];
			}
		}
		
		return null;
	}
	/*
	 * Calcula la edad promedio del equipo. 
	 * 
	 */
	public double calcularLaEdadPromedioDelEquipo() {
		int sumatoriaDeEdad = 0;
		double promedioDeEdad = 0.0;
		
		for(int i=0; i < this.jugadores.length; i++) {
			sumatoriaDeEdad += this.jugadores[i].getEdad();
		}
		
		promedioDeEdad = sumatoriaDeEdad / (double) this.jugadores.length;
		
		return promedioDeEdad;
	}
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		double valorDelEquipo = 0.0;
		
		for(int i=0; i < this.jugadores.length; i++) {
			valorDelEquipo += this.jugadores[i].getPrecio();
		}
		
		return valorDelEquipo;
		
	}
	
	public String toString() {
		return this.nombre;
	}	
}