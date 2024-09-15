import java.util.Scanner;

public class soal2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = new String[3];
        int[] numbers = new int[3];
        
        for (int i = 0; i < 3; i++) {
            strings[i] = scanner.next();  
            numbers[i] = scanner.nextInt();  
        }

        System.out.println("================================");
        
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-15s%03d\n", strings[i], numbers[i]);
        }
        
        System.out.println("================================");
        
        scanner.close();
    }
}
