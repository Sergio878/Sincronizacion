package es.upm.aled.racecondition;

public class Increaser extends Thread{
	protected Counter counter;
	public Increaser(Counter counter) {
		this.counter=counter;
	}
	//Incermenta el contador 1.000.000 veces
	@Override
	public void run() {
		for(int i=0; i<1000000;i++) {
			counter.increase();
		}
	}
}
