package es.upm.aled.puente;

public class Pruebas {
	public static void main(String[]args) {
		Puente p=new Puente();
		/*
		 * Thread v1=new Vehicle(1500, false, p);
		Vehicle a1= new Vehicle(4000, true, p);
		
		Vehicle v2= new Vehicle(1600, false, p);
		Vehicle v3= new Vehicle(1650, false, p);
		Vehicle v4= new Vehicle(1500, false, p);
		
		Vehicle a2= new Vehicle(6000, true, p);
		
		v1.start();
		a1.start();
		v2.start();
		v3.start();
		v4.start();
		a2.start();
		 */
		
		 
		for (int i = 0; i < 20; i++) {
	        // Generar atributos aleatorios
	        // Peso entre 1000 y 4000 kg
	        int peso = 1000 + (int)(Math.random() * 3000);
	        // 10% de probabilidad de ser ambulancia
	        boolean esAmbulancia = Math.random() < 0.15; 
	        
	        new Vehicle(peso, esAmbulancia, p).start();
	        
	        try { Thread.sleep(200); } catch (InterruptedException e) {}
	    }
		 
		
	}
	

	
	
	
}
