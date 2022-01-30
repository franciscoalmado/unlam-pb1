package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public class Tragamonedas {
	
	private Tambor tambor1;
	private Tambor tambor2;
	private Tambor tambor3;
	
	public Tragamonedas() {
		this.tambor1 = new Tambor();
		this.tambor2 = new Tambor();
		this.tambor3 = new Tambor();
	}

	public void girar() {
		this.tambor1.girar();
		this.tambor2.girar();
		this.tambor3.girar();		
	}
	
	public boolean estatus(){
		boolean gano = false;
		if (this.tambor1.getPosicion() == this.tambor2.getPosicion() && this.tambor1.getPosicion() == this.tambor3.getPosicion()) {
			gano = true;
		}
		return gano;
	}
	
	public int getPosicion(Tambor tamborDeseado) {
		return tamborDeseado.getPosicion();
	}
	
	public int getPosicionTambor2() {
		return this.tambor2.getPosicion();
	}
	
	public int getPosicionTambor3() {
		return this.tambor3.getPosicion();
	}
	
	public String toString() {
		return "La posición del tragamonedas es: "+getPosicion(this.tambor1)+"-"+getPosicion(this.tambor2)+"-"+getPosicion(this.tambor3);
	}	
}