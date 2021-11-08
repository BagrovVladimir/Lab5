
package lab5;

public class Lab5 {
    
    private static final double precission = 1e-5;
    //static double x;

    public static void main(String[] args) {
        
        //inner class, e^(-x)-0.5=0
        Function function1=  new FunkOneOne();
        System.out.println("inner class, root of e^(-x)-0.5=0 : x= "+root(function1, 0.01, 2, precission));
        
        //anonim class, sin(x)-0.75=0
        Function function2= new Function() {
            @Override
            public double function(double x) {
                return Math.sin(x)-0.75;
            }
        };
        System.out.println("anonim class, root of sin(x)-0.75=0 : x= "+root(function2, 2, 3, precission));
        
        //static method referance, ln(x^3)-2=0
        Function function3= Function::functionOneThree;
        System.out.println("static method referance, root of ln(x^3)-2=0  : x= "+root(function3, 1, 3, precission));
       
        //instance method reference, tgx=0 
        FunkOneFour fof = new FunkOneFour();
        Function function4=fof::tang;
        System.out.println("instance method reference, root of tgx=0 : x= "+root(function4, 2, 4, precission));
        
        //lyambda, x^3-8x+2=0
        Function function5 = x -> x*x*x-8*x+2;
        System.out.println("lyambda, root of x^3-8x+2=0 : x= "+root(function5, 1, 5, precission));
      
    }
    
    public static double root(Function f, double aBound, double bBound, double precision){
        while((bBound-aBound)>precision){
            double middle = (aBound+bBound)/2;
            if (f.function(middle) == 0)
                return middle;
            if(f.function(aBound)<0 && f.function(middle)<0 || f.function(aBound)>0 && f.function(middle)>0)
                aBound=middle;
            else if(f.function(middle)>0 && f.function(bBound)>0 || f.function(middle)<0 && f.function(bBound)<0)
                bBound=middle;
        }
        return (aBound+bBound)/2;
    }
    
    private static class FunkOneOne implements Function{

        @Override
        public double function(double x) {
            return Math.exp(-x)-0.5;
        }
        
    }
    
    private static class FunkOneFour{
        double tang(double x){
            return Math.tan(x);
        }
    }
}
