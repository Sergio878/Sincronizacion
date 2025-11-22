package es.upm.aled.ejercicios3;

public class Consumidora extends Thread {
	private int entero;
	private Buffer buffer;
	private int[] aProducir;
	
	public Consumidora(int valor) {
		this.entero=valor;
		this.aProducir=new int[10];
		this.buffer=new Buffer(aProducir);
	}
	
	@Override
	public void run() {
		buffer.consumeEntero(entero);
	}
}
