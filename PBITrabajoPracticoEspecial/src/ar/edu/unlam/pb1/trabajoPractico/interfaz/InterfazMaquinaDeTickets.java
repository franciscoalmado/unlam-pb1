package ar.edu.unlam.pb1.trabajoPractico.interfaz;

import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ar.edu.unlam.pb1.trabajoPractico.dominio.Provincia;
import ar.edu.unlam.pb1.trabajoPractico.dominio.MaquinaDeTickets;
import ar.edu.unlam.pb1.trabajoPractico.dominio.Pasajero;
import ar.edu.unlam.pb1.trabajoPractico.dominio.Ticket;

public class InterfazMaquinaDeTickets {

	static Scanner teclado = new Scanner(System.in);
	static DateTimeFormatter formatoDeFechaYHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static Ticket nuevo;
	private static MaquinaDeTickets maquinaDeTickets;
	private static Pasajero pasajero;
	private static int cantidadMaximaDeTickets = 5;
	private static double montoInicial = 1000.0;
	private static LocalDateTime fechaYHoraDeSalida, fechaYHoraDeRegreso;
	
public static void main(String[] args){
		
		System.out.println("Bienvenido al sistema de venta de tickets de FLECHA BUS");
		
		maquinaDeTickets = new MaquinaDeTickets("BEMATECH-R001", cantidadMaximaDeTickets, montoInicial);
		
		int opcion = -1;
		int salir = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				ingresarTicket(maquinaDeTickets);
				break;
			case 2:
				venderTicket(maquinaDeTickets);
				break;
			case 3:
				System.out.println("Tickets vendidos: ");
				System.out.println(maquinaDeTickets.imprimirTicketsVendidos()+"\n");
				break;
			case 4:
				eliminarTicketVendido(maquinaDeTickets);
				break;
			case 5:
				System.out.println("Tickets en reserva: ");
				System.out.println(maquinaDeTickets.verTicketsEnReserva()+"\n");
				break;
			case 6:
				eliminarTicketReservado(maquinaDeTickets);
			case 7:
				System.out.println("Monto total de ventas: $ "+mostrarMontoTotalDeVentas(maquinaDeTickets));
				break;
			case 8:
				System.out.println("Cantidad de tickets vendidos: "+maquinaDeTickets.getObtenerCantidadDeTicketsVendidos());
				break;
			case 0:
				System.out.println("¡Gracias por preferirnos!");
				break;
			default:
				System.out.println("Opcion Inválida");
				break;
			}
		} while (opcion != salir);	
	}

	private static int seleccionarOpcion() {
		teclado = new Scanner(System.in);
		
		int opcionSeleccionada = -1;
		
		System.out.println("*******************************************");
		System.out.println("Menú de opciones\n");
		System.out.println("1 - Ingresar tickets");
		System.out.println("2 - Vender tickets");
		System.out.println("3 - Imprimir tickets");
		System.out.println("4 - Eliminar tickets vendidos");
		System.out.println("5 - Mostrar tickets en reserva");
		System.out.println("6 - Eliminar tickets en reserva");
		System.out.println("7 - Mostrar monto acumulado de ventas");
		System.out.println("8 - Cantidad de tickets vendidos");
		System.out.println("0 - Salir");
		System.out.println("*******************************************");
		System.out.println("Ingrese una opción");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static void ingresarTicket(MaquinaDeTickets actual) {
		
		nuevo = crearTicket(teclado);
		
		if(actual.ingresarTicket(nuevo) == true) {
			System.out.println("Ingreso satisfactorio");
		}else {
			System.out.println("No se pudo ingresar");
		}
	}
	
	private static Ticket crearTicket(Scanner teclado) {
		
		int ida = 1, idaYVuelta = 2, contador;
		Provincia origen, destino;
		double precio = 0.0;
		
		System.out.println("Ingrese 1: para ticket de ida");
		System.out.println("Ingrese 2: para ticket de ida y vuelta");
		int verificar = teclado.nextInt();
		
		if(verificar == ida) {
			
			origen = elegirOrigen(teclado);
			
			destino = elegirDestino(teclado);
			
			fechaYHoraDeSalida = ingresarFechaYHoraDeSalida(teclado);
			
			pasajero = checkInPasajero(teclado);
			
			precio = obtenerPrecioFinalDelTicket(teclado);
			
			nuevo = new Ticket(origen, destino, fechaYHoraDeSalida, precio, pasajero);
			
			contador = nuevo.getCodigo();
		}
		
		if(verificar == idaYVuelta) {
			
			origen = elegirOrigen(teclado);
			
			destino = elegirDestino(teclado);
			
			fechaYHoraDeSalida = ingresarFechaYHoraDeSalida(teclado);
	
			fechaYHoraDeRegreso = ingresarFechaYHoraDeRegreso(teclado);		
			
			pasajero = checkInPasajero(teclado);
			
			precio = obtenerPrecioFinalDelTicket(teclado);
			
			nuevo = new Ticket(origen, destino, fechaYHoraDeSalida, fechaYHoraDeRegreso, precio, pasajero);
			 
			contador = nuevo.getCodigo();
		}			
		return nuevo;
	}
	
	private static Provincia elegirOrigen(Scanner teclado) {
		Provincia origen = null;
		int elegirOrigen, minimo = 1, maximo = 23;
		
		do {
			System.out.println("Ingrese la Provincia de origen (ejemplo: 1):");
			System.out.println("1. CABA - 2. Buenos Aires - 3. Catamarca - 4. Chaco - 5. Chubut - 6. Corrientes");
			System.out.println("7. Entre Ríos - 8. Formosa - 9. Jujuy - 10. La Pampa - 11. La Rioja - 12. Mendoza");
			System.out.println("13. Misiones - 14. Neuquén - 15. Río Negro - 16. Salta - 17. San Juan - 18. San Luis");
			System.out.println("19. Santa Cruz - 20. Santa Fe - 21. Santiago del Estero - 22. Tierra del Fuego - 23. Tucumán");
			elegirOrigen = teclado.nextInt();	
		} while (elegirOrigen < minimo || elegirOrigen > maximo);
		
		switch(elegirOrigen) {
			case 1:
				origen = Provincia.CABA;
				break;
			case 2:
				origen = Provincia.BUENOS_AIRES;
				break;
			case 3:
				origen = Provincia.CATAMARCA;
				break;
			case 4:
				origen = Provincia.CHACO;
				break;
			case 5:
				origen = Provincia.CHUBUT;
				break;
			case 6:
				origen = Provincia.CORRIENTES;
				break;
			case 7:
				origen = Provincia.ENTRE_RIOS;
				break;
			case 8:
				origen = Provincia.FORMOSA;
				break;
			case 9:
				origen = Provincia.JUJUY;
				break;
			case 10:
				origen = Provincia.LA_PAMPA;
				break;
			case 11:
				origen = Provincia.LA_RIOJA;
				break;
			case 12:
				origen = Provincia.MENDOZA;
				break;
			case 13:
				origen = Provincia.MISIONES;
				break;
			case 14:
				origen = Provincia.NEUQUEN;
				break;
			case 15:
				origen = Provincia.RIO_NEGRO;
				break;
			case 16:
				origen = Provincia.SALTA;
				break;
			case 17:
				origen = Provincia.SAN_JUAN;
				break;
			case 18:
				origen = Provincia.SAN_LUIS;
				break;
			case 19:
				origen = Provincia.SANTA_CRUZ;
				break;
			case 20:
				origen = Provincia.SANTA_CRUZ;
				break;
			case 21:
				origen = Provincia.SANTIAGO_DEL_ESTERO;
				break;
			case 22:
				origen = Provincia.TIERRA_DEL_FUEGO;
				break;
			case 23:
				origen = Provincia.TUCUMAN;
				break;
		}
		return origen;
	}
	
	private static Provincia elegirDestino(Scanner teclado) {
		Provincia destino = null;
		int elegirDestino, minimo = 1, maximo = 23;
		
		do {
			System.out.println("Ingrese la Provincia de destino (ejemplo: 7):");
			System.out.println("1. CABA - 2. Buenos Aires - 3. Catamarca - 4. Chaco - 5. Chubut - 6. Corrientes");
			System.out.println("7. Entre Ríos - 8. Formosa - 9. Jujuy - 10. La Pampa - 11. La Rioja - 12. Mendoza");
			System.out.println("13. Misiones - 14. Neuquén - 15. Río Negro - 16. Salta - 17. San Juan - 18. San Luis");
			System.out.println("19. Santa Cruz - 20. Santa Fe - 21. Santiago del Estero - 22. Tierra del Fuego - 23. Tucumán");
			elegirDestino = teclado.nextInt();	
		} while (elegirDestino < minimo || elegirDestino > maximo);
		
		switch(elegirDestino) {
			case 1:
				destino = Provincia.CABA;
				break;
			case 2:
				destino = Provincia.BUENOS_AIRES;
				break;
			case 3:
				destino = Provincia.CATAMARCA;
				break;
			case 4:
				destino = Provincia.CHACO;
				break;
			case 5:
				destino = Provincia.CHUBUT;
				break;
			case 6:
				destino = Provincia.CORRIENTES;
				break;
			case 7:
				destino = Provincia.ENTRE_RIOS;
				break;
			case 8:
				destino = Provincia.FORMOSA;
				break;
			case 9:
				destino = Provincia.JUJUY;
				break;
			case 10:
				destino = Provincia.LA_PAMPA;
				break;
			case 11:
				destino = Provincia.LA_RIOJA;
				break;
			case 12:
				destino = Provincia.MENDOZA;
				break;
			case 13:
				destino = Provincia.MISIONES;
				break;
			case 14:
				destino = Provincia.NEUQUEN;
				break;
			case 15:
				destino = Provincia.RIO_NEGRO;
				break;
			case 16:
				destino = Provincia.SALTA;
				break;
			case 17:
				destino = Provincia.SAN_JUAN;
				break;
			case 18:
				destino = Provincia.SAN_LUIS;
				break;
			case 19:
				destino = Provincia.SANTA_CRUZ;
				break;
			case 20:
				destino = Provincia.SANTA_CRUZ;
				break;
			case 21:
				destino = Provincia.SANTIAGO_DEL_ESTERO;
				break;
			case 22:
				destino = Provincia.TIERRA_DEL_FUEGO;
				break;
			case 23:
				destino = Provincia.TUCUMAN;
				break;
		}
		return destino;
	}
	
	private static LocalDateTime ingresarFechaYHoraDeSalida(Scanner teclado) {
		String itinerarioDeSalida;
		LocalDateTime fechaYHoraDeSalidaConvertidaALocalDateTime, fechaYHoraDeHoy = LocalDateTime.now();
		
		System.out.println("Disponiblidad fecha y hora de salida: ");
		System.out.println("1. La fecha ingresada debe ser igual o mayor al día de hoy");
		System.out.println("2. La hora ingresada debe ser mayor a la hora actual \n");
		
		do {
			String anio = verificarAnio(teclado);
			String mes = verificarMes(teclado);
			String dia = verificarDia(teclado);
			String hora = verificarHora(teclado);
			String minutos = verificarMinutos(teclado);

			itinerarioDeSalida = anio+"-"+mes+"-"+dia+" "+hora+":"+minutos+":00";
			fechaYHoraDeSalidaConvertidaALocalDateTime = LocalDateTime.parse(itinerarioDeSalida, formatoDeFechaYHora);	
			
		}while(fechaYHoraDeSalidaConvertidaALocalDateTime.compareTo(fechaYHoraDeHoy) < 0);
        	
		return fechaYHoraDeSalidaConvertidaALocalDateTime;
	}
	
	private static LocalDateTime ingresarFechaYHoraDeRegreso(Scanner teclado) {
		String itinerarioDeRegreso;
		LocalDateTime fechaYHoraDeRegresoConvertidaALocalDateTime, fechaYHoraDeHoy = LocalDateTime.now();
	
		System.out.println("Disponiblidad fecha y hora de regreso: ");
		System.out.println("1. La fecha ingresada debe ser mayor a la fecha de salida");
		
		do {
			String anio = verificarAnio(teclado);
			String mes = verificarMes(teclado);
			String dia = verificarDia(teclado);
			String hora = verificarHora(teclado);
			String minutos = verificarMinutos(teclado);
				
			itinerarioDeRegreso = anio+"-"+mes+"-"+dia+" "+hora+":"+minutos+":00";
			fechaYHoraDeRegresoConvertidaALocalDateTime = LocalDateTime.parse(itinerarioDeRegreso, formatoDeFechaYHora);			
		
		}while(fechaYHoraDeRegresoConvertidaALocalDateTime.compareTo(fechaYHoraDeHoy) < 0 && fechaYHoraDeRegresoConvertidaALocalDateTime.compareTo(ingresarFechaYHoraDeRegreso(teclado)) > 0);
        	
		return fechaYHoraDeRegresoConvertidaALocalDateTime;
	}
		
	private static Pasajero checkInPasajero(Scanner teclado) {
		int menorDeEdad = 13;
		int edadAdolescente = 17;
		
		System.out.println("Ingrese dni:");
		int dni = teclado.nextInt();
		System.out.println("Ingrese nombre:");
		String nombre = teclado.next();
		System.out.println("Ingrese apellido:");
		String apellido = teclado.next();
		System.out.println("Ingrese edad:");
		int edad = teclado.nextInt();
		if(edad < menorDeEdad) {
			System.out.println("La persona es menor de edad, no puede viajar sola.");
			System.out.println("Debe viajar en compañía de uno o ambos de sus padres y/o un representantes.");
		}
		if(edad >= menorDeEdad  && edad <= edadAdolescente) {
			System.out.println("La persona puede viajar con autorización, de uno o ambos padres.");
		}
		
		pasajero = new Pasajero (dni, nombre, apellido, edad);
			
		return pasajero;
	}
	
	private static double obtenerPrecioFinalDelTicket(Scanner teclado) {
		double precioNominal = 0.0, precioFinal = 0.0, precioFinal1 = 0.0, precioFinal2 = 0.0; 
		double descuentoPorDiaEspecial = 0.20, descuentoPorJubilado = 0.60, descuentoPorEdadEspecial = 0.15;
		int edadJubilado = 65, edadNinio = 6, edadEspecial = 12;
		
		System.out.println("Ingrese precio:");
		precioNominal = teclado.nextDouble();
		
		if(pasajero.getEdad() > edadEspecial && pasajero.getEdad() < edadJubilado) {
			precioFinal = precioNominal;
		}
		if(fechaYHoraDeSalida.getDayOfWeek() == DayOfWeek.TUESDAY && pasajero.getEdad() > edadEspecial && pasajero.getEdad() < edadJubilado) {
			precioFinal = precioNominal - (precioNominal * descuentoPorDiaEspecial);
		}	
		if(pasajero.getEdad() >= edadJubilado) {
			precioFinal = precioNominal - (precioNominal * descuentoPorJubilado);
		}
		if(fechaYHoraDeSalida.getDayOfWeek() == DayOfWeek.TUESDAY && pasajero.getEdad() >= edadJubilado) {
			precioFinal1 = precioNominal - (precioNominal * descuentoPorDiaEspecial);
			precioFinal2 = precioNominal - (precioNominal * descuentoPorJubilado);
			if(precioFinal1 > precioFinal2) {
				precioFinal = precioFinal1;
			}else {
				precioFinal = precioFinal2;
			}
		}
		if(pasajero.getEdad() <= edadNinio) {
			precioFinal = 0.0;
		}
		if(pasajero.getEdad() > edadNinio && pasajero.getEdad() <= edadEspecial) {
			precioFinal = precioNominal - (precioNominal * descuentoPorEdadEspecial);
		}
		if(fechaYHoraDeSalida.getDayOfWeek() == DayOfWeek.TUESDAY && pasajero.getEdad() >= edadEspecial) {
			precioFinal1 = precioNominal - (precioNominal * descuentoPorDiaEspecial);	
			precioFinal2 = precioNominal - (precioNominal * descuentoPorEdadEspecial);
			if(precioFinal1 > precioFinal2) {
				precioFinal = precioFinal1;
			}else {
				precioFinal = precioFinal2;
			}
		}
		
		return precioFinal;
	}
	
	private static void venderTicket(MaquinaDeTickets actual) {
		
		if(actual.venderTicket() == true) {
			System.out.println("Venta satisfactoria");
		}else {
			System.out.println("No se pudo vender");
		}
	}
	
	private static void eliminarTicketVendido(MaquinaDeTickets actual) {
		int codigo;
		
		System.out.println("Ingrese un código de ticket:");
		codigo = teclado.nextInt();
		
		Ticket ticketEliminado = actual.eliminarTicketVendido(codigo);
		
		if(ticketEliminado == null) {
			System.out.println("El ticket se eliminó correctamente");
		}else {
			System.out.println("El ticket no se pudo eliminar");
		}
	}
	
	private static void eliminarTicketReservado(MaquinaDeTickets actual) {
		int codigo;
		
		System.out.println("Ingrese un código de ticket:");
		codigo = teclado.nextInt();
		
		Ticket ticketEliminado = actual.eliminarTicketReserva(codigo);
		
		if(ticketEliminado == null) {
			System.out.println("El ticket se eliminó correctamente");
		}else {
			System.out.println("El ticket no se pudo eliminar");
		}
	}
	
	private static double mostrarMontoTotalDeVentas(MaquinaDeTickets actual){
		double importe;
		
		importe = actual.calcularSaldoDeVenta();
		
		return importe;
	}
	
	private static String verificarAnio(Scanner teclado) {
		String anioActual = "2021";
		String anioVenidero = "2022";
		String anioTexto = "";
		String anioIngresado = "";
		int validacion = 0;
		
		do {
			System.out.println("Ingrese el año (ejemplo: 2021):");
			anioIngresado = teclado.next();
			if(anioActual.compareTo(anioIngresado) == validacion || anioVenidero.compareTo(anioIngresado) == validacion && anioIngresado.length() == 4) {
				anioTexto = anioIngresado;
				break;
			}else {
				System.out.println("Por favor, ingrese un valor de año válido.");
			}
		}while(anioActual.compareTo(anioIngresado) != validacion || anioVenidero.compareTo(anioIngresado) != validacion || anioIngresado.length() != 4);
			
		return anioTexto;
	}

	private static String verificarMes(Scanner teclado) {
		String mesTexto = "";
		int mesIngresado = 0;
		
		do {
			System.out.println("Ingrese el mes (ejemplo: 1 ó 10)");
			mesIngresado = teclado.nextInt();
			if(mesIngresado > 0 && mesIngresado <= 9) {		
				mesTexto = "0"+String.valueOf(mesIngresado);
				break;
			}
			if(mesIngresado >= 10 && mesIngresado <= 12) {		
				mesTexto = String.valueOf(mesIngresado);
				break;
			}
			else {
				System.out.println("Por favor, ingrese un valor de mes válido.");				
			}
		}while(mesIngresado >= 13 || mesIngresado <= 0);
			
		return mesTexto;
	}
	
	private static String verificarDia(Scanner teclado) {
		String diaTexto = "";
		int diaIngresado = 0;
		
		do {
			System.out.println("Ingrese el día (ejemplo: 1 ó 26)");
			diaIngresado = teclado.nextInt();
			if(diaIngresado > 0 && diaIngresado < 10) {		
				diaTexto = "0"+String.valueOf(diaIngresado);
				break;
			}
			if(diaIngresado >= 10 && diaIngresado <= 31) {
				diaTexto = String.valueOf(diaIngresado);
				break;
			}
			else {
				System.out.println("Por favor, ingrese un valor de día válido.");				
			}
		}while(diaIngresado >= 32 || diaIngresado <= 0);
		
		return diaTexto;
	}
	
	private static String verificarHora(Scanner teclado) {
		String horaTexto = "";
		int horaIngresada = 0;
	
		do {
			System.out.println("Ingrese la hora (ejemplo: 9 ó 18)");
			horaIngresada = teclado.nextInt();
			if(horaIngresada >= 0 && horaIngresada <= 9) {		
				horaTexto = "0"+String.valueOf(horaIngresada);
				break;
			}
			if(horaIngresada > 9 && horaIngresada < 24) {		
				horaTexto = String.valueOf(horaIngresada);
				break;
			}
			else {
				System.out.println("Por favor, ingrese un valor de hora válido.");				
			}
		}while(horaIngresada >= 24 || horaIngresada < 0);
		
		return horaTexto;
	}
	
	private static String verificarMinutos(Scanner teclado) {
		String minutosTexto = "";
		int minutosIngresados = 0;
	
		do {
			System.out.println("Ingrese los minutos (ejemplo: 0 ó 35)");
			minutosIngresados = teclado.nextInt();
			if(minutosIngresados >= 0 && minutosIngresados <= 9) {		
				minutosTexto = "0"+String.valueOf(minutosIngresados);
				break;
			}
			if(minutosIngresados >= 10 && minutosIngresados < 60) {		
				minutosTexto = String.valueOf(minutosIngresados);
				break;
			}
			else {
				System.out.println("Por favor, ingrese un valor de minutos válido.");				
			}
		}while(minutosIngresados >= 60 || minutosIngresados < 0);
		
		return minutosTexto;
	}
}