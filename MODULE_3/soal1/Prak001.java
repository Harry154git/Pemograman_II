package soal1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

class Dadu {
    private int angka;

    public Dadu(){
        Random angka_random = new Random();
        this.angka = angka_random.nextInt(6) + 1;
    }

    public int getAngka() {
        return this.angka;
    }

}

public class Prak001 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        LinkedList<Dadu> isidadu = new LinkedList<>();

        int jumlah_masukkan = inputan.nextInt();

        for (int i = 0; i < jumlah_masukkan; i++) {
            isidadu.add(new Dadu());
        }

        int total_angka_dadu = 0;
        for (int i = 0; i < isidadu.size(); i++) {
            Dadu datadadu = isidadu.get(i);
            int nilaidadu = datadadu.getAngka();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilaidadu);
            total_angka_dadu += nilaidadu;
        }
        System.out.println("Total nilai dadu keseluruhan " + total_angka_dadu);
    }
}