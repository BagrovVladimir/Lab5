
package lab5;

public class OdnomernyaFunction {
    
    public static final int n=100;
    
    public static void main(String[] args) {
        
        //inner classs, f(х)=ln(x), bounds of x:[2,5]
        Function function1= new FunkTwoOne();
        System.out.println("inner classs, f(х)=ln(x) bounds of x:[2,5] : "+rectangleOdnomer(function1, 2, 5, n));
        
        //anonim class, f(x)=x^2+x, bounds of x:[3,4]
        Function function2= new Function() {
            @Override
            public double function(double x) {
                return Math.pow(x, 2)+x;
            }
        };
        System.out.println("anonim class, f(x)=x^2+x, bounds of x[3,4] : "+rectangleOdnomer(function2, 3, 4, n));
        
        //static method reference, f(x)=e^(-x), bounds of x:[0.01,2]
        Function function3= Function::functionTwoThree;
        System.out.println("static method reference, f(x)=e^(-x), bounds of x:[0.01,2] : "+rectangleOdnomer(function3, 0.01, 2, n));
        
        //instance reference method, f(x)=x^2, bounds of x:[1,3]
        FunkTwoFoor ftf= new FunkTwoFoor();
        Function function4= ftf::xkvadrat;
        System.out.println("instance reference method, f(x)=x^2, bounds of x:[1,3] : "+rectangleOdnomer(function4, 1, 3, n));
        
        //lyambda, f(x)=x*sin(x), bounds of x:[0,1]
        Function function5=x -> x*Math.sin(x);
        System.out.println("lyambda, f(x)=x*sin(x), bounds of x:[0,1] : "+rectangleOdnomer(function5, 0, 1, n));
        
        
        
    }
    
    public static double rectangleOdnomer(Function f, double aBound, double bBound, int n){
        double length = (bBound-aBound)/n;
        double xi;
        double xiplus1;
        double square;
        double rezultSquare=0;
        double h;
        
        xi=aBound;
 
        for (int i = 0; i < n; i++) {
            xiplus1 = xi+length;
            h=(xiplus1+xi)/2;
            square = length*f.function(h);
            rezultSquare=rezultSquare+square;
            xi=xiplus1;  
        }
        return rezultSquare;
    }
    
    public static class FunkTwoOne implements Function{

        @Override
        public double function(double x) {
            return  Math.log(x);
        }
        
    }
    
    public static class FunkTwoFoor{
        double xkvadrat(double x){
            return x*x;
        }
    }
    
}
