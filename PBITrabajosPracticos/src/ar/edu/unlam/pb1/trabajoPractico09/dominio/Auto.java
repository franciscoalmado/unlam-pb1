package ar.edu.unlam.pb1.trabajoPractico09.dominio;

public class Auto {

	private String marca;
	private String modelo;
	private static int contador = 0;
	private int codigo;

	public Auto(String marca, String modelo) {
		Auto.contador++;
		this.codigo = contador;
		this.marca = marca;
		this.modelo = modelo;
	}

	public int getCodigo(){	
		return this.codigo;
	}
	
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Código del auto: "+this.codigo+" Marca: "+this.marca+" Modelo: "+this.modelo;
	}	
}