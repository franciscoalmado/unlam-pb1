package ar.edu.unlam.pb1.trabajoPractico06.dominio;

public class Destornillador {

	private final char TIPO_DE_CABEZA;

	public Destornillador(char tipoDeCabeza) {
		this.TIPO_DE_CABEZA = tipoDeCabeza;
	}

	public void atornillar(Tornillo tornillo) {
		boolean sePudoGirar = true;
		
		if (this.TIPO_DE_CABEZA == tornillo.getTipoCabeza()) {
			do {
				sePudoGirar = tornillo.girar(Tornillo.SENTIDO_HORARIO);		
			}while(sePudoGirar);		
		}
	}

	public void desatornillar(Tornillo tornillo) {
		boolean sePudoGirar = true;
		
		if (this.TIPO_DE_CABEZA == tornillo.getTipoCabeza()) {
			do {
				sePudoGirar = tornillo.girar(Tornillo.SENTIDO_ANTIHORARIO);		
			}while(sePudoGirar);		
		}
	}
	
	public void atornillar(Tornillo tornillo, Tarugo tarugo) {
		boolean sePudoGirar = true;
		
		if (this.TIPO_DE_CABEZA == tornillo.getTipoCabeza()) {
			do {
				sePudoGirar = tornillo.girar(Tornillo.SENTIDO_HORARIO);		
			}while(sePudoGirar && tornillo.getLongitud() <= tarugo.getLongitud());		
		}
	}

	public void desatornillar(Tornillo tornillo, Tarugo tarugo) {
		boolean sePudoGirar = true;
		
		if (this.TIPO_DE_CABEZA == tornillo.getTipoCabeza()) {
			do {
				sePudoGirar = tornillo.girar(Tornillo.SENTIDO_ANTIHORARIO);		
			}while(sePudoGirar && tornillo.getLongitud() > tarugo.getLongitud());		
		}
	}
}