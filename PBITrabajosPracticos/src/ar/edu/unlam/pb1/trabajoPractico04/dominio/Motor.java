package ar.edu.unlam.pb1.trabajoPractico04.dominio;

public class Motor {

	private int tipoBomba;
	private String tipoFluido;
	private String combustible;
	private final int VALOR_NO_DEFINIDO = 0;
	private final int BOMBA_DE_AGUA = 1;
	private final int BOMBA_DE_GASOLINA = 2;
	private final int BOMBA_DE_HORMIGON = 3;
	private final int BOMBA_DE_PASTA_ALIMENTICIA = 4;
	
	public Motor(int tipoBomba, String tipoFluido, String combustible) {
		this.tipoBomba = tipoBomba;
		this.tipoFluido = tipoFluido;
		this.combustible = combustible;
	}
	
	public String dimeTipoMotor(int tipoDeMotor) {
		String mensaje = "";
		
		switch(tipoDeMotor) {
		case VALOR_NO_DEFINIDO:
			mensaje = "No hay establecido un valor definido para el tipo de bomba.";
			break;
		case BOMBA_DE_AGUA:
			mensaje = "La bomba es una bomba de agua.";
			break;
		case BOMBA_DE_GASOLINA:
			mensaje = "La bomba es una bomba de gasolina.";
			break;
		case BOMBA_DE_HORMIGON:
			mensaje = "La bomba es una bomba de hormigón.";
			break;
		case BOMBA_DE_PASTA_ALIMENTICIA:
			mensaje = "La bomba es una bomba de pasta alimenticia.";
			break;
		default:
			mensaje = "No existe un valor válido para tipo de bomba.";
			break;
		}
		return mensaje;	
	}
	
	public int getTipoBomba() {
		return this.tipoBomba;
	}

	public void setTipoBomba(int tipoBomba) {
		this.tipoBomba = tipoBomba;
	}

	public String getTipoFluido() {
		return this.tipoFluido;
	}

	public void setTipoFluido(String tipoFluido) {
		this.tipoFluido = tipoFluido;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
}