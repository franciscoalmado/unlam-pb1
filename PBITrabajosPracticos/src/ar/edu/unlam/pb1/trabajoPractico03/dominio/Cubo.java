package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class Cubo {

	private float longitudLado;
	
	public Cubo(float lado) {
		this.longitudLado = lado;
	}
	
	public float getLongitudLado() {
		return this.getLongitudLado();
	}
	
	public void setLongitudLado(float longitudLado) {
		this.longitudLado = longitudLado;
	}
	
	public float getSuperficieCara() {
		float superficieCara = 0.0f;
		
		superficieCara = (float) (Math.pow(this.longitudLado, 2));
		
		float superficieCaraConValorAproximado = ((float)Math.round(superficieCara*100)/100);
		
		return superficieCaraConValorAproximado;
	}
	
	public float getVolumen() {
		float volumen = 0.0f;
		
		volumen = (float) Math.pow(this.longitudLado, 3);
		
		float volumenConValorAproximado = ((float)Math.round(volumen*100)/100);
		
		return volumenConValorAproximado;		
	}	
}