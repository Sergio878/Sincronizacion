package es.upm.aled.racecondition;

public class Counter {
	protected int count=0;
	
	//Región crítica
	public int getCount() {
		return count;
	}
	//Región crítica
	public void setCount(int count) {
		this.count = count;
	}
	//Región crítica
	public void increase() {
		count++;//Tampoco es atómico
	}
}
