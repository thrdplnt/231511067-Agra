/*
 * Nama: Agra Anisa Ibtisamah
 * NIM: 231511067
 * Kelas: 2C
 */

public class Constants { 
public static void main(String[] args) { 
 final double CM_PER_INCH = 2.54; // mendefinisikan variabel lokal CM_PER_INCH dengan nilai 2.54
 double paperWidth = 8.5; // variabel paperWidth bertipe double
 double paperHeight = 11; // variabel paperHeight bertipe double
 System.out.println("Paper size in centimeters: " + // print ke layar Paper size in centimeters
 paperWidth * CM_PER_INCH + " by " + paperHeight * // menghitung dan mencetak ukuran kertas dalam cm
 CM_PER_INCH); 
} 
}

public class Constants2 { 
 public static final double CM_PER_INCH = 2.54; // mendefinisikan variabel kelas CM_PER_INCH dengan nilai 2.54
 public static void main(String[] args) {
 double paperWidth = 8.5; // variabel paperWidth bertipe double
 double paperHeight = 11; // variabel paperHeight bertipe double
 System.out.println("Paper size in centimeters: " + paperWidth * // print ke layar Paper size in centimeters
 CM_PER_INCH + " by " + paperHeight * CM_PER_INCH); // menghitung dan mencetak ukuran kertas dalam cm
 } 
}
