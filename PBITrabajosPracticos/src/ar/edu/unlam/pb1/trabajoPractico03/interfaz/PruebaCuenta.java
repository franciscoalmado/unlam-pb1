package ar.edu.unlam.pb1.trabajoPractico03.interfaz;

import ar.edu.unlam.pb1.trabajoPractico03.dominio.Cuenta;

public class PruebaCuenta {

	public static void main(String[] args) {
		
		Cuenta cuenta1 = new Cuenta("Florencia Martino");
		Cuenta cuenta2 = new Cuenta("Leonardo Perassi",1000);
		
		System.out.println("Titular de la cuenta 1: "+cuenta1.getTitular());
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");
		
		cuenta1.depositar(500);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");
		
		cuenta1.retirar(600);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");
		
		cuenta1.depositar(-500);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");	
		
		cuenta1.retirar(-600);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");	
		
		cuenta1.depositar(300);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");
		
		cuenta1.retirar(150);
		System.out.println("Saldo de la cuenta 1: "+cuenta1.getSaldo()+" $");
		
		System.out.println("Titular de la cuenta 2: "+cuenta2.getTitular());
		System.out.println("Saldo de la cuenta 2: "+cuenta2.getSaldo()+" $");
		
		cuenta2.depositar(300);
		System.out.println("Saldo de la cuenta 2: "+cuenta2.getSaldo()+" $");
		
		cuenta2.retirar(400);
		System.out.println("Saldo de la cuenta 2: "+cuenta2.getSaldo()+" $");
	}
}