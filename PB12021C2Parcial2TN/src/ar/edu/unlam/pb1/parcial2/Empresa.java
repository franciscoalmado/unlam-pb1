package ar.edu.unlam.pb1.parcial2;

public class Empresa {
	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private int zonasDeCobertura[];
	private String nombreEmpresa;
	private Contacto[] contactos;
	private int cantidadMaximaDeContactos;
	private int cantidadDeContactos;
 	
	public Empresa(String nombreEmpresa, int cantidadDeZonasDeCobertura, int cantidadDeContactos) {
		this.nombreEmpresa = nombreEmpresa;
		this.zonasDeCobertura = new int[cantidadDeZonasDeCobertura];
		this.cantidadMaximaDeContactos = cantidadDeContactos;
		this.contactos = new Contacto[this.cantidadMaximaDeContactos];
		this.cantidadDeContactos = 0;
	}
	
	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */		
		return this.nombreEmpresa;
	}
	
	public boolean agregarNuevoContacto(Contacto nuevo) {
		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		boolean contactoAgregado = false;
		
		for(int i=0; i < this.contactos.length; i++) {
			if(this.contactos[i] == null && this.cantidadDeContactos < this.cantidadMaximaDeContactos) {
				this.contactos[i] = nuevo;
				contactoAgregado = true;
				this.cantidadDeContactos++;
				break;
			}
		}	
		
		return contactoAgregado;
	}
	
	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican por el codigo postal)
		 */	
		boolean zonaAgregada = false;
		
		for(int i=0; i < this.zonasDeCobertura.length; i++) {
			if(this.zonasDeCobertura[i] == 0 && elCodigoPostalEstaDentroDeLaZonaDeCobertura(codigoPostal) == false) {
				this.zonasDeCobertura[i] = codigoPostal;
				zonaAgregada = true;
				break;
			}
		}		
		
		return zonaAgregada;
	}
	
	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un código postal está dentro de la zona de cobertura
		 */
		boolean isEnLaZonaDeCobertura = false;
		
		for(int i=0; i < this.zonasDeCobertura.length; i++) {
			if(this.zonasDeCobertura[i] != 0 && this.zonasDeCobertura[i] == codigoPostal) {
				isEnLaZonaDeCobertura = true;
				break;
			}
		}

		return isEnLaZonaDeCobertura;
	}
	
	public Contacto buscarCandidato() {
		/*
		 * Para determinar qué contacto el sistema debe mostrar, se debe realizar la siguiente búsqueda:
		 * 1.	El contacto NO debe ser cliente aún.
		 * 2.	El contacto desea ser llamado o al menos no informó lo contrario.
		 * 3.	El código postal del contacto debe existir en las zonas de cobertura existente.
		 * 4.	Del conjunto de contactos resultante se debe seleccionar aleatoriamente el próximo llamado.
		 */
		Contacto contacto = null;
		int candidato = 0;
		
		do {
			candidato = (int) (Math.random()*contactos.length);
			contacto = seleccionarUnContactoAleatoriamente(candidato);			
		}while(contacto == null);	
		
		return contacto;
	}
	
	private Contacto seleccionarUnContactoAleatoriamente(int posicion) {
		for(int i=0; i < this.contactos.length; i++) {
			if(this.contactos[posicion] != null && this.contactos[posicion].isCliente() == false && this.contactos[posicion].isDeseaSerLlamadoNuevamente() == true && elCodigoPostalEstaDentroDeLaZonaDeCobertura(this.contactos[posicion].obtenerCodigoPostal()) == true) {				
				return this.contactos[posicion];
			}		
		}
		return null;
	}
	
	public Contacto[] getContactos() {
		return this.contactos;
	}
	
	public int getCantidadDeContactos() {
		return this.cantidadDeContactos;
	}
}