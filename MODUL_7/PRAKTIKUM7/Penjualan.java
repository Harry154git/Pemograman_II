package PRAKTIKUM7;

public class Penjualan {
    private int penjualan_id;
    private int jumlah;
    private double total_harga;
    private String tanggal;
    private int pelanggan_penjualan_id;
    private int buku_penjualan_id;

    public Penjualan(int penjualan_id, int jumlah, double total_harga, String tanggal, int pelanggan_id, int buku_id) {
        this.penjualan_id = penjualan_id;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.tanggal = tanggal;
        this.pelanggan_penjualan_id = pelanggan_id;
        this.buku_penjualan_id = buku_id;
    }

    public int getPenjualan_id() { return penjualan_id; }
    public void setPenjualan_id(int penjualan_id) { this.penjualan_id = penjualan_id; }
    public double getTotal_harga() { return total_harga; }
    public void setTotal_harga(double total_harga) { this.total_harga = total_harga; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public int getPenjualanPelanggan_Id() { return pelanggan_penjualan_id; }
    public void setPenjualanPelanggan_Id(int pelanggan_id) { this.pelanggan_penjualan_id = pelanggan_id; }
    public int getPenjualanBuku_Id() { return buku_penjualan_id; }
    public void setPenjualanBuku_Id(int buku_id) { this.buku_penjualan_id = buku_id; }

}
