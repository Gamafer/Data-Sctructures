
package recursionenclase;


public class RecursionEnClase {
    int[] A={1,6,3,4,5,9};
    
    
    public int multRec(int a, int b){
        if(a==0)
            return 0;
        else
            return b+multRec(a-1,b);
                    
    }
    
    public int potRec(int a, int b){
        if(b==0)
            return 1;
        else
            return a*potRec(a,b-1);
    }
    
    public int potRec2(int a, int b){
        if(b==0)
            return 1;
        else
            return multRec(a, potRec2(a,b-1));
    }
    
    public int max(int a, int b){
        if(a>b)
            return a;
        else
            return b;
                    
    }
    //Obtener el macximo numero de un arreglo
    public int maximo(int n, int pos){
        if(pos==n-1)
            return A[pos];
        else 
            return max(A[pos], maximo(n, pos+1));
    }
    
    //Obtener el numero de vocales en una String
    public int Num(String palabra, int n, int pos){
        if(pos<0)
            return n;
        else
            if(palabra.charAt(pos)!='a' && palabra.charAt(pos)!='e' && palabra.charAt(pos)!='i' && palabra.charAt(pos)!='o' && palabra.charAt(pos)!='u')
                return Num(palabra, n, pos-1);
            else
                return Num(palabra, n+1,pos-1);
            
    }
    
    public int fib(int n){
        if(n<=1)
            return n;
        else
            return fib(n-1)+fib(n-2);
    }
    
    //Fibonacci con un arreglo
    public int fibArreglo(int n){
        int [] F=new int [n+1];
        F[0]=0;
        F[1]=1;
        for(int i=2; i<=n; i++)
            F[i]=F[i-1]+F[i-2];
        return F[n];
    }
    
    public double factRec(int n){
        if (n==0)
            return 1;
        else
            return n*factRec(n-1);
    }
    
    public int factTail(int n, int a){
        if(n==0)
            return a;
        else
            return factTail(n-1, n*a);
                   
    }
    
    public int multTail(int n, int a, int acum){
        if(n==0)
            return 0;
        else
            if(n==1)
                return acum;
            else
                return multTail(n-1, a, a+acum);
                
    }
    
    //Maximo numero de un arreglo de forma tail.
     public int maxTail(int n, int pos, int acum){
        if(pos==n)
            return acum;
        else
            if(A[pos]>acum)
                return maxTail(n, pos+1, A[pos]);
            else
                return maxTail(n, pos+1, acum);
    }
    
    public static void main(String[] args) {
        RecursionEnClase miObjeto= new RecursionEnClase();
        int res=0;
        //res=miObjeto.factRec(10);
        //res=miObjeto.potRec(2, 4);
        //res=miObjeto.fib(8);
        //res=miObjeto.fibArreglo(43);
        //res=miObjeto.factTail(4, 5);
        //res=miObjeto.multTail(3, 9, 9);
        res=miObjeto.maxTail(6, 0, miObjeto.A[0]);
        //res=miObjeto.Num("Holaas",0, 5);
        System.out.print(res);
        
    }
    
}
