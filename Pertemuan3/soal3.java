import java.util.Scanner;

public class soal3 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        int A = Integer.parseInt(parts[0]);
        char operator = parts[1].charAt(0);
        int B = Integer.parseInt(parts[2]);

        if (A < 1 || A > 1000 || B < 1 || B > 1000) {
            System.out.println("Input di luar batas 1 ≤ A, B ≤ 1000");
            return; 
        }

        int result = 0;

        switch (operator) {
            case '+':
                result = A + B;
                break;
            case '-':
                result = A - B;
                break;
            case '*':
                result = A * B;
                break;
            case '/':
                result = A / B;
                break;
            case '%':
                result = A % B;
                break;
            default:
                System.out.println("Operator tidak valid");
                return;
        }

        System.out.println(result);

        scanner.close();
    }
}