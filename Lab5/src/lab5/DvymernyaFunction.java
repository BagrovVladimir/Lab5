
package lab5;

public class DvymernyaFunction {
    public static final int n=100;
    public static final int m=100;
    
    public static void main(String[] args) {
        
        //inner class, f(x,y)=xy, bounds of x:[1,3] y:[1,3]
        Bivariate function1= new FunkThreeOne();
        System.out.println("inner class, f(x,y)=xy, bounds of x:[1,3] y:[1,3] : "+rectangleDvymer(function1, 1, 3, 1, 3, n, m));
        
        //anonim class, f(x,y)=(x^2+x)(2y+1), bounds of x:[3,4] y:[7,10]
        Bivariate function2= new Bivariate() {
            @Override
            public double functonBivariate(double x, double y){
            return (Math.pow(x, 2)+x)*(2*y+1);
            }
                };
        System.out.println("anonim class, f(x,y)=(x^2+x)(2y+1), bounds of x:[3,4] y:[7,10] : "+rectangleDvymer(function2, 3, 4, 7, 10, n, m));
        
        //static method reference, f(x,y)=e^(-xy), bounds of x:[0.01,2] y:[0.5,4]
        Bivariate function3=Bivariate::functionThreeThree;
        System.out.println("static method reference, f(x,y)=e^(-x*y), bounds of x:[0.01,2] y:[0.5,4] : "+rectangleDvymer(function3, 0.01, 2, 0.5, 4, n, m));
        
        //instance method  reference, f(x,y)=x^2+y^2, bounds of x:[1,3] y:[1,2]
        FunkThreeFour fthf= new  FunkThreeFour();
        Bivariate function4= fthf::xkvadratPlusykvadrat;
        System.out.println("instance method  reference, f(x,y)=x^2+y^2, bounds of x:[1,3] y:[1,2] : "+rectangleDvymer(function4, 1, 3, 1, 2, n, m));
        
        //lyambda, f(x,y)=xysin(xy), bounds of x:[0,1] y:[0,1]
        Bivariate function5= (x,y)-> x*y*Math.sin(x*y);
        System.out.println("lyambda, f(x,y)=xysin(xy), bounds of x:[0,1] y:[0,1] : "+rectangleDvymer(function5, 0, 1, 0, 1, n, m));
        
        
    }
    
    public static double rectangleDvymer(Bivariate f, double axBound, double bxBound, double ayBound, double byBound,  int n, int m){
        double xi;
        double xiplus1;
        double yi;
        double yiplus1;
        double rez=0;
        double sumRez=0;
        
        double lenghtX=(bxBound-axBound)/n;
        double lentghtY=(byBound-ayBound)/m;
        double square=lenghtX*lentghtY;
                
        
        yi=ayBound;
        
        for (int j = 0; j < m; j++) {
            xi=axBound;
            yiplus1=yi+lentghtY;
            for (int i = 0; i < n; i++) {
                xiplus1=xi+lenghtX;
                rez=square*(f.functonBivariate((lenghtX/2+xi), (lentghtY+yi)));
                sumRez=sumRez+rez;
                xi=xiplus1; 
            }
            yi=yiplus1;   
        }
        
        return sumRez;  
    }
    
    private static class FunkThreeOne implements Bivariate{

        @Override
        public double functonBivariate(double x, double y) {
            return x*y;
        } 
    }
    
    private static class FunkThreeFour{
        double xkvadratPlusykvadrat(double x, double y){
            return x*x+y*y;  
        }
    }
}
