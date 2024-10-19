abstract public class DaftarPegawai {
   protected String name;
   protected String address;
   protected String phone;

   // Constructor
   public DaftarPegawai(String eName, String eAddress, String ePhone) {
       name = eName;
       address = eAddress;
       phone = ePhone;
   }

   // Returns a string including the basic employee information
   public String toString() {
       String result = "Name: " + name + "\n";
       result += "Address: " + address + "\n";
       result += "Phone: " + phone;
       return result;
   }

   // Abstract method to be defined in derived classes
   public abstract double gajian();
}
