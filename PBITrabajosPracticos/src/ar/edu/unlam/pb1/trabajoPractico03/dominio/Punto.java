package ar.edu.unlam.pb1.trabajoPractico03.dominio;

public class Punto {

	private double x;
	private double y;
	public static final double ORIGEN = 0.0;
	
	public Punto(double valorX, double valorY) {
		this.x = valorX;
		this.y = valorY;
	}
	
	public void setX(double valorX) {
		this.x = valorX;
	}
	
	public double getX() {
		return this.x;
	}

	public void setY(double valorY) {
		this.y = valorY;
	}
	
	public double getY() {
		return this.y;
	}
	
	public boolean estaSobreElEjeX() {
		boolean abscisaAlOrigen = false;
		
		if(this.x != ORIGEN && this.y == ORIGEN) {
			abscisaAlOrigen = true;
		}else {
			abscisaAlOrigen = false;
		}
		return abscisaAlOrigen;
	}

	public boolean estaSobreElEjeY() {
		boolean ordenadaAlOrigen = false;
		
		if(this.x == ORIGEN && this.y != ORIGEN) {
			ordenadaAlOrigen = true;
		}else {
			ordenadaAlOrigen = false;
		}
		return ordenadaAlOrigen;
	}
	
	public boolean estaSobreElOrigen() {
		boolean sistemaNulo = false;
		
		if(this.x == ORIGEN && this.y == ORIGEN) {
			sistemaNulo = true;
		}else {
			sistemaNulo = false;
		}
		return sistemaNulo;
	}		
}