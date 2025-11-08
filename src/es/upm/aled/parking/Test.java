package es.upm.aled.parking;

import java.time.LocalDateTime;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Parking teleco = new Parking(5);
		Random rand = new Random(LocalDateTime.now().getNano());
		for (int i = 0; i < 10; i ++) {
			Car c = new Car(rand.nextInt(0, 999), teleco);
			c.start();
		}
	}
}
