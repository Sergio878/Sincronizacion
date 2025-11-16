package es.upm.aled.ejercicios3;

public class Entero extends Thread {
	private int entero;
	
	protected int numLectores;
	protected boolean hayEscritorActivo;
	
	public Entero(int entero) {
		this.entero=entero;
		this.numLectores=0;
		this.hayEscritorActivo=true;
	}
	
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
}
