/*
 * Nama: Agra Anisa Ibtisamah
 * NIM: 231511067
 * Kelas: 2C
 */

import java.util.Scanner;

public class soal1 {

    public static void main(String[] args){
        String input; // untuk menyimpan input dari pengguna
        Scanner scan = new Scanner(System.in); // membuat objek Scanner untuk membaca input 

        for (int i=1; i<=6; i++){
            System.out.print("Masukkan Angka = ");
            input = scan.nextLine(); // membaca inut dari pengguna
            try {
                long number = Long.parseLong(input); // mengubah input menjadi tipe data long
                
                // memeriksa rentang nilai dan mencetak tipe data yang dapat menampung nilai tersebut
                if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
                    System.out.println(input + " dapat disimpan dalam: \n byte\n short\n int\n long");
                }
                else if(number >= Short.MIN_VALUE && number <= Short.MAX_VALUE){
                    System.out.println(input + " dapat disimpan dalam: \n short\n int\n long");
                }
                else if(number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE){
                    System.out.println(input + " dapat disimpan dalam: \n int\n long");
                }
                else if(number >= Long.MIN_VALUE && number <= Long.MAX_VALUE){
                    System.out.println(input + " dapat disimpan dalam: \n long");
                }
            } catch (NumberFormatException e) { // agar input tidak dapat diubah menjadi angka
                System.out.println("tidak dapat disimpan di mana pun");
            }
        }

        scan.close();
    }
}

