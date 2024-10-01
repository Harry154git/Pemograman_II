import java.util.Scanner;

public class prak102_2310817210010_Harry_Pratama_Yunus {
    public static void main(String[] args) {
        Scanner  input = new Scanner(System.in);
        int inputan;
        int angkaA;
        int i = 0;

        inputan = input.nextInt();

        while(i < 11){
            angkaA =inputan+i;
            if(angkaA % 5 == 0){
                int B;
                B=angkaA/5;
                B=B-1;
                System.out.print(B);
            }else{
                System.out.print(angkaA);
            }
            if(i<10){
                System.out.print(",");
            }
            i++;
        }
    }
}