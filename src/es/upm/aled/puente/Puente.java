package es.upm.aled.puente;

public class Puente extends Thread {
	private int numVehicles;
	private int pesoPuente;
	private int waitingEntrar;
	private int numAmbulanciasEsperando;
	
	public Puente() {
		this.numVehicles=0;
		this.pesoPuente=0;
		this.waitingEntrar=0;
		this.numAmbulanciasEsperando=0;
	}
	
	public synchronized void entrarPuente(int peso, boolean ambulancia) {
		this.waitingEntrar++;
		if(ambulancia) {
			this.numAmbulanciasEsperando++;
		}	
		try {
			while(((peso + pesoPuente) >15000) || numVehicles>10
					|| (numAmbulanciasEsperando>0 && !ambulancia)) {
				if (ambulancia)
	                System.out.println("La ambulancia está esperando para entrar");
	            else
	                System.out.println("El vehículo está esperando para entrar");
				wait();
			}
		}catch(InterruptedException e) {}
		this.waitingEntrar--;
		if(ambulancia) {
			this.numAmbulanciasEsperando--;
		}
		this.numVehicles++;
		this.pesoPuente+=peso;
		if(ambulancia) {
			System.out.println("La ambulancia ha entrado");
		}else System.out.println("El vehículo ha entrado");
		
		
		
	}
	
	public synchronized void salirPuente(int peso) {
		this.numVehicles--;
		this.pesoPuente-=peso;
		System.out.println("El vehículo ha salido");
		notifyAll();
	}
}
