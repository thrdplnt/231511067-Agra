public class Karyawan {
   private DaftarPegawai[] staffList;

   // Constructor
   public Karyawan() {
       // Increase size to 8
       staffList = new DaftarPegawai[8];

       staffList[0] = new Direktur("Sam", "123 Main Line", "555-0469", "123-45-6789", 2423.07);
       staffList[1] = new Pegawai("Carla", "456 Off Line", "555-0101", "987-65-4321", 1246.15);
       staffList[2] = new Pegawai("Woody", "789 Off Rocker", "555-0000", "010-20-3040", 1169.23);
       staffList[3] = new PekerjaLepas("Diane", "678 Fifth Ave.", "555-0690", "958-47-3625", 10.55);
       staffList[4] = new Sukarela("Norm", "987 Suds Blvd.", "555-8374");
       staffList[5] = new Sukarela("Cliff", "321 Duds Lane", "555-7282");

       // Add two commission employees
       staffList[6] = new Commission("John", "123 Commerce St.", "555-1111", "555-55-5555", 6.25, 0.20);
       staffList[7] = new Commission("Jane", "456 Market St.", "555-2222", "555-66-6666", 9.75, 0.15);

       // Adding hours to hourly and commission employees
       ((Direktur) staffList[0]).awardBonus(500.00);
       ((PekerjaLepas) staffList[3]).addHours(40);
       ((Commission) staffList[6]).addHours(35); // Adding hours for Commission employee John
       ((Commission) staffList[7]).addHours(40); // Adding hours for Commission employee Jane

       ((Commission) staffList[6]).addSales(400);
       ((Commission) staffList[7]).addSales(950);
   }

   // Pays all staff members
   public void payday() {
       double amount;
       for (int count = 0; count < staffList.length; count++) {
           System.out.println(staffList[count]); // polymorphic
           amount = staffList[count].gajian();  // polymorphic

           if (amount == 0.0)
               System.out.println("Thanks!");
           else
               System.out.println("Paid: " + amount);

           System.out.println("------------------------------");
       }
   }
}
