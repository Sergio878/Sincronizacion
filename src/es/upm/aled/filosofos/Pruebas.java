package es.upm.aled.filosofos;

public class Pruebas {
	public static void main(String[]args) {
		CenaFilosofos cf= new CenaFilosofos();
		for(int i=0; i<5; i++) {
			int id=i;
			new Filosofo(cf, i).start();
		}
		
	
	}
}
