package es.upm.aled.puente;

import java.util.Random;

public class Vehicle extends Thread {
	private int peso;
	private boolean isAmbulance;
	private Puente p;
	
	public Vehicle(int peso, boolean isAmbulance, Puente p) {
		this.peso=peso;
		this.isAmbulance=isAmbulance;
		this.p=p;
	}
	
	@Override
	public void run() {
		//Entra en el puente
		p.entrarPuente(peso, isAmbulance);
		//Cruza el puente
		
		try {
			Thread.sleep((long)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Sale del puente
		p.salirPuente(peso);
	}
}
