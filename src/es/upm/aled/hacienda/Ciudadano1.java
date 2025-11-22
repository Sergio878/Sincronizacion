package es.upm.aled.hacienda;

public class Ciudadano1 extends Thread{
	private boolean acceder;
	private Monitor m;
	
	public Ciudadano1() {
		this.acceder=true;
	}
	@Override
	public void run() {
		while(acceder) {
			m.esperarVentanilla1(this);
		}
	}
}
