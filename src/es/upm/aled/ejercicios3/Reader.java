package es.upm.aled.ejercicios3;

public class Reader extends Thread{
	private Entero entero;
	private int id;
	private Prioridad prioridad;
	
	public Reader(Entero entero, int id) {
		this.entero=entero;
		this.id=id;
	}
	public int getID() {
		return id;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	@Override
	public void run() {
		entero.leer(id);
	}
}
