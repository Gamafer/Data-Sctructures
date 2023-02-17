/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangulo;

/**
 *
 * @author Fernando Garrote De La Macorra
 */
public class Rectangulo {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    //Inicializa las coordenadas del rectangulo
    //La coordenada x1 tiene que ser diferente a la x2
    //La coordenada y1 tiene que ser diferente a la y2
    public Rectangulo(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //Obtiene la coordenada x1 del rectangulo
    public double getX1() {
        return x1;
    }
    
    //Cambia la coordenada x1 del rectangulo
    public void setX1(double x1) {
        this.x1 = x1;
    }

    //Obtiene la coordenada y1 del rectangulo
    public double getY1() {
        return y1;
    }

    //Cambia la coordenada y1 del rectangulo
    public void setY1(double y1) {
        this.y1 = y1;
    }
    
    //Obtiene la coordenada x2 del rectangulo
    public double getX2() {
        return x2;
    }

    //Cambia la coordenada x2 del rectangulo
    public void setX2(double x2) {
        this.x2 = x2;
    }

    //Obtiene la coordenada y2 del rectangulo
    public double getY2() {
        return y2;
    }

    //Cambia la coordenada y2 del rectangulo
    public void setY2(double y2) {
        this.y2 = y2;
    }
    
    //Calcula el largo del rectangulo
    public double calculaLargo(){
        if((x2-x1)>0)
            return x2-x1;
        else
            return x1-x2;
    }
    
    //calcula la altura del rectangulo
    public double calculaAltura(){
        if((y2-y1)>0)
            return y2-y1;
        else
            return y1-y2;
    }
    
    //Calcula el perimetro del rectangulo
    public double calculaPerimetro(){
        
        return calculaLargo()*2+calculaAltura()*2;
    }
    
    //Calcula el area del rectangulo
    public double calculaArea(){
        return calculaLargo()*calculaAltura();
    }
    public static void main(String[] args) {
       
        // TODO code application logic here
    }
    
}
