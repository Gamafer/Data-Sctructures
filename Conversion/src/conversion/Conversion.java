
package conversion;

/**
 *
 * @author garro
 */
public class Conversion {

    public String base10A2 (int num){
        String x="";
        if(num>7)
        while(num/2!=0 && num/2!=1){
            x+=num%2;
            num=num/2;
        }
        else
            while(num/2!=0){
            x+=num%2;
            num=num/2;
        }
     
            x+=num%2;
            x+=num/2; 
        
        if(x.length()<=3)
            while(x.length()<=3)
                x+="0";
        
            
        num=Integer.parseInt(x);
        int num2=0, num3=0;
        while(num!=0){
            num2=num%10;
            num3=(num3*10)+num2;
            num=num/10;
        }
        String xx="";
        int i=0;
        if(num3!=0){
             while(x.charAt(i)=='0'){
                num3=num3*10;
                i++;
            }
        
            xx+=num3; 
         
            i=x.length()-1;
            while(x.charAt(i)=='0'){
                xx="0"+xx;
                i--;
            }
        }
        else
            xx="0000";
        
        return xx;
    }
    
    
    public static void main(String[] args) {
        Conversion c=new Conversion();
        String x=c.base10A2(19);
        System.out.print(x);
    }
    
}
