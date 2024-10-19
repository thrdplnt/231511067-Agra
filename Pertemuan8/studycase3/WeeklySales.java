import java.util.Scanner;

public class WeeklySales {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of salespeople: ");
        int numSalespeople = scan.nextInt();
        SalesPerson[] salesStaff = new SalesPerson[numSalespeople];
        for (int i = 0; i < numSalespeople; i++) {
            System.out.println("Enter the first name for salesperson " + (i + 1) + ": ");
            String firstName = scan.next();
            System.out.println("Enter the last name for salesperson " + (i + 1) + ": ");
            String lastName = scan.next();
            System.out.println("Enter the total sales for salesperson " + (i + 1) + ": ");
            int totalSales = scan.nextInt();
            salesStaff[i] = new SalesPerson(firstName, lastName, totalSales);
        }
        Sorting.insertionSort(salesStaff);
        System.out.println("\nRanking of Sales for the week\n");
        for (SalesPerson s : salesStaff)
            System.out.println(s);
    }
}
