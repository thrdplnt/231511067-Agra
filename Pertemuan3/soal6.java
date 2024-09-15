import java.math.BigInteger;
import java.util.Scanner;

public class soal6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.next());
        BigInteger b = new BigInteger(scanner.next());
        BigInteger sum = a.add(b);  // a + b
        BigInteger product = a.multiply(b);  // a * b

        System.out.println(sum);
        System.out.println(product);

        scanner.close();
    }
}
