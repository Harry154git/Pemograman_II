import java.util.Scanner;

public class prak105_2310817210010_Harry_Pratama_Yunus {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        double jari_jari,tinggi,phi=3.14,hasil;

        System.out.print("Masukkan jari-jari: ");
        jari_jari=input.nextDouble();
        System.out.print("Masukkan tinggi: ");
        tinggi=input.nextDouble();

        double diagonal=jari_jari*jari_jari;
        hasil= phi*diagonal*tinggi;

        String hasilakhir = String.format("%.3f", hasil);
        System.out.println("Volume tabung dengan jari-jari "+jari_jari+" cm dan tinggi "+tinggi+" cm adalah "+hasilakhir+ " m3");
    }
}
