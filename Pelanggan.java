import java.util.Scanner;

public class Pelanggan extends User {

    Scanner sc = new Scanner(System.in);

    public Pelanggan(String email, String password, String nama) {
        super(email, password, nama);
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void menu() {
        while (true) {
            clear();
            System.out.println("=== MENU PELANGGAN ===");
            System.out.println("1. Lihat Kamar");
            System.out.println("2. Booking");
            System.out.println("3. Riwayat Booking");
            System.out.println("4. Logout");

            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1": lihatKamar(); break;
                case "2": bookingKamar(); break;
                case "3": lihatRiwayat(); break;
                case "4": return;
                default: System.out.println("Pilihan salah!"); sc.nextLine();
            }
        }
    }

    private void lihatKamar() {
        clear();
        System.out.println("=== KAMAR TERSEDIA ===");

        for (Kamar k : InitKamar.kamarList) {
            if (k.getStatus().equals("kosong")) {
                System.out.println(k.getId() + " | " + k.getJenis() + " | " + k.getHarga());
            }
        }
        sc.nextLine();
    }

    private void bookingKamar() {
        clear();
        System.out.println("=== BOOKING ===");

        String id = sc.nextLine();

        Kamar target = null;
        for (Kamar k : InitKamar.kamarList) {
            if (k.getId().equalsIgnoreCase(id) && k.getStatus().equals("kosong")) {
                target = k;
            }
        }

        if (target == null) {
            System.out.println("Kamar tidak valid.");
            sc.nextLine();
            return;
        }

        Booking b = new Booking(
            Booking.generateID(),
            this.email,
            target.getId(),
            1,
            target.getHarga(),
            "Booked"
        );

        InitBooking.bookingList.add(b);
        target.setStatus("terisi");

        System.out.println("Booking berhasil!");
        sc.nextLine();
    }

    private void lihatRiwayat() {
        clear();
        System.out.println("=== RIWAYAT ===");

        for (Booking b : InitBooking.bookingList) {
            if (b.getEmail().equalsIgnoreCase(this.email)) {
                b.cetakData();
            }
        }
        sc.nextLine();
    }
}
