package ar.edu.unlam.pb1.trabajoPractico02.dominio;

public class Circulo {

	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double calcularElArea() {
		double areaDelCirculo = 0.0;
		
		areaDelCirculo = Math.PI * this.radio;
		
		return areaDelCirculo;
	}
	
	public double calcularElPerimetro() {
		double perimetroDelCirculo = 0.0;
		
		perimetroDelCirculo = 2 * this.radio * Math.PI;
		
		return perimetroDelCirculo;
	}
}