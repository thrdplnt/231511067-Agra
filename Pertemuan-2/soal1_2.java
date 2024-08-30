import java.util.Scanner;

public class soal1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Membaca jumlah kasus uji
        
        for (int i = 0; i < T; i++) {
            try {
                long n = sc.nextLong();  // Membaca input integer

                // Menampilkan output nomor yang diberikan
                System.out.println(n + " can be fitted in:");

                // Memeriksa apakah nomor bisa disimpan dalam tipe data byte
                if (n >= -128 && n <= 127) {
                    System.out.println("* byte");
                }
                // Memeriksa apakah nomor bisa disimpan dalam tipe data short
                if (n >= -32768 && n <= 32767) {
                    System.out.println("* short");
                }
                // Memeriksa apakah nomor bisa disimpan dalam tipe data int
                if (n >= -2147483648L && n <= 2147483647L) {
                    System.out.println("* int");
                }
                // Memeriksa apakah nomor bisa disimpan dalam tipe data long
                if (n >= -9223372036854775808L && n <= 9223372036854775807L) {
                    System.out.println("* long");
                }

            } catch (Exception e) {
                // Jika nomor tidak bisa disimpan di tipe data apapun
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}
