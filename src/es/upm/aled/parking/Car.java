package es.upm.aled.parking;

import java.util.Random;

public class Car extends Thread{
	private int plate;
	private Parking parking;
	
	public Car(int plate, Parking parking) {
		this.plate=plate;
		this.parking=parking;
	}
	
	@Override
	public void run() {
		//Entra en el parking
		
		try {
			parking.enter(plate);
			//Hago exámenes, voy a clubes y a la cafetería
			Random rand= new Random(plate);
			sleep(rand.nextLong(1000, 5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread interrupted");
		}
		
		//Sale del parking
		parking.exit(plate);
	}
}
