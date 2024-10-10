public class TokoMusikOnline {
    public static void main(String[] args) {
        Pengiriman pengirimanVinyl = new PengirimanStandar("Gudang Vinyl - Jl. Musik No. 789");
        Pengiriman pengirimanTapeRecorder = new PengirimanStandar("Gudang Elektronik - Jl. Retro No. 456");

        Vinyl vinyl = new Vinyl("V001", "Abbey Road", 500000, 10, "The Beatles", 1969, 33, pengirimanVinyl);
        TapeRecorder tapeRecorder = new TapeRecorder("TR001", "Walkman Classic", 300000, 5, "Sony", true, pengirimanTapeRecorder);

        System.out.println("Informasi Produk:");
        vinyl.tampilkanInfo();
        System.out.println("\nBiaya Pengiriman: Rp" + vinyl.getPengiriman().hitungBiayaPengiriman());
        System.out.println("Alamat Pengiriman: " + vinyl.getPengiriman().getAlamatPengiriman());

        System.out.println("\n------------------------\n");

        tapeRecorder.tampilkanInfo();
        System.out.println("\nBiaya Pengiriman: Rp" + tapeRecorder.getPengiriman().hitungBiayaPengiriman());
        System.out.println("Alamat Pengiriman: " + tapeRecorder.getPengiriman().getAlamatPengiriman());

        System.out.println("\nMelakukan Transaksi:");
        vinyl.kurangiStok(2);
        tapeRecorder.tambahStok(3);
    }
}