import java.util.Arrays;
public class Burbuja{
        public double sort(int[] ar){
                int j=(ar.length)-1;
                double tiempoi=System.nanoTime();
		for(int k=0; k<ar.length; k++){
                	for(int i=0; i<j; i++){
                    		if(ar[i]>ar[i+1]){
					int var=ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=var;
		    		}
                	}
			j--;
		}
                double tiempof=System.nanoTime();
                double time=(tiempof-tiempoi)/1000000000;
          //      System.out.println(Arrays.toString(ar));//
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
                        Burbuja so=new Burbuja();
                        int[] a=so.getArreglo(k);
                        double tiempo=so.sort(a);

                        System.out.println(k+", "+tiempo);
                }

        }
}
