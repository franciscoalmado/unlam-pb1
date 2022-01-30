package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class Nota {

	private float nota;
	
	public Nota(float valorInicial) {
		this.nota = valorInicial;
	}
	
	public float getValor() {
		return this.nota;
	}
	
	public boolean aprobado() {
		boolean aprobado = false;
		
		if(this.nota >= 7) {
			aprobado = true;
		}else {
			aprobado = false;
		}
		return aprobado;
	}
	
	public void recuperar(float nuevoValor) {
		this.nota = nuevoValor;
	}
}