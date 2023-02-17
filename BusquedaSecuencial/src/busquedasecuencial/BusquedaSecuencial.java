
package busquedasecuencial;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * Fernando Garrote De La Macorra
 * A01027503
 */
public class BusquedaSecuencial {

     public int [] arregloAleatorio(int numElem){
        int[] arr=new int [numElem];
        Random r=new Random();
        for(int i=0; i<numElem; i++){
            
           arr[i]=(r.nextInt(100))+1;
        }
        Arrays.sort(arr);
        return arr;
    }
    
    //Metodo que mejora la busqueda secuencial sobre un arreglo de valores ordenados.
    public int mejorado(int[]arreglo, int k){
        if(arreglo[arreglo.length/2]>k){
            for(int i=0; i<arreglo.length/2; i++){
                    if(arreglo[i]==k)
                        return i;
                    
            }
        }
        else
            for(int i=arreglo.length/2; i<arreglo.length; i++){
                    if(arreglo[i]==k)
                    return i;
            }
        return -1;
    }
    
    public  void print(int[]arr){
        for(int a : arr)
            System.out.print(a+" ");
    }
    public static void main(String[] args) {
        BusquedaSecuencial b=new BusquedaSecuencial();
        int[] arreglo=b.arregloAleatorio(10);;
        b.print(arreglo);
        
        
       

    long startTime = System.nanoTime();

   int encontrado=b.mejorado(arreglo, 40);
        if(encontrado!=-1)
            System.out.print("\n"+"encontrado en "+encontrado);
        else
            System.out.print("\n"+"no encontrado");

    long endTime = System.nanoTime();

    System.out.print("\n"+(endTime-startTime)+" nanosegundos");
        
        
        }
    
}
