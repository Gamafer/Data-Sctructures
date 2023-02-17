/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto;

/**
 *
 * @author garro
 */
public class Main {
    public static void main(String[] args) {
        Punto p=new Punto(3,4);
        p.imprimeCoordenadas();
        System.out.print("\n"+p.obtenerCoordenadaX());
        System.out.print("\n"+p.obtenerCoordenadaY());
        p.modificaX(7);
        p.modificaY(10);
        p.imprimeCoordenadas();
    }
    
}
