public class Direktur extends Pegawai {
    private double bonus;

    // Constructor
    public Direktur(String eName, String eAddress, String ePhone, String socSecNumber, double rate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        bonus = 0;  // bonus has yet to be awarded
    }

    // Awards the specified bonus to this executive
    public void awardBonus(double execBonus) {
        bonus = execBonus;
    }

    // Computes and returns the pay for an executive
    public double gajian() {
        double payment = super.gajian() + bonus;
        bonus = 0;
        return payment;
    }
}
