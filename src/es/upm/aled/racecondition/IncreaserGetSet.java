package es.upm.aled.racecondition;

public class IncreaserGetSet extends Increaser {

	public IncreaserGetSet(Counter counter) {
		super(counter);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for(int i=0; i<1000000; i++) {
			//counter.increase();
			/*
			int count=counter.getCount();
			count++;//JUSTO AQUÍ PODRÍA HABER OTRO THREAD MODIFICANDO LA VARIABLE
			counter.setCount(count);
			 */
			//SOLUCIÓN:
			// START Region Critica
			synchronized(counter) {
				int count=counter.getCount();
				count++;
				counter.setCount(count);
			}// END Region Critica
		}
	}
}
