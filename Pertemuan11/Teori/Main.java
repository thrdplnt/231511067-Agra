import java.util.*;

class Family {
    private Map<String, Uncle> uncles = new HashMap<>();
    private Map<String, Niece> nieces = new HashMap<>();

    // Constructor
    public Family() {
        // Initializes an empty family with no uncles or nieces
    }

    // 1.Paman dan keponakan dapat ditambahkan ke dalam sistem. Tanggal ulang tahun setiap keponakan juga dicatat.
    public boolean addNiece(String name, int day, int month) {
        if (nieces.containsKey(name)) return false;
        nieces.put(name, new Niece(name, day, month));
        return true;
    }

    // Menambahkan Paman
    public boolean addUncle(String name) {
        if (uncles.containsKey(name)) return false;
        uncles.put(name, new Uncle(name));
        return true;
    }

    // mencari keponakan berdasarkan nama
    public Niece findNiece(String name) {
        return nieces.get(name);
    }

    // mencari paman berdasarkan nama
    public Uncle findUncle(String name) {
        return uncles.get(name);
    }

    // 2.	Daftar paman dapat dihasilkan dalam urutan alfabet berdasarkan nama.
    public void listUncles() {
        uncles.keySet().stream().sorted().forEach(System.out::println);
    }

    // 3.	Daftar keponakan dapat dihasilkan berdasarkan urutan tanggal ulang tahun.
    public void listNieces() {
        nieces.values().stream()
                .sorted(Comparator.comparing(Niece::getBirthday))
                .forEach(niece -> System.out.println(niece.getName()));
    }

    // Metode untuk mendapatkan daftar keponakan
    public List<Niece> getNieces() {
        return new ArrayList<>(nieces.values());
    }

    // Metode untuk mendapatkan daftar paman
    public List<Uncle> getUncles() {
        return new ArrayList<>(uncles.values());
    }
}

class Uncle {
    private String name;
    private Map<Niece, String> presents = new HashMap<>();

    Uncle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 5.	Seorang paman dapat memasukkan hadiah yang dia niatkan untuk diberikan kepada salah satu keponakannya
    public boolean addPresent(Niece recipient, String description) {
        if (presents.containsKey(recipient) || presents.containsValue(description)) return false;
        presents.put(recipient, description);
        return true;
    }

    // 6.	Daftar hadiah yang diberikan oleh salah satu paman dapat dihasilkan, menunjukkan keponakan yang akan menerimanya. Keponakan yang belum dipilihkan hadiah juga harus tercantum.
    public void listPresents(List<Niece> niecesList) {
        System.out.println("Hadiah dari " + name + ":");
        for (Niece niece : niecesList) {
            if (presents.containsKey(niece)) {
                System.out.println("- " + niece.getName() + ": " + presents.get(niece));
            } else {
                System.out.println("- " + niece.getName() + ": Belum ada hadiah yang dipilih");
            }
        }
    }
}

class Niece {
    private String name;
    private int day, month;
    private Map<Uncle, String> receivedPresents = new HashMap<>();

    Niece(String name, int day, int month) {
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    // Dapatkan tanggal lahir keponakan untuk pengurutan
    public Calendar getBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.DAY_OF_MONTH, day);
        birthday.set(Calendar.MONTH, month - 1); // month is 0-based
        return birthday;
    }

    // 7.	Daftar hadiah yang akan diterima oleh salah satu keponakan dapat dihasilkan, menunjukkan paman yang memberikan hadiah tersebut. Paman yang tidak memberikan hadiah kepada keponakan tersebut juga harus tercantum.
    public void listPresents(List<Uncle> unclesList) {
        System.out.println("Hadiah untuk " + name + ":");
        for (Uncle uncle : unclesList) {
            if (receivedPresents.containsKey(uncle)) {
                System.out.println("- Dari " + uncle.getName() + ": " + receivedPresents.get(uncle));
            } else {
                System.out.println("- Dari " + uncle.getName() + ": Belum ada hadiah yang dipilih");
            }
        }
    }

    // 8.	Daftar hadiah untuk seorang keponakan dapat dihapus (itu dilakukan setelah ulang tahunnya berlalu).
    public int clearPresents() {
        int count = receivedPresents.size();
        receivedPresents.clear();
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Family family = new Family();

        // 1. Tambahkan paman dan keponakan beserta tanggal lahir
        family.addUncle("Mark");
        family.addUncle("Haechan");
        family.addUncle("Pieter");
        family.addNiece("Agra", 15, 3);
        family.addNiece("Chika", 22, 5);
        family.addNiece("Elsa", 10, 12);
        family.addNiece("Aulia", 5, 8);

        // 2. Daftar paman dalam urutan alfabet
        System.out.println("Daftar Paman (Urut Alfabet):");
        family.listUncles();

        // 3. Daftar keponakan berdasarkan tanggal ulang tahun
        System.out.println("\nDaftar Keponakan (Urut Tanggal Lahir):");
        family.listNieces();

        // Ambil objek paman dan keponakan untuk digunakan dalam pemenuhan syarat
        Uncle mark = family.findUncle("Mark");
        Uncle haechan = family.findUncle("Haechan");
        Niece agra = family.findNiece("Agra");
        Niece chika = family.findNiece("Chika");

        // 4. Catat hadiah yang akan diberikan oleh setiap paman
        if (mark != null) {
            mark.addPresent(agra, "Buku 'Laut Bercerita'");
            mark.addPresent(chika, "Permainan Puzzle");
        }

        if (haechan != null) {
            haechan.addPresent(agra, "Mainan Robot");
            haechan.addPresent(chika, "Boneka Beruang");
        }

        // 6. Daftar hadiah yang diberikan oleh setiap paman
        System.out.println("\nDaftar Hadiah dari Mark:");
        if (mark != null) mark.listPresents(family.getNieces());

        System.out.println("\nDaftar Hadiah dari Haechan:");
        if (haechan != null) haechan.listPresents(family.getNieces());

        // 7. Daftar hadiah yang akan diterima oleh setiap keponakan
        System.out.println("\nDaftar Hadiah yang Akan Diterima oleh Agra:");
        if (agra != null) agra.listPresents(family.getUncles());

        System.out.println("\nDaftar Hadiah yang Akan Diterima oleh Chika:");
        if (chika != null) chika.listPresents(family.getUncles());

        // 8. Hapus hadiah setelah ulang tahun (simulasi untuk Agra)
        System.out.println("\nMenghapus Hadiah Setelah Ulang Tahun Agra:");
        if (agra != null) {
            int jumlahDihapus = agra.clearPresents();
            System.out.println("Jumlah hadiah yang dihapus untuk Agra: " + jumlahDihapus);
        }

        // 5. Pastikan setiap hadiah unik
        // Coba menambahkan hadiah yang sama untuk memastikan fitur keunikan berfungsi
        boolean hasilTambah = mark.addPresent(agra, "Buku 'Laut Bercerita'"); // Seharusnya gagal
        System.out.println("\nApakah penambahan hadiah duplikat berhasil? " + (hasilTambah ? "Ya" : "Tidak"));

        // Tampilkan daftar hadiah setelah mencoba menambahkan duplikat
        System.out.println("\nDaftar Hadiah dari Mark Setelah Mencoba Menambahkan Duplikat:");
        if (mark != null) mark.listPresents(family.getNieces());
    }
}
