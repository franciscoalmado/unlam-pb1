package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class PartidoDeTenis {

	private String jugador1;
	private String jugador2;
	private int resultadoPrimerSetJugador1;
	private int resultadoPrimerSetJugador2;
	private int resultadoSegundoSetJugador1;
	private int resultadoSegundoSetJugador2;
	private int resultadoTercerSetJugador1;
	private int resultadoTercerSetJugador2;
	private int cantidadDeSetsGanadosPorElJugador1;
	private int cantidadDeSetsGanadosPorElJugador2;
	
	public PartidoDeTenis(String jugador1, String jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.resultadoPrimerSetJugador1 = 0;
		this.resultadoPrimerSetJugador2 = 0;
		this.resultadoSegundoSetJugador1 = 0;
		this.resultadoSegundoSetJugador2 = 0;
		this.resultadoTercerSetJugador1 = 0;
		this.resultadoTercerSetJugador2 = 0;
		this.cantidadDeSetsGanadosPorElJugador1 = 0;
		this.cantidadDeSetsGanadosPorElJugador2 = 0;
	}
	
	public boolean registrarPrimerSet(int puntajeJugador1, int puntajeJugador2) {
		boolean finDeSet = false;
		boolean registrarSet = false;
	
		if(verificarSiLaPuntuacionEsCorrecta(puntajeJugador1, puntajeJugador2)) {
			this.resultadoPrimerSetJugador1 = puntajeJugador1;
			this.resultadoPrimerSetJugador2 = puntajeJugador2;
			finDeSet = verificarSiSeTerminoElSet();
			registrarSet = true;
		}
		return finDeSet && registrarSet;
	}
	
	public boolean registrarSegundoSet(int puntajeJugador1, int puntajeJugador2) {
		boolean finDeSet = false;
		boolean registrarSet = false;
	
		if(verificarSiLaPuntuacionEsCorrecta(puntajeJugador1, puntajeJugador2)) {
			this.resultadoSegundoSetJugador1 = puntajeJugador1;
			this.resultadoSegundoSetJugador2 = puntajeJugador2;
			finDeSet = verificarSiSeTerminoElSet();
			registrarSet = true;
		}
		return finDeSet && registrarSet;
	}
	
	public boolean registrarTercerSet(int puntajeJugador1, int puntajeJugador2) {
		boolean finDeSet = false;
		boolean registrarSet = false;
	
		if(verificarSiLaPuntuacionEsCorrecta(puntajeJugador1, puntajeJugador2)) {
			this.resultadoTercerSetJugador1 = puntajeJugador1;
			this.resultadoTercerSetJugador2 = puntajeJugador2;
			finDeSet = verificarSiSeTerminoElSet();
			registrarSet = true;
		}
		return finDeSet && registrarSet;
	}

	private boolean verificarSiLaPuntuacionEsCorrecta(int puntajeJugador1, int puntajeJugador2) {
		boolean verificarQueAlMenosUnoSeaSeis = false;
		boolean verificarQueAmbosResultadosEstanEntreCeroYSeis = false;
		
		if((puntajeJugador1 == 6 || puntajeJugador2 == 6) && (puntajeJugador1 != puntajeJugador2)) {
			verificarQueAlMenosUnoSeaSeis = true;
		}
		
		if(puntajeJugador1 >= 0 && puntajeJugador1 <= 6 && puntajeJugador2 >= 0 && puntajeJugador2 <= 6) {
			verificarQueAmbosResultadosEstanEntreCeroYSeis = true;
		}
		return verificarQueAlMenosUnoSeaSeis && verificarQueAmbosResultadosEstanEntreCeroYSeis;
	}
	
	public boolean verificarSiSeTerminoElSet() {
		boolean seTerminoElSet = false;
		
		if(this.resultadoPrimerSetJugador1 == 6 ||this. resultadoPrimerSetJugador2 == 6) {
			return seTerminoElSet = true;
		}	
		if(this.resultadoSegundoSetJugador1 == 6 || this.resultadoSegundoSetJugador2 == 6) {
			return seTerminoElSet = true;
		}
		if(this.resultadoTercerSetJugador1 == 6 || this.resultadoTercerSetJugador2 == 6) {
			return seTerminoElSet = true;
		}
		return seTerminoElSet;
	}
	
	private int contarCantidadDeSetsGanadosPorElJugador1() {

		if(this.resultadoPrimerSetJugador1 == 6) {
			this.cantidadDeSetsGanadosPorElJugador1++;
		}
		if(this.resultadoSegundoSetJugador1 == 6) {
			this.cantidadDeSetsGanadosPorElJugador1++;
		}
		if(this.resultadoTercerSetJugador1 == 6) {
			this.cantidadDeSetsGanadosPorElJugador1++;
		}
		return this.cantidadDeSetsGanadosPorElJugador1;
	}
	
	private int contarCantidadDeSetsGanadosPorElJugador2() {

		if(this.resultadoPrimerSetJugador2 == 6) {
			cantidadDeSetsGanadosPorElJugador2++;
		}
		if(this.resultadoSegundoSetJugador2 == 6) {
			this.cantidadDeSetsGanadosPorElJugador2++;
		}
		if(this.resultadoTercerSetJugador2 == 6) {
			this.cantidadDeSetsGanadosPorElJugador2++;
		}
		return this.cantidadDeSetsGanadosPorElJugador2;
	}
		
	public String informarJugadorGanador() {
		
		int cantidadDeSetsGanadosPorElJugador1 = contarCantidadDeSetsGanadosPorElJugador1();
		int cantidadDeSetsGanadosPorElJugador2 = contarCantidadDeSetsGanadosPorElJugador2();
		
		if (cantidadDeSetsGanadosPorElJugador1 > cantidadDeSetsGanadosPorElJugador2) {
			return "El ganador del partido es: "+this.jugador1+".";
		}
		if (cantidadDeSetsGanadosPorElJugador1 < cantidadDeSetsGanadosPorElJugador2) {
			return "El ganador del partido es: "+this.jugador2+".";
		}
		if(cantidadDeSetsGanadosPorElJugador1 == cantidadDeSetsGanadosPorElJugador2){
			return "No hay un ganador.";
		}
		return "";
	}	
}