package es.upm.aled.racecondition;

//This class is Thread-Saved
public class CounterMonitor extends Counter {
	//Nadie más lo puede usar hasta que alguien que lo está usando termine de hacerlo
	
	@Override
	public synchronized int getCount() {
		return count;
	}
	
	@Override
	public synchronized void setCount(int count) {
		this.count = count;
	}
	
	public synchronized void increase() {
		count++;//Tampoco es atómico
		//Con este cerrojo protegemos el dato. 
		//Use quien use esta clase no habrá problemas 
	}
}
