package es.upm.aled.filosofos;

public class CenaFilosofos {
	private int numTenedores;
	private boolean[] tenedorOcupado=new boolean[5];
	
	public CenaFilosofos() {
		this.numTenedores=5;
		for(int i=0; i<numTenedores;i++) {
			this.tenedorOcupado[i]=false;
		}
	}
	
	public synchronized void comer(int i) {
		//this.numTenedores-=2;
			try {
				while(tenedorOcupado[i] || tenedorOcupado[(i+1)%numTenedores]) {
					System.out.println("El filósofo "+ i + " no tiene tenedores a su disposición para comer");
					wait();
				}
			}catch(InterruptedException e) {} 
			
			System.out.println("El filósofo "+ i + " ya puede comer");
			this.tenedorOcupado[i]=true;
			this.tenedorOcupado[(i+1)%5]=true;
			this.numTenedores-=2;
			//notifyAll();
		
	}
	public synchronized void terminarComer(int i) {
		this.numTenedores+=2;
		this.tenedorOcupado[i]=false;
		this.tenedorOcupado[(i+1)%5]=false;
		System.out.println("El filosofo " + i + " ha terminado de comer");
		notifyAll();
	}
}
