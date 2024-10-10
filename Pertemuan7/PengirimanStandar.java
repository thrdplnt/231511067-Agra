public class PengirimanStandar extends Pengiriman {
    public PengirimanStandar(String alamatPengiriman) {
        super(alamatPengiriman, 10000); 
    }

    @Override
    public double hitungBiayaPengiriman() {
        return biayaDasar; 
    }
}