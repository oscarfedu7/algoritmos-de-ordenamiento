public class Nodo{
	private Nodo sig;
	private String elemento;
	public Nodo(String n){
		sig=null;
		elemento=n;
	}
	
	public String getElemento(){
		return elemento;
	}
	public void setElemento(String n){
		elemento=n;
	}
	public Nodo getSig(){
		return sig;
	}
	public void setSig(Nodo a){
		sig=a;
	}
	public void addR(Nodo n){
		if(sig==null)
			sig=n;
		else
			this.sig.addR(n);
	}
}

