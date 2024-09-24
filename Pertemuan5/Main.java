import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Person {
    String nama;
    String kode;

    public Person(String nama, String kode) {
        this.nama = nama;
        this.kode = kode;
    }
}

class Mahasiswa extends Person {
    String kodeKelas;

    public Mahasiswa(String nama, String nim, String kodeKelas) {
        super(nama, nim);
        this.kodeKelas = kodeKelas;
    }
}

class Dosen extends Person {
    public Dosen(String nama, String kodeDosen) {
        super(nama, kodeDosen);
    }
}

class MataKuliah {
    String nama;
    String kode;

    public MataKuliah(String nama, String kode) {
        this.nama = nama;
        this.kode = kode;
    }
}

class Ruangan {
    String nama;

    public Ruangan(String nama) {
        this.nama = nama;
    }
}

class Jadwal {
    String hari;
    LocalTime waktuMulai;
    LocalTime waktuSelesai;
    MataKuliah mataKuliah;
    Dosen dosen;
    Ruangan ruangan;
    String kelas;

    public Jadwal(String hari, LocalTime waktuMulai, LocalTime waktuSelesai, MataKuliah mataKuliah, Dosen dosen, Ruangan ruangan, String kelas) {
        this.hari = hari;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
        this.ruangan = ruangan;
        this.kelas = kelas;
    }
}

class SistemAkademik {
    List<Dosen> dosen = new ArrayList<>();
    List<MataKuliah> mataKuliah = new ArrayList<>();
    List<Ruangan> ruangan = new ArrayList<>();
    List<Jadwal> jadwal = new ArrayList<>();
    List<Mahasiswa> mahasiswa = new ArrayList<>();  

    public void tambahMahasiswa(Mahasiswa mhs) {
        mahasiswa.add(mhs);  
    }
    
    public void tambahDosen(Dosen dsn) {
        dosen.add(dsn);
    }

    public void tambahMataKuliah(MataKuliah mk) {
        mataKuliah.add(mk);
    }

    public void tambahRuangan(Ruangan r) {
        ruangan.add(r);
    }

    public void tambahJadwal(Jadwal j) {
        jadwal.add(j);
    }

    public void tampilkanMahasiswa() {
        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mhs : mahasiswa) {
            System.out.printf("Nama: %s, NIM: %s, Kelas: %s%n", mhs.nama, mhs.kode, mhs.kodeKelas);
        }
    }

    public void tampilkanDosen() {
        System.out.println("Data Dosen:");
        for (Dosen dsn : dosen) {
            System.out.printf("Nama: %s, Kode: %s%n", dsn.nama, dsn.kode);
        }
    }

    public void tampilkanJadwal() {
        String[] hari = {"SENIN", "SELASA", "RABU", "KAMIS", "JUMAT"};
        for (String h : hari) {
            System.out.println("\n" + h + ":");
            for (Jadwal j : jadwal) {
                if (j.hari.equals(h)) {
                    String[] dosenList = j.dosen.nama.split(";"); 
                    String dosenTampil = String.join(", ", dosenList); 
                    
                    System.out.printf("%s-%s | %s | %s | %s | %s | %s%n",
                            j.waktuMulai, j.waktuSelesai, j.mataKuliah.kode,
                            j.mataKuliah.nama, dosenTampil, j.ruangan.nama, j.kelas);
                }
            }
        }
    }
}  


public class Main {
    public static void main(String[] args) {
        SistemAkademik sistem = new SistemAkademik();

        Mahasiswa[] mahasiswa = {
            new Mahasiswa("Mark Lee", "M001", "2C-D3"),
            new Mahasiswa("Haechan Lee", "M002", "2C-D3"),
            new Mahasiswa("Agra Anisa Ibtisamah", "M003", "2C-D3"),
            new Mahasiswa("Lee Minhyung", "M004", "2C-D3"),
            new Mahasiswa("Lee Donghyeok", "M005", "2C-D3"),
            new Mahasiswa("Johnny Suh", "M006", "2C-D3"),
            new Mahasiswa("Do Kyungsoo", "M007", "2C-D3"),
            new Mahasiswa("Park Chanyeol", "M008", "2C-D3"),
            new Mahasiswa("Sri Rizka Sugiartiningsih", "M009", "2C-D3"),
            new Mahasiswa("Na Jaemin", "M010", "2C-D3")
        };
        for (Mahasiswa mhs : mahasiswa) {
            sistem.tambahMahasiswa(mhs);
        }
        
        // Tambah dosen
        Dosen[] dosen = {
            new Dosen("Yadhi Aditya P.", "KO052N"),
            new Dosen("Yudi Widhiyasana", "KO013N"),
            new Dosen("Suprianto", "KO022N"),
            new Dosen("Triana Gelar A.", "KO078N"),
            new Dosen("Ade Chandra Nugraha", "K001N"),
            new Dosen("Muhammad Rizqi S", "KO074N"),
            new Dosen("Santi Sundari", "KO009N"),
            new Dosen("Zulkifli Arsyad", "KO061N"),
            new Dosen("Ade Hodijah", "KO060N"),
            new Dosen("Irwan Setiawan", "KO045N"),
            new Dosen("Irawan Thamrin", "KO006N"),
        };
        for (Dosen dsn : dosen) {
            sistem.tambahDosen(dsn);
        }

        // Tambah mata kuliah
        MataKuliah[] mataKuliah = {
            new MataKuliah("Pemrograman Berorientasi Objek", "211F2011"),
            new MataKuliah("Komputer Grafik", "211F2015"),
            new MataKuliah("Matematika Diskrit II", "211F2010"),
            new MataKuliah("Basis Data", "211F2012"),
            new MataKuliah("Aljabar Linear", "211F2014"),
            new MataKuliah("Proyek 3: Pengembangan Perangkat Lunak Berbasis Web", "211F2016"),
            new MataKuliah("Pengantar Rekayasa Perangkat Lunak", "21IF2013")
        };
        for (MataKuliah mk : mataKuliah) {
            sistem.tambahMataKuliah(mk);
        }

        // Tambah ruangan
        Ruangan[] ruangan = {
            new Ruangan("D217-Kelas"),
            new Ruangan("D102-Lab. MT"),
            new Ruangan("D106-Lab. SDB"),
            new Ruangan("D105-Lab. MT"),
            new Ruangan("D101-Kelas")
        };
        for (Ruangan r : ruangan) {
            sistem.tambahRuangan(r);
        }

        // Tambah jadwal
        Jadwal[] jadwal = {
            new Jadwal("SENIN", LocalTime.of(8, 40), LocalTime.of(9, 30), mataKuliah[0], dosen[0], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(9, 50), LocalTime.of(10, 40), mataKuliah[0], dosen[0], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(10, 40), LocalTime.of(11, 30), mataKuliah[1], dosen[1], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(11, 30), LocalTime.of(12, 20), mataKuliah[1], dosen[1], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(13, 00), LocalTime.of(13, 50), mataKuliah[2], dosen[2], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(13, 50), LocalTime.of(14, 40), mataKuliah[2], dosen[2], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(14, 40), LocalTime.of(15, 30), mataKuliah[2], dosen[2], ruangan[0], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(15, 50), LocalTime.of(16, 40), mataKuliah[1], dosen[3], ruangan[1], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(16, 40), LocalTime.of(17, 30), mataKuliah[1], dosen[3], ruangan[1], "2C-D3"),
            new Jadwal("SENIN", LocalTime.of(17, 30), LocalTime.of(18, 20), mataKuliah[1], dosen[3], ruangan[1], "2C-D3"),
            
            new Jadwal("SELASA", LocalTime.of(7, 00), LocalTime.of(7, 50), mataKuliah[3], dosen[4], ruangan[4], "2C-D3"),
            new Jadwal("SELASA", LocalTime.of(7, 50), LocalTime.of(8, 40), mataKuliah[3], dosen[4], ruangan[4], "2C-D3"),
            new Jadwal("SELASA", LocalTime.of(8, 40), LocalTime.of(9, 30), mataKuliah[4], dosen[5], ruangan[4], "2C-D3"),
            new Jadwal("SELASA", LocalTime.of(9, 50), LocalTime.of(10, 40), mataKuliah[4], dosen[5], ruangan[4], "2C-D3"),
            new Jadwal("SELASA", LocalTime.of(10, 40), LocalTime.of(11, 30), mataKuliah[6], dosen[6], ruangan[4], "2C-D3"),
            new Jadwal("SELASA", LocalTime.of(11, 30), LocalTime.of(12, 20), mataKuliah[6], dosen[6], ruangan[4], "2C-D3"),
            
            new Jadwal("RABU", LocalTime.of(7, 0), LocalTime.of(7, 50), mataKuliah[5], dosen[3], ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(7, 50), LocalTime.of(8, 40), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(8, 40), LocalTime.of(9, 30), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(13, 00), LocalTime.of(13, 50), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(13, 50), LocalTime.of(14, 40), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(14, 40), LocalTime.of(15, 30), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            new Jadwal("RABU", LocalTime.of(15, 50), LocalTime.of(16, 40), mataKuliah[5], new Dosen("Triana Gelar A.;Irwan Setiawan;Irawan Thamrin", "KO078N;KO045N;KO006N"), ruangan[1], "2C-D3"),
            
            new Jadwal("KAMIS", LocalTime.of(9, 50), LocalTime.of(10, 40), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(10, 40), LocalTime.of(11, 30), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(11, 30), LocalTime.of(12, 20), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(13, 00), LocalTime.of(13, 50), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(13, 50), LocalTime.of(14, 40), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(14, 40), LocalTime.of(15, 30), mataKuliah[6], dosen[0], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(15, 50), LocalTime.of(16, 40), mataKuliah[0], dosen[7], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(16, 40), LocalTime.of(17, 30), mataKuliah[0], dosen[7], ruangan[2], "2C-D3"),
            new Jadwal("KAMIS", LocalTime.of(17, 30), LocalTime.of(18, 20), mataKuliah[0], dosen[7], ruangan[2], "2C-D3"),
            
            new Jadwal("JUMAT", LocalTime.of(7, 0), LocalTime.of(7, 50), mataKuliah[3], dosen[8], ruangan[2], "2C-D3"),
            new Jadwal("JUMAT", LocalTime.of(7, 50), LocalTime.of(8, 40), mataKuliah[3], dosen[8], ruangan[2], "2C-D3"),
            new Jadwal("JUMAT", LocalTime.of(8, 40), LocalTime.of(9, 30), mataKuliah[3], dosen[8], ruangan[2], "2C-D3"),
            new Jadwal("JUMAT", LocalTime.of(9, 50), LocalTime.of(10, 40), mataKuliah[3], dosen[8], ruangan[2], "2C-D3"),
            new Jadwal("JUMAT", LocalTime.of(10, 40), LocalTime.of(11, 30), mataKuliah[3], dosen[8], ruangan[2], "2C-D3"),
            new Jadwal("JUMAT", LocalTime.of(13, 00), LocalTime.of(13, 50), mataKuliah[3], dosen[8], ruangan[2], "2C-D3")
        };
        for (Jadwal j : jadwal) {
            sistem.tambahJadwal(j);
        }

        // Tampilkan informasi
        System.out.println("\n=== DATA MAHASISWA ===");
        sistem.tampilkanMahasiswa();
        System.out.println("\n=== DATA DOSEN ===");
        sistem.tampilkanDosen();
        System.out.println("\n=== JADWAL PERKULIAHAN ===");
        sistem.tampilkanJadwal();
    }
}