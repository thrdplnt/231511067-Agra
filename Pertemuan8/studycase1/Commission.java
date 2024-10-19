public class Commission extends PekerjaLepas {
    private double totalSales;
    private double commissionRate;

    // Constructor
    public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    // Method to add sales
    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    // Override the pay method to include commission
    @Override
    public double gajian() {
        double payment = super.gajian();
        payment += totalSales * commissionRate;
        totalSales = 0;  // Reset sales after pay
        return payment;
    }

    // Override the toString method to include commission details
    @Override
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        result += "\nCommission Rate: " + (commissionRate * 100) + "%";
        return result;
    }
}
