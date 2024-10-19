public class Sukarela extends DaftarPegawai {
    // Constructor
    public Sukarela(String eName, String eAddress, String ePhone) {
        super(eName, eAddress, ePhone);
    }

    // Returns a zero pay value for this volunteer
    public double gajian() {
        return 0.0;
    }
}
