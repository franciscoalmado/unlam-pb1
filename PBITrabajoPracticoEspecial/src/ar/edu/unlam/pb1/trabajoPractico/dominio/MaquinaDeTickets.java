package ar.edu.unlam.pb1.trabajoPractico.dominio;

public class MaquinaDeTickets {

	private String codigoDeMaquina;
	private final int CAPACIDAD_MAXIMA_DE_TICKETS;
	private Ticket [] ticketsEnReserva;
	private Ticket [] ticketsVendidos;
	private Ticket ticketNulo;
	private int cantidadDeTicketsEnReserva;
	private int cantidadDeTicketsVendidos;
	private Caja caja; 
	
	public MaquinaDeTickets (String codigoDeMaquina, int cantidadMaximaDeTickets, double importeInicialDeCaja){
		this.codigoDeMaquina = codigoDeMaquina;
		this.CAPACIDAD_MAXIMA_DE_TICKETS = cantidadMaximaDeTickets;
		this.ticketsVendidos = new Ticket[CAPACIDAD_MAXIMA_DE_TICKETS];
		this.ticketsEnReserva = new Ticket[CAPACIDAD_MAXIMA_DE_TICKETS];
		this.ticketNulo = null;
		this.cantidadDeTicketsEnReserva = 0;
		this.cantidadDeTicketsVendidos = 0;
		this.caja = new Caja(importeInicialDeCaja);
	}
	
	public String getCodigoDeMaquina(){
		return this.codigoDeMaquina;
	}
	
	public boolean ingresarTicket(Ticket nuevo) {
		boolean sePudoIngresar = false;
		
		if(this.cantidadDeTicketsEnReserva < this.CAPACIDAD_MAXIMA_DE_TICKETS) {
			ticketsEnReserva[this.cantidadDeTicketsEnReserva++]= nuevo;
			sePudoIngresar = true;
		}
		
		return sePudoIngresar;
	}
	
	public boolean venderTicket() {
		boolean sePudoVender = false;
		
		if(this.cantidadDeTicketsVendidos < this.CAPACIDAD_MAXIMA_DE_TICKETS) {
			this.ticketsVendidos[this.cantidadDeTicketsVendidos++] = this.ticketsEnReserva[0];
			sePudoVender = true;
		}
		eliminarTicketDeLaReserva(this.ticketsEnReserva, this.cantidadDeTicketsEnReserva--);
		
		return sePudoVender;
	}
	
	private void eliminarTicketDeLaReserva(Ticket[] ticket, int cantidadMaximaDeTickets) {
		for(int i=0; i < (cantidadMaximaDeTickets - 1); i++) {
			ticket[i] = ticket[i+1];
		}
		ticket[cantidadMaximaDeTickets - 1] = this.ticketNulo;
	}
	
	public String imprimirTicketsVendidos() {
		String listaDeTicketVendido = "";
		
		for(int i=0; i < this.cantidadDeTicketsVendidos; i++) {
			listaDeTicketVendido += this.ticketsVendidos[i]+"\n";
		}	
		return listaDeTicketVendido;
		
	}
	
	public String verTicketsEnReserva() {
		String listaDeTicketsEnReserva = "";
		
		for(int i=0; i < this.cantidadDeTicketsEnReserva; i++) {
			listaDeTicketsEnReserva += this.ticketsEnReserva[i]+"\n";
		}
		
		return listaDeTicketsEnReserva;
	}
	
	public int getObtenerCantidadDeTicketsVendidos() {
		
		return this.cantidadDeTicketsVendidos;	
	}
	
	public int getObtenerCantidadDeTicketsEnReserva() {
		
		return this.cantidadDeTicketsEnReserva;	
	}

	public Ticket eliminarTicketReserva(int ticketAEliminar) {
		for(int i=0; i < this.ticketsVendidos.length; i++) {
			if(this.ticketsVendidos[i] != null && this.ticketsVendidos[i].getCodigo() == ticketAEliminar) {
				this.ticketsVendidos[i] = null;
			}
		}
		return null;		
	}

	public Ticket eliminarTicketVendido(int ticketAEliminar) {

		for(int i=0; i < this.ticketsVendidos.length; i++) {
			if(this.ticketsVendidos[i] != null && this.ticketsVendidos[i].getCodigo() == ticketAEliminar) {
				this.ticketsVendidos[i] = null;
			}
		}
		return null;
	}
	
	public double calcularSaldoDeVenta(){
		
		double importeTotal = 0.0;
		
		for(int i=0; i < this.ticketsVendidos.length; i++) {
			if(this.ticketsVendidos[i] != null) {
				importeTotal += this.ticketsVendidos[i].getPrecio();
			}
		}		
		return importeTotal;
	}
	
	public double mostrarSaldoEnCaja() {
		double saldoEnCaja = 0.0;
		
		if(this.caja.getMontoInicial() < calcularSaldoDeVenta()) {
			saldoEnCaja = calcularSaldoDeVenta() - this.caja.getMontoInicial();	
		}else {
			saldoEnCaja = this.caja.getMontoInicial() - calcularSaldoDeVenta();	
		}		
		return saldoEnCaja;
	}
}