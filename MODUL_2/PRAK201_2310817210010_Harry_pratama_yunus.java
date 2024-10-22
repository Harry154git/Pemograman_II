class Buah {
    String nama;
    double harga;
    double berat;
    double jumlahBeli;

    public Buah(String nama, double harga, double berat, double jumlahBeli) {
        this.nama = nama;
        this.harga = harga;
        this.berat = berat;
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotalHarga() {
        return (jumlahBeli / berat) * harga;
    }

    public double hitungDiskon() {
        return (Math.floor(jumlahBeli/4)) * 0.02 * harga * 4;
    }

    public double hitungHargaSetelahDiskon() {
        return hitungTotalHarga() - hitungDiskon();
    }

    public void tampilkanPembelian() {
        System.out.println("Nama Buah: " + nama);
        System.out.println("Berat: " + berat + " kg");
        System.out.println("Harga: Rp" + harga);
        System.out.println("Jumlah Beli: " + jumlahBeli + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", hitungTotalHarga());
        System.out.printf("Total Diskon: Rp%.2f%n", hitungDiskon());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n", hitungHargaSetelahDiskon());
        System.out.println();
    }
}

public class PRAK201_2310817210010_Harry_pratama_yunus {
    public static void main(String[] args) {
        Buah Apel = new Buah("Apel", 7000, 0.4, 40);
        Buah Mangga = new Buah("Mangga", 3500, 0.2, 15);
        Buah Alpukat = new Buah("Alpukat", 10000, 0.25, 12);

        Apel.tampilkanPembelian();
        Mangga.tampilkanPembelian();
        Alpukat.tampilkanPembelian();
    }
}
