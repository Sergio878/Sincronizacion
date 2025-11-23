package es.upm.aled.filosofos;

public class Filosofo extends Thread{
	private int id;
	private CenaFilosofos cf;
	
	public Filosofo(CenaFilosofos cf, int id) {
		this.cf=cf;
		this.id=id;
	}
	
	
	@Override
	public void run() {
		//El filósofo empieza a comer 
		cf.comer(id);
		//El filósofo come
		try {
			sleep((long)(Math.random()*3000));
		}catch(InterruptedException e) {}
		//El filósofo termina de comer
		cf.terminarComer(id);
	}
}
