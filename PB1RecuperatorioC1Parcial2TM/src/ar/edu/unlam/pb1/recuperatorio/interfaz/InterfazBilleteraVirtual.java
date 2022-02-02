package ar.edu.unlam.pb1.recuperatorio.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.recuperatorio.dominio.BilleteraVirtual;
import ar.edu.unlam.pb1.recuperatorio.dominio.Operacion;
import ar.edu.unlam.pb1.recuperatorio.dominio.Operador;
import ar.edu.unlam.pb1.recuperatorio.dominio.Transaccion;

public class InterfazBilleteraVirtual {

	static Scanner teclado = new Scanner(System.in);
	private static Operador operador = new Operador("","","","", false);
	private static Transaccion transaccion;
	private static BilleteraVirtual binAnce = new BilleteraVirtual("Bin Ance");
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenido a la billetera Bin Ance.");
		
		int opcion = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				darDeAltaUnOperador();
				break;
			case 2: 
				// TODO: Si no esta autenticado, no puede realizar las siguiente operaciones. Se debe mostrar el nombre y apellido
				iniciarSesion(operador);
				mostarNombreYApellidoDelOperador();
				break;
			case 3:
				// TODO: Mostrar mensaje en caso de éxito o error
				comprarCriptomonedas(binAnce);
				break;
			case 4:
				// TODO: Mostrar mensaje en caso de éxito o error
				venderCriptomonedas(binAnce);
				break;
			case 5:
				informarSaldoDeCriptomonedas(binAnce);
				break;
			case 6:
				informarTransaccionDeMayorMonto(binAnce);
				break;
			case 7:
				listarTransaccionesDeMayorAMenor(binAnce);
				break;
			case 9:
				// TODO: Se debe cerrar la sesión del operador
				System.out.println("Muchas gracias por preferirnos.");
				break;
			default:
				System.out.println("Opción Inválida");
				break;
			}

		} while (opcion != 9);
		
		System.out.println("¡Hasta pronto!");
	}
	
	private static int seleccionarOpcion() {
		
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menú de Transacciones Virtuales\n");
		System.out.println("1 - Dar de alta un Operador ");
		System.out.println("2 - Iniciar sesión"); 
		System.out.println("3 - Comprar Criptomoneda"); 
		System.out.println("4 - Vender Criptomoneda");
		System.out.println("5 - Informar el saldo de criptomonedas");
		System.out.println("6 - Informar la transacción de criptomonedas de mayor monto");
		System.out.println("7 - Listar las transacciones de criptomonedas ordenadas descendentemente");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opción");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	private static Operador darDeAltaUnOperador() {
		/*
		 *  Interfaz de usuario encargada de dar de alta a un Operador
		 */
		String nombre, apellido, nickName, contrasenia;
		
		System.out.println("Ingrese el nombre:");
		nombre = teclado.next();
		System.out.println("Ingrese el apellido:");
		apellido = teclado.next();
		System.out.println("Ingrese el usuario:");
		nickName = teclado.next();
		System.out.println("Ingrese la contraseña:");
		contrasenia = teclado.next();	
		
		operador = new Operador(nombre,apellido,nickName,contrasenia,false);
		
		return operador;
	}

	private static void iniciarSesion(Operador operador) {
		/*
		 *  Interfaz de usuario encargada de:
		 *  - Iniciar sesión.
		 *  - Autenticar usuario. 
		 *  - Mostrar nombre y apellido del usuario.
		 */		
		String nombre, apellido, nickName, contrasenia;
		
		System.out.println("Ingrese su usuario:");
		nickName = teclado.next();
		
		System.out.println("Ingrese su contraseña:");
		contrasenia = teclado.next();
		
		nombre = operador.getNombre();
		apellido = operador.getApellido();
		
		operador = new Operador(nombre,apellido,nickName,contrasenia,false);

		if(operador.iniciarSesion(nickName, contrasenia) == true) {
			System.out.println("Se inicia sesión satisfactoriamente");
			if(operador.estaAutenticado() == true) {
				System.out.println("El usuario se encuentra autenticado");	
			}
			if(operador.estaHabilitadoParaRealizarTransacciones() == true) {
				System.out.println("El usuario se encuentra habilitado para realizar transacciones");	
			}
		}else {
			System.out.println("No se pudo iniciar sesión, inténtelo de nuevo");
		}	
	}
	
	private static void mostarNombreYApellidoDelOperador() {
		
		System.out.println("Bienvenido: "+operador.toString());		
	}
	
	private static void comprarCriptomonedas(BilleteraVirtual binAnce) {
		/*
		 *  Interfaz de usuario encargada de comprar Criptomoneda.
		 */		
		int cantidad = 0;
		boolean sePuedeComprar = false;
		boolean resultado = false;
		double valor = 0.0;
		
		System.out.println("Ingrese cantidad de Criptomonedas a comprar:");
		cantidad = teclado.nextInt();
		
		sePuedeComprar = binAnce.comprarVenderCriptomoneda(cantidad);
		
		valor = binAnce.calcularValorDeLaOperacion(cantidad);
		
		transaccion = new Transaccion(Operacion.COMPRA, cantidad, valor);
		
		resultado = binAnce.realizarNuevaOperacion(transaccion);
		
		if(operador.estaAutenticado() == true && sePuedeComprar == true && resultado == true) {
			System.out.println("Compra exitosa");
		}else {
			System.out.println("No se pudo completar la compra");
		}
	}
	
	private static void venderCriptomonedas(BilleteraVirtual binAnce) {
		/*
		 *  Interfaz de usuario encargada de vender Criptomoneda.
		 */	
		int cantidad = 0;
		boolean sePuedeVender = false;
		boolean resultado = false;
		double valor = 0.0;
		
		System.out.println("Ingrese cantidad de Criptomonedas a vender:");
		cantidad = teclado.nextInt();
		
		sePuedeVender = binAnce.comprarVenderCriptomoneda(cantidad);
		
		valor = binAnce.calcularValorDeLaOperacion(cantidad);
		
		transaccion = new Transaccion(Operacion.VENTA, cantidad, valor);
		
		resultado = binAnce.realizarNuevaOperacion(transaccion);
		
		if(operador.estaAutenticado() == true && sePuedeVender == true && resultado == true) {
			System.out.println("Venta exitosa");
		}else {
			System.out.println("No se pudo completar la venta");
		}
	}
	
	private static void informarSaldoDeCriptomonedas(BilleteraVirtual binAnce) {
		/*
		 *  Interfaz de usuario encargada informar saldo de criptomonedas.
		 */
		System.out.println("Su saldo de criptomoneda es: "+binAnce.obtenerSaldoActual());
	}
	
	private static void informarTransaccionDeMayorMonto(BilleteraVirtual binAnce) {
		/*
		 *  Interfaz de usuario encargada informar la transacción de mayor monto.
		 */	
		System.out.println("Transacción de mayor monto: \n");
		System.out.println(binAnce.obtenerTransaccionMayorMonto());
	}

	private static void listarTransaccionesDeMayorAMenor(BilleteraVirtual binAnce) {
		/*
		 *  Interfaz de usuario encargada de listar las transacciones de criptomedas ordenadas
		 *  descendentemente.
		 */
		
		Transaccion[] ordenarTransaccionesDescendentemente = binAnce.listrarTransaccionesDescendentemente();
		
		System.out.println("Transacciones ordenadas de forma descendente según su valor: \n");
		
		for(int i=0; i < ordenarTransaccionesDescendentemente.length; i++) {
			if(ordenarTransaccionesDescendentemente[i] != null) {
				System.out.println(ordenarTransaccionesDescendentemente[i] + " ");	
			}
		}
	}		
}