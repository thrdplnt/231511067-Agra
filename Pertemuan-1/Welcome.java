/*
 * Nama: Agra Anisa Ibtisamah
 * NIM: 231511067
 * Kelas: 2C
 */

/**
 * This program displays a greeting for the reader.
 * @version 1.30 2014-02-27
 * @author Cay Horstmann
 */

public class Welcome // mendeklarasikan kelas dengan nama Welcome
{
    public static void main(String[] args)
    {
        String greeting = "Welcome to Core Java!"; // variabel greeting bertipe string berisiskan text "Welcome to Core Java!"
        System.out.println(greeting); // mencetak variabel greeting ke layar
        for (int i = 0; i < greeting.length(); i++) // looping for sepanjang variabel greeting bertipe string
            System.out.print("="); // mencetak "=" setiap looping sepanjang isi variabael greeting
        System.out.println(); 
    }
}
