package soal3;

import java.util.ArrayList;
import java.util.Scanner;

class nama_mahasiswa {
    private String name;
    private String nim;

    public nama_mahasiswa(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + name;
    }
}

public class Prak003 {
    static ArrayList<nama_mahasiswa> studentList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;

        while (pilihan == 0) {
            System.out.println("Menu: ");
            System.out.println("    1. Tambah mahasiswa");
            System.out.println("    2. Hapus mahasiswa berdasarkan nim");
            System.out.println("    3. cari mahasiswa berdasarkan NIM");
            System.out.println("    4. tampilkan daftar mahasiswa");
            System.out.println("    0. Keluar");
            System.out.print("Pilihan: ");
            int menu = input.nextInt();

            switch (menu) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    hapusMahasiswa();
                    break;
                case 3:
                    lihatMahasiswaBerdasarkanNIM();
                    break;
                case 4:
                    lihatSemuaMahasiswa();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    pilihan++;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    public static void tambahMahasiswa() {
        input.nextLine();
        System.out.print("Masukkan Nama Mahasiswa: ");
        String name = input.nextLine();

        System.out.print("Masukkan NIM Mahasiswa(harus unik): ");
        String nim = input.nextLine();

        for (nama_mahasiswa mahasiswa : studentList) {
            if (mahasiswa.getNim().equals(nim)) {
                System.out.println("NIM sudah digunakan. Mahasiswa tidak ditambahkan.");
                return;
            }
        }

        nama_mahasiswa mahasiswaBaru = new nama_mahasiswa(name, nim);
        studentList.add(mahasiswaBaru);

        System.out.println("Mahasiswa " + name + " ditambahkan");
    }

    public static void hapusMahasiswa() {
        input.nextLine();
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = input.nextLine();

        boolean dihapus = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getNim().equals(nim)) {
                studentList.remove(i);
                dihapus = true;
                break;
            }
        }

        if (dihapus) {
            System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.");
        } else {
            System.out.println("NIM mahasiswa tidak ditemukan.");
        }
    }

    public static void lihatMahasiswaBerdasarkanNIM() {
        input.nextLine();
        System.out.print("Masukkan NIM mahasiswa yang ingin dilihat: ");
        String nim = input.nextLine();

        boolean ditemukan = false;
        for (nama_mahasiswa mahasiswa : studentList) {
            if (mahasiswa.getNim().equals(nim)) {
                System.out.println(mahasiswa);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    public static void lihatSemuaMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        for (nama_mahasiswa mahasiswa : studentList) {
            System.out.println(mahasiswa);
        }
    }
}