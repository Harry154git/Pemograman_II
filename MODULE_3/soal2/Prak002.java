package soal2;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

class Negara {
    private String nama;
    private String jenis_kepemimpinan;
    private String nama_pemimpin;
    private Integer tanggal_kemerdekaan;
    private Integer bulan_kemerdekaan;
    private Integer tahun_kemerdekaan;

    public Negara(String nama, String jenis_kepemimpinan, String nama_pemimpin) {
        this.nama = nama;
        this.jenis_kepemimpinan = jenis_kepemimpinan;
        this.nama_pemimpin = nama_pemimpin;
    }

    public Negara(String nama, String jenis_kepemimpinan, String nama_pemimpin, Integer tanggal_kemerdekaan, Integer bulan_kemerdekaan, Integer tahun_kemerdekaan) {
        this.nama = nama;
        this.jenis_kepemimpinan = jenis_kepemimpinan;
        this.nama_pemimpin = nama_pemimpin;
        this.tanggal_kemerdekaan = tanggal_kemerdekaan;
        this.bulan_kemerdekaan = bulan_kemerdekaan;
        this.tahun_kemerdekaan = tahun_kemerdekaan;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenisKepemimpinan() {
        if (jenis_kepemimpinan.equalsIgnoreCase("presiden")) {
            return "Presiden";
        } else if (jenis_kepemimpinan.equalsIgnoreCase("perdana menteri")) {
            return "Perdana Menteri";
        } else if (jenis_kepemimpinan.equalsIgnoreCase("monarki")) {
            return "Raja";
        }
        return jenis_kepemimpinan;
    }

    public String getNamaPemimpin() {
        return this.nama_pemimpin;
    }

    public Integer getTanggalKemerdekaan() {
        return this.tanggal_kemerdekaan;
    }

    public Integer getBulanKemerdekaan() {
        return this.bulan_kemerdekaan;
    }

    public Integer getTahunKemerdekaan() {
        return this.tahun_kemerdekaan;
    }
}

public class Prak002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Negara> dataNegara = new LinkedList<>();

        HashMap<Integer, String> namaBulan = new HashMap<>();
        namaBulan.put(1, "Januari");
        namaBulan.put(2, "Februari");
        namaBulan.put(3, "Maret");
        namaBulan.put(4, "April");
        namaBulan.put(5, "Mei");
        namaBulan.put(6, "Juni");
        namaBulan.put(7, "Juli");
        namaBulan.put(8, "Agustus");
        namaBulan.put(9, "September");
        namaBulan.put(10, "Oktober");
        namaBulan.put(11, "November");
        namaBulan.put(12, "Desember");

        int jumlahNegara = Integer.parseInt(input.nextLine());

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = input.nextLine();
            String jenisKepemimpinan = input.nextLine();
            String namaPemimpin = input.nextLine();

            if (!jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                int tanggal = Integer.parseInt(input.nextLine());
                int bulan = Integer.parseInt(input.nextLine());
                int tahun = Integer.parseInt(input.nextLine());
                dataNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggal, bulan, tahun));
            } else {
                dataNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
            }
        }

        for (Negara negara : dataNegara) {
            System.out.println("Negara " + negara.getNama() + " mempunyai " + negara.getJenisKepemimpinan() + " bernama " + negara.getNamaPemimpin());
            if (negara.getTanggalKemerdekaan() != null && negara.getBulanKemerdekaan() != null && negara.getTahunKemerdekaan() != null) {
                System.out.println("Deklarasi Kemerdekaan pada Tanggal " + negara.getTanggalKemerdekaan() + " " + namaBulan.get(negara.getBulanKemerdekaan()) + " " + negara.getTahunKemerdekaan());
            }
            System.out.println();
        }
    }
}