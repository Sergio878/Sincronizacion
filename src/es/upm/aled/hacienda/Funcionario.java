package es.upm.aled.hacienda;

public class Funcionario extends Thread {
	private Monitor m;
	
	public Funcionario() {
		
	}
	
	@Override
	public void run() {
		while(m.waitingQueue1==0 && m.waitingQueue2==0) {
			
		}
	}
}
