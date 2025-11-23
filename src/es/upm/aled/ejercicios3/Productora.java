package es.upm.aled.ejercicios3;

import java.util.Random;

public class Productora extends Thread {
	//private int valor;
	private Buffer buffer;
	//private int[] aProducir;
	
	public Productora(Buffer buffer) {
		//this.valor=valor;
		//this.aProducir=new int[10];
		this.buffer=buffer;
		
	}
	
	@Override
	public void run() {
		buffer.produceEntero((int)(Math.random()*10000));
		try {
			sleep((long)(Math.random() * 500));
		}catch(InterruptedException e) {}
	}
	
}
