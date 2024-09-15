import java.util.Scanner;

public class soal1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Input : ");

        String s = scanner.nextLine();
        String[] tokens = s.split("[^A-Za-z]+");
        int count = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                count++;
            }
        }
        
        System.out.println(count);
        
        for (String token : tokens) {
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }
        
        scanner.close();
    }
}
