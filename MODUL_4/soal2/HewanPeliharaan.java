package soal2;

class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String nama, String ras){
        this.nama=nama;
        this.ras=ras;
    }
    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : "+ nama );
        System.out.println("Dengan ras : "+ ras);
    }
}

class Kucing extends HewanPeliharaan {
    private String warnaBulu;

    public Kucing(String nama, String ras, String bulu){
        super(nama, ras);
        this.warnaBulu=bulu;
    }

    public void displayDetailKucing() {
        super.display();
        System.out.println("Memiliki warna bulu : "+ warnaBulu );
    }
}

class Anjing extends HewanPeliharaan {
    private String warnaBulu;
    private String kemampuan;

    public Anjing(String nama, String ras, String bulu,String kemampuan){
        super(nama, ras);
        this.warnaBulu=bulu;
        this.kemampuan=kemampuan;
    }

    public void displayDetailAnjing() {
        super.display();
        System.out.println("Memiliki warna bulu : "+ warnaBulu );
        System.out.println("Memiliki kemampuan : "+ kemampuan);
    }
}