package PRAKTIKUM6;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    public void setId(int id){
        this.id = id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public int getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public String getNim(){
        return nim;
    }
}