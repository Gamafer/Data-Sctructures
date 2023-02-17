
package busquedabinaria;

import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {
    
    public int [] arregloAleatorio(int numElem){
        int[] arr=new int [numElem];
        Random r=new Random();
        for(int i=0; i<numElem; i++){
            
           arr[i]=(r.nextInt(100))+1;
        }
        Arrays.sort(arr);
        return arr;
    }
    
    //Metodo que hace una busqueda secuencial sobre un arreglo de valores ordenados
    public int secuencial(int[] arreglo, int k){
        int cont=0;
        for(int a: arreglo){
            if(a==k)
                return cont;
            cont++;
        }
        return -1;       
    }
    
    //Metodo que hace una busqueda binaria sobre un arreglo de valores ordenados
    public int busqBin(int [] arreglo, int k){
        int primero=0;
        int ultimo=arreglo.length;
        int medio=(primero+ultimo)/2;
        
        while(medio!=primero && medio!=ultimo && arreglo[medio]!=k){
            if(k>arreglo[medio]){
                primero=medio;
                medio=(ultimo+primero)/2;
                
            }
            else{
                ultimo=medio;
                medio=(ultimo+primero)/2;
            }       
        }
        if(arreglo[medio]==k)
            return medio;
        else
            return -1;
    }
    
  
    
    public  void print(int[]arr){
        for(int a : arr)
            System.out.print(a+" ");
    }

    public static void main(String[] args) {
        
        BusquedaBinaria b=new BusquedaBinaria();
        int[] arreglo=b.arregloAleatorio(10);
        b.print(arreglo);
        int encontrado=b.busqBin(arreglo, 40);
        if(encontrado!=-1)
            System.out.print("\n"+"encontrado en "+encontrado);
        else
            System.out.print("\n"+"no encontrado");
        
        int encontrado2=b.secuencial(arreglo, 40);
        if(encontrado2!=-1)
            System.out.print("\n"+"encontrado en "+encontrado2);
        else
            System.out.print("\n"+"no encontrado");    
    }
    
}
