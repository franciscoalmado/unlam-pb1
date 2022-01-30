package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public class Password {
	private int LONGITUD;
	private String password;

	public Password() {
		generarPassword();
	}

	public Password(int longitud) {
		this.LONGITUD = longitud;
		generarPassword();
	}

	private String generarPassword() {
		int comienzoASCII = 48;
		int finASCII = 122;
		int valorRandom;
		int contador = 0;
		String nuevaContrasenia = "";

		while(contador < this.LONGITUD){
			do {
				valorRandom = (int) ((Math.random() * finASCII) + comienzoASCII);
			}while(!((esNumero(valorRandom) || esMayuscula(valorRandom) || esMinuscula(valorRandom))));

			valorRandom = (char) valorRandom;
			nuevaContrasenia += String.valueOf((char) valorRandom);
			contador++;
		}
		this.password = nuevaContrasenia;
		return this.password;
	}

	private boolean esNumero(int valorATestear) {
		return ((valorATestear > 47) && (valorATestear < 58));
	}

	private boolean esMayuscula(int valorATestear) {
		return ((valorATestear > 64) && (valorATestear < 91));
	}
	
	private boolean esMinuscula(int valorATestear) {
		return ((valorATestear > 96) && (valorATestear < 123));
	}

	public boolean esFuerte() {
		int contadorMayusculas = 0;
		int contadorDeMinusculas = 0;
		int contadorDeNumeros = 0;

		for(int i = 0; i < this.LONGITUD; i++){
			if(esMayuscula((int) (this.password.charAt(i)))) {
				contadorMayusculas++;
			}
			if(esMinuscula((int) (this.password.charAt(i)))) {
				contadorDeMinusculas++;
			}
			if(esNumero((int) (this.password.charAt(i)))) {
				contadorDeNumeros++;
			}
		}
		return ((contadorMayusculas > 2) && (contadorDeMinusculas > 1) && (contadorDeNumeros > 5));
	}

	public String getPassword() {
		return this.password;
	}

	public int getLongitud() {
		return this.LONGITUD;
	}

	public void setLongitud(int longitud) {
		this.LONGITUD = longitud;
	}
}