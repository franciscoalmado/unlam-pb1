package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.DiscoRigido;

public class PruebaDiscoRigido {

	public static void main(String[] args) {
		
		DiscoRigido seagate = new DiscoRigido();
		DiscoRigido hitachi = new DiscoRigido();
		DiscoRigido westernDigital = new DiscoRigido();
		DiscoRigido toshiba = new DiscoRigido();
		
		seagate.setCapacidadDeDvd(10);
		seagate.setCapacidadDeBlueRay(10);
		
		hitachi.setCapacidadDeDvd(20);
		hitachi.setCapacidadDeBlueRay(20);
		
		westernDigital.setCapacidadDeDvd(32);
		westernDigital.setCapacidadDeBlueRay(32);
		
		toshiba.setCapacidadDeDvd(48);
		toshiba.setCapacidadDeBlueRay(48);		
		
		System.out.println("Cantidad de DVD en Seagate: "+seagate.getCantidadDeDvd());
		System.out.println("Cantidad de Blue Ray en Seagate: "+seagate.getCantidadDeBlueRay());

		System.out.println("Cantidad de DVD en Hitachi: "+hitachi.getCantidadDeDvd());
		System.out.println("Cantidad de Blue Ray en Hitachi: "+hitachi.getCantidadDeBlueRay());		
		
		System.out.println("Cantidad de DVD en Western Digital: "+westernDigital.getCantidadDeDvd());
		System.out.println("Cantidad de Blue Ray en Western Digital: "+westernDigital.getCantidadDeBlueRay());	

		System.out.println("Cantidad de DVD en Toshiba: "+toshiba.getCantidadDeDvd());
		System.out.println("Cantidad de Blue Ray en Toshiba: "+toshiba.getCantidadDeBlueRay());	
	}
}