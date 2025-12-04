import java.util.Scanner;

public class RegisterSystem {

    public void start(Scanner sc) {
        System.out.println("=== REGISTER ===");

        // ====== INPUT EMAIL DENGAN VALIDASI ======
        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine().trim();

            // cek format email (sederhana, cukup buat tugas)
            if (!isFormatEmailBenar(email)) {
                System.out.println("Format email salah!");
                System.out.println("Contoh yang benar: nama@gmail.com");
                System.out.println("Silakan ketik ulang.\n");
                continue;
            }

            // cek email sudah dipakai atau belum
            if (InitData.cariUser(email) != null) {
                System.out.println("Email sudah terdaftar!");
                System.out.println("Silakan gunakan email lain.\n");
                continue;
            }

            // kalau lolos dua-duanya, keluar dari loop
            break;
        }

        // ====== INPUT PASSWORD 6 DIGIT ======
        String pass;
        while (true) {
            System.out.print("Password (6 digit): ");
            pass = sc.nextLine().trim();

            if (pass.length() != 6) {
                System.out.println("Password harus tepat 6 digit. Coba lagi.\n");
                continue;
            }
            break;
        }

        System.out.print("Nama: ");
        String nama = sc.nextLine().trim();

        // buat objek pelanggan baru
        Pelanggan p = new Pelanggan(email, pass, nama);

        // simpan ke list utama user
        InitData.users.add(p);
        // 🔹 simpan juga ke list pelangganBaru
        InitData.pelangganBaru.add(p);

        System.out.println("\nRegister sukses!");
        System.out.println("Akun dengan email " + email + " berhasil dibuat.\n");

        // opsional: langsung tampilkan pelanggan baru saja
        InitData.tampilkanPelangganBaru();
        System.out.println();
    }

    // ====== HELPER: CEK FORMAT EMAIL SEDERHANA ======
    private boolean isFormatEmailBenar(String email) {
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');

        // aturan simpel:
        // - ada '@'
        // - '@' bukan karakter pertama
        // - ada '.' setelah '@'
        if (atPos > 0 && dotPos > atPos) {
            return true;
        }
        return false;
    }
}