package es.upm.aled.parking;

public class Parking {
	private final int capacity;
	private int cars;
	
	public Parking(int capacity) {
		this.capacity=capacity;
		this.cars=0;
	}
	
	public synchronized void enter(int plate) {
		//Si cars<capacidad -> entra
		//Si no, a esperar
		//Una vez entra, aumenta cars en uno
		try {
			//SIEMPRE WHILE, NUNCA IF, HAY QUE SER PESIMISTA SIEMPRE
			while(cars>=capacity) {//SIEMPRE USAR UN WHILE -> HAY MUCHOS THREADS QUE NO SABEMOS QUÉ HACEN 
				System.out.println("Car " + plate + " is waiting to enter.");
				wait();//Espero en la entrada
			}
			//Ahora sí, ya sí puede pasar el coche:
			//He conseguido entrar
			System.out.println("Car " + plate + " has managed to enter.");
			cars++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void exit(int plate) {
		//Como sale, cars se reduce en uno
		cars--;
		//Avisar a uno que estuviera esperando
		System.out.println("Car " + plate + " has exited.");
		notify();//Despierta a un coche que espera al azar
	}
	
}
