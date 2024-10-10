public abstract class Produk {
    protected String kode;
    protected String nama;
    protected double harga;
    protected int stok;
    protected Pengiriman pengiriman;

    public Produk(String kode, String nama, double harga, int stok, Pengiriman pengiriman) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.pengiriman = pengiriman;
    }

    public abstract void tampilkanInfo();

    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            stok += jumlah;
            System.out.println("Stok " + nama + " ditambah: " + jumlah);
        } else {
            System.out.println("Jumlah tidak valid");
        }
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah > 0 && jumlah <= stok) {
            stok -= jumlah;
            System.out.println("Stok " + nama + " dikurangi: " + jumlah);
            return true;
        } else {
            System.out.println("Stok tidak mencukupi atau jumlah tidak valid");
            return false;
        }
    }

    public Pengiriman getPengiriman() {
        return pengiriman;
    }
}