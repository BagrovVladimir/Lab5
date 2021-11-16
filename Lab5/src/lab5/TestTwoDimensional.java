
package lab5;

public class TestTwoDimensional {
    
    static void stat(){
        Mathmethods ms= new  Mathmethods();
        ms.showInfoTwoDimensional();
    }
    
    static class Nested{
        Mathmethods m= new Mathmethods();
        
    }
    
    public static void main(String[] args) {
        
        Mathmethods mm= new Mathmethods();
        
        TestTwoDimensional.Nested a= new Nested();
        System.out.println("Nested class");
        a.m.showInfoTwoDimensional();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Anonim class");
          System.out.println("f(x,y)=xy, bounds of x:[1,3] y:[1,3] : "+mm.rectangleDvymer(new Bivariate() {
            @Override
            public double functonBivariate(double x, double y) {
            return x*y;
            }
          }, 1, 3, 1, 3, mm.n2, mm.m2));
          System.out.println("f(x,y)=(x^2+x)(2y+1), bounds of x:[3,4] y:[7,10] : "+mm.rectangleDvymer(new Bivariate() {
            @Override
            public double functonBivariate(double x, double y) {
            return (Math.pow(x, 2)+x)*(2*y+1);
            }
          }, 3, 4, 7, 10, mm.n2, mm.m2));
          System.out.println("f(x,y)=e^(-x*y), bounds of x:[0.01,2] y:[0.5,4] : "+mm.rectangleDvymer(new Bivariate() {
            @Override
            public double functonBivariate(double x, double y) {
            return Math.exp(-x*y);
            }
          }, 0.01, 2, 0.5, 4, mm.n2, mm.m2));
          System.out.println("f(x,y)=x^2+y^2, bounds of x:[1,3] y:[1,2] : "+mm.rectangleDvymer(new Bivariate() {
            @Override
            public double functonBivariate(double x, double y) {
            return x*x+y*y;
            }
          }, 1, 3, 1, 2, mm.n2, mm.m2));
          System.out.println("f(x,y)=xysin(xy), bounds of x:[0,1] y:[0,1] : "+mm.rectangleDvymer(new Bivariate() {
            @Override
            public double functonBivariate(double x, double y) {
            return x*y*Math.sin(x*y);
            }
          }, 0, 1, 0, 1, mm.n2, mm.m2));
          
        System.out.println("___________________________________________________");
            
        System.out.println("Static method reference");
        stat();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Instance method reference");
        mm.showInfoTwoDimensional();
        
        System.out.println("___________________________________________________");
        
        System.out.println("Lyambda");
        System.out.println("f(x,y)=xy, bounds of x:[1,3] y:[1,3] : "+mm.rectangleDvymer((x,y)-> x*y, 1, 3, 1, 3, mm.n2, mm.m2));
        System.out.println("f(x,y)=(x^2+x)(2y+1), bounds of x:[3,4] y:[7,10] : "+mm.rectangleDvymer((x,y)-> (Math.pow(x, 2)+x)*(2*y+1), 3, 4, 7, 10, mm.n2, mm.m2));
        System.out.println("f(x,y)=e^(-x*y), bounds of x:[0.01,2] y:[0.5,4] : "+mm.rectangleDvymer((x,y)-> Math.exp(-x*y), 0.01, 2, 0.5, 4, mm.n2, mm.m2));
        System.out.println("f(x,y)=x^2+y^2, bounds of x:[1,3] y:[1,2] : "+mm.rectangleDvymer((x,y)-> x*x+y*y, 1, 3, 1, 2, mm.n2, mm.m2));
        System.out.println("f(x,y)=xysin(xy), bounds of x:[0,1] y:[0,1] : "+mm.rectangleDvymer((x,y)-> x*y*Math.sin(x*y), 0, 1, 0, 1, mm.n2, mm.m2));
        
        
    }
    
}
