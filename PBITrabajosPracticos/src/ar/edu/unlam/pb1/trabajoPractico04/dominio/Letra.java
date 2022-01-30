package ar.edu.unlam.pb1.trabajoPractico04.dominio;

public class Letra {

	private char letraActual;
	
	public Letra(char letraActual) {
		this.letraActual = letraActual;
	}
	
	public boolean esVocal() {
		boolean resultado = false;
		
		switch(this.letraActual) {
		
			case 'a':
			case 'A':
			case 'e':
			case 'E':
			case 'i':
			case 'I':
			case 'o':
			case 'O':
			case 'U':
			case 'u':
				resultado = true;
				break;
		}
		return resultado;
	}
}