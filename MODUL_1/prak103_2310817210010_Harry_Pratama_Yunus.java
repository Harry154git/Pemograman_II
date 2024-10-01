import java.util.Scanner;

public class prak103_2310817210010_Harry_Pratama_Yunus {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        int N;
        int bilangan_awal;
        int i = 0;

        N = input.nextInt();
        bilangan_awal = input.nextInt();

        do{
            if (bilangan_awal % 2 != 0) {
                System.out.print(bilangan_awal);
                i++;
                if (i<N){
                    System.out.print(",");
                }
            }
            bilangan_awal += 1;
        }while(i<N);
    }
}