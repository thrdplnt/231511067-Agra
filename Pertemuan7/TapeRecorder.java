public class TapeRecorder extends Produk {
    private String merek;
    private boolean adaRadio;

    public TapeRecorder(String kode, String nama, double harga, int stok, String merek, boolean adaRadio, Pengiriman pengiriman) {
        super(kode, nama, harga, stok, pengiriman);
        this.merek = merek;
        this.adaRadio = adaRadio;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Tape Recorder: " + nama);
        System.out.println("Kode: " + kode);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
        System.out.println("Merek: " + merek);
        System.out.println("Ada Radio: " + (adaRadio ? "Ya" : "Tidak"));
    }
}