
package lab5;

public class TestOneDimensional {
    
    static void stat(){
        Mathmethods ms= new Mathmethods();
        ms.showInfoOneDimensional();
    }
    
    static class Nested{
        Mathmethods m= new Mathmethods();
    }
    
    public static void main(String[] args) {
        
        Mathmethods mm= new Mathmethods();
        
        TestOneDimensional.Nested a= new Nested();
        System.out.println("Nested class");
        a.m.showInfoOneDimensional();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Anonim class");
          System.out.println("f(х)=ln(x) bounds of x:[2,5] : "+mm.rectangleOdnomer(new Function() {
            @Override
            public double function(double x) {
            return Math.log(x);
            }
            }, 2, 5, mm.n));
          System.out.println("f(x)=x^2+x, bounds of x[3,4] : "+mm.rectangleOdnomer(new Function() {
            @Override
            public double function(double x) {
            return Math.pow(x, 2)+x;
            }
            }, 3, 4, mm.n));
          System.out.println("f(x)=e^(-x), bounds of x:[0.01,2] : "+mm.rectangleOdnomer(new Function() {
            @Override
            public double function(double x) {
            return Math.exp(-x);
            }
            }, 0.01, 2, mm.n));
          System.out.println("f(x)=x^2, bounds of x:[1,3] : "+mm.rectangleOdnomer(new Function() {
            @Override
            public double function(double x) {
            return x*x;
            }
            }, 1, 3, mm.n));
          System.out.println("f(x)=xsin(x), bounds of x:[0,1] : "+mm.rectangleOdnomer(new Function() {
            @Override
            public double function(double x) {
            return x*Math.sin(x);
            }
            }, 0, 1, mm.n));
        
        System.out.println("___________________________________________________");
        
        System.out.println("Static method reference");
        stat();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Instance method reference");
        mm.showInfoOneDimensional();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Lyambda");
        System.out.println("f(х)=ln(x) bounds of x:[2,5] : "+mm.rectangleOdnomer(x-> Math.log(x), 2, 5, mm.n));
        System.out.println("f(x)=x^2+x, bounds of x[3,4] : "+mm.rectangleOdnomer(x-> Math.pow(x, 2)+x, 3, 4, mm.n));
        System.out.println("f(x)=e^(-x), bounds of x:[0.01,2] : "+mm.rectangleOdnomer(x-> Math.exp(-x), 0.01, 2, mm.n));
        System.out.println("f(x)=x^2, bounds of x:[1,3] : "+mm.rectangleOdnomer(x-> x*x, 1, 3, mm.n));
        System.out.println("f(x)=xsin(x), bounds of x:[0,1] : "+mm.rectangleOdnomer(x-> x*Math.sin(x), 0, 1, mm.n));
    }
    
}
