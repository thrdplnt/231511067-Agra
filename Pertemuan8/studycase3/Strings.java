import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        String[] stringList;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nHow many strings do you want to sort? ");
        size = scan.nextInt();
        stringList = new String[size];
        System.out.println("\nEnter the strings...");
        for (int i = 0; i < size; i++)
            stringList[i] = scan.next();
        Sorting.insertionSort(stringList);
        System.out.println("Your strings in sorted order...");
        for (int i = 0; i < size; i++)
            System.out.println(stringList[i]);
        System.out.println();
    }
}