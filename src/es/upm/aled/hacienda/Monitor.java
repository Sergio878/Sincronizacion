package es.upm.aled.hacienda;

public class Monitor extends Thread {
	int waitingQueue1;
	int atendidosA;
	int waitingQueue2;
	
	private boolean servicioTerminado;
	private boolean AndresDurmiendo;
	
	public Monitor() {
		this.waitingQueue1=0;
		this.atendidosA=0;
		this.waitingQueue2=0;
		this.servicioTerminado=false;
		this.AndresDurmiendo=true;
	}
	
	public synchronized void esperarVentanilla1(Ciudadano1 c1) {
		//Llega un ciudadano a la cola
		this.waitingQueue1++;
		System.out.println("El ciudadano "+ c1+ " ha llegado a la cola");
		//Despierta a Andrés
		notifyAll();
		//Andrés lo atiende
		try {
			while(atendidosA!=1) {
				wait();//Con esto le indico que mientras que no sea 1 la bandera
				//les toca esperar a los de la fila 1, y serán atendidos cuando
				//dicha bandera se ponga a 1
			}
			while(!servicioTerminado) {
				wait();//Espera a que Andrés termine de atenderlo 
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.waitingQueue1--;
		this.atendidosA=0;//Vuelve a quedar libre de nuevo
		System.out.println("El ciudadano " + c1 + " ha sido atendido");
		this.servicioTerminado=true;
		notifyAll();
	}
	
	public synchronized void esperarVentanilla2(Ciudadano2 c2) {
		this.waitingQueue2++;
		System.out.println("El ciudadano "+ c2+ " ha llegado a la cola");
		//Despierta a Andrés
		notifyAll();
		//Espero a que termine 
		while(atendidosA!=2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!servicioTerminado) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.waitingQueue2--;
		this.atendidosA=0;
		System.out.println("El ciudadano " + c2 + " ha sido atendido");
		notifyAll();
	}
	
	public void atenderCiudadano() {
		//Si no hay nadie, duerme
		try {
			while(waitingQueue1==0 && waitingQueue2==0) {
				System.out.println("Andrés duerme");
				wait();
			}
		}catch(InterruptedException e) {}
		//Si hay cola, atiende a la 1 antes de la 2 siempre y cuando haya el mismo número de personas en ambas
		//o más personas esperando en la 1
		if(waitingQueue1>=waitingQueue2) {
			atendidosA=1;
		}else atendidosA=2;
		
		//Notifica a los ciudadanos:
		notifyAll();
		
		//Termina el servicio
        servicioTerminado = true;
        notifyAll(); // Despierta al ciudadano para que se vaya

        //Espera a que el ciudadano se vaya realmente antes de llamar al siguiente
        while (atendidosA != 0) {
            try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}
	
}
