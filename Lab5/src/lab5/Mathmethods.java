
package lab5;

public class Mathmethods implements Info{
    
    public double precission = 1e-5;
    
    public double root(Function f, double aBound, double bBound, double precision){
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
    
    public int n=100;
    
    public double rectangleOdnomer(Function f, double aBound, double bBound, int n){
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
    
    public int n2=100;
    public int m2=100;
    
    public double rectangleDvymer(Bivariate f, double axBound, double bxBound, double ayBound, double byBound,  int n, int m){
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

    @Override
    public void showInfoRoot() {
        
        System.out.println("root of e^(-x)-0.5=0; bounds [0.01, 2] : x= "+root(x-> Math.exp(-x)-0.5, 0.01, 2, precission));
        System.out.println("root of sin(x)-0.75=0; bounds [2, 3] : x= "+root(x-> Math.sin(x)-0.75, 2, 3, precission));
        System.out.println("root of ln(x^3)-2=0; bounds [1, 3] : x= "+root(x-> Math.log(Math.pow(x, 3))-2, 1, 3, precission));
        System.out.println("root of tgx=0; bounds [2, 4] : x= "+root(x-> Math.tan(x), 2, 4, precission));
        System.out.println("root of x^3-8x+2=0; bounds [1, 5] : x= "+root(x-> x*x*x-8*x+2, 1, 5, precission));
    }
    
    public void showInfoOneDimensional(){
        System.out.println("f(х)=ln(x) bounds of x:[2,5] : "+rectangleOdnomer(x-> Math.log(x), 2, 5, n));
        System.out.println("f(x)=x^2+x, bounds of x[3,4] : "+rectangleOdnomer(x-> Math.pow(x, 2)+x, 3, 4, n));
        System.out.println("f(x)=e^(-x), bounds of x:[0.01,2] : "+rectangleOdnomer(x-> Math.exp(-x), 0.01, 2, n));
        System.out.println("f(x)=x^2, bounds of x:[1,3] : "+rectangleOdnomer(x-> x*x, 1, 3, n));
        System.out.println("f(x)=xsin(x), bounds of x:[0,1] : "+rectangleOdnomer(x-> x*Math.sin(x), 0, 1, n));
    }
    
    public void showInfoTwoDimensional(){
        System.out.println("f(x,y)=xy, bounds of x:[1,3] y:[1,3] : "+rectangleDvymer((x,y)-> x*y, 1, 3, 1, 3, n2, m2));
        System.out.println("f(x,y)=(x^2+x)(2y+1), bounds of x:[3,4] y:[7,10] : "+rectangleDvymer((x,y)-> (Math.pow(x, 2)+x)*(2*y+1), 3, 4, 7, 10, n2, m2));
        System.out.println("f(x,y)=e^(-x*y), bounds of x:[0.01,2] y:[0.5,4] : "+rectangleDvymer((x,y)-> Math.exp(-x*y), 0.01, 2, 0.5, 4, n2, m2));
        System.out.println("f(x,y)=x^2+y^2, bounds of x:[1,3] y:[1,2] : "+rectangleDvymer((x,y)-> x*x+y*y, 1, 3, 1, 2, n2, m2));
        System.out.println("f(x,y)=xysin(xy), bounds of x:[0,1] y:[0,1] : "+rectangleDvymer((x,y)-> x*y*Math.sin(x*y), 0, 1, 0, 1, n2, m2));
        
    }
    
    
    
}
