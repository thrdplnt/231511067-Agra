/*
 * Nama: Agra Anisa Ibtisamah
 * NIM: 231511067
 * Kelas: 2C
 */

import java.util.Scanner;

public class soal5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Kata pertama : ");
        String kataPertama = scanner.nextLine();
        System.out.print("Masukkan Kata kedua : ");
        String kataKedua = scanner.nextLine();
        
        int panjangkata = kataPertama.length() + kataKedua.length();  // menghitung panjang total dari kedua kata
        System.out.println(panjangkata);
        
        if (kataPertama.compareTo(kataKedua) > 0) { // membandingkan kedua kata secara lexicographical
            System.out.println("Yes");  // mencetak "Yes" jika kataPertama lebih besar dari kataKedua
        } else {
            System.out.println("No"); // Mmncetak "No" jika kataPertama tidak lebih besar dari kataKedua
        }
        
        // mengubah huruf pertama dari kedua kata menjadi huruf kapital
        String hasilKataPertama = kataPertama.substring(0, 1).toUpperCase() + kataPertama.substring(1);
        String hasilkataKedua = kataKedua.substring(0, 1).toUpperCase() + kataKedua.substring(1);
        System.out.println(hasilKataPertama + " " + hasilkataKedua);
        
        scanner.close();
    }
}
