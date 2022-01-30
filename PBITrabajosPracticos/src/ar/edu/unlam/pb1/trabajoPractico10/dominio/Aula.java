package ar.edu.unlam.pb1.trabajoPractico10.dominio;

public class Aula {

	private String asientos[][];
	private int numero;
	private int cantidadDeFilas;
	private int cantidadDeColumnas;
	private int asistencia;
	
	public Aula(int numero, int cantidadDeFilas, int cantidadDeColumnas) {
		this.numero = numero;
		this.cantidadDeFilas = cantidadDeFilas;
		this.cantidadDeColumnas = cantidadDeColumnas;
		this.asientos = new String[this.cantidadDeFilas][this.cantidadDeColumnas];
		this.asistencia = 0;
	}
	
	public void sentarUnAlumno(int fila, int columna, String nombre) {	
		this.asientos[fila][columna] = nombre;
		this.asistencia++;
	}
	
	public String tostring() {
		String mapa= "";
		
		for(int i = 0; i < this.asientos.length; i++) {
			mapa += " | ";
			for(int j = 0; j < this.asientos[i].length; j++) {
				mapa += this.asientos[i][j] + " | ";
			}
			mapa += " \n ";
		}
		return mapa;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getCantidadDeFilas() {
		return this.cantidadDeFilas;
	}
	
	public int getCantidadDeColumnas() {
		return this.cantidadDeColumnas;
	}
	
	public int mostrarCantidadDeAsistentes() {
		return this.asistencia;
	}
}