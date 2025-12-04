import java.util.Scanner;

public class Admins extends User {

    Scanner sc = new Scanner(System.in);

    public Admins(String email, String password, String nama) {
        super(email, password, nama);
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private String input(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    @Override
    public void menu() {
        while (true) {
            clear();
            System.out.println("=== MENU ADMIN ===");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Lihat Semua Kamar");
            System.out.println("3. Hapus Kamar");
            System.out.println("4. Lihat Semua Pelanggan");
            System.out.println("5. Lihat Pelanggan Baru");
            System.out.println("6. Logout");

            String pilih = input("Pilih: ");

            switch (pilih) {
                case "1": tambahKamar(); break;
                case "2": lihatKamar(); break;
                case "3": hapusKamar(); break;
                case "4": lihatSemuaPelanggan(); break;
                case "5": lihatPelangganBaru(); break;
                case "6": return;
                default:
                    System.out.println("Pilihan salah!");
                    sc.nextLine();
            }
        }
    }

    private void tambahKamar() {
        clear();
        System.out.println("=== TAMBAH KAMAR ===");

        String id = "K" + String.format("%03d", InitKamar.kamarList.size() + 1);
        String jenis = input("Jenis kamar: ");
        int harga = Integer.parseInt(input("Harga: "));

        Kamar k = new Kamar(id, jenis, harga, "kosong");
        InitKamar.kamarList.add(k);

        System.out.println("Kamar ditambahkan!");
        sc.nextLine();
    }

    private void lihatKamar() {
        clear();
        System.out.println("=== LIST KAMAR ===");

        for (Kamar k: InitKamar.kamarList) {
            System.out.println(k.getId() + " | " + k.getJenis() + " | " + k.getHarga() + " | " + k.getStatus());
        }

        sc.nextLine();
    }

    private void hapusKamar() {
        clear();
        System.out.println("=== HAPUS KAMAR ===");

        String id = input("ID kamar: ");

        Kamar target = null;
        for (Kamar k : InitKamar.kamarList) {
            if (k.getId().equalsIgnoreCase(id)) target = k;
        }

        if (target != null) {
            InitKamar.kamarList.remove(target);
            System.out.println("Kamar dihapus!");
        } else {
            System.out.println("Tidak ditemukan.");
        }

        sc.nextLine();
    }

    // 🔹 BARU: lihat semua pelanggan
    private void lihatSemuaPelanggan() {
        clear();
        InitData.tampilkanPelangganTerdaftar();
        System.out.println("\nTekan Enter untuk kembali...");
        sc.nextLine();
    }

    // 🔹 BARU: lihat pelanggan yang baru register
    private void lihatPelangganBaru() {
        clear();
        InitData.tampilkanPelangganBaru();
        System.out.println("\nTekan Enter untuk kembali...");
        sc.nextLine();
    }
}
}
