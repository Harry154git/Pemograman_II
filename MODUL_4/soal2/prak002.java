package soal2;

import java.util.Scanner;

public class prak002 {
    static Scanner inputan = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int angka = inputan.nextInt();
        inputan.nextLine();

        switch (angka){
            case 1:
                masukkandatakucing();
                break;
            case 2:
                masukkandataanjing();
                break;
        }
    }

    public static void masukkandatakucing() {
        System.out.print("Nama Hewan Peliharaan: ");
        String nama = inputan.nextLine();
        System.out.print("Ras: ");
        String ras = inputan.nextLine();
        System.out.print("Warna Bulu: ");
        String bulu = inputan.nextLine();
        Kucing peliharaan = new Kucing(nama, ras, bulu);
        peliharaan.displayDetailKucing();
    }

    public static void masukkandataanjing() {
        System.out.print("Nama Hewan Peliharaan: ");
        String nama = inputan.nextLine();
        System.out.print("Ras: ");
        String ras = inputan.nextLine();
        System.out.print("Warna Bulu: ");
        String bulu = inputan.nextLine();
        System.out.print("Kemampuan: ");
        String kemampuan = inputan.nextLine();
        Anjing peliharaan = new Anjing(nama, ras, bulu, kemampuan);
        peliharaan.displayDetailAnjing();
    }
}


