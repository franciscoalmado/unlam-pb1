package ar.edu.unlam.pb1.trabajoPractico.dominio;

import java.time.LocalDateTime;

public class Ticket {

	private static int contador = 0;
	private int codigo;
	private Provincia origen;
	private Provincia destino;
	private LocalDateTime fechaYHoraDeSalida;
	private LocalDateTime fechaYHoraDeRegreso;
	private String horaDeSalida;
	private String horaDeRegreso;
	private double precio;
	private Pasajero pasajero;
	
	public Ticket(Provincia origen, Provincia destino, LocalDateTime fechaYHoraDeSalida, LocalDateTime fechaYHoraDeRegreso, double precio, Pasajero pasajero){
		Ticket.contador++;
		this.codigo = contador;
		this.origen = origen;
		this.destino = destino;
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
		this.fechaYHoraDeRegreso = fechaYHoraDeRegreso;
		this.precio = precio;
		this.pasajero = pasajero;	
	}
	
	public Ticket(Provincia origen, Provincia destino, LocalDateTime fechaYHoraDeSalida, double precio, Pasajero pasajero){
		Ticket.contador++;
		this.codigo = contador;
		this.origen = origen;
		this.destino = destino;
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
		this.precio = precio;
		this.pasajero = pasajero;
	}
    
	public int getCodigo(){	
		return Ticket.contador;
	}
	
	public Provincia getOrigen(){
		return this.origen;
	}
	
	public void setOrigen(int valor) {
		
		switch(valor) {
		case 1:
			this.origen = Provincia.CABA;
			break;
		case 2:
			this.origen = Provincia.BUENOS_AIRES;
			break;
		case 3:
			this.origen = Provincia.CATAMARCA;
			break;
		case 4:
			this.origen = Provincia.CHACO;
			break;
		case 5:
			this.origen = Provincia.CHUBUT;
			break;
		case 6:
			this.origen = Provincia.CORRIENTES;
			break;
		case 7:
			this.origen = Provincia.ENTRE_RIOS;
			break;
		case 8:
			this.origen = Provincia.FORMOSA;
			break;
		case 9:
			this.origen = Provincia.JUJUY;
			break;
		case 10:
			this.origen = Provincia.LA_PAMPA;
			break;
		case 11:
			this.origen = Provincia.LA_RIOJA;
			break;
		case 12:
			this.origen = Provincia.MENDOZA;
			break;
		case 13:
			this.origen = Provincia.MISIONES;
			break;
		case 14:
			this.origen = Provincia.NEUQUEN;
			break;
		case 15:
			this.origen = Provincia.RIO_NEGRO;
			break;
		case 16:
			this.origen = Provincia.SALTA;
			break;
		case 17:
			this.origen = Provincia.SAN_JUAN;
			break;
		case 18:
			this.origen = Provincia.SAN_LUIS;
			break;
		case 19:
			this.origen = Provincia.SANTA_CRUZ;
			break;
		case 20:
			this.origen = Provincia.SANTA_FE;
			break;
		case 21:
			this.origen = Provincia.SANTIAGO_DEL_ESTERO;
			break;
		case 22:
			this.origen = Provincia.TIERRA_DEL_FUEGO;
			break;
		case 23:
			this.origen = Provincia.TUCUMAN;
			break;
			}
	}
	
	public Provincia getDestino(){
		return this.destino;
	}
	
	public void setDestino(int valor){
		
		switch(valor) {
		case 1:
			this.destino = Provincia.CABA;
			break;
		case 2:
			this.destino = Provincia.BUENOS_AIRES;
			break;
		case 3:
			this.destino = Provincia.CATAMARCA;
			break;
		case 4:
			this.destino = Provincia.CHACO;
			break;
		case 5:
			this.destino = Provincia.CHUBUT;
			break;
		case 6:
			this.destino = Provincia.CORRIENTES;
			break;
		case 7:
			this.destino = Provincia.ENTRE_RIOS;
			break;
		case 8:
			this.destino = Provincia.FORMOSA;
			break;
		case 9:
			this.destino = Provincia.JUJUY;
			break;
		case 10:
			this.destino = Provincia.LA_PAMPA;
			break;
		case 11:
			this.destino = Provincia.LA_RIOJA;
			break;
		case 12:
			this.destino = Provincia.MENDOZA;
			break;
		case 13:
			this.destino = Provincia.MISIONES;
			break;
		case 14:
			this.destino = Provincia.NEUQUEN;
			break;
		case 15:
			this.destino = Provincia.RIO_NEGRO;
			break;
		case 16:
			this.destino = Provincia.SALTA;
			break;
		case 17:
			this.destino = Provincia.SAN_JUAN;
			break;
		case 18:
			this.destino = Provincia.SAN_LUIS;
			break;
		case 19:
			this.destino = Provincia.SANTA_CRUZ;
			break;
		case 20:
			this.destino = Provincia.SANTA_FE;
			break;
		case 21:
			this.destino = Provincia.SANTIAGO_DEL_ESTERO;
			break;
		case 22:
			this.destino = Provincia.TIERRA_DEL_FUEGO;
			break;
		case 23:
			this.destino = Provincia.TUCUMAN;
			break;
		}
	}
	
	public LocalDateTime getFechaDeSalida(){
		return this.fechaYHoraDeSalida;
	}
	
	public void setFechaDeSalida(LocalDateTime fechaYHoraDeSalida){
		this.fechaYHoraDeSalida = fechaYHoraDeSalida;
	}
	
	public LocalDateTime getFechaDeRegreso(){
		return this.fechaYHoraDeRegreso;
	}
	
	public void setFechaDeRegreso(LocalDateTime fechaYHoraDeRegreso){
		this.fechaYHoraDeRegreso = fechaYHoraDeRegreso;
	}
	
	public String getHoraDeSalida(){
		return this.horaDeSalida;
	}
	
	public void setHoraDeSalida(String hora){
		this.horaDeSalida = hora;
	}
	
	public String getHoraDeRegreso(){
		return this.horaDeRegreso;
	}
	
	public void setHoraDeRegreso(String hora){
		this.horaDeRegreso = hora;
	}
	
	public double getPrecio(){
		return this.precio;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "==========================================================================="+"\n"
				+"                               FLECHA BUS"+"\n"
				+"==========================================================================="+"\n"
				+"                                                 Código de venta: "+this.codigo+"\n"
				+"\n"
				+"\n"
				+" Origen: "+this.origen+" Destino: "+this.destino+"\n"
				+" Ida: " +this.fechaYHoraDeSalida+" Vuelta: "+this.fechaYHoraDeRegreso+"\n"
				+" Pasajero: "+this.pasajero+"\n"
				+"\n"
				+"\n"
				+"                                                     PRECIO: "+this.precio+" $ "+"\n"
				+"\n"
				+"\n"
				+"\n"
				+"                                             "+LocalDateTime.now()+"\n"
				+"\n"
				+"\n"
				+"                  ***¡Muchas gracias por su compra!***"+"\n"
				+"                  ***¡Buen viaje y pronto regreso!***"+"\n"
				+"===========================================================================";
	}	
}