package es.upm.aled.buffer;

import java.util.Random;

public class Consumidor extends Thread {
	private int id;
	private int dato;
	private Buffer<Integer> buffer;
	
	public Consumidor(int id, int dato, Buffer<Integer> buffer) {
		this.id = id;
		this.dato = dato;
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			Random rand = new Random(dato);
			sleep(rand.nextLong(1000,5000));
			dato = buffer.retrieve(id);
		} catch (InterruptedException e) {}
	}
}
