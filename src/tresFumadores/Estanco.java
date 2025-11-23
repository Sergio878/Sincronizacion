package tresFumadores;

public class Estanco {
	//private boolean[] estaFumando=new boolean[3];
	private boolean tabaco = false;
    private boolean papel = false;
    private boolean cerilla = false;
    private boolean mesaOcupada = false;

	
	public Estanco() {
		
		
	}
	
	public void poneProductos(int id1, int id2) {
		try {
			while(mesaOcupada) {
				System.out.println("El estanquero debe esperar a que terminen de fumar");
				wait();
			}
		}catch(InterruptedException e) {}
		
		if(id1==0|| id2==0) tabaco=true;
		if(id1==1|| id2==1) papel=true;
		if(id1==2|| id2==2) cerilla=true;
		
		System.out.println("El estamquero coloca los ingredientes " + ingredientes());
	}
	
	public String ingredientes() {
		String s= "[";
		
		if(tabaco) s+="tabaco";
		if(papel) s+="papel";
		if(cerilla) s+="cerillas";
		
		return s+="]";
	}
	
}
