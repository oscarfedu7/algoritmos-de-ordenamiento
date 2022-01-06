public class Lista{
	private Nodo cabeza;
	private Nodo cola;
	private int tam;
	public Lista(){
		cola=null;
		cabeza=null;
		tam=0;
	}
	
	public int tam(){
		return tam;
	}

	public void addR(Nodo n){
		if(cabeza==null)
			cabeza=n;
		else
			cabeza.addR(n);
	}
	
	public Nodo getCola(){
		return cola;
	}
	public Nodo getCabeza(){
		return cabeza;
	}

	public boolean hasNext(Nodo n){
		return n!=cola;
	}
	public Nodo Next(Nodo n){
		return n.getSig();
	}
	public void add(Nodo n){
		if(cabeza==null){
			n.setSig(null);
			cola=n;
			cabeza=n;
			tam++;
		}
		else{
			n.setSig(null);
			cola.setSig(n);
			cola=cola.getSig();
			tam++;
		}
	}
	public String push() throws IllegalStateException{
		Nodo temp;
		if(cabeza==null)
			throw new IllegalStateException("La lista esta vacía");
		else{
			temp=cabeza;
			cabeza=cabeza.getSig();
			temp.setSig(null);
			tam--;
		}
		return temp.getElemento();
	}
	public void toStringg(){
		Nodo temp=cabeza;
		for(int i=0;i<tam(); i++){
			System.out.print(temp.getElemento()+", ");
			temp=temp.getSig();
		}
	}
			
}

