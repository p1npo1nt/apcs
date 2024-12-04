import java.util.Scanner;
import java.util.Arrays;
import java.math.*;


public class newt {
    public static void main(String[] args) {
        System.out.println("Zero is: ");
        // choose both initial guess and a threshold
        System.out.println(newt(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
    }

    public static double f(double x) {
        return x*x*x - 4*x;
    }

    // h --> finite increment
    public static double fprime(double x, double h) {
        return (f(x+h)-f(x-h))/(2*h);
    }

    public static double newt(double x, double thresh) {
        double h = Math.pow(2, -7);

        // initial guess
        double x1 = x - (f(x) / fprime(x, h));

        while(Math.abs(x1 - x) > thresh) {
            x = x1;
            x1 = x - (f(x) / fprime(x,h));
        }

        return x1;
    }

}
