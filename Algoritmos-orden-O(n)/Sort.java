import java.util.Arrays;
public class Sort{
	  public void CountingSort(int[] x){
                int mayor=0;
                int n=x.length;
                for(int i=0; i<n;i++){
                        if(mayor<x[i])
                                mayor=x[i];
                }
                int m=mayor;
                int[] y= new int[m];
                int[] z=new int[n];
                for(int i=0; i<n; i++){
                        y[x[i]-1]++;
                }

                for(int i=1; i<m;i++){
                        y[i]=y[i]+y[i-1];
                }
                for(int i=0; i<n;i++){
                        int k=x[i]-1;
                        z[y[k]-1]=x[i];
                        y[x[i]-1]--;
                }
                x=z;
        }


	public void RadixSort(int[] arreglo){
                String[] s=new String[arreglo.length];
                for(int k=0; k<arreglo.length; k++)
                        s[k]=""+arreglo[k];

                int cont=0;
                Lista[] arr=new Lista[10];

                for(int i=0; i<10;i++)
                        arr[i]=new Lista();


                int max=0;
                for(int h=0;h<s.length;h++){//el tamaño del número más grande del arreglo
                        if(s[h].length()>max)
                                max=s[h].length();
                }

                for(int q=0;q<max;q++){
                        for(int i=0;i<s.length;i++){
                                int numero;
                                int tam=s[i].length();
                                if(tam-cont<=0)
                                        numero=0;
                                else
                                        numero=Integer.parseInt("" + s[i].charAt((tam-cont)-1));

                                Nodo nod=new Nodo(s[i]);
                                arr[numero].add(nod);
                        }
                        cont++;

                        int var=0;
                        for(int j=0;j<10;j++){//pone los elementos donde van
                                while(arr[j].tam() > 0){
                                        s[var]=arr[j].push();
                                        arreglo[var]=Integer.parseInt(s[var]);
                                        var++;
                                }
                        }

                }
        }

	public void BucketSort(int[] a){
		int max=0;

		for(int i=0; i<a.length; i++){
			if(a[i]>max)
				max=a[i];
		}
		while(max%10 != 0)
			max++;

		int tam=(max/10)+1;
		Lista[] arr=new Lista[tam];

		 for(int i=0; i<tam;i++)
                        arr[i]=new Lista();


		int indice=0;
		for(int j=0;j<a.length;j++){ //Los pone en la lista que deben ir 
			String s=Integer.toString(a[j]);//ver
			int x=s.length()-1;
			String ind="";
			if(x==0)
				indice=0;
			else{
				for(int k=0;k<x;k++)
					ind=ind+s.charAt(k);
				indice=Integer.parseInt(ind);
			}
			Nodo nod=new Nodo(Integer.toString(a[j]));
			arr[indice].add(nod);
		}


		for(int o=0; o<tam; o++){
		//	Burbuja co=new Burbuja();
			int[] ar=toArreglo(arr[o]);
			RadixSort(ar);
			arr[o]=toLista(ar);
		}
		

		int gg=(arr.length)-1;
		int y=0;
               	for(int j=0;j<tam;j++){//pone los elementos donde van
                     	while(arr[j].tam() > 0){
				a[y]=Integer.parseInt(arr[j].push());
				y++;
                       	}
                }

	}

	 public int[] getArreglo(int tam){
                int[] a=new int[tam];
                for(int i=0;i<tam; i++){
                        a[i]=(int)(Math.random()*100)+1;
                }
                return a;
        }

	public Lista toLista(int[] a){
		Lista l=new Lista();
		for(int i=0; i<a.length;i++){
			Nodo n=new Nodo(Integer.toString(a[i]));
			l.add(n);
		}
		return l;
	}

	public int[] toArreglo(Lista lista){
		int[] arreglo=new int[lista.tam()];
		Nodo cursor=lista.getCabeza();

		for(int i=0; i<lista.tam(); i++){
			int num=Integer.parseInt(cursor.getElemento());
			arreglo[i]=num;
			cursor=cursor.getSig();
		}
		return arreglo;
	}

        public static void main(String[] args){
                Sort rad=new Sort();
                double time1=0;
		double time2=0;
		double time3=0;
                for(int k=1; k<=1000; k=k+50){
			for(int i=0; i<10; i++){
                        	int[] a=rad.getArreglo(k);

                       		double tiempoi=System.nanoTime();
				rad.RadixSort(a);
                     		double tiempof=System.nanoTime();
                       		time1=time1+((tiempof-tiempoi)/1000000000);

				tiempoi=System.nanoTime();
            	                rad.BucketSort(a);
                                tiempof=System.nanoTime();
                                time2=time2+((tiempof-tiempoi)/1000000000);
	
				tiempoi=System.nanoTime();
                                rad.CountingSort(a);
                                tiempof=System.nanoTime();
                                time3=time3+((tiempof-tiempoi)/1000000000);


			}
			time1=time1/10;
			time2=time2/10;
			time3=time3/10;
                     	System.out.println(k+"    "+time1+"    "+time2+"    "+time3);
            	//      System.out.println(Arrays.toString(a));
                }
        }
}
