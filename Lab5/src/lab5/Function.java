
package lab5;

@FunctionalInterface
public interface Function {
    
    double function(double x);
    
    static double functionOneThree(double x){
        return Math.log(Math.pow(x, 3))-2;
    }
    
}
