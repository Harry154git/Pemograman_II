import java.util.Scanner;

public class prak101_2310817210010_Harry_Pratama_Yunus {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        String Nama_Lengkap;
        String Tempat_Lahir;
        String Tanggal_Lahir;
        int Bulan_Lahir;
        String Tahun_Lahir;
        String Tinggi_Badan;
        String Berat_Badan;

        System.out.print("Masukkan Nama Lengkap: ");
        Nama_Lengkap = input.nextLine();
        System.out.print("Masukkan Tempat Lahir: ");
        Tempat_Lahir = input.nextLine();
        System.out.print("Masukkan Tanggal Lahir: ");
        Tanggal_Lahir = input.nextLine();
        System.out.print("Masukkan Bulan Lahir: ");
        Bulan_Lahir = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Tahun Lahir: ");
        Tahun_Lahir = input.nextLine();
        System.out.print("Masukkan Tinggi Badan: ");
        Tinggi_Badan = input.nextLine();
        System.out.print("Masukkan Berat Badan: ");
        Berat_Badan = input.nextLine();

        String Bulan = switch (Bulan_Lahir) {
            case 1 -> "januari";
            case 2 -> "Februari";
            case 3 -> "Maret";
            case 4 -> "April";
            case 5 -> "Mei";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "Agustus";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Desember";
            default -> "";
        };
        System.out.print("Nama Lengkap " + Nama_Lengkap + ", Lahir di " + Tempat_Lahir + " pada Tanggal " + Tanggal_Lahir + " " + Bulan + " " + Tahun_Lahir + " Tinggi Badan " + Tinggi_Badan + " cm dan Berat Badan " + Berat_Badan + " kilogram ");
    }
}