package es.upm.aled.ejercicios3;

import java.util.Random;

public class Writer extends Thread{
	private Entero entero;
	private int id;
	private Prioridad prioridad;
	
	public Writer(Entero entero, int id) {
		this.entero=entero;
		this.id=id;
	}
	
	public Prioridad getPrioridad() {
		return prioridad;
	}
	@Override
	public synchronized void run() {
		Random rand=new Random();
			
		entero.escribir(rand.nextInt(0, 10000), id);
	}
	
}
