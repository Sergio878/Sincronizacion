package es.upm.aled.ejercicios3;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer  {
	//private int[] enteros=new int[10];
	private final int capacidad;//No va a cambiar nunca
	
	private Queue<Integer> cola;
	
	public Buffer(int capacidad) {
		this.capacidad=capacidad;
		this.cola=new LinkedList<Integer>();
	}
	
	public synchronized void produceEntero(int value) {
		while(cola.size()==capacidad) {
			try {
				System.out.println("El buffer está lleno y no puede producir");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	   
		//this.enteros[i]=value;
		//this.contador++;
		cola.add(value);
		System.out.println("La hebra productora ha generado el valor " + value);
		notifyAll();
	}
	
	public synchronized void consumeEntero() {
		//System.out.println("La hebra lectora ve el dato: "+ value);
		
		while(cola.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//this.bufferVacio=false;
		//this.contador--;
		int value= cola.remove();
		System.out.println("La hebra lectora ve el dato: "+ value);
		notifyAll();
	}
	public static void main(String [] args) {
		int capacidad = 10;
        Buffer buffer = new Buffer(capacidad);

        // Crear hebras productoras
        Productora p1 = new Productora(buffer);
        Productora p2 = new Productora(buffer);

        // Crear hebras consumidoras
        Consumidora c1 = new Consumidora(buffer);
        Consumidora c2 = new Consumidora(buffer);

        // Iniciar hebras
        p1.start();
        p2.start();
        c1.start();
        c2.start();
		
	}
}
