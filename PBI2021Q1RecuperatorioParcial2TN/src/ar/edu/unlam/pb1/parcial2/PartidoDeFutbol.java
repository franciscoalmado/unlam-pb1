package ar.edu.unlam.pb1.parcial2;

import java.util.Arrays;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amonestados[];
	private Evento expulsados[];
	private int cantidadDeGoles;
	private int cantidadMaximaDeGoles;
	private int cantidadDeGolesEquipoLocal;
	private int cantidadDeGolesEquipoVisitante;
	private int cantidadDeJugadoresAmonestados;
	private int cantidadDeJugadoresAmonestadosEquipoLocal;
	private int cantidadDeJugadoresAmonestadosEquipoVisitante;
	private int cantidadMaximaDeAmonestaciones;
	private int cantidadDeJugadoresExpulsados;
	private int cantidadDeJugadoresExpulsadosEquipoLocal;
	private int cantidadDeJugadoresExpulsadosEquipoVisitante;	
	private int cantidadMaximaDeExpulsiones;
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
		this.cantidadDeGoles = 0;
		this.cantidadMaximaDeGoles = 20;
		this.cantidadDeGolesEquipoLocal = 0;
		this.cantidadDeGolesEquipoVisitante = 0;
		this.cantidadDeJugadoresAmonestados = 0;
		this.cantidadMaximaDeAmonestaciones = 20;
		this.cantidadDeJugadoresAmonestadosEquipoLocal = 0;
		this.cantidadDeJugadoresAmonestadosEquipoVisitante = 0;
		this.cantidadDeJugadoresExpulsados = 0;
		this.cantidadDeJugadoresExpulsadosEquipoLocal = 0;
		this.cantidadDeJugadoresExpulsadosEquipoVisitante = 0;
		this.cantidadMaximaDeExpulsiones = 10;
		this.goles = new Evento[cantidadMaximaDeGoles];
		this.amonestados = new Evento[cantidadMaximaDeAmonestaciones];
		this.expulsados = new Evento[cantidadMaximaDeExpulsiones];
	}
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {
		
		for(int i=0; i < this.goles.length; i++) {
			if(this.goles[i] == null && this.cantidadDeGoles < this.cantidadMaximaDeGoles) {
				if(gol.getTipo().equals(TipoDeEvento.GOL_A_FAVOR) && verificarNumeroDelJugadorAutorDelEvento(local, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoLocal++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_A_FAVOR) && verificarNumeroDelJugadorAutorDelEvento(visitante, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoVisitante++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_EN_CONTRA) && verificarNumeroDelJugadorAutorDelEvento(local, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoVisitante++;
				}
				if(gol.getTipo().equals(TipoDeEvento.GOL_EN_CONTRA) && verificarNumeroDelJugadorAutorDelEvento(visitante, gol) == true) {
					this.goles[i] = gol;
					this.cantidadDeGolesEquipoLocal++;
				}
				this.cantidadDeGoles++;
				break;
			}
		}
	}
	
	private boolean verificarNumeroDelJugadorAutorDelEvento(EquipoDeFutbol equipo, Evento evento) {
		
		boolean isElNumero = false;
		
		if(this.local.equals(equipo) && this.local.buscar(evento.getAutor().getNumero()) != null) {
			isElNumero = true;
		}
		
		if(this.visitante.equals(equipo) && this.visitante.buscar(evento.getAutor().getNumero()) != null) {
			isElNumero = true;
		}
		
		return isElNumero;	
	}
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {

		int resultado = 0;		
		
		for(int i=0; i < this.amonestados.length; i++) {
			if(this.amonestados[i] == null && this.cantidadDeJugadoresAmonestados < this.cantidadMaximaDeAmonestaciones) {
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(local, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == false) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoLocal++;
					this.cantidadDeJugadoresAmonestados++;
					return resultado = 1;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(visitante, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == false) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoVisitante++;
					this.cantidadDeJugadoresAmonestados++;
					return resultado = 1;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(local, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == true) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoLocal++;
					this.cantidadDeJugadoresAmonestados++;
					this.amonestados[i].setTipo(TipoDeEvento.EXPULSION);
					return resultado = 2;
				}
				if(amonestado.getTipo().equals(TipoDeEvento.AMONESTACION) && verificarNumeroDelJugadorAutorDelEvento(visitante, amonestado) == true && verificarSiElJugadorEstaAmonestado(amonestado) == true) {
					this.amonestados[i] = amonestado;
					this.cantidadDeJugadoresAmonestadosEquipoVisitante++;
					this.cantidadDeJugadoresAmonestados++;
					this.amonestados[i].setTipo(TipoDeEvento.EXPULSION);
					return resultado = 2;
				}
			}
		}
		
		return resultado;
	}
	
	private boolean verificarSiElJugadorEstaAmonestado(Evento evento) {
		
		boolean isAmonestado = false;
		
		for(int i=0; i < this.amonestados.length; i++) {
			if(this.amonestados[i] != null && this.amonestados[i].getAutor().equals(evento.getAutor())) {
				isAmonestado = true;
			}
		}
		
		return isAmonestado;
	}
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {

		for(int i=0; i < this.expulsados.length; i++) {
			if(this.expulsados[i] == null && this.cantidadDeJugadoresExpulsados < this.cantidadMaximaDeExpulsiones) {
				if(expulsado.getTipo().equals(TipoDeEvento.EXPULSION) && verificarNumeroDelJugadorAutorDelEvento(local, expulsado) == true){
					this.expulsados[i] = expulsado;
					this.cantidadDeJugadoresExpulsadosEquipoLocal++;
				}
				if(expulsado.getTipo().equals(TipoDeEvento.EXPULSION) && verificarNumeroDelJugadorAutorDelEvento(visitante, expulsado) == true){
					this.expulsados[i] = expulsado;
					this.cantidadDeJugadoresExpulsadosEquipoVisitante++;
				}
				if(verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(local, expulsado) == true) {
					expulsados[i] = expulsado;
					this.cantidadDeJugadoresExpulsadosEquipoLocal++;
				}
				if(verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(visitante, expulsado) == true) {
					expulsados[i] = expulsado;
					this.cantidadDeJugadoresExpulsadosEquipoVisitante++;
				}
				this.cantidadDeJugadoresExpulsados++;
				break;
			}
		}
	}
	
	private boolean verificarSiElJugadorEstaExpulsadoPorDobleAmonestacion(EquipoDeFutbol equipo, Evento evento) {
	
		boolean isExpulsado = false;
		
		if(this.local.equals(equipo) && this.local.buscar(evento.getAutor().getNumero()) != null && amonestar(evento) == 2) {
			isExpulsado = true;
		}
		
		if(this.visitante.equals(equipo) && this.visitante.buscar(evento.getAutor().getNumero()) != null && amonestar(evento) == 2) {
			isExpulsado = true;
		}
		
		return isExpulsado;
	}
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		
		if(getCantidadGolesEquipoLocal() > getCantidadGolesEquipoVisitante()) {
			return getLocal();
		}
		
		if(getCantidadGolesEquipoLocal() < getCantidadGolesEquipoVisitante()) {
			return getVisitante();
		}
				
		if(getCantidadGolesEquipoLocal() == getCantidadGolesEquipoVisitante()) {
			return null;
		}		

		return null;
	}
	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String resultado = "Resultado del partido: " + getGanador() + "\n" +
							"Marcador: " + this.local + " " + this.cantidadDeGolesEquipoLocal + " - " + this.cantidadDeGolesEquipoVisitante + " "+ this.visitante + "\n" +
							"Goles: "+ Arrays.toString(goles) + "\n" +
							"Amonestados: "+ Arrays.toString(amonestados) + "\n" +
							"Expulsados: " + Arrays.toString(expulsados);
		return resultado;
	}

	public EquipoDeFutbol getLocal() {
		return this.local;
	}

	public EquipoDeFutbol getVisitante() {
		return this.visitante;
	}
	
	public int getCantidadDeGoles() {
		return this.cantidadDeGoles;
	}
	
	public int getCantidadGolesEquipoLocal() {
		return this.cantidadDeGolesEquipoLocal;
	}
	
	public int getCantidadGolesEquipoVisitante() {
		return this.cantidadDeGolesEquipoVisitante;
	}
	
	public int getCantidadDeJugadoresAmonestados() {
		return this.cantidadDeJugadoresAmonestados;
	}
	
	public int getCantidadDeJugadoresAmonestadosEquipoLocal() {
		return this.cantidadDeJugadoresAmonestadosEquipoLocal;
	}
	
	public int getCantidadDeJugadoresAmonestadosEquipoVisitante() {
		return this.cantidadDeJugadoresAmonestadosEquipoVisitante;
	}
	
	public int getCantidadDeJugadoresExpulsados() {
		return this.cantidadDeJugadoresExpulsados;
	}
	
	public int getCantidadDeJugadoresExpulsadosEquipoLocal() {
		return this.cantidadDeJugadoresExpulsadosEquipoLocal;
	}
	
	public int getCantidadDeJugadoresExpulsadosEquipoVisitante() {
		return this.cantidadDeJugadoresExpulsadosEquipoVisitante;
	}
}