package praktikum2.soal3;

public class Pegawai {// ini seharusnya Pegawai bukan Employee
    public String nama;
    public String asal; // ini seharusnya string karena di function getasal meminta string
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setJabatan(String j) {// ini seharusnya ada tambahan input berupa string
        this.jabatan = j;
    }
}