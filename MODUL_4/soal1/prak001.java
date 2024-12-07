package soal1;

import java.util.Scanner;

public class prak001 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String nama = inputan.nextLine();
        System.out.print("Ras: ");
        String ras = inputan.nextLine();
        HewanPeliharaan peliharaan = new HewanPeliharaan(nama, ras);
        peliharaan.display();
    }
}
