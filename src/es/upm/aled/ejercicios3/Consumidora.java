package es.upm.aled.ejercicios3;

public class Consumidora extends Thread {
	//private int entero;
	private Buffer buffer;
	
	public Consumidora(Buffer buffer) {
		//this.entero=valor;
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		buffer.consumeEntero();
		try {
			sleep((long)(Math.random() * 500));
		}catch(InterruptedException e) {}
	}
}
