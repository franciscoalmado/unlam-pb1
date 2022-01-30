package ar.edu.unlam.pb1.trabajoPractico07.dominio;

public class Calculadora {

	private double operador1;
	private double operador2;
	private double resultado;
	
	public Calculadora() {
		this.operador1 = 4.0;
		this.operador2 = 2.0;
		this.resultado = 0.0;
	}
	
	public Calculadora(double operador1, double operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
		this.resultado = 0.0;
	}
	
	public double sumar() {
			
		this.resultado = this.operador1 + this.operador2;
		
		return this.resultado;
	}
	
	public double sumar(double operador1, double operador2) {
				
		this.resultado = operador1 + operador2;
		
		return this.resultado;		
	}
	
	public double restar() {
				
		this.resultado = this.operador1 - this.operador2;
		
		return this.resultado;
	}
	
	public double restar(double operador1, double operador2) {
		
		this.resultado = operador1 - operador2;
		
		return this.resultado;		
	}	
	
	public double multiplicar() {
		
		this.resultado = this.operador1 * this.operador2;
		
		return this.resultado;
	}
	
	public double multiplicar(double operador1, double operador2) {
		
		this.resultado = operador1 * operador2;
		
		return this.resultado;		
	}
	
	public double dividir() {
		
		if(this.operador2 > 0) {
			this.resultado = this.operador1 / this.operador2;	
		}else {
			this.resultado = 0;
		}
		
		return this.resultado;
	}
	
	public double dividir(double numerador, double divisor) {
		
		if(divisor > 0) {
			this.resultado = numerador / divisor;			
		}else {
			this.resultado = 0;
		}
		return this.resultado;		
	}
	
	public boolean esPositivo() {
		boolean esPositivo = false;
		
		if(this.operador1 > 0 && this.operador2 > 0) {
			esPositivo = true;
		}
		
		return esPositivo;
	}
	
	public double potencia() {
		this.resultado = 1;
		
		if(this.operador1 > 0 && this.operador2 == 0){
            return this.resultado;
        }
        if(this.operador1 == 0 && this.operador2 > 0){
            return this.resultado = 0;
        }    
        for(int i = 1; i <= this.operador2; i++){
            this.resultado *= this.operador1;
        }
        return this.resultado;
	}
	
	public double potencia(double operador1, double operador2) {	
		this.resultado = 1;
		
		if(operador1 > 0 && operador2 == 0){
            return this.resultado;
        }
        if(operador1 == 0 && operador2 > 0){
            return this.resultado = 0;
        }    
        for(int i = 1; i <= operador2; i++){
            this.resultado *= operador1;
        }
        return this.resultado;
	}
	
	public int sumatoria(int limite) {
		int sumatoria = 0;

		for (int i = 1; i < limite; i++) {		
			sumatoria += i;
		}
		return sumatoria;
	}
	
	public int sumatoria(int limiteInferior, int limiteSuperior){
		int sumatoria = 0;
		 
		for(int i = limiteInferior; i <= limiteSuperior; i++){
			sumatoria += i;
		}
		return sumatoria;
	}
	
	public int productoria(int limite) {
		int productoria = 1;
		
		for (int i = 1; i < limite; i++) {
			productoria *= i;
		}
		return productoria;
	}
	
	public int productoria(int limiteInferior, int limiteSuperior){
		int productoria = 1;

		for(int i = limiteInferior; i <= limiteSuperior; i++){
			productoria *= i;
		}
			return productoria;
	}
	
	public String contarDivisores(int numero) {
		String divisores = "";
		int divisor = 1;
		int resto = 0;
		
		for (int i = 0; i <= numero; i++) {
			resto = numero % divisor;
				if (resto == 0) {
					divisores += divisor+", ";
				}
			divisor++;
		}
		return divisores;
	}
	
	public int factorial(int numero) {
		int i = 1;
		this.resultado = 1;
		int numeroVariable = 2;
		
		if (numero == 1) {
			return i;
		}
		if (numero == 2) {
			return numeroVariable;
		}
		if (numero >= 3) {
			do {
				this.resultado *= numeroVariable;
				numeroVariable++;
				i++;
			} while (i < numero);
			
		}
		return (int) this.resultado;
	}
}