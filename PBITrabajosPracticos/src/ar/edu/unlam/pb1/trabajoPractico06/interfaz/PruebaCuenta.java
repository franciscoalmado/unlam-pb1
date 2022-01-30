package ar.edu.unlam.pb1.trabajoPractico06.interfaz;

import ar.edu.unlam.pb1.trabajoPractico06.dominio.Cuenta;

public class PruebaCuenta {

	public static void main(String[] args) {
		
		Cuenta cuenta = new Cuenta("Edward Snowden", 500.0);
		
		System.out.println("Titular de la cuenta: "+cuenta.getTitular());
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");
		
		cuenta.retirar(200);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");
		
		cuenta.retirar(50);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");
		
		cuenta.retirar(10);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");
		
		cuenta.depositar(500);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");
		
		cuenta.retirar(150);
		System.out.println("Saldo de la cuenta: "+cuenta.getSaldo()+" $");		
	}
}