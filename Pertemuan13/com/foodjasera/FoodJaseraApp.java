//  Sebelum Refactoring dan Clean Code
import java.util.Scanner;

class MenuItem {
    private String nama;
    private int harga;

    public MenuItem(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " - Rp " + harga;
    }
}

class Kantin {
    private String nama;
    private MenuItem[] menu;

    public Kantin(String nama, MenuItem[] menu) {
        this.nama = nama;
        this.menu = menu;
    }

    public String getNama() {
        return nama;
    }

    public MenuItem[] getMenu() {
        return menu;
    }

    public void tampilkanMenu() {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }
}

class Pemesanan {
    private String pembeli;
    private Kantin kantin;
    private int totalHarga;

    public Pemesanan(String pembeli, Kantin kantin) {
        this.pembeli = pembeli;
        this.kantin = kantin;
        this.totalHarga = 0;
    }

    public void tambahPesanan(int menuIndex, int jumlah) {
        MenuItem menuItem = kantin.getMenu()[menuIndex];
        totalHarga += menuItem.getHarga() * jumlah;
    }

    public void tampilkanRincian() {
        System.out.println("\nFOODJASERA - DETAIL ORDER");
        System.out.println("Nama Pembeli: " + pembeli);
        System.out.println("Nama Kantin : " + kantin.getNama());
        System.out.println("Total Harga : Rp " + totalHarga);
    }
}

public class FoodJaseraApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kantin kedaiCatur = new Kantin("Kedai Catur", new MenuItem[]{
                new MenuItem("Nasi Goreng Katsu", 15000),
                new MenuItem("Nasi Goreng Ayam Geprek", 15000),
                new MenuItem("Air Mineral", 4000)
        });

        Kantin warungSemar = new Kantin("Warung Semar", new MenuItem[]{
                new MenuItem("Nasi Ayam Geprek", 12000),
                new MenuItem("Nasi Ayam Bakar", 12000),
                new MenuItem("Nasi Ayam Sambal Ijo", 12000),
                new MenuItem("Pop Ice", 6000)
        });

        System.out.print("Masukkan nama pembeli: ");
        String pembeli = scanner.nextLine();

        System.out.println("Pilih kantin:\n1. Kedai Catur\n2. Warung Semar");
        int pilihanKantin = scanner.nextInt();
        Kantin kantinPilihan = (pilihanKantin == 1) ? kedaiCatur : (pilihanKantin == 2) ? warungSemar : null;

        if (kantinPilihan == null) {
            System.out.println("Kantin tidak tersedia.");
            return;
        }

        Pemesanan pesanan = new Pemesanan(pembeli, kantinPilihan);

        System.out.println("Menu di " + kantinPilihan.getNama() + ":");
        kantinPilihan.tampilkanMenu();

        boolean lanjutPesan = true;
        while (lanjutPesan) {
            System.out.print("Pilih nomor menu: ");
            int pilihanMenu = scanner.nextInt();
            if (pilihanMenu < 1 || pilihanMenu > kantinPilihan.getMenu().length) {
                System.out.println("Pilihan menu tidak valid.");
                continue;
            }

            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = scanner.nextInt();

            pesanan.tambahPesanan(pilihanMenu - 1, jumlah);
            
            System.out.print("Pesan lagi? (y/n): ");
            lanjutPesan = scanner.next().equalsIgnoreCase("y");
        }

        pesanan.tampilkanRincian();
    }
}

//  Sesudah Refactoring dan Clean Code
package com.foodjasera;

import java.util.Scanner;
import java.util.logging.Logger;

public class FoodJaseraApp {
    private static final Logger logger = Logger.getLogger(FoodJaseraApp.class.getName());

    public static void main(String[] args) {
        logger.info("Inisialisasi aplikasi FoodJasera...");
        Scanner scanner = new Scanner(System.in);

        Kantin kedaiCatur = new Kantin("Kedai Catur", new MenuItem[]{
                new MenuItem("Nasi Goreng Katsu", 15000),
                new MenuItem("Nasi Goreng Ayam Geprek", 15000),
                new MenuItem("Air Mineral", 4000)
        });

        Kantin warungSemar = new Kantin("Warung Semar", new MenuItem[]{
                new MenuItem("Nasi Ayam Geprek", 12000),
                new MenuItem("Nasi Ayam Bakar", 12000),
                new MenuItem("Nasi Ayam Sambal Ijo", 12000),
                new MenuItem("Pop Ice", 6000)
        });

        logger.info("Mulai proses pemesanan.");
        logger.info("Masukkan nama pembeli:");
        String pembeli = scanner.nextLine();

        logger.info("Pilih kantin:\n1. Kedai Catur\n2. Warung Semar");
        int pilihanKantin = scanner.nextInt();

        Kantin kantinPilihan = getKantinPilihan(pilihanKantin, kedaiCatur, warungSemar);
        if (kantinPilihan == null) {
            logger.warning("Pilihan kantin tidak valid.");
            logger.info("Kantin tidak tersedia. Program selesai.");
            return;
        }

        Pemesanan pesanan = new Pemesanan(pembeli, kantinPilihan);
        prosesPemesanan(scanner, pesanan, kantinPilihan);
        pesanan.tampilkanRincian();
    }

    private static Kantin getKantinPilihan(int pilihan, Kantin kedaiCatur, Kantin warungSemar) {
        if (pilihan == 1) {
            return kedaiCatur;
        } else if (pilihan == 2) {
            return warungSemar;
        } else {
            return null;
        }
    }

    private static void prosesPemesanan(Scanner scanner, Pemesanan pesanan, Kantin kantinPilihan) {
        boolean lanjutPesan = true;

        while (lanjutPesan) {
            logger.info(String.format("Menu di %s:%n", kantinPilihan.getNama()));
            kantinPilihan.tampilkanMenu();

            int pilihanMenu = getMenuPilihan(scanner, kantinPilihan);
            if (pilihanMenu != -1) {
                int jumlah = getJumlahPesanan(scanner);
                if (jumlah > 0) {
                    pesanan.tambahPesanan(pilihanMenu - 1, jumlah);
                    logger.info(() -> String.format("Pesanan berhasil ditambahkan: Menu %d, Jumlah %d", pilihanMenu, jumlah));
                } else {
                    logger.warning("Jumlah pesanan harus lebih dari 0. Pesanan tidak diproses.");
                }
            } else {
                logger.warning("Pilihan menu tidak valid.");
            }
            logger.info("Pesan lagi? (y/n):");
            lanjutPesan = scanner.next().equalsIgnoreCase("y");
        }
    }

    private static int getMenuPilihan(Scanner scanner, Kantin kantinPilihan) {
        logger.info("Masukkan nomor menu:");
        int pilihanMenu = scanner.nextInt();

        if (pilihanMenu < 1 || pilihanMenu > kantinPilihan.getMenu().length) {
            logger.warning(() -> String.format("Pilihan menu tidak valid: %d", pilihanMenu));
            return -1;
        }

        return pilihanMenu;
    }

    private static int getJumlahPesanan(Scanner scanner) {
        logger.info("Masukkan jumlah pesanan:");
        int jumlah = scanner.nextInt();

        if (jumlah <= 0) {
            logger.warning(() -> "Jumlah pesanan harus lebih dari 0.");
            return -1;
        }

        return jumlah;
    }
}
