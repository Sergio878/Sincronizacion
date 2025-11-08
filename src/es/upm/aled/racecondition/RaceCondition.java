package es.upm.aled.racecondition;

public class RaceCondition {
	public static void main(String[]args) {
		Counter c1=new Counter();
		
		Increaser i1=new Increaser(c1);//+1.000.000
		Increaser i2=new Increaser(c1);//+1.000.000
		
		i1.start();
		i2.start();
		
		try {
			i1.join();
			i2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread interrupted.");
		}
		System.out.println(c1.getCount());
		System.out.println("-------");
		
		Counter c2=new CounterMonitor();
		
		Increaser i3= new Increaser(c2);//+1.000.000
		Increaser i4= new Increaser(c2);//+1.000.000
		
		i3.start();
		i4.start();
		
		try {
			i3.join();
			i4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread interrupted.");

		}
		System.out.println(c2.getCount());
		System.out.println("-------");
		
		Counter c3 = new CounterMonitor();
		Increaser i5 = new IncreaserGetSet(c3); // + 1.000.000
		Increaser i6 = new IncreaserGetSet(c3); // + 1.000.000
		i5.start();
		i6.start();
		try {
			i5.join();
			i6.join();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted.");
		}
		System.out.println(c3.getCount());
	}
}
