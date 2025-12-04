public abstract class Transaksi {

    protected String idTransaksi;
    protected int total;

    public Transaksi(String idTransaksi, int total) {
        this.idTransaksi = idTransaksi;
        this.total = total;
    }

    public abstract void hitungTotal();
}
