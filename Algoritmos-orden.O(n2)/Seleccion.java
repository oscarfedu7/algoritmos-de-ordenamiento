import java.util.Arrays;
public class Seleccion{
        public double sort(int[] ar){
		int indiceM=0;
                double tiempoi=System.nanoTime();
		for(int i=0; i<ar.length-1;i++){
                	for(int k=i; k<ar.length; k++){
           			if(ar[indiceM]>ar[k])
					indiceM=k;
			}
                	int var=ar[i];
			ar[i]=ar[indiceM];
			ar[indiceM]=var;
		}
                double tiempof=System.nanoTime();
                double time=(tiempof-tiempoi)/1000000000;
               // System.out.println(Arrays.toString(ar));//
                return time;
        }

        public int[] getArreglo(int tam){
                int[] a=new int[tam];
                for(int i=0;i<tam; i++){
                        a[i]=(int)(Math.random()*1000)+1;
                }
                return a;
        }
	public static void main(String[] args){
                for(int k=1; k<=10000; k=k*10){
                        Seleccion so=new Seleccion();
                        int[] a=so.getArreglo(k);
                        double tiempo=so.sort(a);

                       System.out.println(k+", "+tiempo);
                }

        }
}

