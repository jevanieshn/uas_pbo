public class Kamar {

    private String id;
    private String jenis;
    private int harga;
    private String status;

    public Kamar(String id, String jenis, int harga, String status) {
        this.id = id;
        this.jenis = jenis;
        this.harga = harga;
        this.status = status;
    }

    public String getId() { return id; }
    public String getJenis() { return jenis; }
    public int getHarga() { return harga; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}