import java.util.Scanner;

public class soal5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plat1 = scanner.next();
        String plat2 = scanner.next();
        String plat3 = scanner.next();
        String plat4 = scanner.next();

        String gabunganPlat = plat1 + plat2 + plat3 + plat4;
        
        long gabunganAngka = Long.parseLong(gabunganPlat);

        if ((gabunganAngka - 999999) % 5 == 0) {
            System.out.println("Jalan");
        } else {
            System.out.println("Berhenti");
        }

        scanner.close();
    }
}
