package es.upm.aled.buffer;

public class Buffer<Tipo> {
	//Esta clase implementa un buffer sincronizado de capacidad 1, 
	//donde múltiples productores y consumidores se coordinan usando 
	//wait() y notifyAll() para evitar conflictos y gestionar la espera correctamente
	private Tipo dato;
	
	public Buffer() {
		this.dato=null;
	}
	
	public synchronized void store(int id, Tipo dato) {
		//Inserto el dato si el buffer está vacío
		try {
			//Si el buffer está lleno, el productor espera
			while(this.dato!=null) {
				System.out.println("Productor " + id + "está esperando.");
				wait();
			}
			this.dato=dato;
			System.out.println("Productor "+ id + "ha producido el lado " + dato);
			notifyAll();
		}catch(InterruptedException e) {}
	}
	public synchronized Tipo retrieve(int id) {
		Tipo aDevolver=null;
		
		try {
			//Si el buffer está vacío, el conusmidor espera
			while(dato==null) {
				System.out.println("Consumidor " + id + " está esperando.");
				wait();
			}
			aDevolver=dato;//obtiene el dato
			dato=null;//se vacía el buffer
			System.out.println("Consumidor " + id + " ha consumido el dato " + aDevolver);
			notifyAll();
		}catch(InterruptedException e) {}
		return aDevolver;
	}
}
