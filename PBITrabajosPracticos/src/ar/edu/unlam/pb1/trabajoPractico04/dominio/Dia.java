package ar.edu.unlam.pb1.trabajoPractico04.dominio;

public class Dia {

	private int numeroDia;
	
	public Dia(int numeroDia) {
		this.numeroDia = numeroDia;
	}
	
	public String mostrarNombreDelDia() {
		String dia = "";
		
		switch(numeroDia) {
			case 1:
				dia = "Domingo";
				break;
			case 2:
				dia = "Lunes";
				break;
			case 3:
				dia = "Martes";
				break;
			case 4:
				dia = "Mi�rcoles";
				break;
			case 5:
				dia = "Jueves";
				break;
			case 6:
				dia = "Viernes";
				break;
			case 7:
				dia = "S�bado";
				break;
			default:
				dia = "Opci�n incorrecta";
				break;
		}	
		return dia;
	}	
}