package es.upm.aled.ejercicios3;

import java.util.Random;

public class Productora extends Thread {
	private int valor;
	private Buffer buffer;
	private int[] aProducir;
	
	public Productora(int valor) {
		this.valor=valor;
		this.aProducir=new int[10];
		this.buffer=new Buffer(aProducir);
		
	}
	
	@Override
	public void run() {
		Random rand=new Random();
		
		buffer.produceEntero(rand.nextInt());
	}
	
}
