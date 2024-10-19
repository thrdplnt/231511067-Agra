public class SalesPerson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    public SalesPerson(String first, String last, int sales) {
        super();
        this.firstName = first;
        this.lastName = last;
        this.totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    public boolean equals(Object other) {
        return (lastName.equals(((SalesPerson) other).getLastName())
                && firstName.equals(((SalesPerson) other).getFirstName()));
    }

    public int compareTo(Object other) {
        SalesPerson otherPerson = (SalesPerson) other;
        int salesComparison = Integer.compare(otherPerson.totalSales, this.totalSales);
        if (salesComparison == 0) {
            int lastNameComparison = this.lastName.compareTo(otherPerson.lastName);
            if (lastNameComparison == 0) {
                return this.firstName.compareTo(otherPerson.firstName);
            } else {
                return lastNameComparison;
            }
        } else {
            return salesComparison;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }
}
