public class Vinyl extends Produk {
    private String artis;
    private int tahunRilis;
    private int rpm; // Rotations per minute

    public Vinyl(String kode, String nama, double harga, int stok, String artis, int tahunRilis, int rpm, Pengiriman pengiriman) {
        super(kode, nama, harga, stok, pengiriman);
        this.artis = artis;
        this.tahunRilis = tahunRilis;
        this.rpm = rpm;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Vinyl: " + nama);
        System.out.println("Kode: " + kode);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
        System.out.println("Artis: " + artis);
        System.out.println("Tahun Rilis: " + tahunRilis);
        System.out.println("RPM: " + rpm);
    }
}