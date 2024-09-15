package com.polban.jtk.inventory;

public class Inventori {

    // Array untuk menyimpan objek Barang
    Barang[] barangs;

    // Inisialisasi barang-barang dengan data awal
    void initBarang() {
        barangs = new Barang[2];
        barangs[0] = new Barang("001", "Baju", 10);
        barangs[1] = new Barang("002", "Celana", 20);
    }

    // Menampilkan barang-barang yang ada
    void showBarang() {
        System.out.println(barangs[0].getNamaBarang() + "(" + 
        barangs[0].getStok() + ")");
        System.out.println(barangs[1].getNamaBarang() + "(" + 
        barangs[1].getStok() + ")");
    }

    // Melakukan pengadaan barang (penambahan stok)
    void pengadaan() {
        initBarang();
        
        // Menampilkan daftar barang sebelum pengadaan
        System.out.println("Daftar barang sebelum pengadaan:");
        showBarang();

        // Proses pengadaan (penambahan stok)
        barangs[0].tambahStok(20);  // Menambah stok barang pertama

        // Menampilkan daftar barang setelah pengadaan
        System.out.println("Daftar barang setelah pengadaan:");
        showBarang();
    }

    // Main method sebagai titik awal eksekusi program
    public static void main(String[] args) {
        Inventori beli = new Inventori();
        beli.pengadaan();
    }
}
