import java.util.Scanner;

public class prak104_2310817210010_Harry_Pratama_Yunus {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        String A,B,C;
        String a,b,c;
        int skorAbu = 0;
        int skorBagas = 0;

        System.out.print("Tangan Abu: ");
        String[] tanganAbu = input.nextLine().split(" ");
        A = tanganAbu[0];
        B = tanganAbu[1];
        C = tanganAbu[2];

        System.out.print("Tangan Bagas: ");
        String[] tanganBagas = input.nextLine().split(" ");
        a = tanganBagas[0];
        b = tanganBagas[1];
        c = tanganBagas[2];

        if (A.equals(a)) {
            skorAbu+=0;
        } else if ((A.equals("B") && a.equals("G")) || (A.equals("G") && a.equals("K")) || (A.equals("K") && a.equals("B"))) {
            skorAbu++;
        } else {
            skorBagas++;
        }

        if (B.equals(b)) {
            skorAbu+=0;
        } else if ((B.equals("B") && b.equals("G")) || (B.equals("G") && b.equals("K")) || (B.equals("K") && b.equals("B"))) {
            skorAbu++;
        } else {
            skorBagas++;
        }

        if (C.equals(c)) {
            skorAbu+=0;
        } else if ((C.equals("B") && c.equals("G")) || (C.equals("G") && c.equals("K")) || (C.equals("K") && c.equals("B"))) {
            skorAbu++;
        } else {
            skorBagas++;
        }

        if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

    }
}
