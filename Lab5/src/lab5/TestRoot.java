
package lab5;

public class TestRoot {
    
    static void stat(){
        Mathmethods ms= new Mathmethods();
        ms.showInfoRoot();
    }
    
    static class Nested{
        Mathmethods m= new Mathmethods();
    }
    
    public static void main(String[] args) {
        
        Mathmethods mm=new Mathmethods();
        
        TestRoot.Nested a= new Nested();
        System.out.println("Nested class");
        a.m.showInfoRoot();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Anonim class");
         System.out.println("root of e^(-x)-0.5=0; bounds [0.01, 2] : x= "+mm.root(new Function() {
            @Override
            public double function(double x) {
                return Math.exp(-x)-0.5;
            }
        }, 0.01, 2, mm.precission));
         System.out.println("root of sin(x)-0.75=0; bounds [2, 3] : x= "+mm.root(new Function() {
            @Override
            public double function(double x) {
                return Math.sin(x)-0.75;
            }
        }, 2, 3, mm.precission));
         System.out.println("root of ln(x^3)-2=0; bounds [1, 3] : x= "+mm.root(new Function() {
            @Override
            public double function(double x) {
                return Math.log(Math.pow(x, 3))-2;
            }
        }, 1, 3, mm.precission));
         System.out.println("oot of tgx=0; bounds [2, 4] : x= "+mm.root(new Function() {
            @Override
            public double function(double x) {
                return Math.tan(x);
            }
         }, 2, 4, mm.precission));
          System.out.println("root of x^3-8x+2=0; bounds [1, 5] : x= "+mm.root(new Function() {
            @Override
            public double function(double x) {
                return x*x*x-8*x+2;
            }
          }, 1, 5, mm.precission));
          
         System.out.println("___________________________________________________"); 
        
        
        System.out.println("Static method reference");
        stat();
        
        System.out.println("___________________________________________________"); 
        
        
        System.out.println("Instance method reference");
        mm.showInfoRoot();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Lyambda");
        System.out.println("root of e^(-x)-0.5=0; bounds [0.01, 2] : x= "+mm.root(x-> Math.exp(-x)-0.5, 0.01, 2, mm.precission));
        System.out.println("root of sin(x)-0.75=0; bounds [2, 3] : x= "+mm.root(x-> Math.sin(x)-0.75, 2, 3, mm.precission));
        System.out.println("root of ln(x^3)-2=0; bounds [1, 3] : x= "+mm.root(x-> Math.log(Math.pow(x, 3))-2, 1, 3, mm.precission));
        System.out.println("root of tgx=0; bounds [2, 4] : x= "+mm.root(x-> Math.tan(x), 2, 4, mm.precission));
        System.out.println("root of x^3-8x+2=0; bounds [1, 5] : x= "+mm.root(x-> x*x*x-8*x+2, 1, 5, mm.precission));
      
    }
    
}
