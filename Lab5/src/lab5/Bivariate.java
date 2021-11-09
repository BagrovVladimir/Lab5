
package lab5;

@FunctionalInterface
public interface Bivariate {
    double functonBivariate(double x, double y);
    
    static double functionThreeThree(double x, double y){
        return Math.exp(-x*y);
    }
    
}
