import java.util.Scanner;

public class soal4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah penjualan: ");
        int jumlahPenjualan = scanner.nextInt();

        int gajiPokok = 500000;
        int hargaPerItem = 50000;
        double gajiAkhir = gajiPokok;

        int totalPenjualan = jumlahPenjualan * hargaPerItem;
        int kekurangan = 15 - jumlahPenjualan;
        
        if (jumlahPenjualan > 80) {
            gajiAkhir += 0.35 * totalPenjualan;
        } else if (jumlahPenjualan >= 40) {
            gajiAkhir += 0.25 * totalPenjualan;
        } else if (jumlahPenjualan < 15) {
            gajiAkhir -= 0.15 * (kekurangan * hargaPerItem);
        } else {
            gajiAkhir += 0.10 * totalPenjualan;
        }
        System.out.println((int)gajiAkhir);
        scanner.close();
    }
}
