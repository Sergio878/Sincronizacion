package es.upm.aled.ejercicios3;

import java.util.Random;

public class Writer extends Thread{
	private Entero entero;
	
	public Writer(Entero entero, String nombre) {
		this.entero=entero;
	}
	
	@Override
	public synchronized void run() {
		Random rand=new Random();
			
		entero.escribir(rand.nextInt(0, 10000));
	}
	
}
