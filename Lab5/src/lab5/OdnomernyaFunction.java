
package lab5;

public class OdnomernyaFunction {
    
    public static final int n=100;
    
    public static void main(String[] args) {
        
    }
    
    public static double rectangleOdnomer(Function f, double aBound, double bBound, int n){
        double length = (bBound-aBound)/n;
        double xi;
        double xiplus1;
        double square;
        double rezultSquare=0;
        double h;
 
        for (int i = 0; i < n; i++) {
            xi = aBound;
            xiplus1 = xi+length;
            h=(xiplus1+xi)/2;
            square = length*f.function(h);
            rezultSquare=rezultSquare+square;
            xi=xiplus1;  
        }
        return rezultSquare;
    }
    
}
