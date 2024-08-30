/*
 * Nama: Agra Anisa Ibtisamah
 * NIM: 231511067
 * Kelas: 2C
 */

class convertDataType
{
 static short methodOne(long l)
 {
 int i = (int) l; // mengubah long menjadi integet
 return (short)i; // mengubah integer menjadi short lalu mengembalikan nilai
 }
 public static void main(String[] args)
 {
 double d = 10.25; // variabel d yang bernilai 10.25 bertipe double
 float f = (float) d; // mengubah variabel f bertipe double menjadi float
 byte b = (byte) methodOne((long) f); // mengubah float menjadi long setelah itu memanggil methodOne untuk konversi ke short lalu mengonversi short menjadi byte
 System.out.println(b); // menampilkan nilai b pada layar
 }
}
