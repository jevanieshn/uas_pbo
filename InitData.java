import java.util.ArrayList;

public class InitData {

    public static ArrayList<User> users = new ArrayList<>();
    // list khusus pelanggan yang baru register
    public static ArrayList<Pelanggan> pelangganBaru = new ArrayList<>();

    public static void load() {
        users.clear();
        pelangganBaru.clear(); // reset setiap program jalan

        // Admin default
        users.add(new Admins("admin@gmail.com", "123456", "Admin"));

        // Pelanggan default (bukan "baru", jadi tidak dimasukkan ke pelangganBaru)
        users.add(new Pelanggan("user@gmail.com", "111111", "User Satu"));
    }

    public static User cariUser(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public static void tampilkanUserTerdaftar() {
        if (users.isEmpty()) {
            System.out.println("Belum ada user yang terdaftar.");
            return;
        }

        System.out.println("=== DAFTAR USER TERDAFTAR ===");
        int no = 1;
        for (User u : users) {
            String role = (u instanceof Admins) ? "Admin" : "Pelanggan";
            System.out.println(no + ". " + u.getNama() + " - " + u.getEmail() + " (" + role + ")");
            no++;
        }
    }

    public static void tampilkanPelangganTerdaftar() {
        boolean ada = false;
        System.out.println("=== DAFTAR PELANGGAN TERDAFTAR ===");
        int no = 1;
        for (User u : users) {
            if (u instanceof Pelanggan) {
                System.out.println(no + ". " + u.getNama() + " - " + u.getEmail());
                no++;
                ada = true;
            }
        }
        if (!ada) {
            System.out.println("Belum ada pelanggan terdaftar.");
        }
    }

    // 🔹 BARU: tampilkan hanya pelanggan yang baru register di sesi ini
    public static void tampilkanPelangganBaru() {
        System.out.println("=== PELANGGAN BARU TERDAFTAR ===");
        if (pelangganBaru.isEmpty()) {
            System.out.println("Belum ada pelanggan yang baru register.");
            return;
        }

        int no = 1;
        for (Pelanggan p : pelangganBaru) {
            System.out.println(no + ". " + p.getNama() + " - " + p.getEmail());
            no++;
        }
    }
}