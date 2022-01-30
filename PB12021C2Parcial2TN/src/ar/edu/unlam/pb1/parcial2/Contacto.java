package ar.edu.unlam.pb1.parcial2;

import java.util.Arrays;

public class Contacto {	
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * •	Nombre y Apellido: No se aceptan números.
	 * •	Celular: Compuesto del código de país + código de área + número de celular.
	 * •	E-Mail: Debe contener al menos el símbolo ‘@’ y el caracter ‘.’.
	 * •	Dirección: Valor alfanumérico.
	 * •	Código Postal: Valor numérico.
	 * •	Localidad: Valor alfanumérico.
	 * •	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * •	Es cliente (Si o No): Inicialmente se carga en “No”.
	 * •	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en “Si”.
	 */
	private Llamada llamadasRecibidas[];
	private Llamada llamada;
	private int cantidadMaximaDeLlamadas;
	private int cantidadDeLlamadas;
	private boolean esCliente;
	private boolean deseaSerLlamadoNuevamente;
	private String nombre;
	private String apellido;
	private String telefono;
	private String eMail;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private Provincia provincia;
	
	public Contacto(String nombre, String apellido, String telefono, String eMail, String direccion, int codigoPostal, String localidad, Provincia provincia) {
		this.cantidadMaximaDeLlamadas = 3;
		this.llamadasRecibidas = new Llamada[cantidadMaximaDeLlamadas];
		this.llamada = null;
		this.cantidadDeLlamadas = 0;
		this.esCliente = false;
		this.deseaSerLlamadoNuevamente = true;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.eMail = eMail;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public boolean esEmailValido(String eMail) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como E-MAIL.
		 */
		boolean esEmailValido = false;
		int posicion1 = 0;
		int posicion2 = 0;
		int valor = 0;
		int valor1 = 0;
		int valor2 = 0;
		int valor3 = 0;
		String cadena1 = "";
		String cadena2 = "";
		String cadena3 = "";
		
		for(int i = 0; i < eMail.length(); i++){
		    if(eMail.charAt(i) == '@'){
		        posicion1 = i;
		    }
		}
		for(int i = 0; i < eMail.length(); i++){
		    if (eMail.charAt(i) == '.') {
		        posicion2 = i;
		    }
		}
		
		if(posicion1 == 0 || posicion2 == 0 || posicion1 > posicion2){
			return esEmailValido;
		}
				
		cadena1 = eMail.substring(0, posicion1);
		cadena2 = eMail.substring(posicion1+1, posicion2);
		cadena3 = eMail.substring(posicion2+1, eMail.length());
		
		for(int i = 0; i < cadena1.length(); i++){
		    valor1 = cadena1.charAt(i);
		    if((valor1 > 47 && valor1 < 58) || (valor1 > 96 && valor1 < 123) || valor1 == 45 || valor1 == 46 || valor1 == 95 && cadena1.charAt(0) > 96 && cadena1.charAt(0) < 123) {
		        valor++;
		    }
		}
        
		for(int i = 0; i < cadena2.length(); i++){
		    valor2 = cadena2.charAt(i);
		    if((valor2 > 47 && valor2 < 58) || (valor2 > 96 && valor2 < 123)) {
		        valor++;
		    }
		}

		for(int i = 0; i < cadena3.length(); i++){
		    valor3 = cadena3.charAt(i);
		    if(((valor3 > 47 && valor3 < 58) || (valor3 > 96 && valor3 < 123)) && cadena3.length() == 3) {
		        valor++;
		    }
		}

		if (valor == eMail.length() - 2) {
			if (eMail.length() >= (posicion2 + 3)) {
				esEmailValido = true;
			}
		}
		return esEmailValido;	
	}
	
	public boolean esTelefonoValido(String telefono) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como teléfono.
		 */
		boolean esTelefonoValido = false;
		int posicion1 = 0;
		int posicion2 = 0;
		String cadena1 = "";
		String cadena2 = "";
		int valor = 0;
		int valor1 = 0;
		int valor2 = 0;

		for (int i = 0; i < telefono.length(); i++) {
		    if (telefono.charAt(i) == '+') {
		        posicion1 = i;
		    }
		}
		for (int i = 0; i < telefono.length(); i++) {
		    if (telefono.charAt(i) == '-') {
		        posicion2 = i;
		    }
		}
		
		if(posicion1 != 0 || posicion2 == 0 || posicion1 > posicion2){
			return esTelefonoValido;
		}
		
		cadena1 = telefono.substring(posicion1+1, posicion2);
		cadena2 = telefono.substring(posicion2+1, telefono.length());
		
			for (int i = 0; i < cadena1.length(); i++) {
			    valor1 = cadena1.charAt(i);
			    if(valor1 > 47 && valor1 < 58){
			        valor++;
			    }
			}
	        
			for (int i = 0; i < cadena2.length(); i++) {
			    valor2 = cadena2.charAt(i);
			    if(valor2 > 47 && valor2 < 58){
			        valor++;
			    }
			}
		
		if(valor == telefono.length() - 2){
			esTelefonoValido = true;
		}

		return esTelefonoValido;
	}
			
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 * 
		 */
		boolean seRegistroLaLlamada = false;
		
		if(this.cantidadDeLlamadas < this.cantidadMaximaDeLlamadas) {
			this.llamadasRecibidas[cantidadDeLlamadas++] = nueva;
			this.llamada = new Llamada(nueva.isFueExitosa(), nueva.getObservaciones());
			seRegistroLaLlamada = true;
		}
		
		return seRegistroLaLlamada;
	}

	public String toString() {
	/*
	 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
	 */	
		return "Contacto [Nombre: " + nombre + ", Apellido: " + apellido + ", Teléfono: " + telefono 
				+ ", Email: " + eMail + ", Dirección: " + direccion + ", Localidad: " + localidad 
				+ ", Código Postal: " + codigoPostal + ", Provincia: " + provincia  
				+ ", Registro de llamadas: " + Arrays.toString(llamadasRecibidas) + "]";		
	}
	
	public int obtenerCantidadDeLlamadasRealizadas() {
		return this.cantidadDeLlamadas;
	}
	
	public boolean isCliente() {		
		return this.esCliente;
	}
	
	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}
	
	public boolean isDeseaSerLlamadoNuevamente() {
		return this.deseaSerLlamadoNuevamente;
	}
	
	public void setDeseaSerLlamadoNuevamente(boolean deseaSerLlamadoNuevamente) {
		this.deseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}
	
	public int obtenerCodigoPostal() {
		return this.codigoPostal;
	}
	
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Llamada getLlamada() {
		return this.llamada;
	}	
}