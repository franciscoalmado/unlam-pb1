package ar.edu.unlam.pb1.trabajoPractico08.dominio;

public class Dia {

	private int numeroDia;
	
	public Dia(int numeroDia) {
		this.numeroDia = numeroDia;
	}
	
	public String mostrarNombreDelDia() {
		String dia = "";
				
		switch(numeroDia) {
			case 1:
				dia = DiasDeLaSemana.DOMINGO.getDia();
				break;
			case 2:
				dia = DiasDeLaSemana.LUNES.getDia();
				break;
			case 3:
				dia = DiasDeLaSemana.MARTES.getDia();
				break;
			case 4:
				dia = DiasDeLaSemana.MIERCOLES.getDia();
				break;
			case 5:
				dia = DiasDeLaSemana.JUEVES.getDia();
				break;
			case 6:
				dia = DiasDeLaSemana.VIERNES.getDia();
				break;
			case 7:
				dia = DiasDeLaSemana.SABADO.getDia();
				break;
			default:
				dia = "Día no válido";
		}			
		return dia;
	}
}