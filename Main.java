import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Load data awal
        InitData.load();
        InitKamar.load();
        InitBooking.load();

        // Satu-satunya Scanner di program
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== SISTEM RESERVASI ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            String pilih = sc.nextLine().trim();

            if (pilih.equals("1")) {
                // kirim scanner ke LoginSystem
                String email = LoginSystem.start(sc);
                User u = InitData.cariUser(email);
                if (u != null) {
                    // kalau di dalam User.menu() kamu pakai input juga,
                    // idealnya pakai scanner yang sama, tapi kalau method-nya
                    // belum pakai parameter, biarin dulu seperti ini
                    u.menu();
                }
            }
            else if (pilih.equals("2")) {
                // kirim scanner ke RegisterSystem
                RegisterSystem rs = new RegisterSystem();
                rs.start(sc);
            }
            else if (pilih.equals("3")) {
                System.out.println("Keluar dari program...");
                break;
            }
            else {
                System.out.println("Pilihan tidak valid!\n");
            }
        }

        sc.close();
    }
}