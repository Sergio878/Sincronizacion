package es.upm.aled.hacienda;

public class Ciudadano2 extends Thread{
	private boolean acceder;
	private Monitor m;
	
	public Ciudadano2() {
		this.acceder=true;
	}
	@Override
	public void run() {
		while(acceder) {
			m.esperarVentanilla2(this);
		}
	}
}
