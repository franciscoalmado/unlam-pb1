package ar.edu.unlam.pb1.trabajoPractico08.interfaz;

public class EjemplosDeMetodosDeLaClaseMath {

	public static void main(String[] args) {
		
		int a = -8;
	    double d = -100;
	    float f = -90;
	    System.out.println(Math.abs(a));
	    System.out.println(Math.abs(d));     
	    System.out.println(Math.abs(f));
	    
	    double variable1 = -123456.99;
	    double variable2 = -445.889;
	    System.out.println(Math.abs(variable1));
	    System.out.println(Math.abs(variable2));

	    float variable3 = -123456.99f;
	    float variable4 = -445.889f;
	    System.out.println(Math.abs(variable3));
	    System.out.println(Math.abs(variable4));
	    
	    long variable5 = -123456L;
	    long variable6 = -445889L;
	    System.out.println(Math.abs(variable5));
	    System.out.println(Math.abs(variable6));
	    
	    int c = 30;
        int e = 2;
        System.out.println(Math.pow(c, e));
        
        double random = Math.random();
        System.out.println(random);
        
        System.out.println(Math.round(variable3));
        System.out.println(Math.round(variable4));
        
        System.out.println(Math.round(variable1));
        System.out.println(Math.round(variable2));
        
        System.out.println(Math.sqrt(a));
        System.out.println(Math.sqrt(Math.abs(a)));
        System.out.println(Math.sqrt(c));        
	}
}