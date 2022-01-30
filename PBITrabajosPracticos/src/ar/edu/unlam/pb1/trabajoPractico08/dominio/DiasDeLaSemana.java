package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public enum DiasDeLaSemana {

	DOMINGO("Domingo", 1),
	LUNES("Lunes", 2),
	MARTES("Martes", 3),
	MIERCOLES("Miércoles", 4),
	JUEVES("Jueves", 5),
	VIERNES("Viernes", 6),
	SABADO("Sábado", 7);
	
	private final String dia;
	private final int valor;

	private DiasDeLaSemana(String dia, int valorDeDia) {
		this.dia = dia;
		this.valor = valorDeDia;
	}

	public String getDia() {
		return dia;
	}
	
	public int getValor() {
		return valor;
	}	
}