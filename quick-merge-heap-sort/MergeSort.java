import java.util.Arrays;
public class MergeSort{
         public static void mergesort(int A[],int izq, int der){
    if (izq<der){
            int m=(izq+der)/2;
            mergesort(A,izq, m);
            mergesort(A,m+1, der);
            merge(A,izq, m, der);
    }
}

	 public static void merge(int A[],int izq, int m, int der){
   		int i, j, k;
   		int [] B = new int[A.length]; //array auxiliar
   		for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
             		B[i]=A[i];

             	i=izq; j=m+1; k=izq;
             	while (i<=m && j<=der){ //copia el siguiente elemento más grande
             	 if (B[i]<=B[j])
                     A[k++]=B[i++];
            	 else
                     A[k++]=B[j++];
	     }
             while (i<=m) //copia los elementos que quedan de la
                           A[k++]=B[i++]; //primera mitad (si los hay)
	     while(j<=der)
		A[k++]=B[j++];
 }

	  public static int[] getArreglo(int tam){
                int[] a=new int[tam];
                for(int i=0;i<tam; i++){
                        a[i]=(int)(Math.random()*1000)+1;
                }
                return a;
        }

         public static void main(String[] args){
               // for(int k=1; k<=1000; k++){
                        int[] a=getArreglo(10000);

                        double tiempoi=System.nanoTime();
                        mergesort(a, 0, (a.length-1));
                        double tiempof=System.nanoTime();
                        double time=(tiempof-tiempoi)/1000000000;
                       System.out.println(Arrays.toString(a));//
//                        System.out.println(2+", "+time);
               // }

        }

}
	

