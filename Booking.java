public class Booking extends Transaksi implements CetakData {

    private String email;
    private String idKamar;
    private int jumlahMalam;
    private String status;

    private static int count = 1;

    public Booking(String id,
                   String email,
                   String idKamar,
                   int malam,
                   int total,
                   String status) {

        super(id, total);
        this.email = email;
        this.idKamar = idKamar;
        this.jumlahMalam = malam;
        this.status = status;
    }

    public static String generateID() {
        return "B" + String.format("%03d", count++);
    }

    @Override
    public void hitungTotal() {
        // Sudah dihitung dari harga kamar
    }

    @Override
    public void cetakData() {
        System.out.println(idTransaksi + " | " + idKamar + " | " + total + " | " + status);
    }

    public String getEmail() {
        return email;
    }

    public String getIdKamar() {
        return idKamar;
    }
}