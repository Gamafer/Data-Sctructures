
package busqueda;

import java.util.Arrays;
import java.util.Random;

public class Busqueda {
    
    public int [] arregloAleatorio(int numElem){
        int[] arr=new int [numElem];
        Random r=new Random();
        for(int i=0; i<numElem; i++){
            
           arr[i]=(r.nextInt(100))+1;
        }
        Arrays.sort(arr);
        return arr;
    }
    
    public int secuencial(int[] arreglo, int k){
        int cont=0;
        for(int a: arreglo){
            if(a==k)
                return cont;
            cont++;
        }
        return -1;
            
    }
    
    public int mejorado(int[]arreglo, int k){
        return 0;
    }
    
    public  void print(int[]arr){
        for(int a : arr)
            System.out.print(a+" ");
    }

    public static void main(String[] args) {
        
        Busqueda b=new Busqueda();
        int[] arreglo=b.arregloAleatorio(10);
        //b.print(b.arregloAleatorio(10));
        b.print(arreglo);
        int encontrado=b.secuencial(arreglo, 40);
        if(encontrado!=-1)
            System.out.print("\n"+"encontrado en "+encontrado);
        else
            System.out.print("\n"+"no encontrado");
        
    }
    
}
