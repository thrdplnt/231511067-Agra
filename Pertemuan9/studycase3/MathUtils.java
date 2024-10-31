// public class MathUtils{
//     public static int factorial(int n){
//         int fac = 1;
//         for (int i=n; i>0; i--)
//         fac *= i;
//         return fac;
//     }
// }

public class MathUtils {
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 16) {
            throw new IllegalArgumentException("Factorial cannot be computed for numbers greater than 16 due to integer overflow");
        }

        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}