package es.upm.aled.ejercicios3;

public class Entero extends Thread {
	private int enteroCompartido;
	private int numLectores;
	
	private boolean hayEscritor;
	
	private int lectoresAltaEsperando = 0;
	private int escritoresAltaEsperando = 0;

	private int lectoresMediaEsperando = 0;
	private int escritoresMediaEsperando = 0;

	private int lectoresBajaEsperando = 0;
	private int escritoresBajaEsperando = 0;
	
	public Entero(int entero) {
		this.enteroCompartido=entero;
		this.numLectores=0;
		this.hayEscritor=false; //Si es true nunca podrá leer el valor la hebra lectora
	}
	public void leer(int id) {
		synchronized(this) {
			try {
				while(hayEscritor || lectoresAltaEsperando>0) {
					wait();
					lectoresAltaEsperando--;
					numLectores++;
				}
			}catch(InterruptedException e) {}
			
		}
		
		//hayEscritor=false;
		//ojo, con esto otros lectores o escritores podrían entrar
		//se rompe la exclusión mutua
		System.out.println("La hebra " + id + " lee el número: " + enteroCompartido);
		synchronized(this) {
			numLectores--;
			lectoresAltaEsperando--;
			if(numLectores==0) notifyAll();//despertamos a los escritores si ya no quedan lectores	
		}
	}
	public synchronized void escribir(int valorNuevo, int id) {
		try {
			while(numLectores>0 || hayEscritor) {
				wait();
			}
		}catch(InterruptedException e) {}
		hayEscritor=true;//Al salir de la región crítica, marco que hay un escritor
		this.enteroCompartido=valorNuevo;//procede a escribir:
		System.out.println("La hebra " + id + " escribe el valor " + enteroCompartido);
		hayEscritor=false;
		notifyAll();//despierta a todos para que vuelvan a intentar
		
	}
	public static void main(String[]args) {
		Entero ent= new Entero(7);
		
		
		// Crear hebras lectoras
		for (int i = 0; i < 5; i++) {
			Reader r1=new Reader(ent, (i+1));
			r1.start();
		}
				

        // Crear hebras escritoras
        for (int i = 0; i < 3; i++) {
            Writer w1=new Writer(ent, (i+1));
            w1.start();
        		
		}
	}
	
	/*
	 * protected int numLectores;
	protected boolean hayEscritorActivo;
	
	
	
	public void leer() {
		synchronized(this) {
			while(hayEscritorActivo) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
		}System.out.println("El lector ha leido el valor " + entero);
		synchronized(this) {
			numLectores--;
			if(numLectores==0) notifyAll();
		}
		
	}
	
	public void escribir(int nuevoValor) {
		synchronized(this) {
			while(numLectores>0 || hayEscritorActivo) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}hayEscritorActivo=true;//se pasa el while y empieza a escribir
		
		}this.entero=nuevoValor;
		System.out.println("El escritor ha escrito el valor " + entero);
		synchronized(this){
			hayEscritorActivo=false;//ha acabadi de escribir y procede a notificar que 
			//no hay nadie escribiendo
			notifyAll();
		}
		
	}
	
	public static void main (String[]args) {
		Entero entero=new Entero(7);
		
		
		
		// Crear hebras lectoras
			for (int i = 0; i < 5; i++) {
				Reader r=new Reader(entero, "Lector-" + (i+1));
				r.start();
			}
		

        // Crear hebras escritoras
        for (int i = 0; i < 3; i++) {
            Writer w=new Writer(entero, "Escritor-" + (i+1));
            w.start();
        }
	}
	 */
	
}
