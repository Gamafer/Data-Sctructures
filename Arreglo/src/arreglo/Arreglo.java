/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglo;

/**
 *
 * @author Fernando Garrote De La Macorra
 */
public class Arreglo {
    int[] A={1,2,3,4,5,6,7};
    
    //Cuenta el numero de elementos dentro del arreglo con recursividad. Posicion tiene que empezar en 0.
    public int longitud(int posicion){
        if(A.length<=posicion)
            return 0;
        else
            return 1+longitud(posicion+1);
    }
    
    //Cuenta el numero de elementos dentro del arreglo con recursivivdad tail. Posicion tiene que empezar en 0.
    public int longitudCola(int posicion, int acumulador){
        if(A.length<=posicion)
            return acumulador;
        else
            return longitudCola(posicion+1, acumulador+1);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arreglo miObjeto=new Arreglo();
        System.out.print(miObjeto.longitud(0));
        System.out.print("\n"+miObjeto.longitudCola(0, 0));
        // TODO code application logic here
    }
    
}
