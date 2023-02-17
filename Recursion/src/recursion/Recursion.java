
package recursion;


public class Recursion {
    
    public String limpiaString(String s){
       if(s.length()<=1)
           return s;
       else
           if(s.charAt(0)==s.charAt(1))
               return limpiaString(s.substring(1));
            else
               return s.substring(0, 1)+limpiaString(s.substring(1));
               
           
    }
    
    public int cuentaSubstring(String s, String sub){
        if(s.length()==0||sub.length()==0)
            return 0;
        else
            if(sub.length()<=s.length())
                if(sub.equals(s.substring(0, sub.length())))
                    return 1+cuentaSubstring(s.substring(1),sub);
                else
                    return cuentaSubstring(s.substring(1),sub);
            else
                return 0;
    }
    
    public int sumaDigitos(int n){
        if(n==0)
            return 0;
        else
           return (n%10)+sumaDigitos(n/10); 
    }
    
    public boolean anidacionCorrecta(String s){
        if(s.length()==0)
            return true;
        else
            if(s.length()%2==0){
                if(s.charAt(0)=='('&&s.charAt(1)==')'){
                    return anidacionCorrecta(s.substring(2));
                    
                }
                else
                    if(s.charAt(0)=='('&&s.charAt(s.length()-1)==')'){
                        return anidacionCorrecta(s.substring(1,s.length()-1));
                    }
                    else
                        return false;
                
            }
            else
                return false;
    }
    
    
    
    
}
