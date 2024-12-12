import java.util.HashMap;
import java.util.Scanner;

public class ProductCatalog {
    public static void main(String[] args) {
        HashMap<String, Double> productCatalog = new HashMap<>();
        productCatalog.put("Apple", 10000.0);
        productCatalog.put("Banana", 5000.0);  
        productCatalog.put("Orange", 7000.0);

        System.out.println("Katalog Produk: ");
        for (String product : productCatalog.keySet()) {
            System.out.println(product + " - Harga: " + productCatalog.get(product));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama produk yang ingin dicari: ");
        String productName = scanner.nextLine();

        if (productCatalog.containsKey(productName)) {
            System.out.println("Harga " + productName + ": " + productCatalog.get(productName));
        } else {
            System.out.println(productName + " tidak ditemukan.");
        }
        scanner.close();
    }
}
