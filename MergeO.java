import java.util.*;
public class MergeO{
public static void hacerMonticulo(int[] v, int nodo, int fin) { 
		int izq = 2*nodo+1; 
		int der = izq+1; 
		int may; 
		if(izq>fin) 
			return; 
		if(der>fin) 
			may=izq; 
		else 
			may= v[izq]>v[der]?izq:der; 
		if(v[nodo] < v[may]) { 
			int tmp = v[nodo]; 
			v[nodo] = v[may]; 
			v[may] = tmp; 
			hacerMonticulo(v, may, fin);
		}
	}



	public static void heapsort( int[] v) {
		double TInicio, TFin, tiempo;
		TInicio = System.nanoTime();

		final int N = v.length;
		for(int nodo = N/2; nodo>=0; nodo--)
			hacerMonticulo(v, nodo, N-1); 
		for(int nodo = N-1; nodo>=0; nodo--) { 
			int tmp = v[0]; 
			v[0] = v[nodo]; 
			v[nodo] = tmp; 
			hacerMonticulo(v, 0, nodo-1);
		}

		TFin = System.nanoTime();
		tiempo = TFin - TInicio;
	
//	System.out.println(v.length + "\t" + tiempo);
	}

    public static int[] getArreglo(int tam){
                int[] a=new int[tam];
                for(int i=0;i<tam; i++){
                        a[i]=(int)(Math.random()*1000)+1;
                }
                return a;
        }

         public static void main(String[] args){
		double time=0;
                for(int k=1; k<=1000; k=k+50){
		//	for(int j=0; j<6;j++){
                        int[] a=getArreglo(k);

                        double tiempoi=System.nanoTime();
                        heapsort(a);
                        double tiempof=System.nanoTime();
		//	if(j==0)
				time=(tiempof-tiempoi)/1000000000;
		//	else
                  //      	time=( time +  ((tiempof-tiempoi)/1000000000) ) /2;
                       // System.out.println(Arrays.toString(a));//
		//	if(j==5)
                        	System.out.println(k+"  "+time);
			}
        //        }
	}
}

