import java.util.Arrays;
public class insertionSort{
	public double sort(int[] ar){
		int j;
		double tiempoi=System.nanoTime();
		for(int i=0; i<ar.length; i++){
			j=i;//i-1
			int v=ar[i];
			while(j>0 && ar[j-1]>v){//j>=0  j-1
				ar[j]=ar[j-1]; //j+1
				j--;
			}
			ar[j]=v; //j+1
		}
		double tiempof=System.nanoTime();
		double time=(tiempof-tiempoi)/1000000000;
		System.out.println(Arrays.toString(ar));//
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
		//for(int k=1; k<=10000; k=k*10){
			insertionSort so=new insertionSort();
			int[] a=so.getArreglo(10);
			double tiempo=so.sort(a);
	
//			System.out.println(k+", "+tiempo);
		//}

	}
}
