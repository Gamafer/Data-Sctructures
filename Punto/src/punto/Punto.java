
package punto;


public class Punto {
    //Coordenada x del punto
    private float x;
    //Coordenada y del punto
    private float y;

    //Inicializa las coordenadas del punto
    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    //Refresa la coordenada x del punto
    public float obtenerCoordenadaX() {
        return x;
    }
    
    //Regresa la coordenada y del punto
    public float obtenerCoordenadaY() {
        return y;
    }
    
    //Cambia el valor de la coordenada x del punto
    public void modificaX(float x) {
        this.x = x;
    }
    
    //Cambia el valor de la coordenada y del punto
    public void modificaY(float y) {
        this.y = y; 
    }
    
    //Imprime las coordenadas del punto
    public void imprimeCoordenadas(){
        System.out.print("\nLa coordenada x es "+obtenerCoordenadaX());
        System.out.print("\nLa coordenada y es "+obtenerCoordenadaY());

    }

    
    
    
    
    
    
}
