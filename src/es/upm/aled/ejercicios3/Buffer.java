package es.upm.aled.ejercicios3;

public class Buffer  {
	private int[] enteros=new int[10];
	private final int capacidad;//No va a cambiar nunca
	private int ocupadas;
	
	public Buffer(int[] ent) {
		this.enteros=ent;
		this.capacidad=enteros.length;
		this.ocupadas=0;
	}
	
	public synchronized void produceEntero(int value) {
		while(ocupadas>=capacidad) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 this.ocupadas++;
		 notifyAll();
	}
	
	public synchronized void consumeEntero(int value) {
		System.out.println("Lee el dato: "+ value);
		
		while(ocupadas==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}this.ocupadas--;
	}
	public static void main(String [] args) {
		Thread p1= new Productora(8);
		Thread p2= new Productora(8);
		
		Thread c1= new Consumidora(8);
		Thread c2= new Consumidora(8);
		
		int[] aRellenar=new int[10];
		p1.start();
		p2.start();
		
		c1.start();
		c2.start();
	}
}
