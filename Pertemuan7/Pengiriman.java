public abstract class Pengiriman {
    protected String alamatPengiriman;
    protected double biayaDasar;

    public Pengiriman(String alamatPengiriman, double biayaDasar) {
        this.alamatPengiriman = alamatPengiriman;
        this.biayaDasar = biayaDasar;
    }

    public abstract double hitungBiayaPengiriman();

    public String getAlamatPengiriman() {
        return alamatPengiriman;
    }
}