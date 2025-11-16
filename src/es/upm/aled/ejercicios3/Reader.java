package es.upm.aled.ejercicios3;

public class Reader extends Thread{
	private Entero entero;
	
	public Reader(Entero entero, String nombre) {
		this.entero=entero;
	}
	
	@Override
	public void run() {
		entero.leer();
	}
}
